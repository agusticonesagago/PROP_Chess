package domini;

import javafx.util.Pair;
import persistencia.CtrlPersistenciaJugador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class CtrlDomini {
    private CtrlDominiMantProblema CDMp;
    private CtrlDominiMantRanking CDMr;
    private CtrlPersistenciaJugador CPJ;
    private Problema problema;
    private Tutorial tutorial;
    private Huma sessio;
    private Jugador jugador1;
    private Jugador jugador2;
    private Partida partida;

    private String save_Torns;
    private String save_Temps;

    public CtrlDomini () {
        try {
            CDMp = new CtrlDominiMantProblema();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            CDMr = new CtrlDominiMantRanking();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CPJ = new CtrlPersistenciaJugador();
        problema = new Problema();
        partida = null;
        jugador1 = null;
        jugador2 = null;
        sessio = null;
    }


    public void setSavedTime (String temps){
        save_Temps = temps;
    }

    public String getSavedTime () {
        return save_Temps;
    }

    public void setSavedTorn (String torns){
        save_Torns = torns;
    }

    public String getSavedTorn () {
        return save_Torns;
    }

    public void configurarPartida(Vector <String> problema, String jugador1, String jugador2) {
        assignaProblema(problema.get(0),problema.get(1), problema.get(2) );
        if(jugador1.equals("Huma")) {
            this.jugador1 = new Huma(1);
        }
        else if (jugador1.equals("Maquina1")) {
            this.jugador1 = new Simple(1);
        }
        else if (jugador1.equals("Maquina2")) {
            this.jugador1 = new Complexa(1);
        }

        if (jugador2.equals("Huma")) {
            this.jugador2 = new Huma(2);
        }
        else if (jugador2.equals("Maquina1")) {
            this.jugador2 = new Simple(2);
        }
        else if (jugador2.equals("Maquina2")) {
            this.jugador2 = new Complexa(2);
        }
        Pair<Integer, Boolean> tornMat = this.problema.getTornMat();
        if (tornMat.getValue()) {
            this.partida = new Partida(this.problema, this.jugador1, this.jugador2);
        } else {
            this.partida = new Partida(this.problema, this.jugador2, this.jugador1);
        }
    }

    ///////////////////////////////////////

    public void setTutorial(Tutorial t) {
        tutorial = t;
    }

    public Tutorial getTutorial () {
        return  tutorial;
    }





    public void conf_partida_p(String jugador1, String jugador2) {
        if(jugador1.equals("Huma")) {
            this.jugador1 = new Huma(1);
        }
        else if (jugador1.equals("Maquina1")) {
            this.jugador1 = new Simple(1);
        }
        else if (jugador1.equals("Maquina2")) {
            this.jugador1 = new Complexa(1);
        }

        if (jugador2.equals("Huma")) {
            this.jugador2 = new Huma(2);
        }
        else if (jugador2.equals("Maquina1")) {
            this.jugador2 = new Simple(2);
        }
        else if (jugador2.equals("Maquina2")) {
            this.jugador2 = new Complexa(2);
        }
        Pair<Integer, Boolean> tornMat = this.problema.getTornMat();
        if (tornMat.getValue()) {
            this.partida = new Partida(this.problema, this.jugador1, this.jugador2);
        } else {
            this.partida = new Partida(this.problema, this.jugador2, this.jugador1);
        }
    }

    public ArrayList<Pair<Integer, Integer>> getAjudaMovs (int i, int j) {
        ArrayList<Pair<Integer,Integer>> movs = this.partida.getTaulell().validarMoviments(this.partida.getTaulell().getBoard()[i][j].posicionsposible()
                ,this.partida.getTaulell().getBoard()[i][j].getClass().getName(),this.partida.getTaulell().getBoard()[i][j]);
        return movs;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setProblema(Problema p) {
        problema = p;
    }
    public Problema getProblem_o() {
        return problema;
    }


    public void iniciasessio (String name) throws IOException {
        sessio = CPJ.getJugador(name);
        if (sessio == null) { // Si no existeix es crea
            sessio = CPJ.afegeixJugador(name);
        }
    }

    public String getUser_name () {
        return sessio.getName();
    }

    public Vector<Vector<String>> getUsers() throws FileNotFoundException {
        List<Huma> users= CPJ.getAllJugadors();
        Vector<Vector<String>> resultat = new Vector<>();
        if (!users.isEmpty()){
            for(int i = 0; i < users.size(); i++) {
                Vector<String> dades = new Vector<>();
                dades.add(0, users.get(i).getName());
                dades.add(1, users.get(i).getWinrate());
                dades.add(2, users.get(i).getProblemesJugats());
                resultat.add(dades);
            }
        }
        return resultat;

    }

    ///////////////////////////////////////
    public Pair jugarPartida(String nom1, String nom2) {
        String guanyador;
        Pair<Integer, Boolean> tornMat = problema.getTornMat();
        Integer tornsRestants = tornMat.getKey();
        Boolean quiMou = tornMat.getValue();
        System.out.println("Comença la partida " + "\n");
        float tBlanquesM = 0;
        float tNegresM = 0;
        while (tornsRestants > 0) {
            partida.getTaulell().PrintBoard();
                System.out.println(partida.getTaulell().PrintFEN() + "\n");

                if (quiMou) System.out.println("Mouen Blanques" + "\n");
                else System.out.println("Mouen Negres" + "\n");

                long startTurn = System.currentTimeMillis(); // Temps abans de moure peça
                partida.jugarTorn(tornsRestants);
                long endTurn = System.currentTimeMillis(); // Temps despres de moure peça
                if (quiMou) tBlanquesM += (endTurn - startTurn) / 1000;
                else tNegresM += (endTurn - startTurn) / 1000;
                if (quiMou == tornMat.getValue()) tornsRestants--;
                quiMou = !quiMou;
            }
            System.out.println("Els temps son: ");
            System.out.println("Blanques: " + tBlanquesM);
            System.out.println("Negres  : " + tNegresM);
            partida.getTaulell().PrintBoard();
            System.out.println(partida.getTaulell().PrintFEN() + "\n");
            if (tornMat.getValue()) {
                if (partida.getGuanyador() && tornMat.getValue()) {
                    guanyador = "Blanques";
                    if (jugador1 instanceof Huma) {
                        Vector<String> dades = new Vector<>();
                        dades.add(0, nom1);
                        dades.add(1, problema.getFEN());
                        dades.add(2, String.valueOf(tBlanquesM));
                    }
                } else {
                    guanyador = "Negres";
                    if (jugador2 instanceof Huma) {
                        Vector<String> dades = new Vector<>();
                        dades.add(0, nom2);
                        dades.add(1, problema.getFEN());
                        dades.add(2, "60");
                    }
                }
            } else {
                if (!partida.getGuanyador() && !tornMat.getValue()) {
                    guanyador = "Negres";
                    if (jugador1 instanceof Huma) {
                        Vector<String> dades = new Vector<>();
                        dades.add(0, nom1);
                        dades.add(1, problema.getFEN());
                        dades.add(2, "60");
                }
                } else {
                    guanyador = "Blanques";
                    if (jugador2 instanceof Huma) {
                        Vector<String> dades = new Vector<>();
                        dades.add(0, nom2);
                        dades.add(1, problema.getFEN());
                        dades.add(2, "60");
                    }
                }
            }

            Pair resultat;
            if (tornMat.getValue()) {
                resultat = new Pair((guanyador.equals("Blanques")), tBlanquesM);
                return resultat;
            } else return resultat = new Pair((guanyador.equals("Negres")), tNegresM);
        }

    private void assignaProblema(String fen, String t, String dif) {
        problema.setFEN(fen);
        problema.setTema(t);
        problema.setDificultat(dif);
    }

    public Problema getProblema() {
        return problema;
    }

    public CtrlDominiMantRanking getCDMr() {
        return CDMr;
    }

    public CtrlDominiMantProblema getCDMp() {
        return CDMp;
    }

    public void guardarPartida() throws IOException {
        // Guarda la partiad dels Ctrl i la guarda al usuari amb sesiso iniciada.
        CPJ.guardarPartida(partida, sessio.getName());
    }

    public void setPartida(Partida p) {
        this.partida = p;
    }
}