package test;

import domini.Jugador;
import domini.Partida;
import domini.Taulell;
import javafx.util.Pair;

public class StubJugador extends Jugador {
    public StubJugador(Integer id) {
        super(id);
    }


    @Override
    public Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> moureFitxa(Partida ptd, boolean jugantCom, int torn) {
    Taulell t = ptd.getTaulell();
    if (jugantCom) {
            Pair<Integer, Integer> pi = new Pair<>(6,2);
            Pair<Integer, Integer> pf = new Pair<>(4,2);
            return new Pair<>(pi, pf);
    } else {
            return null;
        }
    }
}
