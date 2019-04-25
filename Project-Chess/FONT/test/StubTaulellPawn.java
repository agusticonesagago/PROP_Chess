package test;

import domini.Peca;
import domini.Taulell;

public class StubTaulellPawn extends Taulell {

    public StubTaulellPawn(String Taula_FEN) {
        super(Taula_FEN);
    }

    @Override
    public Boolean PosOcupada(Integer i, Integer j) {


        if (i==4 && j==2) {
            return true;
        }

        if (i==-1 && j==-1){
            return false;
        }

        if(i==5 && j==1 ){
            return  false;
        }

        if(i==4 && j==1 ){
            return  false;
        }

        if(i==5 && j==4){
            return true;
        }
        if(i==4 && j==4){
            return false;
        }

        if(i==2 && j==3){
            return true;
        }
        if(i==2 && j==0){
            return false;
        }

        if(i==3 && j==3){
            return false;
        }

        if(i==2 && j==3){
            return true;
        }
        if(i==3 && j==0){
            return false;
        }

        if(i==2 && j==1){
            return false;
        }
        return false;
    }

    @Override
    public Peca[][] getBoard() {
        return super.getBoard();
    }
}
