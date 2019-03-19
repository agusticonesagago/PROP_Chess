package test;

import domini.Pawn;
import javafx.util.Pair;

public class DriverPawn {
    public static void main(String[] args) {
        StubTaulell st_cas1 = new StubTaulell("8/8/8/8/8/8/8/8");
        Pawn p = new Pawn(true, new Pair<Integer, Integer>(6,1), st_cas1);

        System.out.println("TEST MOVIMENT 1 posició endavant sense problemes");
        boolean ok = p.espotmoure(new Pair<>(5,1));
        if (ok) System.out.println("EM PUC MOURE");
        else System.out.println("NO EM PUC MOURE");
    }
}
