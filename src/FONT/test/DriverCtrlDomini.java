package test;

import domini.CtrlDomini;
import java.util.Vector;

public class DriverCtrlDomini {
    public static void main (String[] args) {
        CtrlDomini CD  = new CtrlDomini();
        String fen = "3k4/8/8/8/8/1r6/r7/7K b - - 0 1";
        String tema = "Negres fan mat en 1";
        String dificultat = "facil";
        Vector<String> problema = new Vector<>();
        problema.add(0,fen);
        problema.add(1,tema);
        problema.add(2,dificultat);
        System.out.println("Configurem la partida" + "\n");
        CD.configurarPartida(problema, "Maquina1", "Maquina1");
        CD.jugarPartida();
    }
}
