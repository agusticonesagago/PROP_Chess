package test;

import domini.Problema;
import java.util.Scanner;

public class DriverProblema {
    public static void main (String[] args) {
        String fen = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B";
        String t = "Mat_en_X";
        Problema test = new Problema(t, fen);

        System.out.println("Introdueix un valor valid per a probar les operacions:\n
                            0: Test de la funcio per Crear Problema\n
                            1: Test de la funcio cercaProblema\n
                            2: Test de la funcio eliminarProblema\n
                            3: Test de la funcio modificarProblema\n");

        String fenTest;
        String temaTest;

        int cas;
        Scanner sc = new Scanner (System.in);
        cas = sc.nextInt();
        switch (cas){
            case 0:
             System.out.println("Introdueix el fen a probar\n");
             fenTest = sc.nextLine();
             System.out.println("Introdueix el tema\n");
             temaTest = sc.nextLine();
             Problema crear = new Problema(temaTest, fenTest);
            break;

            case 1:
             System.out.println("Introdueix el fen a probar\n");
             fenTest = sc.nextLine();
             test.cercaProblema(fenTest);
            break;

            case 2:
             System.out.println("Introdueix el fen a probar\n");
             fenTest = sc.nextLine();
             test.eliminarProblema(fenTest);
            break;

            case 3:
             System.out.println("Introdueix el fen a probar\n");
             fenTest = sc.nextLine();
             System.out.println("Introdueix el tema\n");
             temaTest = sc.nextLine();
             test.modificarProblema(fenTest, temaTest);
            break;

            default:
            System.out.println("Final del test");
            break;
        }
    }
}
