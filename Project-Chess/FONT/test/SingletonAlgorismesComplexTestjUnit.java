package test;

import domini.Partida;
import domini.Problema;
import domini.Simple;
import domini.SingletonAlgorismes;
import domini.Complexa;

import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SingletonAlgorismesComplexTestjUnit {

    SingletonAlgorismes sa;
    Complexa c;
    Partida p;

    @Before
    public void setUp() {
        sa = SingletonAlgorismes.getInstance();
    }


    @Test
    public void test_mat_blanques_1_torn() {
        p = new Partida(new Problema("Blanques fan mat en 1", "6k1/p1p2rpp/1q6/2p5/4P3/PQ6/1P4PP/3R3K w - - 0 1"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(7, 3), new Pair<>(0, 3));
        //assertEquals(sol, sa.moviment_esperadelreposo3prof(p, true, 1), "Hauria de ser 7=3 -> 0=3");
        System.out.println(sa.moviment_ordenat_esperadelreposo(p, true, 1));
    }

    @Test
    public void test_mat_negres_1_torn() {
        p = new Partida(new Problema("Negres fan mat en 1", "4k3/8/2r5/8/8/8/5PPP/6K1 b - - 0 1"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(2, 2), new Pair<>(7, 2));
        //assertEquals(sol, sa.moviment_esperadelreposo3prof(p, false, 1), "Hauria de ser 2=2 -> 7=2");
        System.out.println(sa.moviment_ordenat_esperadelreposo(p, false, 1));
    }

    @Test
    public void test_mat_blanquess_1_torn() {
        p = new Partida(new Problema("Blanques fan mat en 1", "5k2/4np2/5N2/2B5/8/8/8/6RK w KQkq -"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(2, 2), new Pair<>(7, 2));
        //assertEquals(sol, sa.moviment_esperadelreposo3prof(p, false, 1), "Hauria de ser 2=2 -> 7=2");
        System.out.println(sa.moviment_ordenat_esperadelreposo(p, true, 1));
    }

    @Test
    public void test_problema_on_no_hi_ha_mat() {
        p = new Partida(new Problema("Blanques fan mat en 1", "k7/8/8/4q3/5P2/8/8/K7 w - - 0 1"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(4, 5), new Pair<>(3, 4));
        assertEquals(sol, sa.moviment_esperadelreposo3prof(p, true, 1), "Hauria de ser 4=5 -> 3=4");
    }

    @Test
    public void test_mat_blanques_2_torns() {
        p = new Partida(new Problema("Blanques fan mat en 2", "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(6, 2), new Pair<>(4, 3));
        //assertEquals(sol, sa.moviment_esperadelreposo3prof(p, true, 2), "Hauria de ser 6=2 -> 4=3");
        //System.out.println(p.getTaulell().ferMoviment(new Pair<>(6, 2), new Pair<>(4, 3)));
        //sol = new Pair<>(new Pair<>(0, 3), new Pair<>(4, 7));
        //assertEquals(sol, sa.moviment_esperadelreposo3prof(p, false, 1), "Hauria de ser 0=3 -> 4=7");
        //System.out.println(p.getTaulell().ferMoviment(new Pair<>(0, 3), new Pair<>(4, 7)));
        //sol = new Pair<>(new Pair<>(0, 1), new Pair<>(2, 2));
        //assertEquals(sol, sa.moviment_esperadelreposo3prof(p, true, 1), "Hauria de ser 0=3 -> 4=7");
        System.out.println(sa.moviment_esperadelreposo3prof(p, true, 2));
    }


    @Test
    public void test_mat_blanquess_2_torns() {
        p = new Partida(new Problema("Blanques fan mat en 2", "r1bq2k1/ppp2r1p/2np1pNQ/2bNpp2/2B1P3/3P4/PPP2PPP/R3K2R w - -"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(6, 2), new Pair<>(4, 3));
        System.out.println(sa.moviment_esperadelreposo2prof(p, true, 2));
    }

    @Test
    public void test_mat_blanques_3_torns() {
        p = new Partida(new Problema("Blanques fan mat en 3", "3K4/8/8/p2k4/pp1B4/N5N1/P2Q4/8 w - - 0 "), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(6, 3), new Pair<>(7, 3));
        assertEquals(sol, sa.moviment_esperadelreposo3prof(p, true, 3), "Hauria de ser 6=3 -> 7=3");
    }

    @Test
    public void test_mat_blanquess_3_torns() {
        p = new Partida(new Problema("Blanques fan mat en 3", "8/kbK5/6BR/1Pp5/2P5/5pP1/8/3N2q1 b - -"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(6, 3), new Pair<>(7, 3));
        //assertEquals(sol, sa.moviment_esperadelreposo3prof(p, true, 3), "Hauria de ser 6=3 -> 7=3");
        System.out.println(sa.moviment_esperadelreposo3prof(p, true, 3));
    }

    @Test
    public void test_mat_blanques_segonpas_3_torns() {
        p = new Partida(new Problema("Blanques fan mat en 2", "3K4/8/8/p2k4/p2B4/Np4N1/P7/3Q4 b - - 0 1"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(7, 3), new Pair<>(4, 0));
        //assertEquals(sol, sa.moviment_esperadelreposo(p, true, 2), "Hauria de ser 7=3 -> 4=6");
        System.out.println(sa.moviment_esperadelreposo3prof(p, true, 2));
    }

    @Test
    public void test_mat_blanques_tercerpas_3_torns() {
        p = new Partida(new Problema("Blanques fan mat en 2", "3K4/8/8/p2k4/p2B2Q1/N5N1/Pp6/8 b - - 0 1"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(4, 0), new Pair<>(1, 3));
        //assertEquals(sol, sa.moviment_esperadelreposo(p, true, 1), "Hauria de ser 4=6 -> 1=3");
        System.out.println(sa.moviment_esperadelreposo3prof(p, true, 1));
    }


    @Test
    public void test_mat_blanquessss_4_torns() {
        p = new Partida(new Problema("Blanques fan mat en 4", "k1N1K2Q/P3p3/8/6p1/2p3r1/2p5/3br3/8 w - -"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(4, 0), new Pair<>(1, 3));
        //assertEquals(sol, sa.moviment_esperadelreposo(p, true, 1), "Hauria de ser 4=0 -> 1=3");
        System.out.println(sa.moviment_minmax(p, true, 4));
        return;
    }

    @Test
    public void test_mat_blanques_4_torns() {
        p = new Partida(new Problema("Blanques fan mat en 4", "4kb1Q/5p2/1p6/1K1N4/2P2P2/8/q7/8 w KQkq -"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(4, 0), new Pair<>(1, 3));
        //assertEquals(sol, sa.moviment_esperadelreposo(p, true, 1), "Hauria de ser 4=0 -> 1=3");
        System.out.println(sa.moviment_esperadelreposo3prof(p, true, 4));
        return;
    }

    @Test
    public void test_mat_blanques_segonpas_4_torns() {
        p = new Partida(new Problema("Blanques fan mat en 3", "kr5Q/p3q3/3R1p2/1P2B3/8/8/1K6/8 w - -"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(4, 0), new Pair<>(1, 3));
        //assertEquals(sol, sa.moviment_esperadelreposo(p, true, 1), "Hauria de ser 4=0 -> 1=3");
        System.out.println(sa.moviment_esperadelreposo3prof(p, true, 3));
        return;
    }

    @Test
    public void test_mat_blanques_tercerpas_4_torns() {
        p = new Partida(new Problema("Blanques fan mat en 2", "5b2/2Q2p2/1p2k3/1K1N4/2P2P2/8/q7/8 b - - 0 1"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(4, 0), new Pair<>(1, 3));
        //assertEquals(sol, sa.moviment_esperadelreposo(p, true, 1), "Hauria de ser 4=0 -> 1=3");
        System.out.println(sa.moviment_esperadelreposo3prof(p, true, 2));
        return;
    }

    @Test
    public void test_mat_blanques_quartpas_4_torns() {
        p = new Partida(new Problema("Blanques fan mat en 1", "2Q2b2/5p2/1p1k4/1K1N4/2P2P2/8/q7/8 b - - 0 1"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(4, 0), new Pair<>(1, 3));
        //assertEquals(sol, sa.moviment_esperadelreposo(p, true, 1), "Hauria de ser 4=0 -> 1=3");
        System.out.println(sa.moviment_esperadelreposo3prof(p, true, 1));
        return;
    }

    @Test
    public void test_mat_blanques_4_tornscavalls() {
        p = new Partida(new Problema("Blanques fan mat en 4", "2k5/8/4K3/3NB3/4N3/8/8/8 w KQkq -"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(4, 0), new Pair<>(1, 3));
        //assertEquals(sol, sa.moviment_esperadelreposo(p, true, 1), "Hauria de ser 4=0 -> 1=3");
        System.out.println(sa.moviment_esperadelreposo3prof(p, true, 4));
        return;
    }

    @Test
    public void test_mat_blanques_4_tornsllarg() {
        p = new Partida(new Problema("Blanques fan mat en 4", "r1B1n3/2R1R3/1k1p4/rpp4b/8/qQ6/2K5/8 w - -"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(4, 0), new Pair<>(1, 3));
        //assertEquals(sol, sa.moviment_esperadelreposo(p, true, 1), "Hauria de ser 4=0 -> 1=3");
        System.out.println(sa.moviment_esperadelreposo3prof(p, true, 4));
        return;
    }

    @Test
    public void test_mat_blanques_5_torns() {
        p = new Partida(new Problema("Blanques fan mat en 5", "5k2/pbp2r2/1p5p/4R1pP/1PP5/8/PKBQ1q2/8 w KQkq -"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(4, 0), new Pair<>(1, 3));
        //assertEquals(sol, sa.moviment_esperadelreposo(p, true, 1), "Hauria de ser 4=0 -> 1=3");
        System.out.println(sa.moviment_esperadelreposo3prof(p, true, 3));
        return;
    }

    @Test
    public void test_mat_blanques_4_funciona() {
        p = new Partida(new Problema("Blanques fan mat en 4", "r7/8/8/5bk1/8/5B2/5RPP/6K1 b - - 0 1"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(4, 0), new Pair<>(1, 3));
        //assertEquals(sol, sa.moviment_esperadelreposo( p, true, 1), "Hauria de ser 4=0 -> 1=3");
        System.out.println(sa.moviment_minmax(p, true, 4));
        return;
    }

    @Test
    public void test_mat_blanquesinfin() {
        p = new Partida(new Problema("Blanques fan mat en 5", "r7/8/8/5bk1/8/5B2/5RPP/6K1 b - - 0 1"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(4, 0), new Pair<>(1, 3));
        //assertEquals(sol, sa.moviment_esperadelreposo(p, true, 1), "Hauria de ser 4=0 -> 1=3");
        System.out.println(sa.moviment_esperadelreposo3prof(p, true, 5));
        return;
    }

    @Test
    public void test_situacio_empat() {
        p = new Partida(new Problema("Blanques fan mat en 2", "1K6/8/8/8/8/R7/6R1/7k w - - 0 1"), new Simple(1), new Simple(2));
        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> sol = new Pair<>(new Pair<>(5, 0), new Pair<>(5, 6));
        assertNotEquals(sol, sa.moviment_esperadelreposo3prof(p, true, 1));
    }

    @Test
    public void test_calcul_evalua_taulell_blanques() {
        p = new Partida(new Problema("Blanques fan mat en 1", "k7/8/5r2/4P3/8/8/8/K7 w - - 0 1"), new Simple(1), new Simple(2));
        assertEquals(10, sa.evaluataullel(p.getTaulell(), true, true, -1000000, 1000000, 1));
    }


    @Test
    public void test_calcul_evalua_taulell_negres() {
        p = new Partida(new Problema("Negres fan mat en 2", "k7/8/8/8/3p4/4Q2r/8/K7 b - - 0 1"), new Simple(1), new Simple(2));
        assertEquals(-60, sa.evaluataullel(p.getTaulell(), false, false, -1000000, 1000000, 2));
    }

    @Test
    public void test_evalua_taulell_amb_escac_mat() {
        p = new Partida(new Problema("Blanques fan mat en 1", "K7/8/8/8/8/1R6/3R4/7k w - - 0 1"), new Simple(1), new Simple(2));
        assertEquals(1000, sa.evaluataullel(p.getTaulell(), true, true, -1000000, 1000000, 1));
    }


    @Test
    public void test_calcul_taulell_inicial() {
        p = new Partida(new Problema("Blanques fan mat en 2", "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq -"), new Simple(1), new Simple(2));
        assertEquals(0, sa.calculTaulell(p.getTaulell()));
    }

    @Test
    public void test_calcul_taulell() {
        p = new Partida(new Problema("Blanques fan mat en 2", "k7/8/5r2/4P3/8/8/8/K7 w - - 0 1"), new Simple(1), new Simple(2));
        assertEquals(-40, sa.calculTaulell(p.getTaulell()));
    }

    @Test
    public void test_calcul_taulell_2() {
        p = new Partida(new Problema("Blanques fan mat en 2", "k7/8/8/8/3p4/4Q2r/4R3/K7 b- - 0 1"), new Simple(1), new Simple(2));
        assertEquals(90, sa.calculTaulell(p.getTaulell()));
    }
}