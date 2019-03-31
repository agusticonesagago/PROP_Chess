package test;

import domini.Peca;
import domini.Taulell;

public class StubTaulell extends Taulell {

    public StubTaulell(String Taula_FEN) {
        super(Taula_FEN);
    }

    @Override
    public Boolean PosOcupada(Integer i, Integer j) {
        if (i== 5 && j==1) { // no vull que estigui ocupada
            return false;
        }
        if (i==4 && j==2) {
            return true;
        }

        if (i==-1 && j==-1){
            return false;
        }
        return true;
    }

    @Override
    public Peca[][] getBoard() {
        return super.getBoard();
    }
}
