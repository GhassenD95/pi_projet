package entities.module3;

import enums.Carte;

public class PerformanceJoueur {
    private int id;
    private int matchJoueur_id;
    private int buts;
    private int assist;
    private Carte carte;
    private int score_coach;

    public PerformanceJoueur(int buts, int matchJoueur_id, int assist, Carte carte, int score_coach) {
        this.buts = buts;
        this.matchJoueur_id = matchJoueur_id;
        this.assist = assist;
        this.carte = carte;
        this.score_coach = score_coach;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatchJoueur_id() {
        return matchJoueur_id;
    }

    public void setMatchJoueur_id(int matchJoueur_id) {
        this.matchJoueur_id = matchJoueur_id;
    }

    public int getButs() {
        return buts;
    }

    public void setButs(int buts) {
        this.buts = buts;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public int getAssist() {
        return assist;
    }

    public void setAssist(int assist) {
        this.assist = assist;
    }

    public int getScore_coach() {
        return score_coach;
    }

    public void setScore_coach(int score_coach) {
        this.score_coach = score_coach;
    }
}
