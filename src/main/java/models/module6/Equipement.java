package models.module6;

import enums.Sport;
import enums.StatusEquipement;

public class Equipement {
    private int id;
    private String nom;
    private Sport sport;
    private int installationSportiveId;
    private StatusEquipement etat;
    private String image_url;


    public Equipement(String nom, Sport sport, int installationSportiveId, StatusEquipement etat, String image_url) {
        this.nom = nom;
        this.sport = sport;
        this.installationSportiveId = installationSportiveId;
        this.etat = etat;
        this.image_url = image_url;
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

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public int getInstallationSportiveId() {
        return installationSportiveId;
    }

    public void setInstallationSportiveId(int installationSportiveId) {
        this.installationSportiveId = installationSportiveId;
    }

    public StatusEquipement getEtat() {
        return etat;
    }

    public void setEtat(StatusEquipement etat) {
        this.etat = etat;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
