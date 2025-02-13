package entities.module3;

import entities.module1.Utilisateur;
import enums.Carte;

public class PerformanceJoueur {
    private int id;
    private Utilisateur joueur;
    private int buts;
    private int assist;
    private Carte carte;
    private int score_coach;


    public PerformanceJoueur(Utilisateur joueur, int buts, int assist, Carte carte, int score_coach) {
        this.joueur = joueur;
        this.buts = buts;
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

    public Utilisateur getJoueur() {
        return joueur;
    }

    public void setJoueur(Utilisateur joueur) {
        this.joueur = joueur;
    }

    public int getAssist() {
        return assist;
    }

    public void setAssist(int assist) {
        this.assist = assist;
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

    public int getScore_coach() {
        return score_coach;
    }

    public void setScore_coach(int score_coach) {
        this.score_coach = score_coach;
    }
}
