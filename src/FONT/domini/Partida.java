package src.FONT.domini;

import java.io.Console;



public class Partida {
    private Boolean Guanyador;
    private Integer Torn;
    private Boolean QuiJuga;
    //  private Taullel Board;
    //  private Problema Problem;
    //  private Jugador Blanques;
    //  private Jugador Negres;
 
    public Partida(/*Problema P, Jugador b, Jugador n*/) {
    //    this.Problem = P;
    //    this.Blanques = b;
    //    this.Negres = n;
        String FEN = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1"; // falta saber com serà nom de func getFEN
        // Decomposition of FEN
        /* TAULELL PART  */
        int  endOfBoard = FEN.indexOf(" ");
        String Taulell_FEN = FEN.substring(0, endOfBoard);
          System.out.println("BOARD: " + Taulell_FEN);
        /* A QUI LI TOCA EN AQUEST TORN */
        char PlayerTurn = FEN.charAt(endOfBoard+1);
          System.out.println("COLOR PLAYER: " + PlayerTurn);
        /* HalfMove -> Desde que s'ha matat algu o mogut un peó */
        int halfmove = Character.getNumericValue(FEN.charAt(endOfBoard+7));
          System.out.println("Half Move: " + halfmove);       
        /* FullTurn -> ++ Each time black moves */
        Torn = Character.getNumericValue(FEN.charAt(endOfBoard+9));
          System.out.println("TORN: " + Torn);

          /* TEST */

    }








    public static void main(String[] args) {
        new Partida();
    }
}