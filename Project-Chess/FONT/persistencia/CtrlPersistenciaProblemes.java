package persistencia;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import domini.Problema;
import domini.Tutorial;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CtrlPersistenciaProblemes {

    private static final Type ProblemListType = new TypeToken<ArrayList<Problema>>(){}.getType();
    private static final Type TutorialListType = new TypeToken<ArrayList<Tutorial>>(){}.getType();

    private String globalPath = "data";
    private String f_problems;
    private String f_tutorial;

    public CtrlPersistenciaProblemes() {
        f_problems = globalPath;
        f_problems = f_problems.concat("/");
        f_problems = f_problems.concat("Problemes.json");
        f_tutorial = globalPath;
        f_tutorial = f_tutorial.concat("/");
        f_tutorial = f_tutorial.concat("Tutorials.json");
    }

    public  List<Problema> getProblemes() throws FileNotFoundException {

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(f_problems));
        List<Problema> cjtProblems = gson.fromJson(reader, ProblemListType);
        if (cjtProblems == null) System.out.println("EMPTY LIST");
        else {
            for (int i=0; i < cjtProblems.size(); ++i){
                System.out.println(cjtProblems.get(i).getFEN());
            }
        }

        return cjtProblems;
    }

    public List<Tutorial> getTutorials () throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(f_tutorial));
        List<Tutorial> cjtTutorials = gson.fromJson(reader, TutorialListType);
        if (cjtTutorials == null) System.out.println("EMPTY LIST");
        else {
            for (int i=0; i < cjtTutorials.size(); ++i){
                System.out.println(cjtTutorials.get(i).getFEN());
            }
        }
        return cjtTutorials;
    }

    public void afegirProblema(Problema p) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Dona el format ordenat de JSON
        List<Problema> cjtProblems = getProblemes();
        cjtProblems.add(p);
        Writer writer = new FileWriter(f_problems);
        gson.toJson(cjtProblems,writer);
        writer.flush();
        writer.close();
    }

    public void eliminarProblema(Problema p) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Problema> cjtProblems = getProblemes();
        cjtProblems.remove(p);
        Writer writer = new FileWriter(f_problems);
        gson.toJson(cjtProblems,writer);
        writer.flush();
        writer.close();
    }

    public void modificarProblema(Problema p, String f, String d, String t) throws IOException {

    }

    public Problema cercaProblema (String t) throws FileNotFoundException {
        List<Problema> cjtProblems = getProblemes();
        for (Problema prob: cjtProblems) {
            if (prob.getTema().equals(t)) return prob;
        }
        return null;
    }

    public Tutorial cercaTutorial (String t) throws FileNotFoundException {
        List<Tutorial> cjtTutorials = getTutorials();
        for (Tutorial tuto: cjtTutorials) {
            if (tuto.getFEN().equals(t)) return tuto;
        }
        return null;
    }

}
