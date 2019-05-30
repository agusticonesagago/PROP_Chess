package domini;

public class Tutorial extends Problema {
    private String Camp; // Atac Defensa Basics
    private String Body; // Explicació del potencial

    public Tutorial (String t, String fen, String c, String b) {
        super(t, fen);
        Camp = c;
        Body = b;
    }

    /* GETTERS */
    public String getCamp() {
        return Camp;
    }


    public String getBody() {
        return Body;
    }
    /* SETTERS */
    public void setCamp(String c) {
        Camp = c;
    }

    public void setBody(String b) {
        Body = b;
    }
 }