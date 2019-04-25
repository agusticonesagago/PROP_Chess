package test;

import domini.Pawn;
import javafx.util.Pair;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class DriverPawn {
    public static void main(String[] args) throws IOException {

        String path = "./Project-Chess/EXE/Pawn/OutputPawn.txt";
        FileWriter write = new FileWriter( path , false);
        PrintWriter t = new PrintWriter( write );

        File file = new File("./Project-Chess/EXE/Pawn/DadesPawn.txt");
        Scanner sc = new Scanner(file);


        /*t.printf("Introdueix 0 si vols testejar blanques" + '\n' +
                "Introdueix 1 si vols testejar negres ");*/

        Integer opcion;

        while(sc.hasNextLine()) {
            opcion = Integer.valueOf(sc.nextLine());

            if (opcion == 0) { //blanques
                Integer moviment;
                /*t.printf("Introdueix 0 si vols testejar tirar endavant" + '\n' +
                        "Introdueix 1 si vols testejar tirar en diagonal");*/

                moviment = Integer.valueOf(sc.nextLine());

                if (moviment == 0) { //tirar endavant
                    Integer numeroposicions;
                    /*t.printf("Introdueix 0 si vols testejar tirar endavant 1 posicio"+ '\n' +
                            "Introdueix 1 si vols testejar tirar endavant 2 posicions ");*/
                    numeroposicions = Integer.valueOf(sc.nextLine());

                    if (numeroposicions == 0) { //endavant 1 posicio
                        Integer rival;
                        /*t.printf("Introdueix 0 si vols testejar tirar endavant sense rival"+ '\n' +
                                "Introdueix 1 si vols testejar tirar endavant amb rival ");*/
                        rival = Integer.valueOf(sc.nextLine());

                        if (rival == 0) { //sense rival
                            StubTaulellPawn st_cas1 = new StubTaulellPawn("rnbqkbnr/pppp2pp/3P1p2/8/8/4p3/PPP1PPPP/RNBQKBNR w KQkq - 0 5");
                            Pawn p = new Pawn(true, new Pair<Integer, Integer>(6, 1), st_cas1);
                            boolean ok = p.espotmoure(new Pair<>(5, 1));
                            if (ok) t.printf("EM PUC MOURE, resultat correcte");
                            else t.printf("NO EM PUC MOURE, resultat incorrecte");
                        } else { //amb rival
                            StubTaulellPawn st_cas1 = new StubTaulellPawn("rnbqkbnr/pppp2pp/3P1p2/8/8/4p3/PPP1PPPP/RNBQKBNR w KQkq - 0 5");
                            Pawn p = new Pawn(true, new Pair<Integer, Integer>(6, 4), st_cas1);
                            boolean ok = p.espotmoure(new Pair<>(5, 4));
                            if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                            else t.printf("NO EM PUC MOURE, resultat correcte");
                        }
                    } else { //endavant 2 posicions
                        Integer rival;
                        /*t.printf("Introdueix 0 si vols testejar tirar recte sense rival"+ '\n' +
                                "Introdueix 1 si vols testejar tirar recte amb rival ");*/
                        rival = Integer.valueOf(sc.nextLine());

                        if (rival == 0) { //sense rival
                            StubTaulellPawn st_cas1 = new StubTaulellPawn("rnbqkbnr/pppp2pp/3P1p2/8/8/4p3/PPP1PPPP/RNBQKBNR w KQkq - 0 5");
                            Pawn p = new Pawn(true, new Pair<Integer, Integer>(6, 1), st_cas1);
                            boolean ok = p.espotmoure(new Pair<>(4, 1));
                            if (ok) t.printf("EM PUC MOURE, resultat correcte");
                            else t.printf("NO EM PUC MOURE, resultat incorrecte");
                        } else { //amb rival
                            StubTaulellPawn st_cas1 = new StubTaulellPawn("rnbqkbnr/pppp2pp/3P1p2/8/8/4p3/PPP1PPPP/RNBQKBNR w KQkq - 0 5");
                            Pawn p = new Pawn(true, new Pair<Integer, Integer>(6, 4), st_cas1);
                            boolean ok = p.espotmoure(new Pair<>(4, 4));
                            if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                            else t.printf("NO EM PUC MOURE, resultat correcte");
                        }
                    }
                } else { //diagonal
                    Integer matar;
                    /*t.printf("Introdueix 0 si vols testejar tirar en diagonal amb rival"+ '\n' +
                            "Introdueix 1 si vols testejar tirar en diagonal sense rival ");*/
                    matar = Integer.valueOf(sc.nextLine());

                    if (matar == 0) { //amb rival
                        StubTaulellPawn st_cas1 = new StubTaulellPawn("rnbqkbnr/pppp2pp/3P1p2/8/8/4p3/PPP1PPPP/RNBQKBNR w KQkq - 0 5");
                        Pawn p = new Pawn(true, new Pair<Integer, Integer>(6, 5), st_cas1);
                        boolean ok = p.espotmoure(new Pair<>(5, 4));
                        if (ok) t.printf("EM PUC MOURE, resultat correcte");
                        else t.printf("NO EM PUC MOURE, resultat incorrecte");
                    } else { //sense rival
                        StubTaulellPawn st_cas1 = new StubTaulellPawn("rnbqkbnr/pppp2pp/3P1p2/8/8/4p3/PPP1PPPP/RNBQKBNR w KQkq - 0 5");
                        Pawn p = new Pawn(true, new Pair<Integer, Integer>(6, 0), st_cas1);
                        boolean ok = p.espotmoure(new Pair<>(5, 1));
                        if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                        else t.printf("NO EM PUC MOURE, resultat correcte");
                    }
                }
            } else { //negre
                Integer moviment;
                /*t.printf("Introdueix 0 si vols testejar tirar endavant "+ '\n' +
                        "Introdueix 1 si vols testejar tirar en diagonal ");*/
                moviment = Integer.valueOf(sc.nextLine());

                if (moviment == 0) { //endavant
                    Integer numeroposicions;
                    /*t.printf("Introdueix 0 si vols testejar tirar endavant 1 posicio"+ '\n' +
                            "Introdueix 1 si vols testejar tirar endavant 2 posicions ");*/
                    numeroposicions = Integer.valueOf(sc.nextLine());

                    if (numeroposicions == 0) { //1 posicio
                        Integer rival;
                        /*t.printf("Introdueix 0 si vols testejar tirar endavant amb rival" +'\n' +
                                "Introdueix 1 si vols testejar tirar endavant sense rival ");*/
                        rival = Integer.valueOf(sc.nextLine());

                        if (rival == 0) { //amb rival
                            StubTaulellPawn st_cas1 = new StubTaulellPawn("rnbqkbnr/pppp2pp/3P1p2/8/8/4p3/PPP1PPPP/RNBQKBNR w KQkq - 0 5");
                            Pawn p = new Pawn(false, new Pair<Integer, Integer>(1, 3), st_cas1);
                            boolean ok = p.espotmoure(new Pair<>(2, 3));
                            if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                            else t.printf("NO EM PUC MOURE, resultat correcte");
                        } else { //sense rival
                            StubTaulellPawn st_cas1 = new StubTaulellPawn("rnbqkbnr/pppp2pp/3P1p2/8/8/4p3/PPP1PPPP/RNBQKBNR w KQkq - 0 5");
                            Pawn p = new Pawn(false, new Pair<Integer, Integer>(1, 0), st_cas1);
                            boolean ok = p.espotmoure(new Pair<>(2, 0));
                            if (ok) t.printf("EM PUC MOURE, resultat correcte");
                            else t.printf("NO EM PUC MOURE, resultat incorrecte");
                        }
                    } else { //2 posicions
                        Integer rival;
                        //t.printf("Introdueix 0 si vols testejar tirar recte amb rival" + '\n' +"Introdueix 1 si vols testejar tirar recte sense rival ");
                        rival = Integer.valueOf(sc.nextLine());

                        if (rival == 0) { //amb rival
                            StubTaulellPawn st_cas1 = new StubTaulellPawn("rnbqkbnr/pppp2pp/3P1p2/8/8/4p3/PPP1PPPP/RNBQKBNR w KQkq - 0 5");
                            Pawn p = new Pawn(false, new Pair<Integer, Integer>(1, 3), st_cas1);
                            boolean ok = p.espotmoure(new Pair<>(3, 3));
                            if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                            else t.printf("NO EM PUC MOURE, resultat correcte");
                        } else { //sense rival
                            StubTaulellPawn st_cas1 = new StubTaulellPawn("rnbqkbnr/pppp2pp/3P1p2/8/8/4p3/PPP1PPPP/RNBQKBNR w KQkq - 0 5");
                            Pawn p = new Pawn(false, new Pair<Integer, Integer>(1, 0), st_cas1);
                            boolean ok = p.espotmoure(new Pair<>(3, 0));
                            if (ok) t.printf("EM PUC MOURE, resultat correcte");
                            else t.printf("NO EM PUC MOURE, resultat incorrecte");
                        }
                    }
                } else { //tirar en diagonal
                    Integer matarblancas;
                    /*t.printf("Introdueix 0 si vols testejar tirar en diagonal amb rival" + '\n'+
                            "Introdueix 1 si vols testejar tirar en diagonal sense rival ");*/
                    matarblancas = Integer.valueOf(sc.nextLine());

                    if (matarblancas == 0) { //amb rival
                        StubTaulellPawn st_cas1 = new StubTaulellPawn("rnbqkbnr/pppp2pp/3P1p2/8/8/4p3/PPP1PPPP/RNBQKBNR w KQkq - 0 5");
                        Pawn p = new Pawn(false, new Pair<Integer, Integer>(1, 2), st_cas1);
                        boolean ok = p.espotmoure(new Pair<>(2, 3));
                        if (ok) t.printf("EM PUC MOURE, resultat correcte");
                        else t.printf("NO EM PUC MOURE, resultat incorrecte");
                    } else { //sense rival
                        StubTaulellPawn st_cas1 = new StubTaulellPawn("rnbqkbnr/pppp2pp/3P1p2/8/8/4p3/PPP1PPPP/RNBQKBNR w KQkq - 0 5");
                        Pawn p = new Pawn(false, new Pair<Integer, Integer>(1, 0), st_cas1);
                        boolean ok = p.espotmoure(new Pair<>(2, 1));
                        if (ok) t.printf("EM PUC MOURE, resultat incorrecte");
                        else t.printf("NO EM PUC MOURE, resultat correcte");
                    }
                }

            }
            t.printf("%n");
        }
        t.close();
    }
}