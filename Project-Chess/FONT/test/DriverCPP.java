package test;

import persistencia.CtrlPersistenciaProblemes;
import domini.Problema;

import java.io.IOException;

public class DriverCPP {
    public static void main (String [] args) throws IOException {
        CtrlPersistenciaProblemes cp = new CtrlPersistenciaProblemes();
        cp.getProblemes();
        Problema p = new Problema("t","fen","dif",null);
        cp.afegirProblema(p);
        cp.getProblemes();
    }
}
