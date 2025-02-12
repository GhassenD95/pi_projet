package entities.module5;

public class PerformanceEquipe {
    private int id;
    private int equipeId;
    private int tournoisId;
    private int victoires;
    private int pertes;
    private int rang;

    public PerformanceEquipe(int equipeId, int tournoisId, int victoires, int pertes, int rang) {
        this.equipeId = equipeId;
        this.tournoisId = tournoisId;
        this.victoires = victoires;
        this.pertes = pertes;
        this.rang = rang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(int equipeId) {
        this.equipeId = equipeId;
    }

    public int getTournoisId() {
        return tournoisId;
    }

    public void setTournoisId(int tournoisId) {
        this.tournoisId = tournoisId;
    }

    public int getVictoires() {
        return victoires;
    }

    public void setVictoires(int victoires) {
        this.victoires = victoires;
    }

    public int getPertes() {
        return pertes;
    }

    public void setPertes(int pertes) {
        this.pertes = pertes;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }
}
