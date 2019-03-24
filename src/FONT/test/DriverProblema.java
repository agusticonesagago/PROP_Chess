package test;

import domini.Problema;
import java.util.Scanner;

public class DriverProblema {
    public static void main (String[] args) {
        String fen = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B";
        String t = "Mat_en_X";
        Problema test = new Problema(t, fen);

        int cas;
        Scanner sc = new Scanner (System.in);
        cas = sc.nextInt();
        //switch{}
    }
}
