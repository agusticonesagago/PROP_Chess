package test;


import domini.*;

public class DriverPartida {

    public static void main(String[] args) {
        System.out.println("Tests de Creadora ");
        Tests_1();
        System.out.println("Tests de Jugar Torn");
        Tests_2();
    }

    private static void Tests_2() { // TODO test de Jugar Torn
        Partida t2 = new Partida(new StubProblem("","rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w - - 0 1"), new StubJugador(1), new StubJugador(2));
        t2.getTaulell().PrintBoard();
        System.out.println("\n");
        t2.jugarTorn();
        t2.getTaulell().PrintBoard();
        System.out.println("\n");
        t2.jugarTorn();
        t2.getTaulell().PrintBoard();
        t2.jugarTorn();
        t2.getTaulell().PrintBoard();

    }

    private static void Tests_1() {
        Partida t1 = new Partida(new StubProblem("","1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1"), null, null);
        System.out.println("Case 1: Hem declarat un taullel amb el format FEN, torn de les blanques i el torn actual es el 1.");

        System.out.println("Li toca jugar a Blanques: " + t1.getQuiJuga());
        System.out.println("El torn actual es el: " + t1.getTorn());
        System.out.println("");

    }

}