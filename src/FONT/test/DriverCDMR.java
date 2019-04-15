package test;

import domini.CtrlDominiMantRanking;

import java.util.Vector;

public class DriverCDMR {
    public static void main (String[] args){
        System.out.println("Test de la funcio creadora de problemes" + "\n");
        String nomj = "Aleix";
        String nomp = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1";
        String temps = "1";
        Vector<String> dadesRank = new Vector<>();
        dadesRank.add(0,nomj);
        dadesRank.add(1,nomp);
        dadesRank.add(2,temps);

        Vector <String> resultat;
        CtrlDominiMantRanking test = new CtrlDominiMantRanking();

        if (test.altaRanking(dadesRank.get(0), dadesRank) != 0) {
            System.out.println("Error " + "\n");
        }
        else  System.out.println("Tot Corretce " + "\n");

        if (test.altaRanking(dadesRank.get(0), dadesRank) != 0) {
            System.out.println("Error " + "\n");
        }
        else  System.out.println("Tot Corretce " + "\n");

        resultat = test.consultaRankings();
        for (int i = 0; i < resultat.size(); i++) {
            System.out.println("Ranking " + i + ": " + "\n" + resultat.get(i) + "\n");
        }

        if (test.baixaRankings(dadesRank.get(0)) != 0) {
            System.out.println("Error " + "\n");
        }
        else  System.out.println("Tot Corretce " + "\n");

        if (test.baixaRankings(dadesRank.get(0)) != 0) {
            System.out.println("Error " + "\n");
        }
        else  System.out.println("Tot Corretce " + "\n");

        resultat = test.consultaRankings();
        for (int i = 0; i < resultat.size(); i++) {
            System.out.println("Ranking " + i + ": " + "\n" + resultat.get(i) + "\n");
        }
        if (resultat.size() == 0) System.out.println("No hi ha cap ranking guardat " + "\n");
    }
}
