package domini;


import java.util.ArrayList;

public class CtrlDades {

    private static CtrlDades instance = null;

    private static class SingletonHelper {
        private static final CtrlDades instance = new CtrlDades();
    }
    public static CtrlDades getInstance() {
        return SingletonHelper.instance;
    }

    public ArrayList<String> allProb() {
        return null;
    }

    public void afegeixProblema(String f, String d, String t) {
    }

    public void eliminaProblema(String f){
    }

    public void modificaProblema(String fen, String t, String dif) {
    }

    public boolean cercaProblema(String fen) {
        return true;
    }



    public ArrayList<String> allRank() {
        return null;
    }

    public void afegeixRanking(String nomj, String nomp, Integer temps) {
    }

    public void eliminaRanking(String nomj) {
    }

    public void modificaRanking(String nomj, String nomp, Integer temps) {
    }

    public boolean cercaRanking(String nomj) {
        return true;
    }
}