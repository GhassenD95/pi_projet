package entities.module3;

import enums.Sport;
import enums.TypeMatch;

import java.sql.Time;
import java.util.Date;

public class MatchSportif {
    private int id;
    private Sport sport;
    private int equipe_id;
    private String equipe_opposant;
    private Date date;
    private Time debut;
    private Time fin;
    private String adresse;
    private TypeMatch match;
    private int tournois_id;

    public MatchSportif(Sport sport, Date date, int equipe_id, String equipe_opposant, Time debut, Time fin, String adresse, TypeMatch match, int tournois_id) {
        this.sport = sport;
        this.date = date;
        this.equipe_id = equipe_id;
        this.equipe_opposant = equipe_opposant;
        this.debut = debut;
        this.fin = fin;
        this.adresse = adresse;
        this.match = match;
        this.tournois_id = tournois_id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEquipe_id() {
        return equipe_id;
    }

    public void setEquipe_id(int equipe_id) {
        this.equipe_id = equipe_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEquipe_opposant() {
        return equipe_opposant;
    }

    public void setEquipe_opposant(String equipe_opposant) {
        this.equipe_opposant = equipe_opposant;
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

    public int getTournois_id() {
        return tournois_id;
    }

    public void setTournois_id(int tournois_id) {
        this.tournois_id = tournois_id;
    }
}
