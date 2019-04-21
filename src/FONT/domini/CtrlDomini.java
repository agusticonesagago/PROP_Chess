package domini;

import javafx.util.Pair;

import java.util.Timer;
import java.util.Vector;


public class CtrlDomini {
    private CtrlDominiMantProblema CDMp;
    private CtrlDominiMantRanking CDMr;
    private Problema problema;
    private Jugador jugador1;
    private Jugador jugador2;
    private Partida partida;

    public CtrlDomini () {
        CDMp = new CtrlDominiMantProblema();
        CDMr = new CtrlDominiMantRanking();
        problema = new Problema();
        partida = null;
        jugador1 = null;
        jugador2 = null;
    }

    public void configurarPartida(Vector <String> problema, String jugador1, String jugador2) {
        assignaProblema(problema.get(0),problema.get(1), problema.get(2) );
        if (jugador1.equals("Huma")) {
            this.jugador1 = new Huma(1);
        }
        else if (jugador1.equals("Maquina1")) {
            this.jugador1 = new Simple(1);
        }
        /*
        else if (jugador1.equals("Maquina2")) {
            this.jugador1 = new complex(1);
        }
        */
        if (jugador2.equals("Huma")) {
            this.jugador2 = new Huma(2);
        }
        else if (jugador2.equals("Maquina1")) {
            this.jugador2 = new Simple(2);
        }
        /*
        else if (jugador2.equals("Maquina2")) {
            this.jugador2 = new Complex(2);
        }
        */
        Pair<Integer, Boolean> tornMat = this.problema.getTornMat();
        if (tornMat.getValue()) {
            this.partida = new Partida(this.problema, this.jugador1, this.jugador2);
        }
        else {
            this.partida = new Partida(this.problema, this.jugador2, this.jugador1);
        }
    }

    public String jugarPartida(String nom1, String nom2) {
        String guanyador;
        Pair<Integer, Boolean> tornMat= problema.getTornMat();
        Integer tornsRestants = tornMat.getKey();
        Boolean quiMou = tornMat.getValue();
        System.out.println("Comença la partida " + "\n");
        float tBlanquesM = 0;
        float tNegresM = 0;
        while (tornsRestants > 0) {
            partida.getTaulell().PrintBoard();
            System.out.println (partida.getTaulell().PrintFEN() + "\n");

            if (quiMou) System.out.println("Mouen Blanques" + "\n");
            else System.out.println("Mouen Negres" + "\n");

            long startTurn = System.currentTimeMillis(); // Temps abans de moure peça
            partida.jugarTorn(tornsRestants);
            long endTurn = System.currentTimeMillis(); // Temps despres de moure peça
            if (quiMou) tBlanquesM += (endTurn - startTurn)/1000;
            else tNegresM += (endTurn -startTurn)/1000;

            if (quiMou == tornMat.getValue()) tornsRestants--;
            quiMou = !quiMou;

        }
        System.out.println("Els temps son: ");
        System.out.println("Blanques: "+ tBlanquesM);
        System.out.println("Negres  : "+ tNegresM);
        partida.getTaulell().PrintBoard();
        System.out.println (partida.getTaulell().PrintFEN() + "\n");
        if (tornMat.getValue()){
            if (partida.getGuanyador() && tornMat.getValue())  {
                guanyador = "Blanques";
                if (jugador1 instanceof Huma) {
                    Vector<String> dades = new Vector<>();
                    dades.add(0, nom1);
                    dades.add(1, problema.getFEN());
                    dades.add(2, String.valueOf(tBlanquesM));
                    CDMr.altaRanking(nom1,dades);
                }
            }
            else {
                guanyador = "Negres";
                if (jugador2 instanceof Huma) {
                    Vector<String> dades = new Vector<>();
                    dades.add(0, nom2);
                    dades.add(1, problema.getFEN());
                    dades.add(2, "60");
                    CDMr.altaRanking(nom2,dades);
                }
            }
        }
        else {
            if (!partida.getGuanyador() && !tornMat.getValue()) {
                guanyador = "Negres";
                if (jugador1 instanceof Huma) {
                    Vector<String> dades = new Vector<>();
                    dades.add(0, nom1);
                    dades.add(1, problema.getFEN());
                    dades.add(2, "60");
                    CDMr.altaRanking(nom1,dades);
                }
            }
            else {
                guanyador = "Blanques";
                if (jugador2 instanceof Huma) {
                    Vector<String> dades = new Vector<>();
                    dades.add(0, nom2);
                    dades.add(1, problema.getFEN());
                    dades.add(2, "60");
                    CDMr.altaRanking(nom2,dades);
                }
            }
        }

        return guanyador;
    }


    private void assignaProblema(String fen, String t, String dif) {
        problema.setFEN(fen);
        problema.setTema(t);
        problema.setDificultat(dif);
    }

    public String getProblema() {
        String res = "";
        res += problema.getFEN(); res += " ";
        res += problema.getTema(); res += " ";
        res += problema.getDificultat();
        return  res;
    }

    public CtrlDominiMantRanking getCDMr() {
        return CDMr;
    }

    public CtrlDominiMantProblema getCDMp() {
        return CDMp;
    }

}