package test;

import domini.CtrlDominiMantProblema;
import java.util.Vector;

public class DriverCDMP {
    public static void main (String[] args){
        //Problema amb solucio
        System.out.println("Test de la funcio creadora de problemes" + "\n");
        String fen1 = "3k4/8/8/8/8/1r6/r7/7K b - - 0 1";
        String tema1 = "Negres fan mat en 1";
        String dificultat1 = "facil";
        Vector <String> dadesProb1 = new Vector<>();
        dadesProb1.add(0,fen1);
        dadesProb1.add(1,tema1);
        dadesProb1.add(2,dificultat1);
        //Problema amb solucio
        String fen2 = "4k3/3ppp2/8/8/7Q/8/8/2K5 w - - 0 1";
        String tema2 = "Blanques fan mat en 1";
        String dificultat2 = "facil";
        Vector <String> dadesProb2 = new Vector<>();
        dadesProb2.add(0,fen2);
        dadesProb2.add(1,tema2);
        dadesProb2.add(2,dificultat2);
        //Problema que no te solucio
        String fen3 = "4k3/8/8/8/8/8/8/4K3 b - - 0 1";
        String tema3 = "Negres fan mat en 3";
        String dificultat3 = "Dificil";
        Vector <String> dadesProb3 = new Vector<>();
        dadesProb3.add(0,fen3);
        dadesProb3.add(1,tema3);
        dadesProb3.add(2,dificultat3);

        Vector < Vector <String> > resultat;
        CtrlDominiMantProblema test = new CtrlDominiMantProblema();
        Integer error;

        //Introduim un problema diferent amb solucio
        error = test.altaProblema(dadesProb1.get(0), dadesProb1);
        escriuMissatgeError(error, 0);
        //Introduim un problema amb solucio
        error = test.altaProblema(dadesProb2.get(0), dadesProb2);
        escriuMissatgeError(error, 0);
        //Introduim un problema que no te solucio
        error = test.altaProblema(dadesProb3.get(0), dadesProb3);
        escriuMissatgeError(error, 0);
        //Introduim un problema ja existent
        error = test.altaProblema(dadesProb1.get(0), dadesProb1);
        escriuMissatgeError(error, 0);
        //Introduim un problema amb errors en les dades
        error = test.altaProblema("1", dadesProb1);
        escriuMissatgeError(error, 0);
        //Busquem tots els problemes existents
        resultat = test.consultaProblemes();
        escriuLlistaProblemes(resultat);
        //Borrem un problema existent
        error = test.baixaProblema(dadesProb1.get(0));
        escriuMissatgeError(error, 1);
        //Borrem un problema que no existeix
        error = test.baixaProblema(dadesProb1.get(0));
        escriuMissatgeError(error, 1);
        //Busquem tots els problemes existents
        resultat = test.consultaProblemes();
        escriuLlistaProblemes(resultat);
    }

    private static void escriuLlistaProblemes (Vector <Vector<String>> llprob) {
        if (llprob.size() == 0) System.out.println("No hi ha cap problema a la base de dades" + "\n");
        else {
            for (int i = 0; i < llprob.size(); i++) {
                System.out.println("Problema " + (i+1) + ": " + "\n");
                for (int j = 0; j < llprob.get(i).size(); j++) {
                    System.out.println(llprob.get(i).get(j) + "\n");
                }
            }
        }

    }

    private static void escriuMissatgeError(Integer error, Integer funcio) {
        if (funcio == 0) { //altaProblema
            if (error == 0) System.out.println("El problema s'ha introduit correctament" + "\n");
            else if (error == 1) System.out.println("El problema que vols crear ja existeix " + "\n");
            else if (error == 2) System.out.println("L'identificador no coincideix amb les dades passades " + "\n");
            else if (error == 3) System.out.println("El problema no es pot resoldre " + "\n");
        }
        else if (funcio == 1) { //esborrarProblema
            if (error == 0) System.out.println("El problema s'ha borrat correctament" + "\n");
            else if (error == 1) System.out.println("El problema que vols borrar no existeix " + "\n");
        }
    }
}