package domini;

import javafx.util.Pair;
import java.util.ArrayList;

public class Taulell{

    // falta canviar Character -> Peca
    private Peca[][] Board;
    private ArrayList<Peca> Peces_Blanques;
    private ArrayList<Peca> Peces_Negres;


    public Taulell( Taulell t) {
        this.Board = new Peca[8][8];
        this.Peces_Negres = new ArrayList<>();
        this.Peces_Blanques = new ArrayList<>();
        for (int i=0; i < 8; ++i) {
            for (int j=0; j <  8; ++j) {
                if (t.PosOcupada(i,j)) {
                    switch (t.getBoard()[i][j].getClass().getName()) {
                        case "domini.Knight":
                            this.Board[i][j] = new Knight(t.getBoard()[i][j].getcolor(), new Pair<>(i, j), this);
                            if (t.getBoard()[i][j].getcolor()) Peces_Blanques.add(this.Board[i][j]);
                            else Peces_Negres.add(this.Board[i][j]);
                            break;
                        case "domini.Rook":
                            this.Board[i][j] = new Rook(t.getBoard()[i][j].getcolor(), new Pair<>(i, j), this);
                            if (t.getBoard()[i][j].getcolor()) Peces_Blanques.add(this.Board[i][j]);
                            else Peces_Negres.add(this.Board[i][j]);
                            break;
                        case "domini.Pawn":
                            this.Board[i][j] = new Pawn(t.getBoard()[i][j].getcolor(), new Pair<>(i, j), this);
                            if (t.getBoard()[i][j].getcolor()) Peces_Blanques.add(this.Board[i][j]);
                            else Peces_Negres.add(this.Board[i][j]);
                            break;
                        case "domini.King":
                            this.Board[i][j] = new King(t.getBoard()[i][j].getcolor(), new Pair<>(i, j), this);
                            if (t.getBoard()[i][j].getcolor()) Peces_Blanques.add(this.Board[i][j]);
                            else Peces_Negres.add(this.Board[i][j]);
                            break;
                        case "domini.Queen":
                            this.Board[i][j] = new Queen(t.getBoard()[i][j].getcolor(), new Pair<>(i, j), this);
                            if (t.getBoard()[i][j].getcolor()) Peces_Blanques.add(this.Board[i][j]);
                            else Peces_Negres.add(this.Board[i][j]);
                            break;
                        case "domini.Bishop":
                            this.Board[i][j] = new Bishop(t.getBoard()[i][j].getcolor(), new Pair<>(i, j), this);
                            if (t.getBoard()[i][j].getcolor()) Peces_Blanques.add(this.Board[i][j]);
                            else Peces_Negres.add(this.Board[i][j]);
                            break;
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
        return Board[i][j] != null;
    }


    public String ferMoviment(Pair<Integer, Integer> posini, Pair<Integer,Integer> posfi) {
        Peca p = null;
        if (posini != null) {
           p = Board[posini.getKey()][posini.getValue()];
        }
        if (p != null) {
            if (p.espotmoure(posfi)) { // if ok
                p.mourepeca(posfi);
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

                return "";
            }
            // mov no legal
            String name = p.getClass().getName();
            int until = name.indexOf(".");
            name = name.substring(until+1);
            return "No es pot moure " + name + " de [" + posini.getKey()+","+posini.getValue()+"] a ["+posfi.getKey()+","+posfi.getValue()+"]";
        }
        // pos ini sense peca
        return "No hi ha ningu a ["+posini.getKey()+","+posini.getValue()+"]";
    }


    public Peca findKing(boolean whatKing) {
        if (!whatKing) {
            for (int i=0; i< Peces_Negres.size(); ++i) if (Peces_Negres.get(i).getClass().getName().equals("domini.King")) return Peces_Negres.get(i);
        }
        else {
            for (int i=0; i< Peces_Blanques.size(); ++i) if (Peces_Blanques.get(i).getClass().getName().equals("domini.King")) return Peces_Blanques.get(i);
        }
        return null;
    }


    public boolean escac_mat(boolean jugantCom) {
        ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> mvs_meu;
        ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> mvs_enemic;
        mvs_meu = this.getMoves(jugantCom);
        boolean escacmat = true;
        for (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> aMvs_meu : mvs_meu) {
            Taulell x = new Taulell(this);
            x.ferMoviment(aMvs_meu.getKey(), aMvs_meu.getValue());
            mvs_enemic = x.getMoves(!jugantCom);

            /* todo OPTIMIZE
            if (mvs_enemic.size() == 0) {

            } else {

            }*/

            boolean salvat = true;
            for (Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> aMvs_enemic : mvs_enemic) {
                Taulell aux = new Taulell(x);
                aux.ferMoviment(aMvs_enemic.getKey(), aMvs_enemic.getValue());
                if (aux.findKing(jugantCom) == null) {
                    salvat = false;
                }
            }
            if (salvat) {
                escacmat = false;
            }
        }
        return escacmat;
    }


    public boolean  rei_segur(int i, int j,boolean jugantCom) {
        if (jugantCom) {
            boolean moviment_segur = true;
            for (Peca Pec_negra : Peces_Negres) {
                if (Pec_negra.espotmoure(new Pair<>(i, j))) {
                    moviment_segur = false;
                }
            }
            return moviment_segur;
        } else {
            boolean moviment_segur = true;
            for (Peca Pec_blanc: Peces_Blanques) {

                if (Pec_blanc.espotmoure(new Pair<>(i, j))) {
                    moviment_segur = false;
                }
            }
            return moviment_segur;
        }
    }



    // TODO MODIFICAR

    public ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> getMoves(boolean jugantCom ) {
        ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> mvs = new ArrayList<>();
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (this.PosOcupada(i, j) && Board[i][j].getcolor() == jugantCom) {
                    Peca p = Board[i][j];
                    for (int z = 0; z < 8; ++z) {
                        for (int w = 0; w < 8; ++w) {
                            if (p.espotmoure(new Pair<>(z, w))) { // if mov valid -> add a mvs
                                Taulell aux = new Taulell(this);
                                aux.ferMoviment(new Pair<>(i,j), new Pair<>(z,w));
                                King k = (King) aux.findKing(jugantCom);
                                if (aux.rei_segur(k.getposicioactual().getKey(), k.getposicioactual().getValue(),jugantCom)) {
                                    mvs.add(new Pair<>(new Pair<>(i, j), new Pair<>(z, w)));
                                }
                            }
                        }
                    }
                }
            }
        }
        return mvs;
    }
    // todo -> fix bugg
    /*
    public ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> getMoves(boolean jugantCom) {
        ArrayList< Pair< Pair<Integer, Integer>, Pair<Integer, Integer> > > mvs = new ArrayList<>();
        ArrayList< Pair<Integer, Integer> > aux = new ArrayList<>();
        if (jugantCom) {
            for (Peca pB: Peces_Blanques) {
                    aux.clear();
                    aux = pB.posicionsposible();
                    for (int j = 0; j < aux.size(); ++j) {
                        if (aux.get(j) != null) {
                            mvs.add(new Pair<>(pB.getposicioactual(), aux.get(j)));
                        }
                    }
            }
            return mvs;
        } else {
            for (Peca pN : Peces_Negres) {
                    aux.clear();
                    aux = pN.posicionsposible();
                    for (int j = 0; j < aux.size(); ++j) {
                        if (aux.get(j) != null) {
                            mvs.add(new Pair<>(pN.getposicioactual(), aux.get(j)));
                        }
                    }
            }
            return mvs;
        }
    }
    */


}
