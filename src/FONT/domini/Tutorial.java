package domini;


public class Tutorial extends Problema {
    private String Camp;

    public Problema (String t, String dif, String fen, String c) {
        Camp = c;
        super(t, dif, fen);
    }

    /* GETTERS */
    public String getCamp() {
        return Camp;
    }

    /* SETTERS */
    public Void setCamp(String c) {
        Camp = c;
    }
 }