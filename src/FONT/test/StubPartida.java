package test;

import domini.Partida;

public class StubPartida extends Partida {
    public StubPartida() {
        super(p, null, null);
    }

    public Boolean simulacorrecte(String fen) {
        if (f == "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B") {
            System.out.println("El problema no es pot solucionar" + "\n");
            return false;
        }
        return true;
    }
}
