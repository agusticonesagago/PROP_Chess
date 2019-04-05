package test;

import domini.Simple;
import domini.Taulell;
import javafx.util.Pair;

public class DriverSimple {
    public static void main(String[] args) {
        System.out.println("Simular Partida");
        StubPartida simulacio = new StubPartida(new StubProblem("Blanques fan mat en 2", "3r4/pp3kpQ/5p1p/3q1b2/1B2N3/8/PP3PPP/4R1K1 w - - 0 1"), new Simple(1), new Simple(2));


        jugarPartida(simulacio);

       /*Simple m = (Simple) simulacio.getBlanques();
        Taulell t = new Taulell("3b4/3N2nr/R3q1n1/2Ppk2r/K6R/8/2N1PQ2/B6B");
        System.out.println(m.escac_mat(t, false));*/
    }

    private static void jugarPartida(StubPartida simulacio) {
        Pair<Integer, Boolean> tm = simulacio.getProblema().getTornMat();
        Integer Torn = tm.getKey();
        Boolean Mat  = tm.getValue();

        System.out.println("TAULELL INICIAL");
        simulacio.getTaulell().PrintBoard();

        System.out.println();
        while (Torn >= 0) {
            System.out.println("Les Peces: "+simulacio.getQuiJuga()+" han mogut el torn: "+Torn);
            simulacio.jugarTorn(Torn);
            System.out.println(Torn);
            simulacio.getTaulell().PrintBoard();
            --Torn; // cas s'ha completat un torn
        }
    }
}
