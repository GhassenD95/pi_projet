package entities.module6;

import java.util.Date;

public class ReserverEquipement {
    private int id;
    private int equipementId;
    private int utilisateurId;
    private Date debut;
    private Date fin;

    public ReserverEquipement(int equipementId, int utilisateurId, Date debut, Date fin) {
        this.equipementId = equipementId;
        this.utilisateurId = utilisateurId;
        this.debut = debut;
        this.fin = fin;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEquipementId() {
        return equipementId;
    }

    public void setEquipementId(int equipementId) {
        this.equipementId = equipementId;
    }

    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
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
