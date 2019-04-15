package test;

import domini.*;
import java.util.Vector;

public class DriverCDMP {
    public static void main (String[] args){
        System.out.println("Test de la funcio creadora de problemes" + "\n");
        String fen1 = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1";
        String tema1 = "Blanques fan mat en 2";
        String dificultat1 = "facil";
        Vector <String> dadesProb1 = new Vector<>();
        dadesProb1.add(0,fen1);
        dadesProb1.add(1,tema1);
        dadesProb1.add(2,dificultat1);

        Vector <String> resultat;
        CtrlDominiMantProblema test = new CtrlDominiMantProblema();

        if (test.altaProblema(dadesProb1.get(0), dadesProb1) != 0) {
            System.out.println("Error " + "\n");
        }
        else  System.out.println("Tot Corretce " + "\n");

        if (test.altaProblema(dadesProb1.get(0), dadesProb1) != 0) {
            System.out.println("Error " + "\n");
        }
        else  System.out.println("Tot Corretce " + "\n");

        resultat = test.consultaProblemes();
        for (int i = 0; i < resultat.size(); i++) {
            System.out.println("Problema " + i + ": " + "\n" + resultat.get(i) + "\n");
        }

        if (test.baixaProblema(dadesProb1.get(0)) != 0) {
            System.out.println("Error " + "\n");
        }
        else  System.out.println("Tot Corretce " + "\n");

        if (test.baixaProblema(dadesProb1.get(0)) != 0) {
            System.out.println("Error " + "\n");
        }
        else  System.out.println("Tot Corretce " + "\n");

        resultat = test.consultaProblemes();
        for (int i = 0; i < resultat.size(); i++) {
            System.out.println("Problema " + i + ": " + "\n" + resultat.get(i) + "\n");
        }
        if (resultat.size() == 0) System.out.println("No hi ha cap problema guardat " + "\n");
    }
}
