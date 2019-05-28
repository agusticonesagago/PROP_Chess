package domini;

import javafx.util.Pair;

import java.io.PrintWriter;
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
                            this.Board[i][j] = new Knight(t.getBoard()[i][j].getcolor(), new Pair<>(i, j));
                            if (t.getBoard()[i][j].getcolor()) Peces_Blanques.add(this.Board[i][j]);
                            else Peces_Negres.add(this.Board[i][j]);
                            break;
                        case "domini.Rook":
                            this.Board[i][j] = new Rook(t.getBoard()[i][j].getcolor(), new Pair<>(i, j));
                            if (t.getBoard()[i][j].getcolor()) Peces_Blanques.add(this.Board[i][j]);
                            else Peces_Negres.add(this.Board[i][j]);
                            break;
                        case "domini.Pawn":
                            this.Board[i][j] = new Pawn(t.getBoard()[i][j].getcolor(), new Pair<>(i, j));
                            if (t.getBoard()[i][j].getcolor()) Peces_Blanques.add(this.Board[i][j]);
                            else Peces_Negres.add(this.Board[i][j]);
                            break;
                        case "domini.King":
                            this.Board[i][j] = new King(t.getBoard()[i][j].getcolor(), new Pair<>(i, j));
                            if (t.getBoard()[i][j].getcolor()) Peces_Blanques.add(this.Board[i][j]);
                            else Peces_Negres.add(this.Board[i][j]);
                            break;
                        case "domini.Queen":
                            this.Board[i][j] = new Queen(t.getBoard()[i][j].getcolor(), new Pair<>(i, j));
                            if (t.getBoard()[i][j].getcolor()) Peces_Blanques.add(this.Board[i][j]);
                            else Peces_Negres.add(this.Board[i][j]);
                            break;
                        case "domini.Bishop":
                            this.Board[i][j] = new Bishop(t.getBoard()[i][j].getcolor(), new Pair<>(i, j));
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
                        Board[i][board_pointer] = new King(true, Pos);
                        Peces_Blanques.add(Board[i][board_pointer]);
                    } else if (f.equals('Q')) { // REINA
                        Board[i][board_pointer] = new Queen(true, Pos);
                        Peces_Blanques.add(Board[i][board_pointer]);
                    } else if (f.equals('R')) { // TORRE
                        Board[i][board_pointer] = new Rook(true, Pos);
                        Peces_Blanques.add(Board[i][board_pointer]);
                    } else if (f.equals('N')) { // CABALL
                        Board[i][board_pointer] = new Knight(true, Pos);
                        Peces_Blanques.add(Board[i][board_pointer]);
                    } else if (f.equals('B')) { // ALFIL
                        Board[i][board_pointer] = new Bishop(true, Pos);
                        Peces_Blanques.add(Board[i][board_pointer]);
                    } else if (f.equals('P')) { // PEO
                        Board[i][board_pointer] = new Pawn(true, Pos);
                        Peces_Blanques.add(Board[i][board_pointer]);
                    }
                    /* minus -> black ?*/
                    else if (f.equals('k')) { //rei
                        Board[i][board_pointer] = new King(false, Pos);
                        Peces_Negres.add(Board[i][board_pointer]);
                    } else if (f.equals('q')) { //reina
                        Board[i][board_pointer] = new Queen(false, Pos);
                        Peces_Negres.add(Board[i][board_pointer]);
                    } else if (f.equals('r')) { //torre
                        Board[i][board_pointer] = new Rook(false, Pos);
                        Peces_Negres.add(Board[i][board_pointer]);
                    } else if (f.equals('n')) { // caball
                        Board[i][board_pointer] = new Knight(false, Pos);
                        Peces_Negres.add(Board[i][board_pointer]);
                    } else if (f.equals('b')) { // alfil
                        Board[i][board_pointer] = new Bishop(false, Pos);
                        Peces_Negres.add(Board[i][board_pointer]);
                    } else if (f.equals('p')) { // peo
                        Board[i][board_pointer] = new Pawn(false, Pos);
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

        for(int i = 0; i < 8; ++i){
            if(i==0) System.out.print("   "+i+"  ");
            else System.out.print(i+"  ");
        }
        System.out.print('\n');
        for(int i=0; i < 8; ++i ){
            System.out.print(i+" ");
            for (int j = 0; j < 8; ++j) {
                if (Board[i][j] != null){
                    String name = Board[i][j].getClass().getName();
                    int until = name.indexOf(".");
                    name = name.substring(until+1);
                    if (name.equals("Knight")) name = "N";
                    if (Board[i][j].getcolor()) { // White Capital letters
                        System.out.print(" " + name.toUpperCase().charAt(0)+ " ");
                    } else{
                        System.out.print(" " +name.toLowerCase().charAt(0)+" ");
                    }
                }
                else {
                    System.out.print(" - ");
                }
            }
            System.out.println(" ");
        }
    }


    public void PrintBoard_toFile (PrintWriter pw) {

        for(int i = 0; i < 8; ++i){
            if(i==0) pw.print("   "+i+"  ");
            else pw.print(i+"  ");
        }
        pw.println();
        for(int i=0; i < 8; ++i ){
            pw.print(i+" ");
            for (int j = 0; j < 8; ++j) {
                if (Board[i][j] != null){
                    String name = Board[i][j].getClass().getName();
                    int until = name.indexOf(".");
                    name = name.substring(until+1);
                    if (name.equals("Knight")) name = "N";
                    if (Board[i][j].getcolor()) { // White Capital letters
                        pw.print(" " + name.toUpperCase().charAt(0)+ " ");
                    }
                    else {
                        pw.print(" " +name.toLowerCase().charAt(0)+" ");
                   }
                }
                else pw.print(" - ");
            }
            pw.println(" ");
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
                    if (Board[i][j].getcolor()) {
                        res += String.valueOf(Board[i][j].getClass().getName().charAt(find+1)).toUpperCase();
                    } else {
                        res += String.valueOf(Board[i][j].getClass().getName().charAt(find+1)).toLowerCase();
                    }
                }
            }
            res = res + "/";
        }
        return res.substring(0,res.length()-1);
    }

    public domini.Peca[][] getBoard () {
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
        mvs_meu = this.getMoves(jugantCom);
        if (mvs_meu.size() == 0) return true;
        else return false;
    }

    public boolean  rei_segur(int i, int j,boolean jugantCom) {
        /*
        * Aquesta funció determina si la posicio [i,j] es segura per al jugador  [jugantCom]
        * */
        if (jugantCom) {
            boolean moviment_segur = true;
            ArrayList<Pair<Integer, Integer> > movs_n = new ArrayList<>();
            for (Peca Pec_negra : Peces_Negres) {
                if (Pec_negra.espotmoure(new Pair<>(i, j))) { // Segons el seu moviment
                    movs_n.add(new Pair<>(i,j));
                    if (validarMoviments(movs_n, Pec_negra.getClass().getName(), Pec_negra).size () != 0) { // Segons el taulell
                        moviment_segur = false;
                    }
                    movs_n.clear();
                }
            }
            return moviment_segur;
        } else {
            boolean moviment_segur = true;
            ArrayList<Pair<Integer, Integer> > movs_b = new ArrayList<>();
            for (Peca Pec_blanc: Peces_Blanques) {
                if (Pec_blanc.espotmoure(new Pair<>(i, j))) {
                    movs_b.add(new Pair<>(i,j));
                    if (validarMoviments(movs_b, Pec_blanc.getClass().getName(), Pec_blanc).size () != 0) { // Segons el taulell
                        moviment_segur = false;
                    }
                    movs_b.clear();
                }
            }
            return moviment_segur;
        }
    }



    public ArrayList<Pair<Integer, Integer>> validarMoviments(ArrayList<Pair<Integer, Integer>> moves, String type, Peca p) {
        ArrayList<Pair<Integer, Integer>> defMoves = new ArrayList<>();
        for (int i=0; i < moves.size(); ++i) {
            Pair<Integer, Integer> m = moves.get(i);
            if ((PosOcupada(m.getKey(),m.getValue()) && Board[m.getKey()][m.getValue()].getcolor() != p.getcolor()) || !PosOcupada(m.getKey(), m.getValue())){
                // CAS POSICIO OCUPADA PER PECA DEL ALTRE EQUIP OR CAS POSICIO NO OCUPADA
                if (type.equals("domini.King")){ // Sempre es pot moure
                    defMoves.add(m);
                }
                else if (type.equals("domini.Knight")){ // Sempre es pot moure
                    defMoves.add(m);
                }
                else if (type.equals("domini.Bishop")){ // Nomes si no hi ha objectius al mig
                    int dif_i = m.getKey() - p.getposicioactual().getKey();
                    int dif_j = m.getValue() - p.getposicioactual().getValue();

                    int aux_i = p.getposicioactual().getKey() + ((dif_i > 0) ? 1 : -1);
                    int aux_j = p.getposicioactual().getValue() + ((dif_j > 0) ? 1 : -1);
                    boolean findBlock = false;
                    while (!findBlock && (aux_i != m.getKey()) && (aux_j != m.getValue())){
                        if (!PosOcupada(aux_i,aux_j)){
                            aux_i += (dif_i > 0) ? 1 : -1;
                            aux_j += (dif_j > 0) ? 1 : -1;
                        } else {
                            findBlock = true;
                        }
                    }
                    if (!findBlock) defMoves.add(m);
                }
                else if (type.equals("domini.Queen")){ // Nomes si no hi ha objectius al mig
                    int dif_i = m.getKey() - p.getposicioactual().getKey();
                    int dif_j = m.getValue() - p.getposicioactual().getValue();

                    if (Math.abs(dif_i) == Math.abs(dif_j)){
                        int aux_i = p.getposicioactual().getKey() + ((dif_i > 0) ? 1 : -1);
                        int aux_j = p.getposicioactual().getValue() + ((dif_j > 0) ? 1 : -1);
                        boolean findBlock = false;
                        while (!findBlock && (aux_i != m.getKey()) && (aux_j != m.getValue())){
                            if (!PosOcupada(aux_i,aux_j)){
                                aux_i += (dif_i > 0) ? 1 : -1;
                                aux_j += (dif_j > 0) ? 1 : -1;
                            } else {
                                findBlock = true;
                            }
                        }
                        if (!findBlock) defMoves.add(m);
                    }
                    else if (dif_j == 0) { // Vertical
                        int aux_i = p.getposicioactual().getKey() + ((dif_i > 0) ? 1 : -1);
                        boolean findBlock = false;
                        while (!findBlock && aux_i != m.getKey()) {
                            if (!PosOcupada(aux_i, m.getValue())){
                                aux_i += (dif_i > 0) ? 1 : -1;
                            } else {
                                findBlock = true;
                            }
                        }
                        if (!findBlock) defMoves.add(m);
                    } else if (dif_i == 0){ // Horitzontal

                        int aux_j = p.getposicioactual().getValue() + ((dif_j > 0) ? 1 : -1);
                        boolean findBlock = false;
                        while (!findBlock && aux_j != m.getValue()) {
                            if (!PosOcupada(m.getKey(), aux_j)){
                                aux_j += (dif_j > 0) ? 1 : -1;
                            } else {
                                findBlock = true;
                            }
                        }
                        if (!findBlock) defMoves.add(m);
                    }

                }
                else if (type.equals("domini.Rook")) { // Nomes si no hi ha objectius al mig
                    int dif_i = m.getKey() - p.getposicioactual().getKey();
                    int dif_j = m.getValue() - p.getposicioactual().getValue();
                    if (dif_j == 0) { // Vertical
                        int aux_i = p.getposicioactual().getKey() + ((dif_i > 0) ? 1 : -1);
                        boolean findBlock = false;
                        while (!findBlock && aux_i != m.getKey()) {
                            if (!PosOcupada(aux_i, m.getValue())){
                                aux_i += (dif_i > 0) ? 1 : -1;
                            } else {
                                findBlock = true;
                            }
                        }
                        if (!findBlock) defMoves.add(m);
                    }
                    else if (dif_i == 0){ // Horitzontal
                        int aux_j = p.getposicioactual().getValue() + ((dif_j > 0) ? 1 : -1);
                        boolean findBlock = false;
                        while (!findBlock && aux_j != m.getValue()) {
                            if (!PosOcupada(m.getKey(), aux_j)){
                                aux_j += (dif_j > 0) ? 1 : -1;
                            } else {
                                findBlock = true;
                            }
                        }
                        if (!findBlock) defMoves.add(m);
                    }
                }
                else if (type.equals("domini.Pawn")){ // Nomes si mov es en diagonal
                    int dif_i = m.getKey() - p.getposicioactual().getKey();
                    int dif_j = m.getValue() - p.getposicioactual().getValue();
                    if (PosOcupada(m.getKey(),m.getValue())) { // Vol dir que es el cas de un enemic
                        if (Math.abs(dif_i) == Math.abs(dif_j)) { // Si es un moviment diagonal
                            defMoves.add(m);
                        }
                    } else {
                        if (Math.abs(dif_i) == 2) { // Cas moviment inicial
                            if (p.getcolor()) { // Cas blanques
                                if (!PosOcupada(p.getposicioactual().getKey()-1, p.getposicioactual().getValue())){
                                    defMoves.add(m);
                                }
                            } else {
                                if (!PosOcupada(p.getposicioactual().getKey()+1, p.getposicioactual().getValue())){
                                    defMoves.add(m);
                                }
                            }
                        } else if (Math.abs(dif_i) != Math.abs(dif_j)) {
                            defMoves.add(m);
                        }
                    }
                }
            }
        }
        return defMoves;
    }


