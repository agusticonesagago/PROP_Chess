package test;

import domini.*;

import java.util.Scanner;
import java.util.Vector;

public class Presentation {

    public static void creacioproblema(CtrlDominiMantProblema cdmp, CtrlDominiMantRanking cdr, CtrlDomini cdom){

        Scanner entradaEscaner = new Scanner(System.in);
        System.out.println("Introdueix fen" + '\n');
        Scanner entradafen = new Scanner(System.in);
        String fen = String.valueOf(entradaEscaner.nextLine());
        System.out.println("FEN introduit: " + fen+ " correctament" + '\n');

        System.out.println("Introdueix objectiu, per exemple, Negres fan mat en 1" + '\n');
        Scanner entradatema = new Scanner(System.in);
        String tema = String.valueOf(entradaEscaner.nextLine());
        System.out.println("Objectiu introduit: " + tema + " correctament" + '\n');


        System.out.println("Introdueix dificultat, per exemple, fácil" + '\n');
        Scanner entradadificultat = new Scanner(System.in);
        String dificultat = String.valueOf(entradaEscaner.nextLine());
        System.out.println("Dificultat introduida: " + dificultat + " correctament" + '\n');

        Vector<String> dadesProbl = new Vector<>();
        dadesProbl.add(0,fen);
        dadesProbl.add(1,tema);
        dadesProbl.add(2,dificultat);

        Integer r = cdmp.altaProblema(dadesProbl.get(0),dadesProbl);


        if (r != 0) {
            System.out.println("Error en la creació del problema" + r + "\n");
        }
        else System.out.println("La creació del problema s'ha dut a terme correctament" + "\n");

        menuprincipal(cdmp,cdr,cdom);
    }

    public static void jugarproblema(CtrlDominiMantProblema cdmp, CtrlDominiMantRanking cdr,CtrlDomini cdom){
        Vector<Vector<String>> resultat = new Vector();
        resultat = cdmp.consultaProblemes();
        if (resultat.size() == 0) System.out.println("No hi ha cap problema a la base de dades" + "\n");
        else{
            for (int i = 0; i < resultat.size(); i++) {
                System.out.println("Problema " + (i+1) + ": " + resultat.get(i).get(0)+' ' +resultat.get(i).get(1)+ ' '+resultat.get(i).get(2)+"\n");
            }
        }

        System.out.println("Escull problema que vols jugar, introduint el número de la posició en el qual es mostra" );
        System.out.println("El primer de tots és el número 1" + '\n');

        Integer problema;
        Scanner entradaproblema = new Scanner(System.in);
        problema = Integer.valueOf(entradaproblema.nextLine());

        System.out.println("Introdueix qui vols que sigui el primer jugador (blanques)"+ '\n');

        System.out.println("Introdueix 0 si vols jugar tu mateix" + '\n' +
                "Introdueix 1 si vols que jugui M1 (algorisme bàsic) " + '\n' +
                "Introdueix 2 si vols que jugui M2 (algorisme complex) " + '\n'
        );

        Integer primerjugador;
        Scanner entradaprimerjugador = new Scanner(System.in);
        primerjugador= Integer.valueOf(entradaprimerjugador.nextLine());

        String stringprimerjugador = "";
        if(primerjugador==0){
            stringprimerjugador= "Huma";
        }
        else if(primerjugador==1){
            stringprimerjugador = "Maquina1";
        }
        else if(primerjugador==2){
            stringprimerjugador = "Maquina2";
        }
        String primerusuari="";

        if(primerjugador==0){
            System.out.println("Introdueix el nom d'usuari del primer jugador" +'\n' );
            Scanner entradaprimerusuari = new Scanner(System.in);
            primerusuari = String.valueOf(entradaprimerusuari.nextLine());
        }

        System.out.println("Introdueix qui vols que sigui el segon jugador (negres)"+ '\n');

        System.out.println("Introdueix 0 si vols jugar tu mateix" + '\n' +
                "Introdueix 1 si vols que jugui M1 (algorisme bàsic) " + '\n' +
                "Introdueix 2 si vols que jugui M2 (algorisme complex) " + '\n'
        );

        Integer segonjugador;
        Scanner entradasegonjugador = new Scanner(System.in);
        segonjugador = Integer.valueOf(entradaprimerjugador.nextLine());

        String stringsegonjugador = "";
        if(segonjugador==0){
            stringsegonjugador= "Huma";
        }
        else if(segonjugador==1){
            stringsegonjugador = "Maquina1";
        }
        else if(segonjugador==2){
            stringsegonjugador = "Maquina2";
        }

        String segonusuari="";

        if(segonjugador==0){
            System.out.println("Introdueix el nom d'usuari del segon jugador" +'\n' );
            Scanner entradasegonusuari = new Scanner(System.in);
            segonusuari = String.valueOf(entradasegonusuari.nextLine());
        }

        Vector<String> problemajugar = resultat.get(problema-1);
        cdom.configurarPartida(problemajugar,stringprimerjugador,stringsegonjugador);
        String guanyador = cdom.jugarPartida(primerusuari, segonusuari);
        System.out.println("El guanyador es: "+ guanyador+ '\n' );
        System.out.println("Felicitats per la victòria!"+ '\n' );

        veureranking(cdmp,cdr,cdom);
        menuprincipal(cdmp,cdr,cdom);
    }

