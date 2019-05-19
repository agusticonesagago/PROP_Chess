package test;

import domini.Queen;
import javafx.util.Pair;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DriverQueen {
    public static void main(String[] args) throws IOException {

        /*System.out.println("El testeig de les blanques i negres de la reina és el mateix");
        System.out.println("Introdueix 0 si vols testejar endavant" + '\n' +
                "Introdueix 1 si vols testejar endarrere " + '\n' +
                "Introdueix 2 si vols testejar dreta" + '\n' +
                "Introdueix 3 si vols testejar esquerra" + '\n' +
                "Introdueix 4 si vols testejar diagonal"
        );*/

        String path = "./OutputQueen.txt";
        FileWriter write = new FileWriter( path , false);
        PrintWriter t = new PrintWriter( write );

        File file = new File("./DadesQueen.txt");
        Scanner sc = new Scanner(file);

        Integer opcion;

        while(sc.hasNextLine()) {
            opcion = Integer.valueOf(sc.nextLine());
            if(opcion==0){ //endavant
                Integer rival;
               /* System.out.println("Introdueix 0 si vols testejar sense sobrepassar" +'\n' +
                        "Introdueix 1 si vols testejar amb sobrepassar");*/

                rival = Integer.valueOf(sc.nextLine());
                if(rival==0){
                    StubTaulellQueen st_cas1 = new StubTaulellQueen("rnbqkbnr/6p1/pp6/2pppp1p/2PQP3/2NPKP2/PP4PP/R1B2BNR b kq - 0 10");
                    Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3));
                    boolean ok = p.espotmoure(new Pair<>(3, 3));
                    if (ok) t.printf("EM PUC MOURE, resultat correcte");
                    else t.printf("NO EM PUC MOURE, resultat incorrecte");
                }

                else if(rival==1){
                    StubTaulellQueen st_cas1 = new StubTaulellQueen("rnbqkbnr/6p1/pp6/2pppp1p/2PQP3/2NPKP2/PP4PP/R1B2BNR b kq - 0 10");
                    Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3));
                    boolean ok = p.espotmoure(new Pair<>(2, 3));
                    if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                    else t.printf("NO EM PUC MOURE, resultat correcte");
                }
            }

            else if(opcion==1){ //endarrere
                Integer rival;
             /*   System.out.println("Introdueix 0 si vols testejar sense sobrepassar" +'\n' +
                        "Introdueix 1 si vols testejar amb sobrepassar");*/
                rival = Integer.valueOf(sc.nextLine());

                if(rival==0){
                    StubTaulellQueen st_cas1 = new StubTaulellQueen("rnbqkbnr/6p1/pp6/2pppp1p/2PQP3/2NPKP2/PP4PP/R1B2BNR b kq - 0 10");
                    Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3));
                    boolean ok = p.espotmoure(new Pair<>(5, 3));
                    if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                    else t.printf("NO EM PUC MOURE, resultat correcte");
                }

                else if(rival==1){
                    StubTaulellQueen st_cas1 = new StubTaulellQueen("rnbqkbnr/6p1/pp6/2pppp1p/2PQP3/2NPKP2/PP4PP/R1B2BNR b kq - 0 10");
                    Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3));
                    boolean ok = p.espotmoure(new Pair<>(6, 3));
                    if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                    else t.printf("NO EM PUC MOURE, resultat correcte");
                }
            }

            else if(opcion==2){ //dreta
                Integer rival;
            /*    System.out.println("Introdueix 0 si vols testejar sense sobrepassar" +'\n' +
                        "Introdueix 1 si vols testejar amb sobrepassar");*/
                rival = Integer.valueOf(sc.nextLine());

                if(rival==0){
                    StubTaulellQueen st_cas1 = new StubTaulellQueen("rnbqkbnr/6p1/pp6/2pppp1p/2PQP3/2NPKP2/PP4PP/R1B2BNR b kq - 0 10");
                    Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3));
                    boolean ok = p.espotmoure(new Pair<>(4, 4));
                    if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                    else t.printf("NO EM PUC MOURE, resultat correcte");
                }

                else if(rival==1){
                    StubTaulellQueen st_cas1 = new StubTaulellQueen("rnbqkbnr/6p1/pp6/2pppp1p/2PQP3/2NPKP2/PP4PP/R1B2BNR b kq - 0 10");
                    Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3));
                    boolean ok = p.espotmoure(new Pair<>(4,5));
                    if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                    else t.printf("NO EM PUC MOURE, resultat correcte");
                }
            }

            else if(opcion==3){ //esquerra
                Integer rival;
             /*   System.out.println("Introdueix 0 si vols testejar sense sobrepassar" +'\n' +
                        "Introdueix 1 si vols testejar amb sobrepassar");*/
                rival = Integer.valueOf(sc.nextLine());

                if(rival==0){
                    StubTaulellQueen st_cas1 = new StubTaulellQueen("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PQP3/1PNPKPP1/P6P/R1B2BNR w - - 0 13");
                    Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3));
                    boolean ok = p.espotmoure(new Pair<>(4, 2));
                    if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                    else t.printf("NO EM PUC MOURE, resultat correcte");
                }

                else if(rival==1){
                    StubTaulellQueen st_cas1 = new StubTaulellQueen("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PQP3/1PNPKPP1/P6P/R1B2BNR w - - 0 13");
                    Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3));
                    boolean ok = p.espotmoure(new Pair<>(4,1));
                    if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                    else t.printf("NO EM PUC MOURE, resultat correcte");
                }
            }
            else if(opcion==4) { //diagonals
                Integer diagonal;
               /* System.out.println("Introdueix 0 si vols testejar diagonal adalt-esquerra" +'\n' +
                        "Introdueix 1 si vols testejar diagonal avall-esquerra"+'\n' +
                        "Introdueix 2 si vols testejar diagonal adalt-dreta"+'\n' +
                        "Introdueix 3 si vols testejar diagonal avall-dreta"
                );*/

                diagonal = Integer.valueOf(sc.nextLine());

                if (diagonal == 0) { //adalt-esquerra
                    Integer rival;
                   /* t.printf("Introdueix 0 si vols testejar sense sobrepassar" +'\n' +
                            "Introdueix 1 si vols testejar amb sobrepassar");*/
                    rival = Integer.valueOf(sc.nextLine());

                    if (rival == 0) {
                        StubTaulellQueen st_cas1 = new StubTaulellQueen("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PQP3/1PNPKPP1/P6P/R1B2BNR w - - 0 13");
                        Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3));
                        boolean ok = p.espotmoure(new Pair<>(3, 2));
                        if (ok) t.printf("EM PUC MOURE, resultat correcte");
                        else t.printf("NO EM PUC MOURE, resultat incorrecte");
                    } else if (rival == 1) {
                        StubTaulellQueen st_cas1 = new StubTaulellQueen("8/2bN2nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1");
                        Queen p = new Queen(false, new Pair<Integer, Integer>(4, 6));
                        boolean ok = p.espotmoure(new Pair<>(0, 2));
                        if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                        else t.printf("NO EM PUC MOURE, resultat correcte");
                    }
                } else if (diagonal == 1) { //avall-esquerra
                    Integer rival;
                   /* t.printf("Introdueix 0 si vols testejar sense sobrepassar" +'\n' +
                            "Introdueix 1 si vols testejar amb sobrepassar");*/
                    rival = Integer.valueOf(sc.nextLine());

                    if (rival == 0) {
                        StubTaulellQueen st_cas1 = new StubTaulellQueen("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PQP3/1PNPKPP1/P6P/R1B2BNR w - - 0 13");
                        Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3));
                        boolean ok = p.espotmoure(new Pair<>(5, 2));
                        if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                        else t.printf("NO EM PUC MOURE, resultat correcte");
                    } else if (rival == 1) {
                        StubTaulellQueen st_cas1 = new StubTaulellQueen("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PQP3/1PNPKPP1/P6P/R1B2BNR w - - 0 13");
                        Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3));
                        boolean ok = p.espotmoure(new Pair<>(6, 1));
                        if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                        else t.printf("NO EM PUC MOURE, resultat correcte");
                    }
                } else if (diagonal == 3) { //avall-dreta
                    Integer rival;
                    /*System.out.println("Introdueix 0 si vols testejar sense sobrepassar" +'\n' +
                            "Introdueix 1 si vols testejar amb sobrepassar");*/
                    rival = Integer.valueOf(sc.nextLine());

                    if (rival == 0) {
                        StubTaulellQueen st_cas1 = new StubTaulellQueen("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PQP3/1PNPKPP1/P6P/R1B2BNR w - - 0 13");
                        Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3));
                        boolean ok = p.espotmoure(new Pair<>(5, 4));
                        if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                        else t.printf("NO EM PUC MOURE, resultat correcte");
                    } else if (rival == 1) {
                        StubTaulellQueen st_cas1 = new StubTaulellQueen("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PQP3/1PNPKPP1/P6P/R1B2BNR w - - 0 13");
                        Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3));
                        boolean ok = p.espotmoure(new Pair<>(1, 3));
                        if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                        else t.printf("NO EM PUC MOURE, resultat correcte");
                    }
                } else if (diagonal == 2) { //adalt-dreta
                    Integer rival;
                    /*System.out.println("Introdueix 0 si vols testejar sense sobrepassar" +'\n' +
                            "Introdueix 1 si vols testejar amb sobrepassar");*/
                    rival = Integer.valueOf(sc.nextLine());

                    if (rival == 0) {
                        StubTaulellQueen st_cas1 = new StubTaulellQueen("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PQP3/1PNPKPP1/P6P/R1B2BNR w - - 0 13");
                        Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3));
                        boolean ok = p.espotmoure(new Pair<>(3, 4));
                        if (ok) t.printf("EM PUC MOURE, resultat correcte");
                        else t.printf("NO EM PUC MOURE, resultat incorrecte");
                    } else if (rival == 1) {
                        StubTaulellQueen st_cas1 = new StubTaulellQueen("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PQP3/1PNPKPP1/P6P/R1B2BNR w - - 0 13");
                        Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3));
                        boolean ok = p.espotmoure(new Pair<>(2, 5));
                        if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                        else t.printf("NO EM PUC MOURE, resultat correcte");
                    }
                }
            }
            t.printf("%n");
        }
        t.close();
    }
}
