package test;

import domini.*;
import java.util.Scanner;
import javafx.util.Pair;

public class DriverProblema {
    public static void main (String[] args) {
        System.out.println("Test de la funcio creadora de problemes" + "\n");
        String fen = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B";
        String tema = "Blanques fan mat en 2";
        String dificultat = "facil";
        Problema test = new Problema(tema, fen, dificultat, new StubCtrlDades());

        System.out.println("Introdueix un valor valid per a probar les operacions:" + "\n"
                            + "0: Test de la funcio per troba guanyador i moviments Problema" + "\n");

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