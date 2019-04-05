package test;

import domini.Problema;
import javafx.util.Pair;

public class StubProblem extends Problema {

    public StubProblem(String t,String fen) {
        super(t, fen);
    }

    @Override
    public Pair<Integer, Boolean> getTornMat() {
        return new Pair<>(3, true);
    }
}
