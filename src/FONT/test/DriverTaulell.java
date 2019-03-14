package test;

import domini.Taulell;
import javafx.util.Pair;

public class DriverTaulell {
    public static void main (String[] args) {
        String FEN = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B";
        Taulell t = new Taulell(FEN);
        t.PrintBoard();

        Pair<Integer, Integer> Pos = new Pair<Integer, Integer> (0, 1);
        Boolean ocupat = t.PosOcupada(Pos);
        if (ocupat) System.out.println("OCUPAT");
        else System.out.println("LLIURE");
    }
}
