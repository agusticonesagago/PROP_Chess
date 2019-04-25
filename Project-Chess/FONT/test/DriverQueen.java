package test;
import domini.Queen;
import javafx.util.Pair;
import java.util.Scanner;

public class DriverQueen {
    public static void main(String[] args) {

        System.out.println("El testeig de les blanques i negres de la reina és el mateix");
        System.out.println("Introdueix 0 si vols testejar endavant" + '\n' +
                "Introdueix 1 si vols testejar endarrere " + '\n' +
                "Introdueix 2 si vols testejar dreta" + '\n' +
                "Introdueix 3 si vols testejar esquerra" + '\n' +
                "Introdueix 4 si vols testejar diagonal"
        );

        Integer opcion;
        Scanner entradaEscaner = new Scanner(System.in);
        opcion = Integer.valueOf(entradaEscaner.nextLine());

        if(opcion==0){ //endavant
            Integer rival;
            System.out.println("Introdueix 0 si vols testejar sense sobrepassar" +'\n' +
                    "Introdueix 1 si vols testejar amb sobrepassar");
            Scanner entradarival = new Scanner(System.in);
            rival = Integer.valueOf(entradarival.nextLine());

            if(rival==0){
                StubTaulell st_cas1 = new StubTaulell("rnbqkbnr/6p1/pp6/2pppp1p/2PQP3/2NPKP2/PP4PP/R1B2BNR b kq - 0 10");
                Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(3, 3));
                if (ok) System.out.println("EM PUC MOURE, resultat correcte");
                else System.out.println("NO EM PUC MOURE, resultat incorrecte");
            }

            else if(rival==1){
                StubTaulell st_cas1 = new StubTaulell("rnbqkbnr/6p1/pp6/2pppp1p/2PQP3/2NPKP2/PP4PP/R1B2BNR b kq - 0 10");
                Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(2, 3));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
        }

        else if(opcion==1){ //endarrere
            Integer rival;
            System.out.println("Introdueix 0 si vols testejar sense sobrepassar" +'\n' +
                    "Introdueix 1 si vols testejar amb sobrepassar");
            Scanner entradarival = new Scanner(System.in);
            rival = Integer.valueOf(entradarival.nextLine());

            if(rival==0){
                StubTaulell st_cas1 = new StubTaulell("rnbqkbnr/6p1/pp6/2pppp1p/2PQP3/2NPKP2/PP4PP/R1B2BNR b kq - 0 10");
                Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(5, 3));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }

            else if(rival==1){
                StubTaulell st_cas1 = new StubTaulell("rnbqkbnr/6p1/pp6/2pppp1p/2PQP3/2NPKP2/PP4PP/R1B2BNR b kq - 0 10");
                Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(6, 3));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
        }

        else if(opcion==2){ //dreta
            Integer rival;
            System.out.println("Introdueix 0 si vols testejar sense sobrepassar" +'\n' +
                    "Introdueix 1 si vols testejar amb sobrepassar");
            Scanner entradarival = new Scanner(System.in);
            rival = Integer.valueOf(entradarival.nextLine());

            if(rival==0){
                StubTaulell st_cas1 = new StubTaulell("rnbqkbnr/6p1/pp6/2pppp1p/2PQP3/2NPKP2/PP4PP/R1B2BNR b kq - 0 10");
                Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(4, 4));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }

            else if(rival==1){
                StubTaulell st_cas1 = new StubTaulell("rnbqkbnr/6p1/pp6/2pppp1p/2PQP3/2NPKP2/PP4PP/R1B2BNR b kq - 0 10");
                Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(4,5));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
        }

        else if(opcion==3){ //esquerra
            Integer rival;
            System.out.println("Introdueix 0 si vols testejar sense sobrepassar" +'\n' +
                    "Introdueix 1 si vols testejar amb sobrepassar");
            Scanner entradarival = new Scanner(System.in);
            rival = Integer.valueOf(entradarival.nextLine());

            if(rival==0){
                StubTaulell st_cas1 = new StubTaulell("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PQP3/1PNPKPP1/P6P/R1B2BNR w - - 0 13");
                Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(4, 2));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }

            else if(rival==1){
                StubTaulell st_cas1 = new StubTaulell("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PQP3/1PNPKPP1/P6P/R1B2BNR w - - 0 13");
                Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                boolean ok = p.espotmoure(new Pair<>(4,1));
                if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                else System.out.println("NO EM PUC MOURE, resultat correcte");
            }
        }
        else if(opcion==4){ //diagonals
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
                    StubTaulell st_cas1 = new StubTaulell("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PQP3/1PNPKPP1/P6P/R1B2BNR w - - 0 13");
                    Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                    boolean ok = p.espotmoure(new Pair<>(3, 2));
                    if (ok) System.out.println("EM PUC MOURE, resultat correcte");
                    else System.out.println("NO EM PUC MOURE, resultat incorrecte");
                }
                else if(rival==1){
                    StubTaulell st_cas1 = new StubTaulell("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PQP3/1PNPKPP1/P6P/R1B2BNR w - - 0 13");
                    Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3), st_cas1);
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
                    StubTaulell st_cas1 = new StubTaulell("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PQP3/1PNPKPP1/P6P/R1B2BNR w - - 0 13");
                    Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                    boolean ok = p.espotmoure(new Pair<>(5, 2));
                    if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                    else System.out.println("NO EM PUC MOURE, resultat correcte");
                }
                else if(rival==1){
                    StubTaulell st_cas1 = new StubTaulell("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PQP3/1PNPKPP1/P6P/R1B2BNR w - - 0 13");
                    Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3), st_cas1);
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
                    StubTaulell st_cas1 = new StubTaulell("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PQP3/1PNPKPP1/P6P/R1B2BNR w - - 0 13");
                    Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                    boolean ok = p.espotmoure(new Pair<>(5, 4));
                    if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                    else System.out.println("NO EM PUC MOURE, resultat correcte");
                }
                else if(rival==1){
                    StubTaulell st_cas1 = new StubTaulell("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PQP3/1PNPKPP1/P6P/R1B2BNR w - - 0 13");
                    Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3), st_cas1);
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
                    StubTaulell st_cas1 = new StubTaulell("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PQP3/1PNPKPP1/P6P/R1B2BNR w - - 0 13");
                    Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                    boolean ok = p.espotmoure(new Pair<>(3, 4));
                    if (ok) System.out.println("EM PUC MOURE, resultat correcte");
                    else System.out.println("NO EM PUC MOURE, resultat incorrecte");
                }
                else if(rival==1){
                    StubTaulell st_cas1 = new StubTaulell("1nbq1bnr/r3k1p1/p7/1ppppp1p/2PQP3/1PNPKPP1/P6P/R1B2BNR w - - 0 13");
                    Queen p = new Queen(true, new Pair<Integer, Integer>(4, 3), st_cas1);
                    boolean ok = p.espotmoure(new Pair<>(2, 5));
                    if (ok) System.out.println("EM PUC MOURE, resultat incorrecte");
                    else System.out.println("NO EM PUC MOURE, resultat correcte");
                }
            }
        }


    }
}