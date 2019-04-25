package domini;


import javafx.util.Pair;


public class Problema {
    protected String Tema;
    protected String Dificultat;
    protected String FEN;

    public Problema(String t, String fen, String dif, CtrlDades ctrlD) {
        Tema = t;  //Format: "Color fan mat en X"
        Dificultat = dif;
        FEN = fen;
    }

    public Problema(String t, String fen) {
        Tema = t;  //Format: "Color fan mat en X"
        Dificultat = "facil";
        FEN = fen;
    }

    public Problema() {
        Tema = "tema";  //Format: "Color fan mat en X"
        Dificultat = "dificultat";
        FEN = "fen";
    }

    public Pair <Integer, Boolean> getTornMat() {
        int pos = Tema.indexOf("en");
        int torns = Character.getNumericValue(Tema.charAt(Tema.length() - 1));
        Boolean jugador = Tema.startsWith("Blanques");
        return new Pair<>(torns, jugador);
    }

    /* GETTERS */
    public String getTema() {
        return Tema;
    }

    public String getDificultat() {
        return Dificultat;
    }

    public String getFEN() {
        return FEN;
    }


    /* SETTERS */
    public void setTema(String t) {
        Tema = t;
    }

    public void setDificultat(String dif) {
        Dificultat = dif;
    }

    public void setFEN(String fen) {
        FEN = fen;
    }

}