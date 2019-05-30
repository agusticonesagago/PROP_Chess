package domini;


import javafx.util.Pair;
import java.util.Scanner;


public class Huma extends Jugador {

    private String name;
    private Float winrate;
    private int ProblemesJugats;
    private Partida GameSaved;

    public Huma (Integer id) {
        super(id);
        this.GameSaved = null;
        this.name = null;
        this.ProblemesJugats = 0;
        this.winrate = 0f;
        this.GameSaved = null;
    }



    @Override
    public Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> moureFitxa(Partida ptd, boolean jugantCom, int torns) {
        //llegir de teclat
        System.out.println ("Introduiex la posicio de la peca a moure" + "\n");
        Scanner escaner = new Scanner (System.in);
        int posicioXp = escaner.nextInt();
        int posicioYp = escaner.nextInt();
        System.out.println ("Introduiex la posicio on vols moure la peca" + "\n");
        int posicioXm = escaner.nextInt();
        int posicioYm = escaner.nextInt();
        Pair <Integer, Integer> posPeca = new Pair<Integer, Integer>(posicioXp, posicioYp);
        Pair <Integer, Integer> posMov = new Pair<Integer, Integer>(posicioXm, posicioYm);
        return new Pair<>(posPeca, posMov);
        //return null;
    }

    public Boolean registrar() {
        return false;
    }

    public int getGamesPlayer () {
        return ProblemesJugats;
    }

    public void novaPartidaAcabada(boolean victoria){
        int wins = ProblemesJugats*winrate.intValue();
        if (victoria) ++wins;
        ProblemesJugats++;
        winrate =(float) wins / ProblemesJugats;
    }

    public String getName() {
        return name;
    }

    public String getWinrate() {return winrate.toString();}

    public String getProblemesJugats() {return Integer.toString(ProblemesJugats);}

    public void SetName (String name) {
        this.name = name;
    }

    public void guardarPartida (Partida p) {
        this.GameSaved = p;
    }

    public Partida getPartida () {
        return GameSaved;
    }
}