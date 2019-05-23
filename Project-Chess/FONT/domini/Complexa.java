package domini;
import javafx.util.Pair;

import static java.lang.Integer.min;


public class Complexa extends Maquina{
    public Complexa(Integer id) {
        super(id);
    }

    @Override
    public Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> moureFitxa(Partida ptd, boolean jugantCom, int torns) {
        System.out.println("falla singleton");
        SingletonAlgorismes algorismes = SingletonAlgorismes.getInstance();
        System.out.println("falla minim");
        Integer minim = min(torns,3);
        return algorismes.moviment_esperadelreposo3prof(ptd,jugantCom,minim);
    }

}

