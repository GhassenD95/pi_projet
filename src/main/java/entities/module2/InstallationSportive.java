package entities.module2;

import enums.StatusInstallation;
import enums.TypeInstallation;

public class InstallationSportive {
    private int id;
    private String nom;
    private TypeInstallation typeInstallation;
    private StatusInstallation statusInstallation;
    private String image_url;
    private String adresse;

    public InstallationSportive(String nom, TypeInstallation typeInstallation, String image_url, StatusInstallation statusInstallation, String adresse) {
        this.nom = nom;
        this.typeInstallation = typeInstallation;
        this.image_url = image_url;
        this.statusInstallation = statusInstallation;
        this.adresse = adresse;
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

    public TypeInstallation getTypeInstallation() {
        return typeInstallation;
    }

    public void setTypeInstallation(TypeInstallation typeInstallation) {
        this.typeInstallation = typeInstallation;
    }

    public StatusInstallation getStatusInstallation() {
        return statusInstallation;
    }

    public void setStatusInstallation(StatusInstallation statusInstallation) {
        this.statusInstallation = statusInstallation;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
