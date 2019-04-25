package test;

import domini.CtrlDades;

public class StubCtrlDades extends CtrlDades {
    public StubCtrlDades() {
        super();
    }

    @Override
    public void afegeixProblema(String f, String d, String t) {
        if (f == "8/8/8/8/8/8/8/NNNkkkRr" || f == "5K2/8/8/8/8/8/8/5k2") {
            System.out.println("El problema no s'ha afegit a la base de dades" + "\n");
        }
        else if (f == "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B") {
            System.out.println("El problema s'ha afegit a la base de dades" + "\n");
        }
        
    }

    @Override
    public boolean cercaProblema(String f) {
        if (f == "8/8/8/8/8/8/8/NNNkkkRr") {
            System.out.println("El problema no esta a la base de dades" + "\n");
            return false;
        }
        else if (f == "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B") {
            System.out.println("El problema esta a la base de dades" + "\n");
            return true;
        }
        else return false;
    }

    @Override
    public void eliminaProblema(String f){
        System.out.println("El problema s'ha tret de la base de dades" + "\n");
    }

    @Override
    public void modificaProblema(String fen, String t, String dif) {
        System.out.println("El problema s'ha modificat a la base de dades" + "\n");
    }
}