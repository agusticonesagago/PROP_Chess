package test;

import domini.*;
import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StubHuma extends  Huma {
    public StubHuma (Integer id) {
        super(id);
    }
    /*
    @Override
    public Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> moureFitxa(Partida ptd, boolean jugantCom, int torns) {
        //llegir de teclat
        //System.out.println ("Introduiex la posicio de la peca a moure" + "\n");
        File file = new File("C:\\Users\\PcCom\\Desktop\\Grau Informatica\\3r any\\Projectes de Programació\\PROP-Chess\\src\\FONT\\test\\InputHuma");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int posicioXp = sc.nextInt();
        int posicioYp = sc.nextInt();
        //System.out.println ("Introduiex la posicio on vols moure la peca" + "\n");
        int posicioXm = sc.nextInt();
        int posicioYm = sc.nextInt();
        Pair <Integer, Integer> posPeca = new Pair<Integer, Integer>(posicioXp, posicioYp);
        Pair <Integer, Integer> posMov = new Pair<Integer, Integer>(posicioXm, posicioYm);
        return new Pair<>(posPeca, posMov);
        //return null;
    }
    */
}