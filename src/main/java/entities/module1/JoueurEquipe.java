package entities.module1;

public class JoueurEquipe {
    private int id;
    private int equipe_id;
    private int joueur_id;

    public JoueurEquipe(int equipe_id, int joueur_id) {
        this.equipe_id = equipe_id;
        this.joueur_id = joueur_id;
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

    public int getJoueur_id() {
        return joueur_id;
    }

    public void setJoueur_id(int joueur_id) {
        this.joueur_id = joueur_id;
    }
}
