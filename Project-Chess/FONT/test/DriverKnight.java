package test;

import domini.King;
import domini.Knight;
import javafx.util.Pair;
import java.util.Scanner;

public class DriverKnight {
    public static void main(String[] args) {

        System.out.println("El testeig de les blanques i negres del cavall és el mateix");
        System.out.println("Introdueix 0 si vols testejar endavant" + '\n' +
                "Introdueix 1 si vols testejar endarrere "
        );

        Integer opcion;
        Scanner entradaEscaner = new Scanner(System.in);
        opcion = Integer.valueOf(entradaEscaner.nextLine());

        if(opcion==0){ //endavant
            System.out.println("Introdueix 0 si vols testejar primera possibilitat" + '\n' +
                    "Introdueix 1 si vols testejar segona possibilitat " + '\n' +
                    "Introdueix 2 si vols testejar tercera possibilitat" + '\n' +
                    "Introdueix 3 si vols testejar quarta possibilitat"
            );

            Integer posibilidad;
            Scanner entradaEscanerposibilidad = new Scanner(System.in);
            posibilidad = Integer.valueOf(entradaEscanerposibilidad.nextLine());

            if(posibilidad==0){
                StubTaulell st_cas1 = new StubTaulell("rnbqkb1r/1p1ppp1p/2p2np1/4N3/p1P3P1/3P1P2/PP2P2P/RNBQKB1R b KQkq - 0 7");
                Knight p = new Knight(true, new Pair<Integer, Integer>(3, 4), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(2, 2));
                if (ok) System.out.println("EM PUC MOURE, resultat correcte");
                else System.out.println("NO EM PUC MOURE, resultat incorrecte");
            }
            else if(posibilidad==1){
                StubTaulell st_cas1 = new StubTaulell("rnbqkb1r/1p1ppp1p/2p2np1/4N3/p1P3P1/3P1P2/PP2P2P/RNBQKB1R b KQkq - 0 7");
                Knight p = new Knight(true, new Pair<Integer, Integer>(3, 4), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(1, 3));
                if (ok) System.out.println("EM PUC MOURE, resultat correcte");
                else System.out.println("NO EM PUC MOURE, resultat incorrecte");
            }
            if(posibilidad==2){
                StubTaulell st_cas1 = new StubTaulell("rnbqkb1r/1p1ppp1p/2p2np1/4N3/p1P3P1/3P1P2/PP2P2P/RNBQKB1R b KQkq - 0 7");
                Knight p = new Knight(true, new Pair<Integer, Integer>(3, 4), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(1, 5));
                if (ok) System.out.println("EM PUC MOURE, resultat correcte");
                else System.out.println("NO EM PUC MOURE, resultat incorrecte");
            }
            if(posibilidad==3){
                StubTaulell st_cas1 = new StubTaulell("rnbqkb1r/1p1ppp1p/2p2np1/4N3/p1P3P1/3P1P2/PP2P2P/RNBQKB1R b KQkq - 0 7");
                Knight p = new Knight(true, new Pair<Integer, Integer>(3, 4), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(2, 6));
                if (ok) System.out.println("EM PUC MOURE, resultat correcte");
                else System.out.println("NO EM PUC MOURE, resultat incorrecte");
            }
        }
        else if (opcion==1) { //endarrere
            System.out.println("Introdueix 0 si vols testejar primera possibilitat" + '\n' +
                    "Introdueix 1 si vols testejar segona possibilitat " + '\n' +
                    "Introdueix 2 si vols testejar tercera possibilitat" + '\n' +
                    "Introdueix 3 si vols testejar quarta possibilitat"
            );

            Integer posibilidad;
            Scanner entradaEscanerposibilidad = new Scanner(System.in);
            posibilidad = Integer.valueOf(entradaEscanerposibilidad.nextLine());

            if(posibilidad==0){
                StubTaulell st_cas1 = new StubTaulell("rnbqkb1r/1p1ppp1p/2p2np1/4N3/p1P3P1/3P1P2/PP2P2P/RNBQKB1R b KQkq - 0 7");
                Knight p = new Knight(true, new Pair<Integer, Integer>(3, 4), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(4, 2));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
            else if(posibilidad==1){
                StubTaulell st_cas1 = new StubTaulell("rnbqkb1r/1p1ppp1p/2p2np1/4N3/p1P3P1/3P1P2/PP2P2P/RNBQKB1R b KQkq - 0 7");
                Knight p = new Knight(true, new Pair<Integer, Integer>(3, 4), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(5, 3));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
            if(posibilidad==2){
                StubTaulell st_cas1 = new StubTaulell("rnbqkb1r/1p1ppp1p/2p2np1/4N3/p1P3P1/3P1P2/PP2P2P/RNBQKB1R b KQkq - 0 7");
                Knight p = new Knight(true, new Pair<Integer, Integer>(3, 4), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(5, 5));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
            if(posibilidad==3){
                StubTaulell st_cas1 = new StubTaulell("rnbqkb1r/1p1ppp1p/2p2np1/4N3/p1P3P1/3P1P2/PP2P2P/RNBQKB1R b KQkq - 0 7");
                Knight p = new Knight(true, new Pair<Integer, Integer>(3, 4), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(4, 6));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
        }


    }
}