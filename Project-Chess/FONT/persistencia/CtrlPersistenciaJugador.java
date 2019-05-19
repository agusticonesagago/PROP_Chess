package persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import domini.Huma;
import domini.Partida;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CtrlPersistenciaJugador {
    // PARAMS
    private String path_huma = "C:\\Users\\Usuario\\Desktop\\UPC\\Q6\\PROP\\Project\\Project-Chess\\EXE\\Dades\\Users.json";

    private static final Type HumansListType = new TypeToken<ArrayList<Huma>>(){}.getType();
    // FUNCTIONS


    public List<Huma> getAllJugadors () throws FileNotFoundException {

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(path_huma));
        List<Huma> cjtHumans = gson.fromJson(reader, HumansListType);
        if (cjtHumans == null) System.out.println("EMPTY LIST");
        else {
            for (int i=0; i < cjtHumans.size(); ++i){
                System.out.println(cjtHumans.get(i).getID());
            }
        }

        return cjtHumans;
    }

    public Huma getJugador(String name) throws FileNotFoundException {
        List<Huma> cjtHumans = getAllJugadors();
        for(int i=0; i < cjtHumans.size(); ++i) {
            if (cjtHumans.get(i).getName().equals(name)) return cjtHumans.get(i);
        }
        return null;
    }

    public void guardarPartida (Huma h, Partida p) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Huma> cjtHumas = getAllJugadors();
        int ind = cjtHumas.indexOf(h);
        cjtHumas.get(ind).guardarPartida(p);
        Writer writer = new FileWriter(path_huma);
        gson.toJson(cjtHumas,writer);
        writer.flush();
        writer.close();
    }

    public Partida carregarPartidaGuardada (String name) throws FileNotFoundException {
        return getJugador(name).getPartida();
    }
}

