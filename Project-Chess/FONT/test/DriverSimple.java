package test;

import domini.Simple;
import domini.Taulell;
import javafx.util.Pair;

// todo
public class DriverSimple {
    public static void main(String[] args) {
        System.out.println("Simular Partida");
        StubPartida simulacio = new StubPartida(new StubProblem("Blanques fan mat en 2", "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1"), new Simple(1), new Simple(2));


        jugarPartida(simulacio);
    }

    private static void jugarPartida(StubPartida simulacio) {

    }
}

