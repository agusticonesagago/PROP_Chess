package test;

import domini.Bishop;
import javafx.util.Pair;
import java.util.Scanner;

public class DriverBishop {
    public static void main(String[] args) {

        System.out.println("El testeig de les blanques i negres de l'alfil és el mateix");

        Integer diagonal;
        System.out.println("Introdueix 0 si vols testejar diagonal adalt-esquerra" +'\n' +
                "Introdueix 1 si vols testejar diagonal avall-esquerra"+'\n' +
                "Introdueix 2 si vols testejar diagonal adalt-dreta"+'\n' +
                "Introdueix 3 si vols testejar diagonal avall-dreta"
        );

        Scanner entradadiagonal = new Scanner(System.in);
        diagonal = Integer.valueOf(entradadiagonal.nextLine());

        if(diagonal==0){ //adalt-esquerra
            Integer rival;
            System.out.println("Introdueix 0 si vols testejar sense sobrepassar" +'\n' +
                    "Introdueix 1 si vols testejar amb sobrepassar");
            Scanner entradarival = new Scanner(System.in);
            rival = Integer.valueOf(entradarival.nextLine());

            if (rival == 0) {
                StubTaulell st_cas1 = new StubTaulell("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PBP3/1PNPKPP1/P6P/R1B3NR w - - 0 13");
                Bishop p = new Bishop(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(3, 2));
                if (ok) System.out.println("EM PUC MOURE, resultat correcte");
                else System.out.println("NO EM PUC MOURE, resultat incorrecte");
            }
            else if(rival==1){
                StubTaulell st_cas1 = new StubTaulell("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PBP3/1PNPKPP1/P6P/R1B3NR w - - 0 13");
                Bishop p = new Bishop(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(2, 1));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
        }

        else if(diagonal==1){ //avall-esquerra
            Integer rival;
            System.out.println("Introdueix 0 si vols testejar sense sobrepassar" +'\n' +
                    "Introdueix 1 si vols testejar amb sobrepassar");
            Scanner entradarival = new Scanner(System.in);
            rival = Integer.valueOf(entradarival.nextLine());

            if (rival == 0) {
                StubTaulell st_cas1 = new StubTaulell("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PBP3/1PNPKPP1/P6P/R1B3NR w - - 0 13");
                Bishop p = new Bishop(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(5, 2));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
            else if(rival==1){
                StubTaulell st_cas1 = new StubTaulell("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PBP3/1PNPKPP1/P6P/R1B3NR w - - 0 13");
                Bishop p = new Bishop(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(6, 1));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
        }
        else if(diagonal==3){ //avall-dreta
            Integer rival;
            System.out.println("Introdueix 0 si vols testejar sense sobrepassar" +'\n' +
                    "Introdueix 1 si vols testejar amb sobrepassar");
            Scanner entradarival = new Scanner(System.in);
            rival = Integer.valueOf(entradarival.nextLine());

            if (rival == 0) {
                StubTaulell st_cas1 = new StubTaulell("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PBP3/1PNPKPP1/P6P/R1B3NR w - - 0 13");
                Bishop p = new Bishop(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(5, 4));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
            else if(rival==1){
                StubTaulell st_cas1 = new StubTaulell("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PBP3/1PNPKPP1/P6P/R1B3NR w - - 0 13");
                Bishop p = new Bishop(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(6, 5));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
        }
        else if(diagonal==2){ //adalt-dreta
            Integer rival;
            System.out.println("Introdueix 0 si vols testejar sense sobrepassar" +'\n' +
                    "Introdueix 1 si vols testejar amb sobrepassar");
            Scanner entradarival = new Scanner(System.in);
            rival = Integer.valueOf(entradarival.nextLine());

            if (rival == 0) {
                StubTaulell st_cas1 = new StubTaulell("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PBP3/1PNPKPP1/P6P/R1B3NR w - - 0 13");
                Bishop p = new Bishop(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(3, 4));
                if (ok) System.out.println("EM PUC MOURE, resultat correcte");
                else System.out.println("NO EM PUC MOURE, resultat incorrecte");
            }
            else if(rival==1){
                StubTaulell st_cas1 = new StubTaulell("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PBP3/1PNPKPP1/P6P/R1B3NR w - - 0 13");
                Bishop p = new Bishop(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(2, 5));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
        }
    }


}