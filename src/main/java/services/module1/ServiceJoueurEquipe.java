package services.module1;

import entities.module1.JoueurEquipe;
import services.BaseService;
import services.IService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceJoueurEquipe  extends BaseService implements IService<JoueurEquipe> {

    @Override
    public void add(JoueurEquipe joueurEquipe) throws SQLException {
        String sql = "INSERT INTO utilisateurequipe(equipe_id, joueur_id) VALUES(?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, joueurEquipe.getEquipe_id());
            ps.setInt(2, joueurEquipe.getJoueur_id());
            ps.executeUpdate();
            System.out.println("UtilisateurEquipe has been added!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(JoueurEquipe joueurEquipe) {
        String sql = "UPDATE utilisateurequipe SET equipe_id = ?, joueur_id = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, joueurEquipe.getEquipe_id());
            ps.setInt(2, joueurEquipe.getJoueur_id());
            ps.setInt(3, joueurEquipe.getId());
            ps.executeUpdate();
            System.out.println("JoueurEquipe has been updated!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(JoueurEquipe joueurEquipe) {
        String sql = "DELETE FROM utilisateurequipe WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, joueurEquipe.getId());
            ps.executeUpdate();
            System.out.println("JoueurEquipe has been deleted!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public JoueurEquipe get(int id) {
        String sql = "SELECT * FROM utilisateurequipe WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int equipe_id = rs.getInt("equipe_id");
                    int joueur_id = rs.getInt("joueur_id");
                    JoueurEquipe joueurEquipe = new JoueurEquipe(equipe_id, joueur_id);
                    joueurEquipe.setId(id);
                    return joueurEquipe;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public List<JoueurEquipe> getAll() throws SQLException {
        List<JoueurEquipe> joueurEquipes = new ArrayList<>();
        String sql = "SELECT * FROM utilisateurequipe";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int equipe_id = rs.getInt("equipe_id");
                int joueur_id = rs.getInt("joueur_id");
                int id = rs.getInt("id");

                JoueurEquipe joueurEquipe = new JoueurEquipe(equipe_id, joueur_id);
                joueurEquipe.setId(id);
                joueurEquipes.add(joueurEquipe);
            }
        }
        return joueurEquipes;

    }
}
