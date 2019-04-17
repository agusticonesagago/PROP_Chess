package test;

import domini.CtrlDomini;
import domini.CtrlDominiMantRanking;

import java.util.Vector;

public class DriverCtrlDomini {
    public static void main (String[] args) {
        CtrlDomini CD  = new CtrlDomini();
        String guanyador;
        String nom1 = "Agusti";
        String nom2 = "Enric";

        //l'algorisme no funciona(crea situacio d'empat): "5Br1/5PP1/5KBk/8/8/8/8/8 w - - 0 1"; "Blanques fan mat en 2"
        //l'algorisme funciona: "4k3/3ppp2/8/8/7Q/8/8/2K5 w - - 0 1"; "Blanques fan mat en 1"
        //l'algorisme funciona: "4k3/1R6/R7/8/8/8/8/2K5 w - - 0 1"; "Blanques fan mat en 1"
        //l'algorisme no funciona(crea situacio d'empat): "3k4/8/8/8/8/1r6/6r1/7K b - - 0 1";

        String fen = "r2k4/8/8/8/8/8/1r6/7K b - - 0 1";
        String tema = "Negres fan mat en 1";
        String dificultat = "facil";
        Vector<String> problema = new Vector<>();
        problema.add(0,fen);
        problema.add(1,tema);
        problema.add(2,dificultat);
        System.out.println("Configurem la partida" + "\n");
        CD.configurarPartida(problema, "Maquina1", "Maquina1");
        guanyador = CD.jugarPartida(nom1, nom2);
        System.out.println("El guanyador son les " + guanyador + "\n");

        CtrlDominiMantRanking cdmr= CD.getCDMr();
        Vector<String> llista = cdmr.consultaRankings();
        for (int i = 0; i < llista.size(); ++i) {
            System.out.println(llista.get(i) + "\n");
        }
    }
}