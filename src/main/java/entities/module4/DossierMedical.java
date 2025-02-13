package entities.module4;

import entities.module1.Utilisateur;

import java.util.Date;

public class DossierMedical {
    private int id;
    private Utilisateur joueur;
    private String allergies;
    private String historiqueBlessures;
    private Date dernierCheckup;


    public DossierMedical(Utilisateur joueur, String allergies, String historiqueBlessures, Date dernierCheckup) {
        this.joueur = joueur;
        this.allergies = allergies;
        this.historiqueBlessures = historiqueBlessures;
        this.dernierCheckup = dernierCheckup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public Utilisateur getJoueur() {
        return joueur;
    }

    public void setJoueur(Utilisateur joueur) {
        this.joueur = joueur;
    }

    public Date getDernierCheckup() {
        return dernierCheckup;
    }

    public void setDernierCheckup(Date dernierCheckup) {
        this.dernierCheckup = dernierCheckup;
    }

    public String getHistoriqueBlessures() {
        return historiqueBlessures;
    }

    public void setHistoriqueBlessures(String historiqueBlessures) {
        this.historiqueBlessures = historiqueBlessures;
    }
}
