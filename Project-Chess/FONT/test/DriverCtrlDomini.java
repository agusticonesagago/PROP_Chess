
package test;

import domini.*;
import javafx.util.Pair;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class DriverCtrlDomini {
    public static void main (String[] args) throws IOException, InterruptedException {

        CtrlDomini CD  = new CtrlDomini();

        String path = "./output-cd.txt";
        FileWriter write = new FileWriter( path, false);
        PrintWriter print_line = new PrintWriter( write );

        File file = new File("./DadesCtrl.txt");
        Scanner sc = new Scanner(file);

        String guanyador;
        String nom1 = sc.nextLine();
        String nom2 = sc.nextLine();

        String fen = sc.nextLine();
        String tema = sc.nextLine();
        String dificultat = sc.nextLine();
        Vector<String> problema = new Vector<>();
        problema.add(0,fen);
        problema.add(1,tema);
        problema.add(2,dificultat);

        print_line.println("Configurem la partida M1 vs M1" + "\n");
        CD.configurarPartida(problema, "Maquina1", "Maquina1");
       // guanyador = CD.jugarPartida(nom1, nom2, null, null);
      //  print_line.printf("El guanyador son les " + guanyador + "\n");


        print_line.println("Configurem la partida H vs M1" + "\n");
        CD.configurarPartida(problema, "Huma", "Maquina1");
      //  guanyador = CD.jugarPartida(nom1, nom2, print_line, sc);
        //print_line.printf("El guanyador son les " + guanyador + "\n");
//
//        System.out.println("Configurem la partida H vs H" + "\n");
//        CD.configurarPartida(problema, "Maquina1", "Maquina1");
//        guanyador = CD.jugarPartida(nom1, nom2);
//        System.out.println("El guanyador son les " + guanyador + "%n");
        print_line.close();
    }

}