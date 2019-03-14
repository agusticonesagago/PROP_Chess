package domini;


public class Problema {
    protected String Tema;
    protected String Dificultat;
    protected String FEN;
    //protected CtrlDades CtrlD

    public Problema (String t, String dif, String fen) {
        Tema = t;
        Dificultat = dif;
        FEN = fen;
        //deixar constancia a la base de dades
    }

    public Problema cercaProblema(String fen) {
        //return CtrlD.getProblema(fen);
        return null;
    }

    public void eliminarProblema(String fen) {
        //CtrlD.destroyProblema(fen);
    }

    public void modificarProblema (String fen, String t, String dif) {
        //CtrlD.modify(fen)
        FEN = fen;
        Dificultat = dif;
        Tema = t;

        //
    }

    public boolean teSolucio() {
        return true;
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