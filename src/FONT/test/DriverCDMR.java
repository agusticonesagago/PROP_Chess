package test;

import domini.CtrlDominiMantRanking;

import java.util.Vector;

public class DriverCDMR {
    public static void main (String[] args){
        System.out.println("Test de la funcio creadora de problemes" + "\n");

        String nomj1 = "Aleix";
        String nomp1 = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1";
        String temps1 = "280";
        Vector<String> dadesRank1 = new Vector<>();
        dadesRank1.add(0,nomj1);
        dadesRank1.add(1,nomp1);
        dadesRank1.add(2,temps1);

        String nomj2 = "Aaaaa";
        String nomp2 = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1";
        String temps2 = "120";
        Vector <String> dadesRank2 = new Vector<>();
        dadesRank2.add(0,nomj2);
        dadesRank2.add(1,nomp2);
        dadesRank2.add(2,temps2);

        String nomj3 = "Aleix";
        String nomp3 = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1";
        String temps3 = "180";
        Vector<String> dadesRank3 = new Vector<>();
        dadesRank3.add(0,nomj3);
        dadesRank3.add(1,nomp3);
        dadesRank3.add(2,temps3);

        String nomj4 = "Aleix";
        String nomp4 = "4k3/3ppp2/8/8/7Q/8/8/2K5 w - - 0 1";
        String temps4 = "180";
        Vector<String> dadesRank4 = new Vector<>();
        dadesRank4.add(0,nomj4);
        dadesRank4.add(1,nomp4);
        dadesRank4.add(2,temps4);

        Vector <String> resultat;
        CtrlDominiMantRanking test = new CtrlDominiMantRanking();
        Integer error;

        //Introduim una instancia al ranking correcte
        error = test.altaRanking(dadesRank1.get(0), dadesRank1);
        escriuMissatgeError(error, 0);
        //Introduim una instancia al ranking correcte
        error = test.altaRanking(dadesRank2.get(0), dadesRank2);
        escriuMissatgeError(error, 0);
        //Busquem totes les instancies de ranking
        resultat = test.consultaRankings();
        escriuRanking(resultat);

        //Introduim una instancia al ranking correcte
        error = test.altaRanking(dadesRank3.get(0), dadesRank3);
        escriuMissatgeError(error, 0);
        //Introduim una instancia al ranking ja existent
        error = test.altaRanking(dadesRank4.get(0), dadesRank4);
        escriuMissatgeError(error, 0);
        //Introduim una instancia al ranking ja existent
        error = test.altaRanking(dadesRank1.get(0), dadesRank1);
        escriuMissatgeError(error, 0);
        //Introduim una instancia al ranking amb dades incorrectes
        error = test.altaRanking("Aleixx", dadesRank1);
        escriuMissatgeError(error, 0);
        //Busquem totes les instancies de ranking
        resultat = test.consultaRankings();
        escriuRanking(resultat);

        //Esborrem una instancia de ranking
        error = test.baixaRankings(dadesRank1.get(0), dadesRank1);
        escriuMissatgeError(error, 1);
        //Esborrem una instancia de ranking ja existent
        error = test.baixaRankings(dadesRank1.get(0), dadesRank1);
        escriuMissatgeError(error, 1);
        //Busquem totes les instancies de ranking
        resultat = test.consultaRankings();
        escriuRanking(resultat);
    }

    private static void escriuRanking (Vector<String> ranking) {
        if (ranking.size() == 0) System.out.println("No hi ha cap ranking guardat " + "\n");
        for (int i = 0; i < ranking.size(); i++) {
            System.out.println((i+1) + ": " + ranking.get(i) + "\n");
        }
    }

    private static void escriuMissatgeError(Integer error, Integer funcio) {
        if (funcio == 0) { //altaRanking
            if (error == 0) System.out.println("La fila del ranking s'ha introduit correctament" + "\n");
            else if (error == 1) System.out.println("La fila del ranking que vols crear ja existeix " + "\n");
            else if (error == 2) System.out.println("L'identificador no coincideix amb les dades passades " + "\n");
        }
        else if (funcio == 1) { //esborrarRanking
            if (error == 0) System.out.println("La fila del ranking s'ha borrat correctament" + "\n");
            else if (error == 1) System.out.println("La fila del ranking que vols borrar no existeix " + "\n");
        }
    }
}