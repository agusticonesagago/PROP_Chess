package test;

import domini.Problema;
import javafx.util.Pair;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DriverProblema {
    public static void main (String[] args) throws IOException {
        /*
        System.out.println("Test de la classe Problema" + "\n");

        String path = "C:\\Users\\PcCom\\Desktop\\Grau Informatica\\3r any\\Projectes de Programació\\PROP-Chess\\src\\FONT\\test\\OutputDriverProblema";
        FileWriter write = new FileWriter( path, true);
        PrintWriter print_line = new PrintWriter( write );

        File file = new File("C:\\Users\\PcCom\\Desktop\\Grau Informatica\\3r any\\Projectes de Programació\\PROP-Chess\\src\\FONT\\test\\InputDriverProblema");
        Scanner sc = new Scanner(file);

        //Problema a crear
        String fen1 = sc.nextLine();
        String tema1 = sc.nextLine();
        String dificultat1 = sc.nextLine();
        Problema test = new Problema(tema1, fen1, dificultat1, new StubCtrlDades());
        //Comprobacio de que agafa be les dades
        Pair <Integer, Boolean> p  = test.getTornMat();
        Integer torn = p.getKey();
        Boolean color = p.getValue();
        String jugador;
        if (color == true) jugador = "Blanques";
        else jugador = "Negres";
        print_line.printf("Torns per a fer mat: " + torn + "%n");
        print_line.printf("Jugador que pot fer mat: " + jugador + "%n");
        print_line.close();
        */
    }
}