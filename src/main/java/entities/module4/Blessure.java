package entities.module4;

import enums.TypeBlessure;

import java.util.Date;

public class Blessure {
    private int id;
    private int joueur_id;
    private TypeBlessure type;
    private String description;
    private Date date;
    private Date date_retour;

    public Blessure(int id, TypeBlessure type, String description, Date date, Date date_retour) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.date = date;
        this.date_retour = date_retour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJoueur_id() {
        return joueur_id;
    }

    public void setJoueur_id(int joueur_id) {
        this.joueur_id = joueur_id;
    }

    public TypeBlessure getType() {
        return type;
    }

    public void setType(TypeBlessure type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(Date date_retour) {
        this.date_retour = date_retour;
    }
}
