package test;

import domini.Knight;
import javafx.util.Pair;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DriverKnight {
    public static void main(String[] args) throws IOException {

        /*System.out.println("El testeig de les blanques i negres del cavall és el mateix");
        System.out.println("Introdueix 0 si vols testejar endavant" + '\n' +
                "Introdueix 1 si vols testejar endarrere "
        );*/

        String path = "./OutputKnight.txt";
        FileWriter write = new FileWriter( path , false);
        PrintWriter t = new PrintWriter( write );

        File file = new File("./DadesKnight.txt");
        Scanner sc = new Scanner(file);

        Integer opcion;

        while(sc.hasNextLine()) {
            opcion = Integer.valueOf(sc.nextLine());
            if (opcion == 0) { //endavant
                /*System.out.println("Introdueix 0 si vols testejar primera possibilitat" + '\n' +
                        "Introdueix 1 si vols testejar segona possibilitat " + '\n' +
                        "Introdueix 2 si vols testejar tercera possibilitat" + '\n' +
                        "Introdueix 3 si vols testejar quarta possibilitat"
                );*/

                Integer posibilidad;
                posibilidad = Integer.valueOf(sc.nextLine());

                if (posibilidad == 0) {
                    StubTaulellKnight st_cas1 = new StubTaulellKnight("rnbqkb1r/1p1ppp1p/2p2np1/4N3/p1P3P1/3P1P2/PP2P2P/RNBQKB1R b KQkq - 0 7");
                    Knight p = new Knight(true, new Pair<Integer, Integer>(3, 4));
                    boolean ok = p.espotmoure(new Pair<>(2, 2));
                    if (ok) t.printf("EM PUC MOURE, resultat correcte");
                    else t.printf("NO EM PUC MOURE, resultat incorrecte");
                } else if (posibilidad == 1) {
                    StubTaulellKnight st_cas1 = new StubTaulellKnight("rnbqkb1r/1p1ppp1p/2p2np1/4N3/p1P3P1/3P1P2/PP2P2P/RNBQKB1R b KQkq - 0 7");
                    Knight p = new Knight(true, new Pair<Integer, Integer>(3, 4));
                    boolean ok = p.espotmoure(new Pair<>(1, 3));
                    if (ok) t.printf("EM PUC MOURE, resultat correcte");
                    else t.printf("NO EM PUC MOURE, resultat incorrecte");
                }
                if (posibilidad == 2) {
                    StubTaulellKnight st_cas1 = new StubTaulellKnight("rnbqkb1r/1p1ppp1p/2p2np1/4N3/p1P3P1/3P1P2/PP2P2P/RNBQKB1R b KQkq - 0 7");
                    Knight p = new Knight(true, new Pair<Integer, Integer>(3, 4));
                    boolean ok = p.espotmoure(new Pair<>(1, 5));
                    if (ok) t.printf("EM PUC MOURE, resultat correcte");
                    else t.printf("NO EM PUC MOURE, resultat incorrecte");
                }
                if (posibilidad == 3) {
                    StubTaulellKnight st_cas1 = new StubTaulellKnight("rnbqkb1r/1p1ppp1p/2p2np1/4N3/p1P3P1/3P1P2/PP2P2P/RNBQKB1R b KQkq - 0 7");
                    Knight p = new Knight(true, new Pair<Integer, Integer>(3, 4));
                    boolean ok = p.espotmoure(new Pair<>(2, 6));
                    if (ok) t.printf("EM PUC MOURE, resultat correcte");
                    else t.printf("NO EM PUC MOURE, resultat incorrecte");
                }
            } else if (opcion == 1) { //endarrere
                /*System.out.println("Introdueix 0 si vols testejar primera possibilitat" + '\n' +
                        "Introdueix 1 si vols testejar segona possibilitat " + '\n' +
                        "Introdueix 2 si vols testejar tercera possibilitat" + '\n' +
                        "Introdueix 3 si vols testejar quarta possibilitat"
                );*/

                Integer posibilidad;
                posibilidad = Integer.valueOf(sc.nextLine());

                if (posibilidad == 0) {
                    StubTaulellKnight st_cas1 = new StubTaulellKnight("rnbqkb1r/1p1ppp1p/2p2np1/4N3/p1P3P1/3P1P2/PP2P2P/RNBQKB1R b KQkq - 0 7");
                    Knight p = new Knight(true, new Pair<Integer, Integer>(3, 4));
                    boolean ok = p.espotmoure(new Pair<>(4, 2));
                    if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                    else t.printf("NO EM PUC MOURE, resultat correcte");
                } else if (posibilidad == 1) {
                    StubTaulellKnight st_cas1 = new StubTaulellKnight("rnbqkb1r/1p1ppp1p/2p2np1/4N3/p1P3P1/3P1P2/PP2P2P/RNBQKB1R b KQkq - 0 7");
                    Knight p = new Knight(true, new Pair<Integer, Integer>(3, 4));
                    boolean ok = p.espotmoure(new Pair<>(5, 3));
                    if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                    else t.printf("NO EM PUC MOURE, resultat correcte");
                }
                if (posibilidad == 2) {
                    StubTaulellKnight st_cas1 = new StubTaulellKnight("rnbqkb1r/1p1ppp1p/2p2np1/4N3/p1P3P1/3P1P2/PP2P2P/RNBQKB1R b KQkq - 0 7");
                    Knight p = new Knight(true, new Pair<Integer, Integer>(3, 4));
                    boolean ok = p.espotmoure(new Pair<>(5, 5));
                    if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                    else t.printf("NO EM PUC MOURE, resultat correcte");
                }
                if (posibilidad == 3) {
                    StubTaulellKnight st_cas1 = new StubTaulellKnight("rnbqkb1r/1p1ppp1p/2p2np1/4N3/p1P3P1/3P1P2/PP2P2P/RNBQKB1R b KQkq - 0 7");
                    Knight p = new Knight(true, new Pair<Integer, Integer>(3, 4));
                    boolean ok = p.espotmoure(new Pair<>(4, 6));
                    if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                    else t.printf("NO EM PUC MOURE, resultat correcte");
                }
            }
            t.printf("%n");
        }
        t.close();
    }
}