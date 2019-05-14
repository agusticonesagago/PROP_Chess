package test;

import domini.CtrlPersistenciaProblemes;

import java.io.FileNotFoundException;

public class DriverCPP {
    public static void main (String [] args) throws FileNotFoundException {
        CtrlPersistenciaProblemes cp = new CtrlPersistenciaProblemes();
        cp.getProblemes();
    }
}
