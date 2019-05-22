package domini;


import persistencia.CtrlPersistenciaProblemes;
import persistencia.CtrlPersistenciaRanking;

import java.util.ArrayList;

public class CtrlDades {
    private CtrlPersistenciaProblemes ctrlPP;
    private CtrlPersistenciaRanking ctrlPR;

    private static CtrlDades ourInstance = new CtrlDades();

    public static CtrlDades getInstance() {
        return ourInstance;
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

    public void afegeixRanking(String nomj, String nomp, Float temps) {
    }

    public void eliminaRanking(String nomj, String nomp, Float temps) {
    }

    public void modificaRanking(String nomj, String nomp, Float temps) {
    }

    public boolean cercaRanking(String nomj) {
        return true;
    }
}