package entities.module3;

import entities.module1.Utilisateur;

public class MatchJoueurs {
    private int id;
    private Utilisateur joueur;
    private MatchSportif match;
    private int minutesjoues;


    public MatchJoueurs(Utilisateur joueur, MatchSportif match, int minutesjoues) {
        this.joueur = joueur;
        this.match = match;
        this.minutesjoues = minutesjoues;
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

    public MatchSportif getMatch() {
        return match;
    }

    public void setMatch(MatchSportif match) {
        this.match = match;
    }

    public int getMinutesjoues() {
        return minutesjoues;
    }

    public void setMinutesjoues(int minutesjoues) {
        this.minutesjoues = minutesjoues;
    }
}
