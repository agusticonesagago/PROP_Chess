package test;

import domini.Problema;
import javafx.util.Pair;

public class DriverProblema {
    public static void main (String[] args) {
        System.out.println("Test de la classe Problema" + "\n");
        //Problema a crear
        String fen1 = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B";
        String tema1 = "Blanques fan mat en 2";
        String dificultat1 = "facil";

        System.out.println("Test de la creadora de Problema" + "\n");
        Problema test = new Problema(tema1, fen1, dificultat1, new StubCtrlDades());
        //Comprobacio de que agafa be les dades
        System.out.println("Test de la funcio que rotorna qui guanyaria i en quans moviments" + "\n");
        Pair <Integer, Boolean> p  = test.getTornMat();
        Integer torn = p.getKey();
        Boolean color = p.getValue();
        String jugador;
        if (color == true) jugador = "Blanques";
        else jugador = "Negres";
        System.out.println("Torns per a fer mat: " + torn + "\n");
        System.out.println("Jugador que pot fer mat: " + jugador + "\n");

    }
}