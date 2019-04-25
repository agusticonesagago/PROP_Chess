package test;

import domini.Peca;
import domini.Taulell;

public class StubTaulellKing extends Taulell {

    public StubTaulellKing (String Taula_FEN) {
        super(Taula_FEN);
    }

    @Override
    public Boolean PosOcupada(Integer i, Integer j) {

        if(i==3 && j==5){
            return true;
        }
        if(i==4 && j==6){
            return true;
        }
        if(i==3 && j==6){
            return true;
        }

        if(i==3 && j==4){
            return true;
        }
        if(i==2 && j==3){
            return true;
        }
        if(i==1 && j==3){
            return true;
        }
        if(i==3 && j==3){
            return true;
        }
        return false;
    }

    @Override
    public Peca[][] getBoard() {
        return super.getBoard();
    }
}