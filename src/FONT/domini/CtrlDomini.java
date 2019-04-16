package domini;

import javafx.util.Pair;
import java.util.Vector;


public class CtrlDomini {
    private CtrlDominiMantProblema CDMp;
    private CtrlDominiMantRanking CDMr;
    private Problema problema;
    private Jugador jugador1;
    private Jugador jugador2;
    private Partida partida;
    private CtrlDades ctrlD;

    public CtrlDomini () {
        CDMp = new CtrlDominiMantProblema();
        CDMr = new CtrlDominiMantRanking();
        problema = new Problema();
        partida = null;
        jugador1 = null;
        jugador2 = null;
        ctrlD = new CtrlDades();
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

    public void jugarPartida() {
        Pair<Integer, Boolean> tornMat= problema.getTornMat();
        Integer tornsRestants = (tornMat.getKey()*2) -1;
        Boolean quiMou = tornMat.getValue();
        System.out.println("Comença la partida " + "\n");
        while (tornsRestants > 0) {
            partida.getTaulell().PrintBoard();
            System.out.println (partida.getTaulell().PrintFEN() + "\n");

            if (quiMou) System.out.println("Mouen Blanques" + "\n");
            else System.out.println("Mouen Negres" + "\n");

            partida.jugarTorn(tornsRestants);
            quiMou = !quiMou;
            tornsRestants--;

        }
        partida.getTaulell().PrintBoard();
        System.out.println (partida.getTaulell().PrintFEN() + "\n");
        if (tornMat.getValue()){
            if (partida.getGuanyador() && tornMat.getValue())  System.out.println("Han guanyat les blanques" + "\n");
            else {
                System.out.println("Perden les blanques" + "\n");
                System.out.println("Guanyen les negres" + "\n");
            }
        }
        else {
            if (!partida.getGuanyador() && !tornMat.getValue()) System.out.println("Han guanyat les negres" + "\n");
            else {
                System.out.println("Perden les negres" + "\n");
                System.out.println("Guanyen les blanques" + "\n");
            }
        }

        System.out.println("La partida ha acabat" + "\n");
    }

    /* Opreacions relacionades amb PROBLEMES*/

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

}