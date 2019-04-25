package test;

import domini.*;
import javafx.util.Pair;

public class DriverPartida {

    public static void main(String[] args) {
        System.out.println("Tests de Creadora ");
        Tests_1();
        System.out.println("Tests de Jugar Torn");
        Tests_2();
    }

    private static void Tests_2() {
        Partida t2 = new Partida(new StubProblem("","rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w - - 0 1"), new StubJugador(1), new StubJugador(2));
        t2.getTaulell().PrintBoard();
        System.out.println("\n");
        t2.jugarTorn(/*new Pair<>(new Pair<>(6,0), new Pair<>(5,0))*/1);
        t2.getTaulell().PrintBoard();
        System.out.println("\n");
        t2.jugarTorn(/*new Pair<>(new Pair<>(1,0), new Pair<>(2,0))*/1);
        t2.getTaulell().PrintBoard();

    }

    private static void Tests_1() {
        Partida t1 = new Partida(new StubProblem("","1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1"), null, null);
        System.out.println("Case 1: Hem declarat un taullel amb el format FEN, torn de les blanques");

        System.out.println("Li toca jugar a Blanques: " + t1.getQuiJuga());
        System.out.println();

    }

}