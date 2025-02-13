package models.module6;

import models.module1.Utilisateur;

import java.util.Date;

public class ReserverEquipement {
    private int id;
    private Equipement equipement;
    private Utilisateur utilisateur;
    private Date debut;
    private Date fin;

    public ReserverEquipement(Utilisateur utilisateur, Date debut, Date fin, Equipement equipement) {
        this.utilisateur = utilisateur;
        this.debut = debut;
        this.fin = fin;
        this.equipement = equipement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }
}
