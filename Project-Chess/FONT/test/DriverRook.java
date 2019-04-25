package test;

import domini.Rook;
import javafx.util.Pair;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DriverRook {
    public static void main(String[] args) throws IOException {

        /*System.out.println("El testeig de les blanques i negres de torre és el mateix");
        System.out.println("Introdueix 0 si vols testejar endarrere" + '\n' +
                "Introdueix 1 si vols testejar endavant " + '\n' +
                "Introdueix 2 si vols testejar cap a la dreta"+ '\n' +
                "Introdueix 3 si vols testejar cap a l'esquerra"
        );*/

        String path = "./Project-Chess/EXE/Rook/OutputRook.txt";
        FileWriter write = new FileWriter( path , false);
        PrintWriter t = new PrintWriter( write );

        File file = new File("./Project-Chess/EXE/Rook/DadesRook.txt");
        Scanner sc = new Scanner(file);

        Integer opcion;

        while(sc.hasNextLine()) {
            opcion = Integer.valueOf(sc.nextLine());

            if (opcion == 0) { //endarrera
                Integer rival;
                /*System.out.println("Introdueix 0 si vols testejar amb rival" +'\n' +
                        "Introdueix 1 si vols testejar sense rival " + '\n' +
                        "Introdueix 2 si vols testejar sobrepassar");*/

                rival = Integer.valueOf(sc.nextLine());

                if (rival == 0) { //rival
                    StubTaulellRook st_cas1 = new StubTaulellRook("1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1");
                    Rook p = new Rook(true, new Pair<Integer, Integer>(2, 0), st_cas1);
                    boolean ok = p.espotmoure(new Pair<>(4, 0));
                    if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                    else t.printf("NO EM PUC MOURE, resultat correcte");
                } else if (rival == 1) { //sense rival
                    StubTaulellRook st_cas1 = new StubTaulellRook("rnbqk1nr/pppppp2/3R4/6pp/3b3P/8/PPPPPP2/RNBQKBN1 b Qkq - 2 1");
                    Rook p = new Rook(true, new Pair<Integer, Integer>(2, 3), st_cas1);
                    boolean ok = p.espotmoure(new Pair<>(3, 3));
                    if (ok) t.printf("EM PUC MOURE, resultat correcte");
                    else t.printf("NO EM PUC MOURE, resultat incorrecte");
                } else if (rival == 2) { //sobrepassar
                    StubTaulellRook st_cas1 = new StubTaulellRook("rnbqk1nr/pppppp2/3R4/6pp/3b3P/8/PPPPPP2/RNBQKBN1 b Qkq - 2 1");
                    Rook p = new Rook(false, new Pair<Integer, Integer>(2, 3), st_cas1);
                    boolean ok = p.espotmoure(new Pair<>(5, 3));
                    if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                    else t.printf("NO EM PUC MOURE, resultat correcte");
                }
            } else if (opcion == 1) { //endavant
                Integer rival;
                /*System.out.println("Introdueix 0 si vols testejar amb rival" +'\n' +
                        "Introdueix 1 si vols testejar sense rival " + '\n' +
                        "Introdueix 2 si vols testejar sobrepassar");*/

                rival = Integer.valueOf(sc.nextLine());

                if (rival == 0) { //rival
                    StubTaulellRook st_cas1 = new StubTaulellRook("rn3bn1/pp1p1k2/3P3p/1Npr1ppP/2P2PP1/4p3/PP2P3/RNBQKB1R w KQ - 3 1");
                    Rook p = new Rook(false, new Pair<Integer, Integer>(4, 3), st_cas1);
                    boolean ok = p.espotmoure(new Pair<>(2, 3));
                    if (ok) t.printf("EM PUC MOURE, resultat correcte");
                    else t.printf("NO EM PUC MOURE, resultat incorrecte");
                } else if (rival == 1) { //sense rival
                    StubTaulellRook st_cas1 = new StubTaulellRook("rn3bn1/pp1p1k2/3P3p/1Npr1ppP/2P2PP1/4p3/PP2P3/RNBQKB1R w KQ - 3 1");
                    Rook p = new Rook(false, new Pair<Integer, Integer>(4, 3), st_cas1);
                    boolean ok = p.espotmoure(new Pair<>(3, 3));
                    if (ok) t.printf("EM PUC MOURE, resultat correcte");
                    else t.printf("NO EM PUC MOURE, resultat incorrecte");
                } else if (rival == 2) { //sobrepassar
                    StubTaulellRook st_cas1 = new StubTaulellRook("rn3bn1/pp1p1k2/3P3p/1Np1ppP1/2PrPP2/4p3/PP2P3/RNBQKB1R w KQ - 3 12");
                    Rook p = new Rook(false, new Pair<Integer, Integer>(4, 3), st_cas1);
                    boolean ok = p.espotmoure(new Pair<>(0, 3));
                    if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                    else t.printf("NO EM PUC MOURE, resultat correcte");
                }
            } else if (opcion == 2) { //dreta
                Integer rival;
                /*System.out.println("Introdueix 0 si vols testejar amb rival" +'\n' +
                        "Introdueix 1 si vols testejar sense rival " + '\n' +
                        "Introdueix 2 si vols testejar sobrepassar");*/

                rival = Integer.valueOf(sc.nextLine());

                if (rival == 0) { //rival
                    StubTaulellRook st_cas1 = new StubTaulellRook("rnbqkbn1/pp1p4/2pP3p/1N3ppP/2P1r1P1/4p3/PP2PP2/RNBQKB1R b KQq - 0 12");
                    Rook p = new Rook(false, new Pair<Integer, Integer>(4, 4), st_cas1);
                    boolean ok = p.espotmoure(new Pair<>(4, 6));
                    if (ok) t.printf("EM PUC MOURE, resultat correcte");
                    else t.printf("NO EM PUC MOURE, resultat incorrecte");
                } else if (rival == 1) { //sense rival
                    StubTaulellRook st_cas1 = new StubTaulellRook("rnbqkbn1/pppp4/3P3p/1N3pp1/2P1r1PP/4p3/PP2PP2/RNBQKB1R b KQq - 4 11");
                    Rook p = new Rook(false, new Pair<Integer, Integer>(4, 4), st_cas1);
                    boolean ok = p.espotmoure(new Pair<>(4, 5));
                    if (ok) t.printf("EM PUC MOURE, resultat correcte");
                    else t.printf("NO EM PUC MOURE, resultat incorrecte");
                } else if (rival == 2) { //sobrepassar
                    StubTaulellRook st_cas1 = new StubTaulellRook("rnbqkbn1/pppp4/3P3p/1N3pp1/2P1r1PP/4p3/PP2PP2/RNBQKB1R b KQq - 4 11");
                    Rook p = new Rook(false, new Pair<Integer, Integer>(4, 4), st_cas1);
                    boolean ok = p.espotmoure(new Pair<>(4, 7));
                    if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                    else t.printf("NO EM PUC MOURE, resultat correcte");
                }
            } else if (opcion == 3) { //esquerra
                Integer rival;
                /*System.out.println("Introdueix 0 si vols testejar amb rival" +'\n' +
                        "Introdueix 1 si vols testejar sense rival " + '\n' +
                        "Introdueix 2 si vols testejar sobrepassar");*/
                rival = Integer.valueOf(sc.nextLine());

                if (rival == 0) { //rival
                    StubTaulellRook st_cas1 = new StubTaulellRook("rnbqkbn1/pppp4/3P3p/1N3pp1/r1P3PP/p7/PP2PP2/RNBQKB1R b KQq -");
                    Rook p = new Rook(false, new Pair<Integer, Integer>(3, 7), st_cas1);
                    boolean ok = p.espotmoure(new Pair<>(5, 7));
                    if (ok) t.printf("EM PUC MOURE, resultat correcte");
                    else t.printf("NO EM PUC MOURE, resultat incorrecte");
                } else if (rival == 1) { //sense rival
                    StubTaulellRook st_cas1 = new StubTaulellRook("rnbqkbn1/pppp3r/3P3p/1N3pp1/2P3PP/4p3/PP2PP2/RNBQKB1R b KQq -");
                    Rook p = new Rook(false, new Pair<Integer, Integer>(1, 7), st_cas1);
                    boolean ok = p.espotmoure(new Pair<>(1,6));
                    if (ok) t.printf("EM PUC MOURE, resultat correcte");
                    else t.printf("NO EM PUC MOURE, resultat incorrecte");
                } else if (rival == 2) { //sobrepassar
                    StubTaulellRook st_cas1 = new StubTaulellRook("rnbqk1nr/ppppb3/3P3p/1N3pp1/2P3PP/4p3/PP2PP2/RNBQKB1R b KQq -");
                    Rook p = new Rook(false, new Pair<Integer, Integer>(0, 7), st_cas1);
                    boolean ok = p.espotmoure(new Pair<>(0, 5));
                    if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                    else t.printf("NO EM PUC MOURE, resultat correcte");
                }
            }
            t.printf("%n");
        }
        t.close();
    }
}