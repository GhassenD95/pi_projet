package entities.module5;

import entities.module1.Equipe;

public class PerformanceEquipe {
    private int id;
    private Equipe equipe;
    private Tournois tournois;
    private int victoires;
    private int pertes;
    private int rang;

    public PerformanceEquipe(Equipe equipe, int victoires, int pertes, int rang, Tournois tournois) {
        this.equipe = equipe;
        this.victoires = victoires;
        this.pertes = pertes;
        this.rang = rang;
        this.tournois = tournois;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Tournois getTournois() {
        return tournois;
    }

    public void setTournois(Tournois tournois) {
        this.tournois = tournois;
    }

    public int getVictoires() {
        return victoires;
    }

    public void setVictoires(int victoires) {
        this.victoires = victoires;
    }

    public int getPertes() {
        return pertes;
    }

    public void setPertes(int pertes) {
        this.pertes = pertes;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }
}
