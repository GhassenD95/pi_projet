package entities.module4;

import entities.module1.Utilisateur;
import enums.TypeBlessure;

import java.util.Date;

public class Blessure {
    private int id;
    private Utilisateur joueur;
    private TypeBlessure type;
    private String description;
    private Date date;
    private Date date_retour;

    public Blessure(TypeBlessure type, Utilisateur joueur, Date date, String description, Date date_retour) {
        this.type = type;
        this.joueur = joueur;
        this.date = date;
        this.description = description;
        this.date_retour = date_retour;
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

    public TypeBlessure getType() {
        return type;
    }

    public void setType(TypeBlessure type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(Date date_retour) {
        this.date_retour = date_retour;
    }
}
