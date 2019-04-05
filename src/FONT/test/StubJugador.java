package test;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
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
        if (torn == 2) {
            return new Pair<>(new Pair<>(4,7), new Pair<>(4,6));
        } else if ( torn == 0) {
            return new Pair<>(new Pair<>(0,0), new Pair<>(4,3));
        }
        return null;
    }
}
