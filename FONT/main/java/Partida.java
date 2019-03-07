import java.io.Console;

public class Partida {
    private Boolean Guanyador;
    private Integer Torn;
    private Boolean QuiJuga;
    private Taullel Board;
    private Problema Problem;
    private Jugador Blanques;
    private Jugador Negres;
 
    public Partida(Problema P, Jugador b, Jugador n) {
        this.Problem = P;
        this.Blanques = b;
        this.Negres = n;
        String FEN = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1"; // falta saber com serà nom de func getFEN
        int a = FEN.indexOf(" ");
        System.out.print(aS);


    }
}