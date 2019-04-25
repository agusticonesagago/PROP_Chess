package test;

import domini.Peca;
import domini.Taulell;

public class StubTaulellRook extends Taulell {

    public StubTaulellRook(String Taula_FEN) {
        super(Taula_FEN);
    }

    @Override
    public Boolean PosOcupada(Integer i, Integer j) {


        if(i==4 && j==3){

            return true;
        }

        if(i==4 && j==2){
            return true;
        }

        if(i==4 && j==0){
            return true;
        }

        if(i==4 && j==1){
            return false;
        }

        if(i==4 && j==5){
            return false;
        }

        if(i==4 && j==6){
            return true;
        }

        if(i==4 && j==7){
            return false;
        }

        if(i==2 && j==3){
            return true;
        }

        if(i==1 && j==3){
            return true;
        }

        if(i==0 && j==3){
            return false;
        }

        if(i==3 && j==3){
            return false;
        }

        if(i==6 && j==3){
            return true;
        }


        if(i==1 && j==3){
            return true;
        }

        if(i==5 && j==3){
            return false;
        }

        if(i==3 && j==7){
            return true;
        }
        if(i==4 && j==7){
            return false;
        }
        if(i==5 && j==7){
            return false;
        }
        if(i==1 && j==7){
            return true;
        }
        if(i==1 && j==6){
            return false;
        }
        if(i==0 && j==6){
            return true;
        }
        if(i==0 && j==5){
            return false;
        }


        return false;
    }

    @Override
    public Peca[][] getBoard() {
        return super.getBoard();
    }
}
