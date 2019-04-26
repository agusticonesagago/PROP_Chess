package test;

import domini.King;
import domini.Taulell;
import javafx.util.Pair;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DriverTaulell {

    private static FileWriter output;
    private static Scanner sc;
    private static PrintWriter print_line;

    public static void main (String[] args) throws IOException {
        System.out.println("Introdueix quina funcio vols testejar:" +'\n' +
                "1 Imprimir Taulell (FEN o normal)" +'\n' +
                "2 Posicio ocupada" +'\n' +
                "3 Fer Moviment" +'\n' +
                "4 Buscar al rei" +'\n' +
                "5 Mirar si escac mat" +'\n' +
                "6 Mirar si rei segur " );

        File input = new File("./input-taulell.txt");
        output = new FileWriter("./output-taulell.txt",true);
        print_line = new PrintWriter(output);
        sc = new Scanner(input);
        Integer opt;
        while (sc.hasNext()) {
            opt = Integer.valueOf(sc.nextLine());
            System.out.println(opt);
            switch (opt) {
                case 1:
                    test_prints();
                    print_line.println();
                    break;
                case 2:
                    test_ocupat();
                    print_line.println();
                    break;
                case 3:
                    test_movement();
                    print_line.println();
                    break;
                case 4:
                    test_find_king();
                    print_line.println();
                    break;
                case 5:
                    test_check_mate();
                    print_line.println();
                    break;
                case 6:
                    test_rei_segur();
                    print_line.println();
                    break;
                case -1:
                    print_line.close();
                    break;
            }
        }
    }


    private static void test_rei_segur() {


        print_line.println("TEST REI SEGUR EN [X,Y]");
        print_line.println("Donat el seguent taulell: ");
        Taulell t = new Taulell(sc.nextLine());
        t.PrintBoard_toFile(print_line);
        print_line.println();


        String pos = sc.nextLine();
        int i = Character.getNumericValue(pos.charAt(0));
        int j = Character.getNumericValue(pos.charAt(2));

        print_line.println("El rei es pot moure a "+i + ","+j+": "+t.rei_segur(i,j,true));

        pos = sc.nextLine();
        i = Character.getNumericValue(pos.charAt(0));
        j = Character.getNumericValue(pos.charAt(2));

        print_line.println("El rei es pot moure a "+i + ","+j+": "+t.rei_segur(i,j,true));

    }

    private static void test_find_king() {
        print_line.println("TEST TROBAR ALS REIS");
        print_line.println("Donat el següent taulell:");
        Taulell t = new Taulell(sc.nextLine());
        t.PrintBoard_toFile(print_line);
        print_line.println();
        King b = (King) t.findKing(true);
        print_line.println("El rei de les Blanques està a : ["+b.getposicioactual().getKey()+","+b.getposicioactual().getValue()+"]");
        King n = (King) t.findKing(false);
        print_line.println("El rei de les Negres està a : ["+n.getposicioactual().getKey()+","+n.getposicioactual().getValue()+"]");


        print_line.println("Donat un taulell buit:");
        t = new Taulell("8/8/8/8/8/8/8/8");
        print_line.println("El rei Blanc està a :" + t.findKing(true));

        print_line.println();

    }

    private static void test_check_mate() {
        print_line.println("TEST ESCAC MAT: ");

        print_line.println("Donat el seguent taulell on les blanques han fet escac mat a les negres: ");
        Taulell t = new Taulell(sc.nextLine());
        t.PrintBoard_toFile(print_line);
        print_line.println();
        print_line.println("Les blanques han fet escac mat: ["+t.escac_mat(false) +"]");

        print_line.println("Donat el seguent taulell on les negres han fet escac mat a les blanques: ");
        t = new Taulell(sc.nextLine());
        t.PrintBoard_toFile(print_line);
        print_line.println();
        print_line.println("Les negres   han fet escac mat: ["+t.escac_mat(true) +"]");

        print_line.println("Donat el seguent taulell on ni les blanques ni les negres han fet escac mat: ");
        t = new Taulell(sc.nextLine());
        t.PrintBoard_toFile(print_line);
        print_line.println();
        print_line.println("Les blanques han fet escac mat: ["+t.escac_mat(true) +"]");
        print_line.println("Les negres   han fet escac mat: ["+t.escac_mat(false) +"]");

    }

    private static void test_movement() {
        print_line.println("TEST MOVIMENTS POSIBLES");
        print_line.println("Partint del taulell inicial d'una partda d'escacs");
        Taulell t = new Taulell(sc.nextLine());
        t.PrintBoard();


        print_line.println("Cas moviment no vàlid");

        String pos_f = sc.nextLine();
        int xf = Character.getNumericValue(pos_f.charAt(0));
        int yf = Character.getNumericValue(pos_f.charAt(2));
        String pos_t = sc.nextLine();
        int xt = Character.getNumericValue(pos_t.charAt(0));
        int yt = Character.getNumericValue(pos_t.charAt(2));

        print_line.println(t.ferMoviment(new Pair<>(xf,yf), new Pair<>(xt,yt)));

        print_line.println("Origen Sense Peca");

        pos_f = sc.nextLine();
        xf = Character.getNumericValue(pos_f.charAt(0));
        yf = Character.getNumericValue(pos_f.charAt(2));
        pos_t = sc.nextLine();
        xt = Character.getNumericValue(pos_t.charAt(0));
        yt = Character.getNumericValue(pos_t.charAt(2));

        print_line.println(t.ferMoviment(new Pair<>(xf,yf), new Pair<>(xt,yt)));

        print_line.println("Cas moviment Correcte");

        pos_f = sc.nextLine();
        xf = Character.getNumericValue(pos_f.charAt(0));
        yf = Character.getNumericValue(pos_f.charAt(2));
        pos_t = sc.nextLine();
        xt = Character.getNumericValue(pos_t.charAt(0));
        yt = Character.getNumericValue(pos_t.charAt(2));

        print_line.println(t.ferMoviment(new Pair<>(xf,yf), new Pair<>(xt,yt)));
        t.PrintBoard_toFile(print_line);

    }

    private static void test_ocupat() {

        print_line.println("TEST COMPROVAR SI POSICIÓ OCUPADA");
        Taulell t = new Taulell("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");
        print_line.println("Taulell: ");
        t.PrintBoard_toFile(print_line);

        String pos;
        int x,y;
        for(int a = 0; a < 3; ++a) {
            pos = sc.nextLine();
            x = Character.getNumericValue(pos.charAt(0));
            y = Character.getNumericValue(pos.charAt(2));
            print_line.println("La posició ["+x+","+y+"] esta ocuapada: "+ t.PosOcupada(x,y));
        }


    }

    private static void test_prints() {
        print_line.println("TEST IMPRIMIR FEN/TAULELL PER PANTALLA");
        print_line.println("Aquest es el FEN que introduim: ");
        String FEN = sc.nextLine();
        Taulell t = new Taulell(FEN);
        print_line.println(FEN);
        t.PrintBoard_toFile(print_line);
        print_line.println(t.PrintFEN());
        print_line.println();
    }
}
