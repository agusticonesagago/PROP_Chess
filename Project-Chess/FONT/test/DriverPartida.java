package test;


// TODO
import domini.*;
import javafx.util.Pair;

import java.io.*;
import java.util.Scanner;

public class DriverPartida {

    private static FileWriter output;
    private static Scanner sc;
    private static PrintWriter print_line;

    public static void main(String[] args) throws IOException {

        File input = new File ("./Project-Chess/EXE/Partida/input-partida.txt");
        sc = new Scanner(input);

        output = new FileWriter("./Project-Chess/EXE/Partida/output-partida.txt");
        print_line = new PrintWriter(output);


        print_line.println("Tests de Creadora ");
        Tests_1();
        print_line.println("Tests de Jugar Torn");
        Tests_2();
        print_line.println("Test de Status de moviment");
        Test_3();
        print_line.close();
    }

    private static void Tests_2() {
        Partida t2 = new Partida(new StubProblem("",sc.nextLine()), new StubJugador(1), new StubJugador(2));
        t2.getTaulell().PrintBoard_toFile(print_line);
        print_line.println();
        t2.jugarTorn_toFile(1, print_line);
        t2.getTaulell().PrintBoard_toFile(print_line);
        print_line.println();
        t2.jugarTorn_toFile(1, print_line);
        t2.getTaulell().PrintBoard_toFile(print_line);
    }

    private static void Tests_1() {
        print_line.println("Volem introduir el següent FEN: ");
        String FEN = sc.nextLine();
        print_line.println(FEN);
        Partida t1 = new Partida(new StubProblem("",FEN), null, null);
        t1.getTaulell().PrintBoard_toFile(print_line);
        print_line.println();

        print_line.println("Li toca jugar a Blanques: " + t1.getQuiJuga());
        print_line.println();
    }

    private static void Test_3 () {
        Partida t3 = new Partida(new StubProblem("",sc.nextLine()),new StubJugador(3), new StubJugador(4));
        t3.getTaulell().PrintBoard_toFile(print_line);
        // NOT EXISTS
        String mov = sc.nextLine();
        int ii = Character.getNumericValue(mov.charAt(0));
        int ji = Character.getNumericValue(mov.charAt(2));
        int ie = Character.getNumericValue(mov.charAt(4));
        int je = Character.getNumericValue(mov.charAt(6));
        print_line.println(t3.getState(new Pair<>(new Pair<>(ii,ji), new Pair<>(ie,je))));
        // NOT OWNER
        mov = sc.nextLine();
        ii = Character.getNumericValue(mov.charAt(0));
        ji = Character.getNumericValue(mov.charAt(2));
        ie = Character.getNumericValue(mov.charAt(4));
        je = Character.getNumericValue(mov.charAt(6));
        print_line.println(t3.getState(new Pair<>(new Pair<>(ii,ji), new Pair<>(ie,je))));

        // SAVE KING
        mov = sc.nextLine();
        ii = Character.getNumericValue(mov.charAt(0));
        ji = Character.getNumericValue(mov.charAt(2));
        ie = Character.getNumericValue(mov.charAt(4));
        je = Character.getNumericValue(mov.charAt(6));
        print_line.println(t3.getState(new Pair<>(new Pair<>(ii,ji), new Pair<>(ie,je))));

        // SAVE KING BY PAWN
        mov = sc.nextLine();
        ii = Character.getNumericValue(mov.charAt(0));
        ji = Character.getNumericValue(mov.charAt(2));
        ie = Character.getNumericValue(mov.charAt(4));
        je = Character.getNumericValue(mov.charAt(6));
        print_line.println(t3.getState(new Pair<>(new Pair<>(ii,ji), new Pair<>(ie,je))));

        // GOOD
        mov = sc.nextLine();
        ii = Character.getNumericValue(mov.charAt(0));
        ji = Character.getNumericValue(mov.charAt(2));
        ie = Character.getNumericValue(mov.charAt(4));
        je = Character.getNumericValue(mov.charAt(6));
        print_line.println(t3.getState(new Pair<>(new Pair<>(ii,ji), new Pair<>(ie,je))));
    }

}