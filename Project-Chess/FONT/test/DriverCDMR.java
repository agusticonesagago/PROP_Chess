package test;

import domini.CtrlDominiMantRanking;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class DriverCDMR {

    private static FileWriter output;
    private static Scanner sc;
    private static PrintWriter print_line;

    public static void main (String[] args) throws IOException {
        System.out.println("Test de la funcio creadora de instancies de ranking" + "\n");

        String path = "./output-cdmr.txt";
        output = new FileWriter( path, false);
        print_line = new PrintWriter( output );

        //File file = new File("./Dades.txt");
        //Scanner sc = new Scanner(file);

        //"Aleix";
        //"1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1";
        //"280";
        String nomj1 = "Aleix";//sc.nextLine();
        String nomp1 = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1";//sc.nextLine();
        String temps1 = "280";//sc.nextLine();
        Vector<String> dadesRank1 = new Vector<>();
        dadesRank1.add(0,nomj1);
        dadesRank1.add(1,nomp1);
        dadesRank1.add(2,temps1);

        //"Aaaaa";
        //"1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1";
        //"120";
        String nomj2 = "Aaaaa";//sc.nextLine();
        String nomp2 = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1";//sc.nextLine();
        String temps2 = "120";//sc.nextLine();
        Vector <String> dadesRank2 = new Vector<>();
        dadesRank2.add(0,nomj2);
        dadesRank2.add(1,nomp2);
        dadesRank2.add(2,temps2);

        //"Aleix";
        //"1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1";
        //"180";
        String nomj3 = "Aleix";//sc.nextLine();
        String nomp3 = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1";//sc.nextLine();
        String temps3 = "180";//sc.nextLine();
        Vector<String> dadesRank3 = new Vector<>();
        dadesRank3.add(0,nomj3);
        dadesRank3.add(1,nomp3);
        dadesRank3.add(2,temps3);

        //"Aleix";
        //"4k3/3ppp2/8/8/7Q/8/8/2K5 w - - 0 1";
        //"180";
        String nomj4 = "Aleix";//sc.nextLine();
        String nomp4 = "4k3/3ppp2/8/8/7Q/8/8/2K5 w - - 0 1";//sc.nextLine();
        String temps4 = "180";//sc.nextLine();
        Vector<String> dadesRank4 = new Vector<>();
        dadesRank4.add(0,nomj4);
        dadesRank4.add(1,nomp4);
        dadesRank4.add(2,temps4);

        Vector <Vector<String>> resultat;
        CtrlDominiMantRanking test = new CtrlDominiMantRanking();
        Integer error;

        //Introduim una instancia al ranking correcte
        error = test.altaRanking(dadesRank1.get(0), dadesRank1);
        escriuMissatgeError(error, 0, print_line);
        //Introduim una instancia al ranking correcte
        error = test.altaRanking(dadesRank2.get(0), dadesRank2);
        escriuMissatgeError(error, 0, print_line);
        //Busquem totes les instancies de ranking
        resultat = test.consultaRankings();
        escriuRanking(resultat, print_line);

        //Introduim una instancia al ranking correcte
        error = test.altaRanking(dadesRank3.get(0), dadesRank3);
        escriuMissatgeError(error, 0, print_line);
        //Introduim una instancia al ranking ja existent
        error = test.altaRanking(dadesRank4.get(0), dadesRank4);
        escriuMissatgeError(error, 0, print_line);
        //Introduim una instancia al ranking ja existent
        error = test.altaRanking(dadesRank1.get(0), dadesRank1);
        escriuMissatgeError(error, 0, print_line);
        //Introduim una instancia al ranking amb dades incorrectes
        error = test.altaRanking("Aleixx", dadesRank1);
        escriuMissatgeError(error, 0, print_line);
        //Busquem totes les instancies de ranking
        resultat = test.consultaRankings();
        escriuRanking(resultat, print_line);

        //Esborrem una instancia de ranking
        error = test.baixaRankings(dadesRank1.get(0), dadesRank1);
        escriuMissatgeError(error, 1, print_line);
        //Esborrem una instancia de ranking ja existent
        error = test.baixaRankings(dadesRank2.get(0), dadesRank2);
        escriuMissatgeError(error, 1, print_line);
        //Busquem totes les instancies de ranking
        resultat = test.consultaRankings();
        escriuRanking(resultat, print_line);
        print_line.close();
    }

    private static void escriuRanking (Vector<Vector<String>> ranking, PrintWriter out) {
        if (ranking.size() == 0) print_line.println("No hi ha cap rank a la base de dades");
        else {
            for (int i = 0; i < ranking.size(); i++) {
                print_line.println((i+1) + ": ");
                for (int j = 0; j < ranking.get(i).size(); j++) {
                    print_line.println(ranking.get(i).get(j));
                }
                print_line.println();
            }
        }
    }

    private static void escriuMissatgeError(Integer error, Integer funcio, PrintWriter out) {
        if (funcio == 0) { //altaRanking
            if (error == 0) print_line.println("La fila del ranking s'ha introduit correctament" );
            else if (error == 1) print_line.println("La fila del ranking que vols crear ja existeix " );
            else if (error == 2) print_line.println("L'identificador no coincideix amb les dades passades " );
        }
        else if (funcio == 1) { //esborrarRanking
            if (error == 0) print_line.println("La fila del ranking s'ha borrat correctament" );
            else if (error == 1) print_line.println("La fila del ranking que vols borrar no existeix ");
        }
        print_line.println();
    }
}