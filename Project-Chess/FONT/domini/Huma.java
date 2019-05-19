package domini;


import javafx.util.Pair;
import java.util.Scanner;


public class Huma extends Jugador {

    private String name;
    private Partida GameSaved;

    public Huma (Integer id, String name) {
        super(id);
        this.name = name;
        this.GameSaved = null;
    }


    public void guardarPartida (Partida p) {
        this.GameSaved = p;
    }

    public Partida getPartida () {
        return GameSaved;
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

    public String getName() {
        return name;
    }

    public Boolean registrar() {
        return false;
    }
}