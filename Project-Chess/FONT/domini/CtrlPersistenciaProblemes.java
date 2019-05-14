package domini;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CtrlPersistenciaProblemes {
    public  Problema getProblemes() throws FileNotFoundException {
        String path = "C:\\Users\\Usuario\\Desktop\\UPC\\Q6\\PROP\\Project\\Project-Chess\\EXE\\Dades\\Problemes.txt";
        String jsonProblemes = "";
        File f = new File(path);
        Scanner sc = new Scanner(f);
        String line;
        String tema = "";
        String FEN = "";
        String Dif = "";
        while (sc.hasNext()) {
            line = sc.next();
            if (line.equals("{")) { // New Problema;
                while (!line.equals("},")) {
                    line = sc.next();
                    if (line.equals("},") || line.equals("}")) break;
                    line = line.substring(1, line.length() - 2);
                    switch (line) {
                        case "Tema":
                            line = sc.next();
                            tema = line.substring(1,line.length()-2);
                            break;
                        case "FEN":
                            line = sc.next();
                            FEN = line.substring(1,line.length()-2);
                            break;
                        case "dificultat":
                            line = sc.next();
                            if (line.charAt(line.length()-1) == ',') Dif = line.substring(1,line.length()-2);
                            else Dif = line.substring(1,line.length()-1);
                            break;
                        default:
                            break;
                    }
                }
                System.out.println(tema+" -- "+FEN+" -- "+Dif);
                Problema m = new Problema(tema,FEN,Dif, null);
            }
        }
        return null;
    }

}
