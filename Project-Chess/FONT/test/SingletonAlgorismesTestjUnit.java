package test;

import domini.Partida;
import domini.Problema;
import domini.Simple;
import domini.SingletonAlgorismes;

import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SingletonAlgorismesTestjUnit {

    SingletonAlgorismes sa;
    Partida p;

    @Before
    public void setUp() {
        sa = SingletonAlgorismes.getInstance();
    }


    @Test
    public void test_mat_blanques_1_torn () {
        p = new Partida(new Problema("Blanques fan mat en 1","6k1/p1p2rpp/1q6/2p5/4P3/PQ6/1P4PP/3R3K w - - 0 1"), new Simple(1), new Simple(2));
        Pair< Pair<Integer, Integer>, Pair<Integer, Integer> > sol = new Pair<>(new Pair<>(7,3), new Pair<>(0,3));
        assertEquals( sol, sa.moviment_minmax(p,true,1), "Hauria de ser 7=3 -> 0=3");
    }

    @Test
    public void test_mat_negres_1_torn () {
        p = new Partida(new Problema("Negres fan mat en 1","4k3/8/2r5/8/8/8/5PPP/6K1 b - - 0 1"), new Simple(1), new Simple(2));
        Pair< Pair<Integer, Integer>, Pair<Integer, Integer> > sol = new Pair<>(new Pair<>(2,2), new Pair<>(7,2));
        assertEquals( sol, sa.moviment_minmax(p,false,1), "Hauria de ser 2=2 -> 7=2");

    }

    @Test
    public void test_problema_on_no_hi_ha_mat() {
        p = new Partida(new Problema("Blanques fan mat en 1","k7/8/8/4q3/5P2/8/8/K7 w - - 0 1"), new Simple(1), new Simple(2));
        Pair< Pair<Integer, Integer>, Pair<Integer, Integer> > sol = new Pair<>(new Pair<>(4,5), new Pair<>(3,4));
        assertEquals( sol, sa.moviment_minmax(p,true,1), "Hauria de ser 4=5 -> 3=4");
    }

    @Test
    public void test_mat_blanques_2_torns () {
        p = new Partida(new Problema("Blanques fan mat en 2","1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - -"), new Simple(1), new Simple(2));
        Pair< Pair<Integer, Integer>, Pair<Integer, Integer> > sol = new Pair<>(new Pair<>(6,2), new Pair<>(4,3));
        assertEquals( sol, sa.moviment_minmax(p,true,2), "Hauria de ser 0,5-> 2=3");
        System.out.println(p.getTaulell().ferMoviment(new Pair<>(6,2), new Pair<>(4,3)));

        sol = new Pair<>(new Pair<>(0,3), new Pair<>(4,7));
        assertEquals( sol, sa.moviment_minmax(p, false, 1), "Hauria de ser 0=3 -> 4=7");
        System.out.println(p.getTaulell().ferMoviment(new Pair<>(0,3), new Pair<>(4,7)));
        sol = new Pair<>(new Pair<>(0,1), new Pair<>(2,2));
        assertEquals( sol, sa.moviment_minmax(p, true, 1), "Hauria de ser 0=3 -> 4=7");
    }

    @Test
    public void test_situacio_empat () {
        p = new Partida(new Problema("Blanques fan mat en 2","1K6/8/8/8/8/R7/6R1/7k w - - 0 1"), new Simple(1), new Simple(2));
        Pair< Pair<Integer, Integer>, Pair<Integer, Integer> > sol = new Pair<>(new Pair<>(5,0), new Pair<>(5,6));
        assertNotEquals(sol, sa.moviment_minmax(p, true, 1));
    }

    @Test
    public void test_calcul_evalua_taulell_blanques () {
        p = new Partida(new Problema("Blanques fan mat en 1","k7/8/5r2/4P3/8/8/8/K7 w - - 0 1"), new Simple(1), new Simple(2));
        assertEquals(10,sa.evaluataullel(p.getTaulell(),true, true, -1000000,1000000, 1));
    }


    @Test
    public void test_calcul_evalua_taulell_negres () {
        p = new Partida(new Problema("Negres fan mat en 2","k7/8/8/8/3p4/4Q2r/8/K7 b - - 0 1"), new Simple(1), new Simple(2));
        assertEquals(-60, sa.evaluataullel(p.getTaulell(), false, false, -1000000, 1000000, 2));
    }

    @Test
    public void test_evalua_taulell_amb_escac_mat () {
        p = new Partida(new Problema("Blanques fan mat en 1","K7/8/8/8/8/1R6/3R4/7k w - - 0 1"), new Simple(1), new Simple(2));
        assertEquals(1000, sa.evaluataullel(p.getTaulell(), true, true, -1000000, 1000000, 1));
    }


    @Test
    public void test_calcul_taulell_inicial () {
        p = new Partida(new Problema("Blanques fan mat en 2","rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq -"), new Simple(1), new Simple(2));
        assertEquals(0,sa.calculTaulell(p.getTaulell()));
    }

    @Test
    public void test_calcul_taulell () {
        p = new Partida(new Problema("Blanques fan mat en 2","k7/8/5r2/4P3/8/8/8/K7 w - - 0 1"), new Simple(1), new Simple(2));
        assertEquals(-40,sa.calculTaulell(p.getTaulell()));
    }

    @Test
    public void test_calcul_taulell_2 () {
        p = new Partida(new Problema("Blanques fan mat en 2","k7/8/8/8/3p4/4Q2r/4R3/K7 b- - 0 1"), new Simple(1), new Simple(2));
        assertEquals(90,sa.calculTaulell(p.getTaulell()));
    }
}