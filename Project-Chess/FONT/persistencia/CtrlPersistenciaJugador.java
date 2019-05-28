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
import java.util.Random;

public class CtrlPersistenciaJugador {
    // PARAMS
    private String path_huma = "C:\\Users\\Usuario\\Desktop\\UPC\\Q6\\PROP\\Project\\Project-Chess\\EXE\\Dades\\Users.json";

    private static final Type HumansListType = new TypeToken<ArrayList<Huma>>(){}.getType();
    // FUNCTIONS


    public List<Huma> getAllJugadors () throws FileNotFoundException {

        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(path_huma));
        List<Huma> cjtHumans = gson.fromJson(reader, HumansListType);
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


    public void guardarPartida(Partida p, String jugador) throws IOException {
        Gson gson =  new GsonBuilder().setPrettyPrinting().create();// Dona el format ordenat de JSON
        List<Huma> cjtHumans = getAllJugadors();
        int a = -1;
        for(int i=0; i < cjtHumans.size();++i){
            if(cjtHumans.get(i).getName().equals(jugador)) {
                a = i;
                break;
            }
        }
        Huma session = getJugador(jugador);
        session.guardarPartida(p);
        cjtHumans.set(a,session);
        Writer writer = new FileWriter(path_huma, false);
        gson.toJson(cjtHumans,writer);
        writer.flush();
        writer.close();
    }

    public Huma afegeixJugador(String name) throws IOException {
        Random r = new Random();
        int new_id = r.nextInt((50 ) + 1);
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Dona el format ordenat de JSON
        List<Huma> cjtHumans = getAllJugadors();
        Huma to_add = new Huma(new_id);
        to_add.SetName(name);
        cjtHumans.add(to_add);
        Writer writer = new FileWriter(path_huma);
        gson.toJson(cjtHumans,writer);
        writer.flush();
        writer.close();
        return to_add;
    }
}

