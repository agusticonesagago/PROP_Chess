package domini;

import com.sun.org.apache.xpath.internal.operations.Bool;
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

    public Problema() {
        Tema = "tema";  //Format: "Color fan mat en X"
        Dificultat = "dificultat";
        FEN = "fen";
    }

    public Pair getTornMat() {
        int pos = FEN.indexOf("en");
        int torns = Integer.parseInt(FEN.charAt(pos+1));
        Boolean jugador = FEN.startsWith("Blanques");
        return new Pair<Integer, Boolean>(torns, jugador);
    }

    public void eliminar() {
        //comprobar que existeix
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