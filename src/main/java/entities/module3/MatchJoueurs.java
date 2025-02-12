package entities.module3;

public class MatchJoueurs {
    private int id;
    private int joueur_id;
    private int match_id;
    private int minutesjoues;


    public MatchJoueurs(int joueur_id, int match_id, int minutesjoues) {
        this.joueur_id = joueur_id;
        this.match_id = match_id;
        this.minutesjoues = minutesjoues;
    }


    public int getJoueur_id() {
        return joueur_id;
    }

    public void setJoueur_id(int joueur_id) {
        this.joueur_id = joueur_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public int getMinutesjoues() {
        return minutesjoues;
    }

    public void setMinutesjoues(int minutesjoues) {
        this.minutesjoues = minutesjoues;
    }
}
