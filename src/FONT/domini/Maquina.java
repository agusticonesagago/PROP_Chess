package domini;

import javafx.util.Pair;

public abstract class Maquina extends Jugador{
    public Maquina(Integer id) {
        super(id);
    }

    public abstract Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> moureFitxa(Partida ptd, boolean jugantCom, int torns);
}
