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
    private String path_problems = "C:\\Users\\Usuario\\Desktop\\UPC\\Q6\\PROP\\Project\\Project-Chess\\EXE\\Dades\\Problemes.json";
    private String path_tutorials = "C:\\Users\\Usuario\\Desktop\\UPC\\Q6\\PROP\\Project\\Project-Chess\\EXE\\Dades\\Tutorials.json";



    public  List<Problema> getProblemes() throws FileNotFoundException {

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(path_problems));
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
        JsonReader reader = new JsonReader(new FileReader(path_tutorials));
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
        Writer writer = new FileWriter(path_problems);
        gson.toJson(cjtProblems,writer);
        writer.flush();
        writer.close();
    }

    public void eliminarProblema(Problema p) throws IOException {
        List<Problema> cjtProblems = getProblemes();
        cjtProblems.remove(p);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Writer writer = new FileWriter(path_problems);
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
            if (tuto.getTema().equals(t)) return tuto;
        }
        return null;
    }

}
