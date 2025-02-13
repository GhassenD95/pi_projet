package entities.module2;

import entities.module1.Equipe;
import entities.module1.Utilisateur;
import enums.TypeEntrainment;

import java.sql.Time;
import java.util.Date;

public class Entrainment {
    private int id;
    private Equipe equipe;
    private Utilisateur coach;
    private InstallationSportive installationSportive;
    private Date date;
    private Time debut;
    private Time fin;
    private TypeEntrainment typeEntrainment;

    public Entrainment(Equipe equipe, Utilisateur coach, InstallationSportive installationSportive, Date date, Time debut, Time fin, TypeEntrainment typeEntrainment) {
        this.equipe = equipe;
        this.coach = coach;
        this.installationSportive = installationSportive;
        this.date = date;
        this.debut = debut;
        this.fin = fin;
        this.typeEntrainment = typeEntrainment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Utilisateur getCoach() {
        return coach;
    }

    public void setCoach(Utilisateur coach) {
        this.coach = coach;
    }

    public InstallationSportive getInstallationSportive() {
        return installationSportive;
    }

    public void setInstallationSportive(InstallationSportive installationSportive) {
        this.installationSportive = installationSportive;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getFin() {
        return fin;
    }

    public void setFin(Time fin) {
        this.fin = fin;
    }

    public Time getDebut() {
        return debut;
    }

    public void setDebut(Time debut) {
        this.debut = debut;
    }

    public TypeEntrainment getTypeEntrainment() {
        return typeEntrainment;
    }

    public void setTypeEntrainment(TypeEntrainment typeEntrainment) {
        this.typeEntrainment = typeEntrainment;
    }
}
