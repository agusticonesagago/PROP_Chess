package test;

import domini.Jugador;
import domini.Partida;
import domini.Problema;

public class StubPartida extends Partida {
    public StubPartida(Problema P, Jugador blanques, Jugador negres) {
        super(P, blanques, negres);
    }
}
