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


    public boolean equals(Ranking obj) {
        if (obj.getJugador() == jugador && obj.getProblema() == problema) return true;
        else return false;
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