package entities.module3;

import entities.module1.Equipe;
import entities.module5.Tournois;
import enums.Sport;
import enums.TypeMatch;

import java.sql.Time;
import java.util.Date;

public class MatchSportif {
    private int id;
    private Sport sport;
    private Equipe equipe;
    private String equipe_opposant;
    private Date date;
    private Time debut;
    private Time fin;
    private String adresse;
    private TypeMatch match;
    private Tournois tournois;

    public MatchSportif(Sport sport, Equipe equipe, String equipe_opposant, Time debut, Date date, Time fin, String adresse, Tournois tournois, TypeMatch match) {
        this.sport = sport;
        this.equipe = equipe;
        this.equipe_opposant = equipe_opposant;
        this.debut = debut;
        this.date = date;
        this.fin = fin;
        this.adresse = adresse;
        this.tournois = tournois;
        this.match = match;
    }


    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public String getEquipe_opposant() {
        return equipe_opposant;
    }

    public void setEquipe_opposant(String equipe_opposant) {
        this.equipe_opposant = equipe_opposant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getDebut() {
        return debut;
    }

    public void setDebut(Time debut) {
        this.debut = debut;
    }

    public Time getFin() {
        return fin;
    }

    public void setFin(Time fin) {
        this.fin = fin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public TypeMatch getMatch() {
        return match;
    }

    public void setMatch(TypeMatch match) {
        this.match = match;
    }

    public Tournois getTournois() {
        return tournois;
    }

    public void setTournois(Tournois tournois) {
        this.tournois = tournois;
    }
}