// todo -> Funcions mirar si moviment de la peca es legal per part del taulell
    public ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> getMoves(boolean jugantCom) {
        ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> mvs = new ArrayList<>();

        if (jugantCom) {
            for (Peca pB : Peces_Blanques) {
                ArrayList<Pair<Integer, Integer>> auxB = validarMoviments(pB.posicionsposible(), pB.getClass().getName(),pB);
                /*Funció per saber si es pot moure a la posicio segons les posicions de les altres peces*/
                for (int j = 0; j < auxB.size(); ++j) {
                    Taulell t_aux = new Taulell(this);
                    Pair<Integer, Integer> pact = pB.getposicioactual();
                    t_aux.ferMoviment(pact, auxB.get(j));
                    King k = (King) t_aux.findKing(true);
                    if (t_aux.rei_segur(k.getposicioactual().getKey(), k.getposicioactual().getValue(), true)) {
                        mvs.add(new Pair<>(pact, auxB.get(j)));
                    }

                }

            }
            return mvs;
        } else {
            for (Peca pN : Peces_Negres) {
                ArrayList<Pair<Integer, Integer>> auxN = validarMoviments(pN.posicionsposible(),pN.getClass().getName(),pN);
                for (int j = 0; j < auxN.size(); ++j) {
                    Taulell t_aux = new Taulell(this);
                    Pair<Integer, Integer> pact = pN.getposicioactual();
                    t_aux.ferMoviment(pN.getposicioactual(), auxN.get(j));
                    King k = (King) t_aux.findKing(false);
                    if (k == null || t_aux.rei_segur(k.getposicioactual().getKey(), k.getposicioactual().getValue(), false)) {
                        mvs.add(new Pair<>(pact, auxN.get(j)));
                    }
                }
            }
            return mvs;
        }
    }

}
