package domini;


public class Problema {
    protected String Tema;
    protected String Dificultat;
    protected String FEN;
    //protected Partida Tester
    //protected CtrlDades CtrlD

    public Problema (String t, String dif, String fen) {
        Tema = t;
        Dificultat = dif;
        FEN = fen;
        //deixar constancia a la base de dades
    }

    public Problema cercaProblema(String fen) {
        //return CtrlD.getProblema(fen);
    }

    public void eliminarProblema(String fen) {
        //CtrlD.destroyProblema(fen);
    }

    public void modificarProblema (String fen, String t, String dif) {
        //CtrlD.modify(fen)
        FEN = fen;
        Dificultat = dif;
        Tema = t;
    }
        /* Work In Progress */
    public boolean teSolucio(String fen) {
        fen;
        if() return false;
        else 
        //return Tester.comprova_solució(fen);
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