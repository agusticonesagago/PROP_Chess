package domini;

import javafx.util.Pair;

import java.util.ArrayList;

// MIN MAX Algorithm

// TODO Pot ser aplicar alpha beta ????



public class Simple extends Maquina{
    public Simple(Integer id) {
        super(id);
    }



    // TODO Versio -> Blanc o negre min max.


    // Min max functions
    // TODO Pot ser canviar la mecanica de moure fitxa?
    @Override
    public Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> moureFitxa(Partida ptd, boolean jugantCom, int torns) {
        Taulell t = ptd.getTaulell();
        ArrayList<Taulell> posiblesTaulells = new ArrayList<>();
        ArrayList< Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> > Moviments = new ArrayList<>();


        /* Guardem tots els possibles moviments de cadascun de les nostres peces*/
        // todo extraure metode.
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


        // TODO a PROBLEMA cal fer la funció QuiHaDeFerMat -> aquesta info esta a tema oi ??;
        // boolean maximitzarJugador = ptd.getProblema().getQuiHaDeFerMat();

        Pair<Pair<Integer,Integer>, Pair<Integer,Integer>> millorMoviment = Moviments.get(0);
        int evalMax = evaluataullel(posiblesTaulells.get(0), jugantCom, torns);

        for (int i=1; i < posiblesTaulells.size(); ++i) {
            int aux = evaluataullel(posiblesTaulells.get(i), jugantCom, torns);
            if (aux > evalMax) {
                evalMax = aux;
                millorMoviment = Moviments.get(i);
            }
        }

        return millorMoviment;
    }


    private int evaluataullel(Taulell taulell, boolean jugantCom,  int torns) {
        if (torns == 0) {
            /* Cas Basic, en aquest cas evaluem el taullel segons l'assignació de valors esmentada en el document respectiu
            a la descripció de l'algorisme
             */
            return calculTaulell(taulell);
        }

        // todo extraure func
        ArrayList< Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> > mvs = new ArrayList<>();
        // Agafem tot l'arbre de moviments respectius a aquest torn
        for (int i=0; i < 8; ++i) {
            for (int j=0; j < 8; ++j) {
                if (taulell.PosOcupada(i,j) && taulell.getBoard()[i][j].getcolor() == jugantCom) {
                    Peca p = taulell.getBoard()[i][j];
                    for(int z=0; z<8; ++z) {
                        for(int w=0; w<8; ++w) {
                            if (p.espotmoure(new Pair<>(z,w))){ // if mov valid -> add a mvs
                                mvs.add(new Pair<>(new Pair<>(i,j), new Pair<>(z,w)));
                            }
                        }
                    }
                }
            }
        }
        // Cas que volem maximitzar la puntuació -> jugador a maximitzar (qui aplica el algorisme)
        if (jugantCom) {
            // Ara agafem busquem aquell moviment que port a la maxima puntuació
            int max = -1000000;
            for (int i=0; i < mvs.size(); ++i) {
                Pair<Integer, Integer> posini = mvs.get(i).getKey();
                Pair<Integer, Integer> posfi  = mvs.get(i).getValue();
                Taulell aux = taulell;
                aux.ferMoviment(posini, posfi);
                max = Math.max(max, evaluataullel(aux, !jugantCom, torns-1));
            }
            return max;
        }
        // Cas que volem minimitzar la puntuació -> jugador a minimitar (contrincant)
        else {
            int min = 1000000;
            for(int i=0; i < mvs.size(); ++i) {
                Pair<Integer, Integer> posini = mvs.get(i).getKey();
                Pair<Integer, Integer> posfi  = mvs.get(i).getValue();
                Taulell aux = taulell;
                aux.ferMoviment(posini, posfi);
                min = Math.min(min, evaluataullel(aux, !jugantCom, torns-1));
            }
            return min;
        }
    }
    // TODO trobar com fer per que es pugui fer tambe amb color negre aplicant minmax com a max.


    // Establim estandars de costos. Inicialment:
    /*
    Peo -> 10
    Caball -> 30
    Alfil  -> 30
    Torre  -> 50
    Reina  -> 100
    Rei    -> 1000
    */
    private int calculTaulell(Taulell taulell) {
        int total = 0;

        for(int i=0; i < 8; ++i) {
            for(int j=0; j < 8; ++j) {
                if (taulell.PosOcupada(i,j)) {
                    Peca p = taulell.getBoard()[i][j];
                    if (p.getcolor()) { // White
                        System.out.println(p.getClass().getName());
                    }
                }
            }
        }
        return 0;
    }
}
