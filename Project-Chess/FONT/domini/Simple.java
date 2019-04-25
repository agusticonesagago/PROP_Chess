package domini;
import javafx.util.Pair;


public class Simple extends Maquina{
    public Simple(Integer id) {
        super(id);
    }

    @Override
    public Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> moureFitxa(Partida ptd, boolean jugantCom, int torns) {
        SingletonAlgorismes algorismes = SingletonAlgorismes.getInstance();
        return algorismes.moviment_minmax(ptd,jugantCom,torns);
    }

}

