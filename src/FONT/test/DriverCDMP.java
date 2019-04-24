package test;

import domini.CtrlDominiMantProblema;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.Vector;

public class DriverCDMP {
    public static void main (String[] args) throws IOException {
        /*
        String path = "C:\\Users\\PcCom\\Desktop\\Grau Informatica\\3r any\\Projectes de Programació\\PROP-Chess\\src\\FONT\\test\\OutputDriverCDMP";
        FileWriter write = new FileWriter( path, true);
        PrintWriter print_line = new PrintWriter( write );

        File file = new File("C:\\Users\\PcCom\\Desktop\\Grau Informatica\\3r any\\Projectes de Programació\\PROP-Chess\\src\\FONT\\test\\InputDriverCDMP");
        Scanner sc = new Scanner(file);
        String fen1 = sc.nextLine();
        String tema1 = sc.nextLine();
        String dificultat1 = sc.nextLine();


        //Problema amb solucio
        Vector <String> dadesProb1 = new Vector<>();
        dadesProb1.add(0,fen1);
        dadesProb1.add(1,tema1);
        dadesProb1.add(2,dificultat1);
        //Problema amb solucio
        String fen2 = sc.nextLine();
        String tema2 = sc.nextLine();
        String dificultat2 = sc.nextLine();
        Vector <String> dadesProb2 = new Vector<>();
        dadesProb2.add(0,fen2);
        dadesProb2.add(1,tema2);
        dadesProb2.add(2,dificultat2);
        //Problema que no te solucio
        String fen3 = sc.nextLine();
        String tema3 = sc.nextLine();
        String dificultat3 = sc.nextLine();
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
        */
    }

    private static void escriuLlistaProblemes (Vector <Vector<String>> llprob, PrintWriter out) throws IOException {
        if (llprob.size() == 0) out.printf("No hi ha cap problema a la base de dades");
        else {
            for (int i = 0; i < llprob.size(); i++) {
                out.printf("Problema " + (i+1) + ": " + "%n");
                for (int j = 0; j < llprob.get(i).size(); j++) {
                    out.printf(llprob.get(i).get(j) + "%n");
                }
                out.printf("%n");
            }
        }
    }

    private static void escriuMissatgeError(Integer error, Integer funcio, PrintWriter out) throws IOException {
        if (funcio == 0) { //altaProblema
            if (error == 0) out.printf("El problema s'ha introduit correctament" + "%n");
            else if (error == 1) out.printf("El problema que vols crear ja existeix " + "%n");
            else if (error == 2) out.printf("L'identificador no coincideix amb les dades passades " + "%n");
            else if (error == 3) out.printf("El problema no es pot resoldre " + "%n");
        }
        else if (funcio == 1) { //esborrarProblema
            if (error == 0) out.printf("El problema s'ha borrat correctament" + "%n");
            else if (error == 1) out.printf("El problema que vols borrar no existeix " + "%n");
        }
        out.printf("%n");
    }
}