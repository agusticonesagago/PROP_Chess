package test;

import domini.Taulell;

public class DriverTaulell {
    public static void main (String[] args) {
        String FEN = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B";
        Taulell t = new Taulell(FEN);
        t.PrintBoard();
    }
}
