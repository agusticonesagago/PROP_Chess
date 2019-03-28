package test;

import domini.Simple;
import javafx.util.Pair;

public class DriverSimple {
    public static void main(String[] args) {
        System.out.println("Simular Partida");
        StubPartida simulacio = new StubPartida(new StubProblem("Blanques fan mat en 2", "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1"), new Simple(1), new StubJugador(2));

        jugarPartida(simulacio);

    }

    private static void jugarPartida(StubPartida simulacio) {
        Pair<Integer, Boolean> tm = simulacio.getProblema().getTornMat();
        Integer Torn = tm.getKey();
        Boolean Mat  = tm.getValue();
        while (Torn > 0) {
            System.out.println(simulacio.getQuiJuga());
            simulacio.jugarTorn(Torn);
            if (!simulacio.getQuiJuga())--Torn; // cas s'ha completat un torn
            simulacio.getTaulell().PrintBoard();
        }
    }
}
