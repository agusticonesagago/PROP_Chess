package domini;

import javafx.util.Pair;




public class Taulell {

    // falta canviar Character -> Peca
    private Peca[][] Board;

    /* 1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B */
    public Taulell (String Taula_FEN) {
        Board = new Peca[8][8];
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
                        Board[i][board_pointer] = null;
                        ++board_pointer;
                        --pos;
                    }
                }
                // todo MODIFY WHEN PECA FET
                /* MAYUS -> white ? */
                else {
                    Pair<Integer, Integer> Pos = new Pair<>(i,board_pointer);
                    if (f.equals('K')) { // REI
                        Board[i][board_pointer] = new King(true, Pos, this);
                    } else if (f.equals('Q')) { // REINA
                        Board[i][board_pointer] = new Queen(true, Pos, this);
                    } else if (f.equals('R')) { // TORRE
                        Board[i][board_pointer] = new Rook(true, Pos, this);
                    } else if (f.equals('N')) { // CABALL
                        Board[i][board_pointer] = new Knight(true, Pos, this);
                    } else if (f.equals('B')) { // ALFIL
                        Board[i][board_pointer] = new Bishop(true, Pos, this);
                    } else if (f.equals('P')) { // PEO
                        Board[i][board_pointer] = new Pawn(true, Pos, this);
                    }
                    /* minus -> black ?*/
                    else if (f.equals('k')) { //rei
                        Board[i][board_pointer] = new King(false, Pos, this);
                    } else if (f.equals('q')) { //reina
                        Board[i][board_pointer] = new Queen(false, Pos, this);
                    } else if (f.equals('r')) { //torre
                        Board[i][board_pointer] = new Rook(false, Pos, this);
                    } else if (f.equals('n')) { // caball
                        Board[i][board_pointer] = new Knight(false, Pos, this);
                    } else if (f.equals('b')) { // alfil
                        Board[i][board_pointer] = new Bishop(false, Pos, this);
                    } else if (f.equals('p')) { // peo
                        Board[i][board_pointer] = new Pawn(false, Pos, this);
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
                if (Board[i][j] != null){
                    String name = Board[i][j].getClass().getName();
                    int until = name.indexOf(".");
                    name = name.substring(until+1);
                    System.out.print(name.charAt(0)+ " ");
                }
                else System.out.print(" - ");
            }
            System.out.println(" ");
        }
    }

    public String PrintFEN () {
        String res = "";
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (Board[i][j] == null) {
                    int c = 0;
                    while (Board[i][j] == null && j++ < 7) {
                        ++c;
                    }
                    if (j == 8) ++c;
                    res = res + String.valueOf(c);
                    --j;
                } else {
                    int find = Board[i][j].getClass().getName().indexOf('.');
                    res = res + String.valueOf(Board[i][j].getClass().getName().charAt(find+1));
                }
            }
            res = res + "/";
        }
        return res;
    }

    public Peca[][] getBoard () {
        return Board;
    }

    public Boolean PosOcupada(Integer i, Integer j) {
        if (Board[i][j] == null) return false;
        else return true;
    }

    // Todo TO TEST -> Preguntar si modo STRING BONA IDEA
    public String ferMoviment(Pair<Integer, Integer> posini, Pair<Integer,Integer> posfi) {
        Peca p = null;
        if (posini != null) p = Board[posini.getKey()][posini.getValue()];
        if (p != null) {
            if (p.espotmoure(posfi)) { // if ok
                p.mourepeca(posfi);
                Board[posini.getKey()][posini.getValue()] = null;
                Board[posfi.getKey()][posfi.getValue()] = p;
                return "";
            }
            // mov no legal
            String name = p.getClass().getName();
            int until = name.indexOf(".");
            name = name.substring(until+1);
            String res = "No es pot moure " + name + "de [" + posini.getKey()+","+posini.getValue()+"] a ["+posfi.getKey()+","+posfi.getValue()+"]";
            return res;
        }
        // pos ini sense peca
        return "No hi ha ningu a ["+posini.getKey()+","+posini.getValue()+"]";
    }

    // todo IMPLEMENT + TEST
    public boolean checkMate () {
        return false;
    }


}
