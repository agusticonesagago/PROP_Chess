package domini;

import javafx.util.Pair;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import sun.security.util.PendingException;

import java.util.ArrayList;
import java.util.Arrays;


public class Taulell{

    // falta canviar Character -> Peca
    private Peca[][] Board;
    private ArrayList<Peca> Peces_Blanques;
    private ArrayList<Peca> Peces_Negres;

    /* 1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B */

    public Taulell( Taulell t) {
        this.Board = new Peca[8][8];
        this.Peces_Negres = new ArrayList<>();
        this.Peces_Blanques = new ArrayList<>();

        for (int i=0; i < 8; ++i) {
            for (int j=0; j <  8; ++j) {
                if (t.PosOcupada(i,j)) {
                    if (t.getBoard()[i][j].getClass().getName() == "domini.Knight") {
                        this.Board[i][j]   = new Knight(t.getBoard()[i][j].getcolor(),new Pair<>(i,j),this );
                        if (t.getBoard()[i][j].getcolor()) Peces_Blanques.add(this.Board[i][j]);
                        else Peces_Negres.add(this.Board[i][j]);
                    }
                    else if (t.getBoard()[i][j].getClass().getName() == "domini.Rook") {
                        this.Board[i][j]   = new Rook(t.getBoard()[i][j].getcolor(),new Pair<>(i,j),this );
                        if (t.getBoard()[i][j].getcolor()) Peces_Blanques.add(this.Board[i][j]);
                        else Peces_Negres.add(this.Board[i][j]);
                    }
                    else if (t.getBoard()[i][j].getClass().getName() == "domini.Pawn") {
                        this.Board[i][j]   = new Pawn(t.getBoard()[i][j].getcolor(),new Pair<>(i,j),this );
                        if (t.getBoard()[i][j].getcolor()) Peces_Blanques.add(this.Board[i][j]);
                        else Peces_Negres.add(this.Board[i][j]);
                    }
                    else if (t.getBoard()[i][j].getClass().getName() == "domini.King") {
                        this.Board[i][j]   = new King(t.getBoard()[i][j].getcolor(),new Pair<>(i,j),this );
                        if (t.getBoard()[i][j].getcolor()) Peces_Blanques.add(this.Board[i][j]);
                        else Peces_Negres.add(this.Board[i][j]);
                    }
                    else if (t.getBoard()[i][j].getClass().getName() == "domini.Queen") {
                        this.Board[i][j]  = new Queen(t.getBoard()[i][j].getcolor(),new Pair<>(i,j),this );
                        if (t.getBoard()[i][j].getcolor()) Peces_Blanques.add(this.Board[i][j]);
                        else Peces_Negres.add(this.Board[i][j]);
                    }

                    else if (t.getBoard()[i][j].getClass().getName() == "domini.Bishop") {
                        this.Board[i][j] = new Bishop(t.getBoard()[i][j].getcolor(),new Pair<>(i,j),this );
                        if (t.getBoard()[i][j].getcolor()) Peces_Blanques.add(this.Board[i][j]);
                        else Peces_Negres.add(this.Board[i][j]);
                    }
                } else {
                    Board[i][j] = null;
                }
            }
        }
    }

