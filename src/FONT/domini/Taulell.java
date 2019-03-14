package domini;

import javafx.util.Pair;

import java.util.ArrayList;

public class Taulell {

    // falta canviar Character -> Peca
    private Peça[][] Board;

    /* 1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B */
    public Taulell (String Taula_FEN) {
        Board = new Character[8][8];
        int i = 0;
        while (!Taula_FEN.isEmpty()){
            int ir = Taula_FEN.indexOf("/");
            if (ir == -1) ir = Taula_FEN.length();
            String row = Taula_FEN.substring(0, ir);

            int board_pointer = 0;
            int row_pointer = 0;
            while (board_pointer != 8){
                Character f = row.charAt(row_pointer);
                /* CASE NUMBER */
                if (f>= '1' && f <='8') {
                    int pos = Character.getNumericValue(f);
                    while (pos != 0) {
                        Board[i][board_pointer] = '-';
                        ++board_pointer;
                        --pos;
                    }
                }
                // todo MODIFY WHEN PECA FET
                /* MAYUS -> white ? */
                else {
                    if (f.equals('K')) { // REI
                        Board[i][board_pointer] = 'K';
                    } else if (f.equals('Q')) { // REINA
                        Board[i][board_pointer] = 'Q';
                    } else if (f.equals('R')) { // TORRE
                        Board[i][board_pointer] = 'R';
                    } else if (f.equals('N')) { // CABALL
                        Board[i][board_pointer] = 'N';
                    } else if (f.equals('B')) { // ALFIL
                        Board[i][board_pointer] = 'B';
                    } else if (f.equals('P')) { // PEO
                        Board[i][board_pointer] = 'P';
                    }
                    /* minus -> black ?*/
                    else if (f.equals('k')) { //rei
                        Board[i][board_pointer] = 'k';
                    } else if (f.equals('q')) { //reina
                        Board[i][board_pointer] = 'q';
                    } else if (f.equals('r')) { //torre
                        Board[i][board_pointer] = 'r';
                    } else if (f.equals('n')) { // caball
                        Board[i][board_pointer] = 'n';
                    } else if (f.equals('b')) { // alfil
                        Board[i][board_pointer] = 'b';
                    } else if (f.equals('p')) { // peo
                        Board[i][board_pointer] = 'p';
                    }
                    ++board_pointer;
                }
                ++row_pointer;
            }


            if (ir == Taula_FEN.length()) Taula_FEN = "";
            else Taula_FEN = Taula_FEN.substring(ir+1);
            ++i;
        }
    }

    public void PrintBoard () {
        for(int i=0; i < 8; ++i ){
            for (int j = 0; j < 8; ++j) {
                System.out.print(Board[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public Boolean PosOcupada(Integer i, Integer j) {
        if (Board[i][j] == '-') return false;
        else return true;
    }

    public
}
