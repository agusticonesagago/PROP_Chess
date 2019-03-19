package domini;


public class Tutorial extends Problema {
    private String Camp;

    public Tutorial (String t, String dif, String fen, String c) {
        super(t, dif, fen);
        Camp = c;
    }

    /* GETTERS */
    public String getCamp() {
        return Camp;
    }

    /* SETTERS */
    public void setCamp(String c) {
        Camp = c;
    }
 }