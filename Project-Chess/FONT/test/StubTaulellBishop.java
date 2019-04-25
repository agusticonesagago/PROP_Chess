package test;

import domini.Peca;
import domini.Taulell;

public class StubTaulellBishop extends Taulell {

    public StubTaulellBishop(String Taula_FEN) {
        super(Taula_FEN);
    }

    @Override
    public Boolean PosOcupada(Integer i, Integer j) {

        if(i==3 && j==3){
            return true;
        }
        if(i==3 && j==2){
            return true;
        }
        if(i==3 && j==4){
            return true;
        }
        if(i==3 && j==5){
            return true;
        }
        if(i==5 && j==3){
            return true;
        }
        if(i==4 && j==4){
            return true;
        }
        if(i==4 && j==5){
            return true;
        }
        if(i==4 && j==2){
            return true;
        }
        if(i==3 && j==2){
            return true;
        }
        if(i==5 && j==2){
            return true;
        }
        if(i==5 && j==4){
            return true;
        }
        return false;
    }

    @Override
    public Peca[][] getBoard() {
        return super.getBoard();
    }
}
