package persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import domini.Ranking;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CtrlPersistenciaRanking {


    // PARAMS
    private String path_ranking = "C:\\Users\\enric\\Documents\\Enric\\Projecte-Prop\\Project-Chess\\EXE\\Dades\\Ranking.json";

    private static final Type RankingListType = new TypeToken<ArrayList<Ranking>>(){}.getType();
    // FUNCS

    public List<Ranking> getAllRankings () throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(path_ranking));
        List<Ranking> cjtRankings = gson.fromJson(reader, RankingListType);
        return cjtRankings;
    }

    public List<Ranking> getRankingByProblem (String f) throws FileNotFoundException {
        List<Ranking> cjtRankings = getAllRankings();
        List<Ranking> response = null;
        for (int i=0; i < cjtRankings.size(); ++i) {
            if (cjtRankings.get(i).getProblema().equals(f)) response.add(cjtRankings.get(i));
        }
        return response;
    }

    public List<Ranking> getRankingByUser (String n) throws FileNotFoundException {
        List<Ranking> cjtRankings = getAllRankings();
        List<Ranking> response = null;
        for (int i=0; i < cjtRankings.size(); ++i) {
            if (cjtRankings.get(i).getJugador().equals(n)) response.add(cjtRankings.get(i));
        }
        return response;
    }

    public void addRanking (Ranking r) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Dona el format ordenat de JSON
        List<Ranking> cjtRankings = getAllRankings();
        cjtRankings.add(r);
        Writer writer = new FileWriter(path_ranking);
        gson.toJson(cjtRankings,writer);
        writer.flush();
        writer.close();
    }

    public void removeRanking (Ranking r) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Dona el format ordenat de JSON
        List<Ranking> cjtRankings = getAllRankings();
        cjtRankings.remove(r);
        Writer writer = new FileWriter(path_ranking);
        gson.toJson(cjtRankings,writer);
        writer.flush();
        writer.close();
    }

    public void modifRanking (Ranking r, Float time) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Dona el format ordenat de JSON
        List<Ranking> cjtRankings = getAllRankings();
        int ind = cjtRankings.indexOf(r);
        r.setTemps(time);
        cjtRankings.set(ind,r);
        Writer writer = new FileWriter(path_ranking);
        gson.toJson(cjtRankings,writer);
        writer.flush();
        writer.close();
    }

    public Ranking cercaRanking (String aux) throws FileNotFoundException {
        List<Ranking> cjtRankings = getAllRankings();
        for (int i=0; i < cjtRankings.size(); ++i){
            if (cjtRankings.get(i).getJugador().equals(aux) ||cjtRankings.get(i).getProblema().equals(aux)) return cjtRankings.get(i);
        }
        return null;
    }
}
