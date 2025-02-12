package entities.module1;

import enums.Division;
import enums.Sport;

public class Equipe {
    private int id;
    private String nom;
    private Division division;
    private int coach_id;
    private Sport sport;

    public Equipe(String nom, Division division, int coach_id, Sport sport) {
        this.nom = nom;
        this.division = division;
        this.coach_id = coach_id;
        this.sport = sport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public int getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }


    @Override
    public String toString() {
        return "Equipe{" +
                "nom='" + nom + '\'' +
                ", division=" + division +
                ", coach_id=" + coach_id +
                ", sport=" + sport +
                '}';
    }
}
