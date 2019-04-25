package test;

import domini.Peca;
import domini.Taulell;

public class StubTaulellKnight extends Taulell {

    public StubTaulellKnight(String Taula_FEN) {
        super(Taula_FEN);
    }

    @Override
    public Boolean PosOcupada(Integer i, Integer j) {


        if(i==2 && j==2){
            return true;
        }
        if(i==1 && j==3){
            return true;
        }
        if(i==1 && j==5){
            return true;
        }
        if(i==2 && j==6){
            return true;
        }
        if(i==4 && j==2){
            return true;
        }
        if(i==5 && j==3){
            return true;
        }
        if(i==5 && j==5){
            return true;
        }
        if(i==4 && j==6){
            return true;
        }

        return false;
    }

    @Override
    public Peca[][] getBoard() {
        return super.getBoard();
    }
}
