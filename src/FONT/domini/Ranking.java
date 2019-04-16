package domini;

public class Ranking {
    Integer temps;
    String jugador;
    String problema;

    public Ranking (Integer t, String nomP, String nomJ) {
        temps = t;
        jugador = nomJ;
        problema = nomP;
    }

    public Ranking() {
    }

    /* GETTERS */

    public Integer getTemps(){
        return temps;
    }

    public String getJugador() {
        return jugador;
    }

    public String getProblema() {
        return problema;
    }

    /* SETTERS */

    public void setTemps(Integer param) {
        temps = param;
    }

    public void setJugador(String param) {
        jugador = param;
    }

    public void setProblema(String param) {
        problema = param;
    }
}