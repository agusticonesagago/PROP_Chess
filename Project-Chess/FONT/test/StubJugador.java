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
        if (this.getID() == 1) return new Pair<>(new Pair<>(6,0), new Pair<>(5,0));
        else if (this.getID() == 2) return new Pair<>(new Pair<>(1,0), new Pair<>(2,0));
        return null;
    }
}
