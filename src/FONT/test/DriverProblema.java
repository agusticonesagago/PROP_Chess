package test;

import domini.Problema;
import java.util.Scanner;

public class DriverProblema {
    public static void main (String[] args) {
        String fen = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B";
        String t = "Blanques fan mat en 2";
        Problema test = new Problema(t, fen);

        System.out.println("Introdueix un valor valid per a probar les operacions:" + "\n"
                            + "0: Test de la funcio per Crear Problema" + "\n"
                            + "1: Test de la funcio cercaProblema" + "\n"
                            + "2: Test de la funcio eliminarProblema" + "\n"
                            + "3: Test de la funcio modificarProblema" + "\n");

        int cas;
        Scanner sc = new Scanner (System.in);
        cas = sc.nextInt();
        switch (cas){
            case 0:
             System.out.println("Cas 1: el problema conte un FEN que no compleix les normes" + "\n");
             Problema crear = new Problema("Blanques fan mat en 4", "8/8/8/8/8/8/8/NNNkkkRr");

             System.out.println("Cas 2: el problema conte un FEN que no es pot guanyar en els moviments indicats" + "\n");
             Problema crear = new Problema("Blanques fan mat en 4", "5K2/8/8/8/8/8/8/5k2");
            break;

            case 1:
            String s;
             System.out.println("Cas 1: el problema no esta en la base de dades" + "\n");
             s = test.cercaProblema("8/8/8/8/8/8/8/NNNkkkRr");
             System.out.println(s + "\n");
             System.out.println("Cas 2: el problema si esta en la base de dades" + "\n");
             s = test.cercaProblema("1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B");
             System.out.println(s + "\n");
            break;

            case 2:
             test.eliminarProblema("1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B");
            break;

            case 3:
             test.modificarProblema("1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B", "Blanques fan mat en 2");
            break;

            default:
            System.out.println("Final del test" + "\n");
            break;
        }
    }
}
