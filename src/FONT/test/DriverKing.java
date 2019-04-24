package test;

import domini.King;
import javafx.util.Pair;
import java.util.Scanner;

public class DriverKing {
    public static void main(String[] args) {

        System.out.println("El testeig de les blanques i negres del rei és el mateix");
        System.out.println("Introdueix 0 si vols testejar endarrere" + '\n' +
                "Introdueix 1 si vols testejar endavant " + '\n' +
                "Introdueix 2 si vols testejar cap a la dreta" + '\n' +
                "Introdueix 3 si vols testejar cap a l'esquerra" + '\n' +
                "Introdueix 4 si vols testejar en diagonal"
        );

        Integer opcion;
        Scanner entradaEscaner = new Scanner(System.in);
        opcion = Integer.valueOf(entradaEscaner.nextLine());

        if(opcion==1){ //endavant
            //amb rival
            StubTaulell st_cas1 = new StubTaulell("rnb1kbnr/pppp4/7p/5pq1/3P1Kp1/4p3/QPP1PPPP/RNBQ1BNR w - - 2 9");
            King p = new King(false, new Pair<Integer, Integer>(4, 5), st_cas1);
            boolean ok = p.espotmoure(new Pair<>(3, 5));
            if (ok) System.out.println("EM PUC MOURE, resultat correcte");
            else System.out.println("NO EM PUC MOURE, resultat incorrecte");
        }
        else if (opcion==0){ //endarrere
            StubTaulell st_cas1 = new StubTaulell("rnbq1bnr/ppppp1pp/3Pkp2/1B2P3/8/8/PPP1KPPP/RNBQ2NR b - - 0 8");
            King p = new King(false, new Pair<Integer, Integer>(2, 4), st_cas1);
            boolean ok = p.espotmoure(new Pair<>(3, 4));
            if (ok) System.out.println("EM PUC MOURE, resultat correcte");
            else System.out.println("NO EM PUC MOURE, resultat incorrecte");
        }

        else if(opcion==2){ //dreta
            StubTaulell st_cas1 = new StubTaulell("rnb1kbnr/pppp4/7p/5pq1/3P1Kp1/4p3/QPP1PPPP/RNBQ1BNR w - - 2 9");
            King p = new King(false, new Pair<Integer, Integer>(4, 5), st_cas1);
            boolean ok = p.espotmoure(new Pair<>(4, 6));
            if (ok) System.out.println("EM PUC MOURE, resultat correcte");
            else System.out.println("NO EM PUC MOURE, resultat incorrecte");
        }
        else if(opcion==3){ //esquerra
            StubTaulell st_cas1 = new StubTaulell("rnbq1bnr/ppppp1pp/3Pkp2/1B2P3/8/8/PPP1KPPP/RNBQ2NR b - - 0 8");
            King p = new King(false, new Pair<Integer, Integer>(2, 4), st_cas1);
            boolean ok = p.espotmoure(new Pair<>(2, 3));
            if (ok) System.out.println("EM PUC MOURE, resultat correcte");
            else System.out.println("NO EM PUC MOURE, resultat incorrecte");
        }
        else if(opcion==4){ //diagonal

            System.out.println("Introdueix 0 si vols testejar diagonal dreta-amunt" + '\n' +
                    "Introdueix 1 si vols testejar diagonal dreta-avall " + '\n' +
                    "Introdueix 2 si vols testejar diagonal esquerra-amunt" + '\n' +
                    "Introdueix 3 si vols testejar diagonal esquerra-avall"
            );

            Integer diagonal;
            Scanner entradaEscanerdiagonal = new Scanner(System.in);
            diagonal = Integer.valueOf(entradaEscanerdiagonal.nextLine());

            if(diagonal==0) {
                StubTaulell st_cas1 = new StubTaulell("rnb1kbnr/pppp4/7p/5pq1/3P1Kp1/4p3/QPP1PPPP/RNBQ1BNR w - - 2 9");
                King p = new King(false, new Pair<Integer, Integer>(4, 5), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(3, 6));
                if (ok) System.out.println("EM PUC MOURE, resultat correcte");
                else System.out.println("NO EM PUC MOURE, resultat incorrecte");
            }
            else if(diagonal==1) {
                StubTaulell st_cas1 = new StubTaulell("rnbq1bnr/1pppp1pp/3Pkp2/1B2PP2/p7/8/PPP1K1PP/RNBQ2NR b - - 0 10");
                King p = new King(false, new Pair<Integer, Integer>(2, 4), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(3, 5));
                if (ok) System.out.println("EM PUC MOURE, resultat correcte");
                else System.out.println("NO EM PUC MOURE, resultat incorrecte");
            }
            else if(diagonal==2) {
                StubTaulell st_cas1 = new StubTaulell("rnb1kbnr/pppp4/7p/5pq1/3P1Kp1/4p3/QPP1PPPP/RNBQ1BNR w - - 2 9");
                King p = new King(false, new Pair<Integer, Integer>(2, 4), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(1, 3));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
            else if(diagonal==3) {
                StubTaulell st_cas1 = new StubTaulell("rnbq1bnr/1pppp1pp/3Pkp2/3BP3/p7/7P/PPP1K1P1/RNBQ2NR b - - 2 16");
                King p = new King(false, new Pair<Integer, Integer>(2, 4), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(3, 3));
                if (ok) System.out.println("EM PUC MOURE, resultat correcte");
                else System.out.println("NO EM PUC MOURE, resultat incorrecte");
            }
        }

    }
}