package test;

import domini.King;
import domini.Taulell;
import javafx.util.Pair;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.Scanner;

public class DriverTaulell {
    public static void main (String[] args) {
        System.out.println("Introdueix quina funcio vols testejar:" +'\n' +
                "0 Clonar un taulell" +'\n' +
                "1 Imprimir Taulell (FEN o normal)" +'\n' +
                "2 Posicio ocupada" +'\n' +
                "3 Fer Moviment" +'\n' +
                "4 Buscar al rei" +'\n' +
                "5 Mirar si escac mat" +'\n' +
                "6 Getter de moviments posibles");

        Scanner entradadiagonal = new Scanner(System.in);
        Integer cas = Integer.valueOf(entradadiagonal.nextLine());
        
        if (cas == 0) {
            test_clone();
        } else if (cas == 1) {
            test_prints();
        } else if (cas == 2) {
            test_ocupat();
        } else if (cas == 3) {
            test_movement();
        } else if (cas == 4) {
            test_find_king();
        } else if (cas == 5) {
            test_check_mate();
        } else if (cas == 6) {
            test_get_moves();
        }
    }


    private static void test_get_moves() {
        System.out.println("Cas de que no hi ha moviments posibles: ");
        Taulell t = new Taulell("3K2r1/8/3k4/8/8/8/8/8");
        t.PrintBoard();
        System.out.println(t.getMoves(true).size());

        System.out.println();

        System.out.println("Cas de que nomes podem moure una peca (rei)");
        Taulell t2 = new Taulell("8/8/8/3K4/8/8/8/8");
        t2.PrintBoard();
        System.out.println(t2.getMoves(true));
    }
    private static void test_find_king() {
        System.out.println("Donat el següent taulell: ");
        Taulell t = new Taulell("3r4/pp3kpQ/5p1p/3q1b2/1B2N3/8/PP3PPP/4R1K1");
        t.PrintBoard();
        King b = (King) t.findKing(true);
        System.out.println("El rei de les Blanques està a : ["+b.getposicioactual().getKey()+","+b.getposicioactual().getValue()+"]");
        King n = (King) t.findKing(false);
        System.out.println("El rei de les Negres està a : ["+n.getposicioactual().getKey()+","+n.getposicioactual().getValue()+"]");

    }
    private static void test_check_mate() {
        System.out.println("Indica que vols testejar:" +'\n' +
                "0 Blanques fan escac mat" +'\n' +
                "1 Negres fan escac mat" +'\n' +
                "2 Ningu fa escac mat");

        Scanner scn = new Scanner(System.in);
        int w = scn.nextInt();
        if (w == 0){
            Taulell t = new Taulell("3k2R1/8/3K4/8/8/8/8/8");
            t.PrintBoard();
            System.out.println("El rei negre esta en escac mat: "+ t.escac_mat(false));
        } else if (w == 1){
            Taulell t = new Taulell("3K2r1/8/3k4/8/8/8/8/8");
            t.PrintBoard();
            System.out.println("El rei blanc esta en escac mat: "+ t.escac_mat(true));
        } else {
            Taulell t = new Taulell("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
            t.PrintBoard();
            System.out.println("El rei blanc esta en escac mat: "+ t.escac_mat(true));
            System.out.println("El rei negre esta en escac mat: "+ t.escac_mat(false));

        }

    }
    private static void test_movement() {
        System.out.println("Partid del taulell inicial d'una partda d'escacs");
        Taulell t = new Taulell("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        t.PrintBoard();

        Scanner scn_pos = new Scanner(System.in);
        System.out.println("Introdueix des de on et vols moure: ");
        int i = scn_pos.nextInt();
        int j = scn_pos.nextInt();
        System.out.println("Introdueix a on et vols moure: ");
        int i_f = scn_pos.nextInt();
        int j_f = scn_pos.nextInt();

        System.out.println(t.ferMoviment(new Pair<>(i,j), new Pair<>(i_f,j_f)));
        t.PrintBoard();
    }

    private static void test_ocupat() {
        System.out.println("Partim del taulell inicial d'una partida d'escacs");
        Taulell t = new Taulell("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        t.PrintBoard();
        System.out.println("Introdueix la parella i j que mirar");
        Scanner scn_pos = new Scanner(System.in);
        int i = scn_pos.nextInt();
        int j = scn_pos.nextInt();

        System.out.println("La Posicio ["+i+","+j+"] esta ocupada: "+ t.PosOcupada(i,j));

    }

    private static void test_prints() {
        System.out.println("Partim del taulell inicial d'una partida d'escacs");
        Taulell t = new Taulell("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        System.out.println("Indica quin format vols testejar:" +'\n' +
                " 0 FEN" +'\n' +
                " 1 Chessboard");

        Scanner entradaformat = new Scanner(System.in);
        Integer format = Integer.valueOf(entradaformat.nextLine());

        if (format == 0) {
            System.out.println(t.PrintFEN());
        } else {
            t.PrintBoard();
        }

    }
    private static void test_clone() {
        System.out.println("Taulell Original: ");
        Taulell t = new Taulell("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        t.PrintBoard();
        System.out.println();
        System.out.println("Taulell Clonat: ");
        Taulell cloned = new Taulell(t);
        cloned.PrintBoard();
    }
}
