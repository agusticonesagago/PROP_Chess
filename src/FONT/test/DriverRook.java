package test;

import domini.Rook;
import javafx.util.Pair;
import java.util.Scanner;

public class DriverRook {
    public static void main(String[] args) {

        System.out.println("El testeig de les blanques i negres de torre és el mateix");
        System.out.println("Introdueix 0 si vols testejar endarrere" + '\n' +
                "Introdueix 1 si vols testejar endavant " + '\n' +
                "Introdueix 2 si vols testejar cap a la dreta"+ '\n' +
                "Introdueix 3 si vols testejar cap a l'esquerra"
        );

        Integer opcion;
        Scanner entradaEscaner = new Scanner(System.in);
        opcion = Integer.valueOf(entradaEscaner.nextLine());

        if (opcion == 0) { //endarrera
            Integer rival;
            System.out.println("Introdueix 0 si vols testejar amb rival" +'\n' +
                    "Introdueix 1 si vols testejar sense rival " + '\n' +
                    "Introdueix 2 si vols testejar sobrepassar");
            Scanner entradarival = new Scanner(System.in);
            rival = Integer.valueOf(entradarival.nextLine());

            if(rival==0){ //rival
                StubTaulell st_cas1 = new StubTaulell("1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1");
                Rook p = new Rook(true, new Pair<Integer, Integer>(2, 0), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(4, 0));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
            else if(rival==1){ //sense rival
                StubTaulell st_cas1 = new StubTaulell("rnbqk1nr/pppppp2/3R4/6pp/3b3P/8/PPPPPP2/RNBQKBN1 b Qkq - 2 1");
                Rook p = new Rook(true, new Pair<Integer, Integer>(2, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(3, 3));
                if (ok) System.out.println("EM PUC MOURE, resultat correcte");
                else System.out.println("NO EM PUC MOURE, resultat incorrecte");
            }
            else if(rival==2){ //sobrepassar
                StubTaulell st_cas1 = new StubTaulell("rnbqk1nr/pppppp2/3R4/6pp/3b3P/8/PPPPPP2/RNBQKBN1 b Qkq - 2 1");
                Rook p = new Rook(false, new Pair<Integer, Integer>(2, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(5, 3));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
        }
        else if (opcion == 1) { //endavant
            Integer rival;
            System.out.println("Introdueix 0 si vols testejar amb rival" +'\n' +
                    "Introdueix 1 si vols testejar sense rival " + '\n' +
                    "Introdueix 2 si vols testejar sobrepassar");
            Scanner entradarival = new Scanner(System.in);
            rival = Integer.valueOf(entradarival.nextLine());

            if(rival==0){ //rival
                StubTaulell st_cas1 = new StubTaulell("rn3bn1/pp1p1k2/3P3p/1Npr1ppP/2P2PP1/4p3/PP2P3/RNBQKB1R w KQ - 3 1");
                Rook p = new Rook(false, new Pair<Integer, Integer>(4, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(2, 3));
                if (ok) System.out.println("EM PUC MOURE, resultat correcte");
                else System.out.println("NO EM PUC MOURE, resultat incorrecte");
            }
            else if(rival==1){ //sense rival
                StubTaulell st_cas1 = new StubTaulell("rn3bn1/pp1p1k2/3P3p/1Npr1ppP/2P2PP1/4p3/PP2P3/RNBQKB1R w KQ - 3 1");
                Rook p = new Rook(false, new Pair<Integer, Integer>(4, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(3, 3));
                if (ok) System.out.println("EM PUC MOURE, resultat correcte");
                else System.out.println("NO EM PUC MOURE, resultat incorrecte");
            }
            else if(rival==2){ //sobrepassar
                StubTaulell st_cas1 = new StubTaulell("rn3bn1/pp1p1k2/3P3p/1Np1ppP1/2PrPP2/4p3/PP2P3/RNBQKB1R w KQ - 3 12");
                Rook p = new Rook(false, new Pair<Integer, Integer>(4, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(0, 3));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
        }
        else if (opcion == 2) { //dreta
            Integer rival;
            System.out.println("Introdueix 0 si vols testejar amb rival" +'\n' +
                    "Introdueix 1 si vols testejar sense rival " + '\n' +
                    "Introdueix 2 si vols testejar sobrepassar");
            Scanner entradarival = new Scanner(System.in);
            rival = Integer.valueOf(entradarival.nextLine());

            if(rival==0){ //rival
                StubTaulell st_cas1 = new StubTaulell("rnbqkbn1/pp1p4/2pP3p/1N3ppP/2P1r1P1/4p3/PP2PP2/RNBQKB1R b KQq - 0 12");
                Rook p = new Rook(false, new Pair<Integer, Integer>(4, 4), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(4, 6));
                if (ok) System.out.println("EM PUC MOURE, resultat correcte");
                else System.out.println("NO EM PUC MOURE, resultat incorrecte");
            }
            else if(rival==1){ //sense rival
                StubTaulell st_cas1 = new StubTaulell("rnbqkbn1/pppp4/3P3p/1N3pp1/2P1r1PP/4p3/PP2PP2/RNBQKB1R b KQq - 4 11");
                Rook p = new Rook(false, new Pair<Integer, Integer>(4, 4), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(4, 5));
                if (ok) System.out.println("EM PUC MOURE, resultat correcte");
                else System.out.println("NO EM PUC MOURE, resultat incorrecte");
            }
            else if(rival==2){ //sobrepassar
                StubTaulell st_cas1 = new StubTaulell("rnbqkbn1/pppp4/3P3p/1N3pp1/2P1r1PP/4p3/PP2PP2/RNBQKB1R b KQq - 4 11");
                Rook p = new Rook(false, new Pair<Integer, Integer>(4, 4), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(4, 7));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
        }
        else if(opcion==3){ //esquerra
            Integer rival;
            System.out.println("Introdueix 0 si vols testejar amb rival" +'\n' +
                    "Introdueix 1 si vols testejar sense rival " + '\n' +
                    "Introdueix 2 si vols testejar sobrepassar");
            Scanner entradarival = new Scanner(System.in);
            rival = Integer.valueOf(entradarival.nextLine());

            if(rival==0){ //rival
                StubTaulell st_cas1 = new StubTaulell("rnbqkbn1/pppp4/3P3p/1N3pp1/2P1r1PP/4p3/PP2PP2/RNBQKB1R b KQq - 4 11");
                Rook p = new Rook(false, new Pair<Integer, Integer>(4, 4), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(4, 2));
                if (ok) System.out.println("EM PUC MOURE, resultat correcte");
                else System.out.println("NO EM PUC MOURE, resultat incorrecte");
            }
            else if(rival==1){ //sense rival
                StubTaulell st_cas1 = new StubTaulell("rnbqkbn1/pppp4/3P3p/1N3pp1/2P1r1PP/4p3/PP2PP2/RNBQKB1R b KQq - 4 11");
                Rook p = new Rook(false, new Pair<Integer, Integer>(4, 4), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(4, 3));
                if (ok) System.out.println("EM PUC MOURE, resultat correcte");
                else System.out.println("NO EM PUC MOURE, resultat incorrecte");
            }
            else if(rival==2){ //sobrepassar
                StubTaulell st_cas1 = new StubTaulell("rnbqkbn1/pppp4/3P3p/1N3pp1/2P1r1PP/4p3/PP2PP2/RNBQKB1R b KQq - 4 11");
                Rook p = new Rook(false, new Pair<Integer, Integer>(4, 4), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(4, 0));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
        }
    }
}