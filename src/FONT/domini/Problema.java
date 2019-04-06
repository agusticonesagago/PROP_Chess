package domini;

import javafx.util.Pair;


public class Problema {
    protected String Tema;
    protected String Dificultat;
    protected String FEN;
    protected CtrlDades CtrlD;

    public Problema(String t, String fen, String dif, CtrlDades ctrlD) {
        Tema = t;  //Format: "Color fan mat en X"
        Dificultat = dif;
        FEN = fen;
        this.CtrlD = ctrlD;
        if (ctrlD.findProblema(fen)) {
            CtrlD.add(fen, dif, t);
        }
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

    public Pair getTornMat() {
        int pos = Tema.indexOf("en");
        int torns = Character.getNumericValue(Tema.charAt(Tema.length() - 1));
        Boolean jugador = Tema.startsWith("Blanques");
        return new Pair<Integer, Boolean>(torns, jugador);
    }

    public void eliminar() {
        CtrlD.destroyProblema(FEN);
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