package test;

import domini.*;
import java.util.Vector;

public class DriverCDMP {
    public static void main (String[] args){
        System.out.println("Test de la funcio creadora de problemes" + "\n");
        String fen1 = "3k4/8/8/8/8/1r6/r7/7K b - - 0 1";
        String tema1 = "Negres fan mat en 1";
        String dificultat1 = "facil";
        Vector <String> dadesProb1 = new Vector<>();
        dadesProb1.add(0,fen1);
        dadesProb1.add(1,tema1);
        dadesProb1.add(2,dificultat1);

        Vector <String> resultat;
        CtrlDominiMantProblema test = new CtrlDominiMantProblema();

        System.out.println("Introduim nou problema" + "\n");
        if (test.altaProblema(dadesProb1.get(0), dadesProb1) != 0) {
            System.out.println("Error " + "\n");
        }
        else  System.out.println("Tot Corretce " + "\n");

        System.out.println("Introduim nou problema" + "\n");
        if (test.altaProblema(dadesProb1.get(0), dadesProb1) != 0) {
            System.out.println("Error " + "\n");
        }
        else  System.out.println("Tot Corretce " + "\n");

        resultat = test.consultaProblemes();
        for (int i = 0; i < resultat.size(); i++) {
            System.out.println("Problema " + i + ": " + "\n" + resultat.get(i) + "\n");
        }

        System.out.println("Borrem un problema" + "\n");
        if (test.baixaProblema(dadesProb1.get(0)) != 0) {
            System.out.println("Error " + "\n");
        }
        else  System.out.println("Tot Corretce " + "\n");

        System.out.println("Borrem un problema" + "\n");
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
