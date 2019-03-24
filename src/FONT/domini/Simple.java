package domini;

import javafx.util.Pair;

import java.util.ArrayList;

// MIN MAX Algorithm
public class Simple extends Maquina {
    public Simple(Integer id) {
        super(id);
    }

    // Min max functions

    @Override
    public Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> moureFitxa(Taulell t, boolean jugantCom) {
        ArrayList<Taulell> posiblesTaulells = new ArrayList<>();
        ArrayList< Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> > Moviments = new ArrayList<>();


        /* Guardem tots els possibles moviments de cadascun de les nostres peces*/
        for (int i=0; i < 8; ++i) {
            for (int j=0; j < 8; ++j) {
                if (t.PosOcupada(i,j) && t.getBoard()[i][j].getcolor() == jugantCom) { // if pos ocupada i es una peca meva
                    Peca p = t.getBoard()[i][j];
                    // TODO nova funció -> getPosibles moviments: retorna un ArrayList<Pair<int,int>>
                    ArrayList<Pair<Integer,Integer>> movs = p.getPossiblesMoviments();
                    for (int z=0; z < movs.size(); ++z){
                        Taulell x = t;
                        // Creem el taulell en cas de que es fes el moviment
                        x.ferMoviment(new Pair<>(i,j), movs.get(z));
                        posiblesTaulells.add(x);
                        Moviments.add(new Pair<>(new Pair<>(i,j), movs.get(z)));
                    }
                }
            }
        }

        /* Evaluem el potencial de cada posible taulell segons el benefici que aquest ens aporta, i ens quedem nomes
        *  amb aquell que ens aporta més.*/

        Pair<Pair<Integer,Integer>, Pair<Integer,Integer>> millorMoviment = Moviments.get(0);
        int evalMax = evaluataullel(posiblesTaulells.get(0));

        for (int i=1; i < posiblesTaulells.size(); ++i) {
            int aux = evaluataullel(posiblesTaulells.get(i));
            if (aux > evalMax) {
                evalMax = aux;
                millorMoviment = Moviments.get(i);
            }
        }

        return millorMoviment;
    }

    // TODO evaluar taulell
    private int evaluataullel(Taulell taulell) {
        return 0;
    }
}
