package test;

import domini.CtrlDominiMantRanking;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class DriverCDMR {
    public static void main (String[] args) throws IOException {
        /*
        System.out.println("Test de la funcio creadora de instancies de ranking" + "\n");

        String path = "C:\\Users\\PcCom\\Desktop\\Grau Informatica\\3r any\\Projectes de Programació\\PROP-Chess\\src\\FONT\\test\\OutputDriverCDMR";
        FileWriter write = new FileWriter( path, true);
        PrintWriter print_line = new PrintWriter( write );

        File file = new File("C:\\Users\\PcCom\\Desktop\\Grau Informatica\\3r any\\Projectes de Programació\\PROP-Chess\\src\\FONT\\test\\InputDriverCDMR");
        Scanner sc = new Scanner(file);

        String nomj1 = sc.nextLine();
        String nomp1 = sc.nextLine();
        String temps1 = sc.nextLine();
        Vector<String> dadesRank1 = new Vector<>();
        dadesRank1.add(0,nomj1);
        dadesRank1.add(1,nomp1);
        dadesRank1.add(2,temps1);

        String nomj2 = sc.nextLine();
        String nomp2 = sc.nextLine();
        String temps2 = sc.nextLine();
        Vector <String> dadesRank2 = new Vector<>();
        dadesRank2.add(0,nomj2);
        dadesRank2.add(1,nomp2);
        dadesRank2.add(2,temps2);

        String nomj3 = sc.nextLine();
        String nomp3 = sc.nextLine();
        String temps3 = sc.nextLine();
        Vector<String> dadesRank3 = new Vector<>();
        dadesRank3.add(0,nomj3);
        dadesRank3.add(1,nomp3);
        dadesRank3.add(2,temps3);

        String nomj4 = sc.nextLine();
        String nomp4 = sc.nextLine();
        String temps4 = sc.nextLine();
        Vector<String> dadesRank4 = new Vector<>();
        dadesRank4.add(0,nomj4);
        dadesRank4.add(1,nomp4);
        dadesRank4.add(2,temps4);

        Vector <String> resultat;
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
        error = test.baixaRankings(dadesRank1.get(0), dadesRank1);
        escriuMissatgeError(error, 1, print_line);
        //Busquem totes les instancies de ranking
        resultat = test.consultaRankings();
        escriuRanking(resultat, print_line);
        print_line.close();
        */
    }

    private static void escriuRanking (Vector<String> ranking, PrintWriter out) {
        if (ranking.size() == 0) out.printf("No hi ha cap ranking guardat " + "%n");
        for (int i = 0; i < ranking.size(); i++) {
            out.printf((i+1) + ": " + ranking.get(i) + "%n");
        }
        out.printf("%n");
    }

    private static void escriuMissatgeError(Integer error, Integer funcio, PrintWriter out) {
        if (funcio == 0) { //altaRanking
            if (error == 0) out.printf("La fila del ranking s'ha introduit correctament" + "%n");
            else if (error == 1) out.printf("La fila del ranking que vols crear ja existeix " + "%n");
            else if (error == 2) out.printf("L'identificador no coincideix amb les dades passades " + "%n");
        }
        else if (funcio == 1) { //esborrarRanking
            if (error == 0) out.printf("La fila del ranking s'ha borrat correctament" + "%n");
            else if (error == 1) out.printf("La fila del ranking que vols borrar no existeix " + "%n");
        }
        out.printf("%n");
    }
}