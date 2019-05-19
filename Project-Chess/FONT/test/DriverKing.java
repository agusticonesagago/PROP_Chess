package test;

import domini.King;
import javafx.util.Pair;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DriverKing {
    public static void main(String[] args) throws IOException {


        String path = "./OutputKing.txt";
        FileWriter write = new FileWriter( path , false);
        PrintWriter t = new PrintWriter( write );

        File file = new File("./DadesKing.txt");
        Scanner sc = new Scanner(file);


        int opcion;
        while(sc.hasNextLine()) {
            opcion = Integer.parseInt(sc.nextLine());

            if (opcion == 1) { //endavant
                //amb rival
                StubTaulellKing st_cas1 = new StubTaulellKing("rnb1kbnr/pppp4/7p/5pq1/3P1Kp1/4p3/QPP1PPPP/RNBQ1BNR w - - 2 9");
                King p = new King(false, new Pair<Integer, Integer>(4, 5));
                boolean ok = p.espotmoure(new Pair<>(3, 5));
                if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                else t.printf("NO EM PUC MOURE, resultat correcte");
            } else if (opcion == 0) { //endarrere
                StubTaulellKing st_cas1 = new StubTaulellKing("rnbq1bnr/ppppp1pp/3Pkp2/1B2P3/8/8/PPP1KPPP/RNBQ2NR b - - 0 8");
                King p = new King(false, new Pair<Integer, Integer>(2, 4));
                boolean ok = p.espotmoure(new Pair<>(3, 4));
                if (ok) t.printf("EM PUC MOURE, resultat correcte");
                else t.printf("NO EM PUC MOURE, resultat incorrecte");
            } else if (opcion == 2) { //dreta
                StubTaulellKing st_cas1 = new StubTaulellKing("rnb1kbnr/pppp4/7p/5pq1/3P1Kp1/4p3/QPP1PPPP/RNBQ1BNR w - - 2 9");
                King p = new King(false, new Pair<Integer, Integer>(4, 5));
                boolean ok = p.espotmoure(new Pair<>(4, 6));
                if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                else t.printf("NO EM PUC MOURE, resultat correcte");
            } else if (opcion == 3) { //esquerra
                StubTaulellKing st_cas1 = new StubTaulellKing("rnbq1bnr/ppppp1pp/3Pkp2/1B2P3/8/8/PPP1KPPP/RNBQ2NR b - - 0 8");
                King p = new King(false, new Pair<Integer, Integer>(2, 4));
                boolean ok = p.espotmoure(new Pair<>(2, 3));
                if (ok) t.printf("EM PUC MOURE, resultat correcte");
                else t.printf("NO EM PUC MOURE, resultat incorrecte");
            } else if (opcion == 4) { //diagonal
                int diagonal;
                diagonal = Integer.parseInt(sc.nextLine());

                if (diagonal == 0) {
                    StubTaulellKing st_cas1 = new StubTaulellKing("rnb1kbnr/pppp4/7p/5pq1/3P1Kp1/4p3/QPP1PPPP/RNBQ1BNR w - - 2 9");
                    King p = new King(false, new Pair<Integer, Integer>(4, 5));
                    boolean ok = p.espotmoure(new Pair<>(3, 6));
                    if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                    else t.printf("NO EM PUC MOURE, resultat correcte");
                } else if (diagonal == 1) {
                    StubTaulellKing st_cas1 = new StubTaulellKing("rnbq1bnr/1pppp1pp/3Pkp2/1B2PP2/p7/8/PPP1K1PP/RNBQ2NR b - - 0 10");
                    King p = new King(false, new Pair<Integer, Integer>(2, 4));
                    boolean ok = p.espotmoure(new Pair<>(3, 5));
                    if (ok) t.printf("EM PUC MOURE, resultat correcte");
                    else t.printf("NO EM PUC MOURE, resultat incorrecte");
                } else if (diagonal == 2) {
                    StubTaulellKing st_cas1 = new StubTaulellKing("rnb1kbnr/pppp4/7p/5pq1/3P1Kp1/4p3/QPP1PPPP/RNBQ1BNR w - - 2 9");
                    King p = new King(false, new Pair<Integer, Integer>(2, 4));
                    boolean ok = p.espotmoure(new Pair<>(1, 3));
                    if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                    else t.printf("NO EM PUC MOURE, resultat correcte");
                } else if (diagonal == 3) {
                    StubTaulellKing st_cas1 = new StubTaulellKing("rnbq1bnr/1pppp1pp/3Pkp2/3BP3/p7/7P/PPP1K1P1/RNBQ2NR b - - 2 16");
                    King p = new King(false, new Pair<Integer, Integer>(2, 4));
                    boolean ok = p.espotmoure(new Pair<>(3, 3));
                    if (ok) t.printf("EM PUC MOURE, resultat correcte");
                    else t.printf("NO EM PUC MOURE, resultat incorrecte");
                }
            }
            t.println();
        }
        t.close();
    }
}
