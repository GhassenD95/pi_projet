package entities.module2;

import enums.TypeEntrainment;

import java.sql.Time;
import java.util.Date;

public class Entrainment {
    private int id;
    private int equipe_id;
    private int coach_id;
    private int installationSportive_id;
    private Date date;
    private Time debut;
    private Time fin;
    private TypeEntrainment typeEntrainment;

    public Entrainment(int equipe_id, int coach_id, Time fin, TypeEntrainment typeEntrainment, Date date, Time debut, int installationSportive_id) {
        this.equipe_id = equipe_id;
        this.coach_id = coach_id;
        this.fin = fin;
        this.typeEntrainment = typeEntrainment;
        this.date = date;
        this.debut = debut;
        this.installationSportive_id = installationSportive_id;
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

    public int getInstallationSportive_id() {
        return installationSportive_id;
    }

    public void setInstallationSportive_id(int installationSportive_id) {
        this.installationSportive_id = installationSportive_id;
    }

    public TypeEntrainment getTypeEntrainment() {
        return typeEntrainment;
    }

    public void setTypeEntrainment(TypeEntrainment typeEntrainment) {
        this.typeEntrainment = typeEntrainment;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
    }


}