    public static void veureranking(CtrlDominiMantProblema cdmp, CtrlDominiMantRanking cdr, CtrlDomini cdom){
        Vector<String> ranking = cdr.consultaRankings();
        if (ranking.size() == 0) System.out.println("No hi ha cap ranking guardat " + "\n");
        for (int i = 0; i < ranking.size(); i++) {
            System.out.println((i+1) + ": " + ranking.get(i) + "\n");
        }
        menuprincipal(cdmp,cdr,cdom);
    }

    public static void modificarfen(CtrlDominiMantProblema cdmp, CtrlDominiMantRanking cdr, CtrlDomini cdom){
        Vector<Vector<String>> resultat = new Vector();
        resultat = cdmp.consultaProblemes();
        if (resultat.size() == 0) System.out.println("No hi ha cap problema a la base de dades" + "\n");
        else{
            for (int i = 0; i < resultat.size(); i++) {
                System.out.println("Problema " + (i+1) + ": " + resultat.get(i).get(0)+' ' +resultat.get(i).get(1)+ ' '+resultat.get(i).get(2)+"\n");
            }
        }

        System.out.println("Escull problema que vols modificar el FEN, introduint el número de la posició en el qual es mostra" );
        System.out.println("El primer de tots és el número 1" + '\n');

        Integer problemamodificar;
        Scanner entradaproblemamodificar = new Scanner(System.in);
        problemamodificar = Integer.valueOf(entradaproblemamodificar.nextLine());

        Vector<String> problemodificar= resultat.get(problemamodificar-1);

        System.out.println("Introdueix el FEN nou que vols que modifiqui l'actual" + '\n');
        String fennou;
        Scanner entradafennou = new Scanner(System.in);
        fennou = String.valueOf(entradafennou.nextLine());

        System.out.println("Introdueix el tema nou que vols que modifiqui l'actual" + '\n');
        String temanou;
        Scanner entradatemanou = new Scanner(System.in);
        temanou = String.valueOf(entradatemanou.nextLine());

        System.out.println("Introdueix la dificultat nova que vols que modifiqui l'actual" + '\n');
        String dificultatnova;
        Scanner entradadificultat = new Scanner(System.in);
        dificultatnova = String.valueOf(entradadificultat.nextLine());

        Vector<String> problemanou = new Vector();
        problemanou.add(fennou);
        problemanou.add(temanou);
        problemanou.add(dificultatnova);

        cdmp.baixaProblema(problemodificar.get(0));
        cdmp.altaProblema(fennou, problemanou );
        menuprincipal(cdmp,cdr,cdom);
    }

    public static void menuprincipal(CtrlDominiMantProblema cdmp , CtrlDominiMantRanking cdr, CtrlDomini cdom){


        System.out.println("Introdueix 0 si vols jugar problema" + '\n' +
                "Introdueix 1 si vols introduir un problema o modificar-ne un" + '\n' +
                "Introdueix 2 si vols veure ranking" + '\n'
        );

        Integer opcion;
        Scanner entradaEscaner = new Scanner(System.in);
        opcion = Integer.valueOf(entradaEscaner.nextLine());

        if(opcion==0){
            jugarproblema(cdmp, cdr,cdom);
        }

        else if (opcion == 1) {
            System.out.println("Introdueix 0 si vols crear un problema" + '\n' +
                    "Introdueix 1 si vols modificar un problema existent" + '\n'
            );
            Integer modificar;
            Scanner entradamodificar = new Scanner(System.in);
            modificar = Integer.valueOf(entradaEscaner.nextLine());
            if(modificar==0) creacioproblema(cdmp, cdr,cdom);
            else if (modificar==1) modificarfen(cdmp,cdr,cdom);
            menuprincipal(cdmp,cdr,cdom);
        }

        else if(opcion == 2){
            veureranking(cdmp, cdr,cdom);
        }
        menuprincipal(cdmp,cdr,cdom);
    }

    public static void main(String[] args) {
        System.out.println("Benvingut/da al joc dels escacs! Estàs llest per lluitar?" + '\n');
        CtrlDomini cdom = new CtrlDomini();
        CtrlDominiMantProblema cdmp = cdom.getCDMp();
        CtrlDominiMantRanking cdr = cdom.getCDMr();
        menuprincipal(cdmp, cdr,cdom);
    }
}