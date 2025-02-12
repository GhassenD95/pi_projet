package entities.module4;

import java.util.Date;

public class DossierMedical {
    private int id;
    private int joueur_id;
    private String allergies;
    private String historiqueBlessures;
    private Date dernierCheckup;


    public DossierMedical(int joueur_id, String allergies, String historiqueBlessures, Date dernierCheckup) {
        this.joueur_id = joueur_id;
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

    public int getJoueur_id() {
        return joueur_id;
    }

    public void setJoueur_id(int joueur_id) {
        this.joueur_id = joueur_id;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getHistoriqueBlessures() {
        return historiqueBlessures;
    }

    public void setHistoriqueBlessures(String historiqueBlessures) {
        this.historiqueBlessures = historiqueBlessures;
    }

    public Date getDernierCheckup() {
        return dernierCheckup;
    }

    public void setDernierCheckup(Date dernierCheckup) {
        this.dernierCheckup = dernierCheckup;
    }
}
