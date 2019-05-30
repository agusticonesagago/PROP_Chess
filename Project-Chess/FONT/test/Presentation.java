package test;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;
import domini.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class Presentation {

    private static FileWriter output;
    private static Scanner sc;
    private static PrintWriter print_line;

    public static void creacioproblema(CtrlDominiMantProblema cdmp, CtrlDominiMantRanking cdr, CtrlDomini cdom) throws InterruptedException, IOException {

        print_line.println("Introdueix fen" + '\n');
        String fen = String.valueOf(sc.nextLine());
        print_line.println("FEN introduit: " + fen+ " correctament" + '\n');

        print_line.println("Introdueix objectiu, per exemple, Negres fan mat en 1" + '\n');
        String tema = String.valueOf(sc.nextLine());
        print_line.println("Objectiu introduit: " + tema + " correctament" + '\n');


        print_line.println("Introdueix dificultat, per exemple, fácil" + '\n');
        String dificultat = String.valueOf(sc.nextLine());
        print_line.println("Dificultat introduida: " + dificultat + " correctament" + '\n');

        Vector<String> dadesProbl = new Vector<>();
        dadesProbl.add(0,fen);
        dadesProbl.add(1,tema);
        dadesProbl.add(2,dificultat);

        Integer r = cdmp.altaProblema(dadesProbl.get(0),dadesProbl);

        System.out.println(r);
        if (r != 0) {
            print_line.println("Error en la creació del problema [Error: " + r + "]\n");
        }
        else print_line.println("La creació del problema s'ha dut a terme correctament" + "\n");

        menuprincipal(cdmp,cdr,cdom);
    }

    public static void jugarproblema(CtrlDominiMantProblema cdmp, CtrlDominiMantRanking cdr,CtrlDomini cdom) throws InterruptedException, IOException {
        Vector<Vector<String>> resultat = new Vector();
        resultat = cdmp.consultaProblemes();
        if (resultat.size() == 0) print_line.println("No hi ha cap problema a la base de dades" + "\n");
        else {
            for (int i = 0; i < resultat.size(); i++) {
                print_line.println("Problema " + (i + 1) + ": " + resultat.get(i).get(0) + ' ' + resultat.get(i).get(1) + ' ' + resultat.get(i).get(2) + "\n");
            }




            Integer problema;
            Integer primerjugador;
            if (sc.hasNext()) {

                print_line.println("Escull problema que vols jugar, introduint el número de la posició en el qual es mostra");
                print_line.println("El primer de tots és el número 1" + '\n');

                problema = Integer.valueOf(sc.nextLine());

                print_line.println("Introdueix qui vols que sigui el primer jugador (blanques)" + '\n');

                print_line.println("Introdueix 0 si vols jugar tu mateix" + '\n' +
                        "Introdueix 1 si vols que jugui M1 (algorisme bàsic) " + '\n' +
                        "Introdueix 2 si vols que jugui M2 (algorisme complex) " + '\n'
                );
                primerjugador = Integer.valueOf(sc.nextLine());
                print_line.println(primerjugador);
                String stringprimerjugador = "";
                if (primerjugador == 0) {
                    stringprimerjugador = "Huma";
                } else if (primerjugador == 1) {
                    stringprimerjugador = "Maquina1";
                } else if (primerjugador == 2) {
                    stringprimerjugador = "Maquina2";
                }
                String primerusuari = "";

                if (primerjugador == 0) {
                    print_line.println("Introdueix el nom d'usuari del primer jugador" + '\n');
                    primerusuari = String.valueOf(sc.nextLine());
                }

                print_line.println("Introdueix qui vols que sigui el segon jugador (negres)" + '\n');

                print_line.println("Introdueix 0 si vols jugar tu mateix" + '\n' +
                        "Introdueix 1 si vols que jugui M1 (algorisme bàsic) " + '\n' +
                        "Introdueix 2 si vols que jugui M2 (algorisme complex) " + '\n'
                );

                Integer segonjugador;
                segonjugador = Integer.valueOf(sc.nextLine());
                print_line.println(segonjugador);
                String stringsegonjugador = "";
                if (segonjugador == 0) {
                    stringsegonjugador = "Huma";
                } else if (segonjugador == 1) {
                    stringsegonjugador = "Maquina1";
                } else if (segonjugador == 2) {
                    stringsegonjugador = "Maquina2";
                }

                String segonusuari = "";

                if (segonjugador == 0) {
                    print_line.println("Introdueix el nom d'usuari del segon jugador" + '\n');
                    segonusuari = String.valueOf(sc.nextLine());
                }

                Vector<String> problemajugar = resultat.get(problema - 1);
                cdom.configurarPartida(problemajugar, stringprimerjugador, stringsegonjugador);
               // String guanyador = cdom.jugarPartida(primerusuari, segonusuari, print_line,sc);
                //print_line.println("El guanyador es: " + guanyador + '\n');
                print_line.println("Felicitats per la victòria!" + '\n');
                veureranking(cdmp, cdr, cdom);
            }
        }
        menuprincipal(cdmp,cdr,cdom);
    }

    public static void veureranking(CtrlDominiMantProblema cdmp, CtrlDominiMantRanking cdr, CtrlDomini cdom) throws InterruptedException, IOException {
        //Vector<String> ranking = cdr.consultaRankings();
        //if (ranking.size() == 0) print_line.println("No hi ha cap ranking guardat " + "\n");
        //for (int i = 0; i < ranking.size(); i++) {
          //  print_line.println((i+1) + ": " + ranking.get(i) + "\n");
       // }
        menuprincipal(cdmp,cdr,cdom);
    }

    public static void modificarfen(CtrlDominiMantProblema cdmp, CtrlDominiMantRanking cdr, CtrlDomini cdom) throws InterruptedException, IOException {
        Vector<Vector<String>> resultat = new Vector();
        resultat = cdmp.consultaProblemes();
        if (resultat.size() == 0) print_line.println("No hi ha cap problema a la base de dades" + "\n");
        else {
            for (int i = 0; i < resultat.size(); i++) {
                print_line.println("Problema " + (i + 1) + ": " + resultat.get(i).get(0) + ' ' + resultat.get(i).get(1) + ' ' + resultat.get(i).get(2) + "\n");
            }


            print_line.println("Escull problema que vols modificar el FEN, introduint el número de la posició en el qual es mostra");
            print_line.println("El primer de tots és el número 1" + '\n');

            Integer problemamodificar;
            problemamodificar = Integer.valueOf(sc.nextLine());
            print_line.println(problemamodificar);
            Vector<String> problemodificar = resultat.get(problemamodificar - 1);

            print_line.println("Introdueix el FEN nou que vols que modifiqui l'actual" + '\n');
            String fennou;
            fennou = String.valueOf(sc.nextLine());
            print_line.println(fennou);
            print_line.println("Introdueix el tema nou que vols que modifiqui l'actual" + '\n');
            String temanou;
            temanou = String.valueOf(sc.nextLine());
            print_line.println(temanou);
            print_line.println("Introdueix la dificultat nova que vols que modifiqui l'actual" + '\n');
            String dificultatnova;
            dificultatnova = String.valueOf(sc.nextLine());
            print_line.println(dificultatnova);
            Vector<String> problemanou = new Vector();
            problemanou.add(fennou);
            problemanou.add(temanou);
            problemanou.add(dificultatnova);

            cdmp.baixaProblema(problemodificar.get(0));
            int r = cdmp.altaProblema(fennou, problemanou);

            System.out.println(r);
            if (r != 0) {
                print_line.println("Error en la creació del problema [Error: " + r + "]\n");
            }
            else print_line.println("La creació del problema s'ha dut a terme correctament" + "\n");
        }
        menuprincipal(cdmp,cdr,cdom);
    }

    public static void menuprincipal(CtrlDominiMantProblema cdmp , CtrlDominiMantRanking cdr, CtrlDomini cdom) throws InterruptedException, IOException {


        print_line.println("Introdueix 0 si vols jugar problema" + '\n' +
                "Introdueix 1 si vols introduir un problema o modificar-ne un" + '\n' +
                "Introdueix 2 si vols veure ranking" + '\n'
        );

        int opcion;
        if (sc.hasNext()) {
            String opt = sc.nextLine();
            print_line.println(opt);
            opcion = Integer.valueOf(opt);

            if (opcion == 0) {
                jugarproblema(cdmp, cdr, cdom);
            } else if (opcion == 1) {
                print_line.println("Introdueix 0 si vols crear un problema" + '\n' +
                        "Introdueix 1 si vols modificar un problema existent" + '\n'
                );
                Integer modificar;
                modificar = Integer.valueOf(sc.nextLine());
                print_line.println(modificar);
                if (modificar == 0) creacioproblema(cdmp, cdr, cdom);
                else if (modificar == 1) modificarfen(cdmp, cdr, cdom);
                menuprincipal(cdmp, cdr, cdom);
            } else if (opcion == 2) {
                veureranking(cdmp, cdr, cdom);
            }
            menuprincipal(cdmp, cdr, cdom);
        } else {
            print_line.close();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        output = new FileWriter("./output-main.txt", false);
        print_line = new PrintWriter(output);

        System.out.println("Benvingut/da al joc dels escacs! Estàs llest per lluitar?" + '\n');
        System.out.println("Escull quin joc de proves vols executar: "+ '\n' +
                            "0 Crear-Problema" + '\n' +
                            "1 Modificar-Problema" + '\n' +
                            "2 Jugar M1 v M1 Facil" + '\n' +
                            "3 Jugar M1 v M1 Exhaustiu" + '\n' +
                            "4 Jugar M1 v H  Facil" + '\n' +
                            "5 Jugar H v H   Facil");
        Scanner aux = new Scanner(System.in);
        switch (aux.nextInt()) {
            case 0:
                sc = new Scanner(new File("./jp-crea-problema.txt"));
                break;
            case 1:
                sc = new Scanner(new File("./jp-modificar-problema.txt"));
                break;
            case 2:
                sc = new Scanner(new File("./jp-jugar-M1vM1-facil.txt"));
                break;
            case 3:
                sc = new Scanner(new File("./jp-jugar-M1vM1-exhaustiu.txt"));
                break;
            case 4:
                sc = new Scanner(new File("./jp-jugar-M1vH-facil.txt"));
                break;
            case 5:
                sc = new Scanner(new File("./jp-jugar-HvH-facil.txt"));
                break;
            case 6:
                sc = new Scanner(System.in);
                break;
        }

        CtrlDomini cdom = new CtrlDomini();
        CtrlDominiMantProblema cdmp = cdom.getCDMp();
        CtrlDominiMantRanking cdr = cdom.getCDMr();
        menuprincipal(cdmp, cdr,cdom);
    }
}