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
    public static void main (String[] args) throws IOException {

        CtrlDomini CD  = new CtrlDomini();
/*
        String path = "C:\\Users\\PcCom\\Desktop\\Grau Informatica\\3r any\\Projectes de Programació\\PROP-Chess\\src\\FONT\\test\\OutputDriverCtrlDomini";
        FileWriter write = new FileWriter( path, true);
        PrintWriter print_line = new PrintWriter( write );

        File file = new File("C:\\Users\\PcCom\\Desktop\\Grau Informatica\\3r any\\Projectes de Programació\\PROP-Chess\\src\\FONT\\test\\InputDriverCtrlDomini");
        Scanner sc = new Scanner(file);
*/
        String guanyador;
        String nom1 = "G";
        String nom2 ="A";

        String fen = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1";
        String tema = "Blanqes fan mat en 2";
        String dificultat = "f";
        Vector<String> problema = new Vector<>();
        problema.add(0,fen);
        problema.add(1,tema);
        problema.add(2,dificultat);

        System.out.println("Configurem la partida M1 vs M1" + "\n");
        CD.configurarPartida(problema, "Maquina1", "Maquina1");
        guanyador = CD.jugarPartida(nom1, nom2);
        System.out.println("El guanyador son les " + guanyador + "%n");

//
//        System.out.println("Configurem la partida H vs M1" + "\n");
//        CD.configurarPartida(problema, "HumaStub", "Maquina1");
//        guanyador = CD.jugarPartida(nom1, nom2);
//        System.out.println("El guanyador son les " + guanyador + "%n");
//
//        System.out.println("Configurem la partida H vs H" + "\n");
//        CD.configurarPartida(problema, "Maquina1", "Maquina1");
//        guanyador = CD.jugarPartida(nom1, nom2);
//        System.out.println("El guanyador son les " + guanyador + "%n");

        System.out.println();
    }

}