    public Taulell (String Taula_FEN) {
        this.Board = new Peca[8][8];
        this.Peces_Negres = new ArrayList<>();
        this.Peces_Blanques = new ArrayList<>();
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
                        Peces_Blanques.add(Board[i][board_pointer]);
                    } else if (f.equals('Q')) { // REINA
                        Board[i][board_pointer] = new Queen(true, Pos, this);
                        Peces_Blanques.add(Board[i][board_pointer]);
                    } else if (f.equals('R')) { // TORRE
                        Board[i][board_pointer] = new Rook(true, Pos, this);
                        Peces_Blanques.add(Board[i][board_pointer]);
                    } else if (f.equals('N')) { // CABALL
                        Board[i][board_pointer] = new Knight(true, Pos, this);
                        Peces_Blanques.add(Board[i][board_pointer]);
                    } else if (f.equals('B')) { // ALFIL
                        Board[i][board_pointer] = new Bishop(true, Pos, this);
                        Peces_Blanques.add(Board[i][board_pointer]);
                    } else if (f.equals('P')) { // PEO
                        Board[i][board_pointer] = new Pawn(true, Pos, this);
                        Peces_Blanques.add(Board[i][board_pointer]);
                    }
                    /* minus -> black ?*/
                    else if (f.equals('k')) { //rei
                        Board[i][board_pointer] = new King(false, Pos, this);
                        Peces_Negres.add(Board[i][board_pointer]);
                    } else if (f.equals('q')) { //reina
                        Board[i][board_pointer] = new Queen(false, Pos, this);
                        Peces_Negres.add(Board[i][board_pointer]);
                    } else if (f.equals('r')) { //torre
                        Board[i][board_pointer] = new Rook(false, Pos, this);
                        Peces_Negres.add(Board[i][board_pointer]);
                    } else if (f.equals('n')) { // caball
                        Board[i][board_pointer] = new Knight(false, Pos, this);
                        Peces_Negres.add(Board[i][board_pointer]);
                    } else if (f.equals('b')) { // alfil
                        Board[i][board_pointer] = new Bishop(false, Pos, this);
                        Peces_Negres.add(Board[i][board_pointer]);
                    } else if (f.equals('p')) { // peo
                        Board[i][board_pointer] = new Pawn(false, Pos, this);
                        Peces_Negres.add(Board[i][board_pointer]);
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
                    if (name.equals("Knight")) name = "N";
                    if (Board[i][j].getcolor()) { // White Capital letters
                        System.out.print(name.toUpperCase().charAt(0)+ " ");
                    }
                    else {
                        System.out.print(name.toLowerCase().charAt(0)+" ");
                    }
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

    public ArrayList<Peca> getPeces_Blanques() {
        return Peces_Blanques;
    }

    public ArrayList<Peca> getPeces_Negres () {
        return Peces_Negres;
    }

    public Boolean PosOcupada(Integer i, Integer j) {
        if (Board[i][j] == null) return false;
        else return true;
    }

    // Todo TO TEST -> Preguntar si modo STRING BONA IDEA
    public String ferMoviment(Pair<Integer, Integer> posini, Pair<Integer,Integer> posfi) {
        Peca p = null;
        int ind = 0;
        if (posini != null) {
            //System.out.println(posini+ " " + posfi);
            if (Board[posini.getKey()][posini.getValue()].getcolor())ind = Peces_Blanques.indexOf(Board[posini.getKey()][posini.getValue()]);
            else ind = Peces_Negres.indexOf(Board[posini.getKey()][posini.getValue()]);

            p = Board[posini.getKey()][posini.getValue()];

        }
        if (p != null) {
            if (p.espotmoure(posfi)) { // if ok
                p.mourepeca(posfi);
                // TODO
                Board[posini.getKey()][posini.getValue()] = null;

                if (Board[posfi.getKey()][posfi.getValue()] != null && Board[posfi.getKey()][posfi.getValue()].getcolor() != p.getcolor()) {
                    if (p.getcolor()) {
                        Peces_Negres.remove(Board[posfi.getKey()][posfi.getValue()]);
                    } else {
                        Peces_Blanques.remove(Board[posfi.getKey()][posfi.getValue()]);
                    }
                }

                Board[posfi.getKey()][posfi.getValue()] = null;

                Board[posfi.getKey()][posfi.getValue()] = p;

                if(p.getcolor()) Peces_Blanques.set(ind, p);
                else Peces_Negres.set(ind,p);

                return "";
            }
            // mov no legal
            String name = p.getClass().getName();
            int until = name.indexOf(".");
            name = name.substring(until+1);
            String res = "No es pot moure " + name + " de [" + posini.getKey()+","+posini.getValue()+"] a ["+posfi.getKey()+","+posfi.getValue()+"]";
            return res;
        }
        // pos ini sense peca
        return "No hi ha ningu a ["+posini.getKey()+","+posini.getValue()+"]";
    }


    public Peca findKing(boolean whatKing) {
        for(int i=0; i < 8; ++i) {
            for(int j=0; j<8; ++j) {
                if (PosOcupada(i,j) && Board[i][j].getcolor() == whatKing && Board[i][j].getClass().getName()=="domini.King") {
                    return new King(Board[i][j].getcolor(), new Pair<>(i,j), this);
                }
            }
        }
        return null;
    }


}
