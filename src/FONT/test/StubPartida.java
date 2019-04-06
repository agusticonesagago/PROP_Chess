package test;

import domini.Partida;
import domini.Problema;
import domini.Simple;

public class StubPartida extends Partida {
    public StubPartida() {
        super(new Problema(), null, null);
    }

    public StubPartida(StubProblem stubProblem, Simple simple, StubJugador stubJugador) {
        super(stubProblem, simple, stubJugador);
    }

    public Boolean simulacorrecte(String fen) {
        if (fen == "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B") {
            System.out.println("El problema no es pot solucionar" + "\n");
            return false;
        }
        return true;
    }
}