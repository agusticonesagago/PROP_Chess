package test;

import domini.CtrlDominiMantProblema;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class DriverCDMP {

    private static FileWriter output;
    private static Scanner sc;
    private static PrintWriter print_line;

    public static void main (String[] args) throws IOException {

        String path = "./output-cdmp.txt";
        output = new FileWriter( path, true);
        print_line = new PrintWriter( output );

        //File file = new File("./dades.txt");
        //sc = new Scanner(file);
        String fen1 = "3k4/8/8/8/8/1r6/r7/7K b - - 0 1";//sc.nextLine();
        String tema1 = "Negres fan mat en 1";//sc.nextLine();
        String dificultat1 = "facil";//sc.nextLine();
        //3k4/8/8/8/8/1r6/r7/7K b - - 0 1;
        //"Negres fan mat en 1";
        //"facil";

        //Problema amb solucio
        Vector <String> dadesProb1 = new Vector<>();
        dadesProb1.add(0,fen1);
        dadesProb1.add(1,tema1);
        dadesProb1.add(2,dificultat1);

        //"4k3/3ppp2/8/8/7Q/8/8/2K5 w - - 0 1";
        //"Blanques fan mat en 1";
        //"facil";
        //Problema amb solucio
        String fen2 = "4k3/3ppp2/8/8/7Q/8/8/2K5 w - - 0 1";//sc.nextLine();
        String tema2 = "Blanques fan mat en 1";//sc.nextLine();
        String dificultat2 = "facil";//sc.nextLine();
        Vector <String> dadesProb2 = new Vector<>();
        dadesProb2.add(0,fen2);
        dadesProb2.add(1,tema2);
        dadesProb2.add(2,dificultat2);

        //"4k3/8/8/8/8/8/8/4K3 b - - 0 1";
        //"Negres fan mat en 3";
        //"Dificil";
        //Problema que no te solucio
        String fen3 = "4k3/8/8/8/8/8/8/4K3 b - - 0 1";//sc.nextLine();
        String tema3 = "Negres fan mat en 3";//sc.nextLine();
        String dificultat3 = "Dificil";//sc.nextLine();
        Vector <String> dadesProb3 = new Vector<>();
        dadesProb3.add(0,fen3);
        dadesProb3.add(1,tema3);
        dadesProb3.add(2,dificultat3);

        Vector < Vector <String> > resultat;
        CtrlDominiMantProblema test = new CtrlDominiMantProblema();
        Integer error;

        //Introduim un problema diferent amb solucio
        error = test.altaProblema(dadesProb1.get(0), dadesProb1);
        escriuMissatgeError(error, 0, print_line);
        //Introduim un problema amb solucio
        error = test.altaProblema(dadesProb2.get(0), dadesProb2);
        escriuMissatgeError(error, 0, print_line);
        //Introduim un problema que no te solucio
        error = test.altaProblema(dadesProb3.get(0), dadesProb3);
        escriuMissatgeError(error, 0, print_line);
        //Introduim un problema ja existent
        error = test.altaProblema(dadesProb1.get(0), dadesProb1);
        escriuMissatgeError(error, 0, print_line);
        //Introduim un problema amb errors en les dades
        error = test.altaProblema("1", dadesProb1);
        escriuMissatgeError(error, 0, print_line);
        //Busquem tots els problemes existents
        resultat = test.consultaProblemes();
        escriuLlistaProblemes(resultat, print_line);

        //Borrem un problema existent
        error = test.baixaProblema(dadesProb1.get(0));
        escriuMissatgeError(error, 1, print_line);
        //Borrem un problema que no existeix
        error = test.baixaProblema(dadesProb1.get(0));
        escriuMissatgeError(error, 1, print_line);
        //Busquem tots els problemes existents
        resultat = test.consultaProblemes();
        escriuLlistaProblemes(resultat, print_line);

        print_line.close();
    }

    private static void escriuLlistaProblemes (Vector <Vector<String>> llprob, PrintWriter out) throws IOException {
        if (llprob.size() == 0) print_line.println("No hi ha cap problema a la base de dades");
        else {
            for (int i = 0; i < llprob.size(); i++) {
                print_line.println("Problema " + (i+1) + ": ");
                for (int j = 0; j < llprob.get(i).size(); j++) {
                    print_line.println(llprob.get(i).get(j));
                }
                print_line.println();
            }
        }
    }

    private static void escriuMissatgeError(Integer error, Integer funcio, PrintWriter out) throws IOException {
        if (funcio == 0) { //altaProblema
            if (error == 0) print_line.println("El problema s'ha introduit correctament" );
            else if (error == 1) print_line.println("El problema que vols crear ja existeix ");
            else if (error == 2) print_line.println("L'identificador no coincideix amb les dades passades ");
            else if (error == 3) print_line.println("El problema no es pot resoldre ");
        }
        else if (funcio == 1) { //esborrarProblema
            if (error == 0) print_line.println("El problema s'ha borrat correctament");
            else if (error == 1) print_line.println("El problema que vols borrar no existeix ");
        }
        print_line.println();
    }
}