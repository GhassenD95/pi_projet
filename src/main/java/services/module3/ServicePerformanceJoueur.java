package services.module3;

import models.module1.Utilisateur;
import models.module3.PerformanceJoueur;
import enums.Carte;
import services.BaseService;
import services.IService;
import services.module1.ServiceUtilisateur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServicePerformanceJoueur extends BaseService implements IService<PerformanceJoueur> {
    @Override
    public void add(PerformanceJoueur performanceJoueur) throws SQLException {
        String sql = "INSERT INTO performancejoueur(joueur_id, buts, assist, carte, score_coach) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, performanceJoueur.getJoueur().getId());
            ps.setInt(2, performanceJoueur.getButs());
            ps.setInt(3, performanceJoueur.getAssist());
            ps.setString(4, performanceJoueur.getCarte().name());
            ps.setInt(5, performanceJoueur.getScore_coach());
            ps.executeUpdate();
            System.out.println("PerformanceJoueur has been added!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(PerformanceJoueur performanceJoueur) {
        String sql = "UPDATE performancejoueur SET match_joueur_id = ?, buts = ?, assist = ?, carte = ?, score_coach = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, performanceJoueur.getJoueur().getId());
            ps.setInt(2, performanceJoueur.getButs());
            ps.setInt(3, performanceJoueur.getAssist());
            ps.setString(4, performanceJoueur.getCarte().name());
            ps.setInt(5, performanceJoueur.getScore_coach());
            ps.setInt(6, performanceJoueur.getId());
            ps.executeUpdate();
            System.out.println("PerformanceJoueur has been updated!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(PerformanceJoueur performanceJoueur) {
        String sql = "DELETE FROM performancejoueur WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, performanceJoueur.getId());
            ps.executeUpdate();
            System.out.println("PerformanceJoueur has been deleted!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public PerformanceJoueur get(int id) {
        String sql = "SELECT * FROM performancejoueur WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Utilisateur joueur = new ServiceUtilisateur().get(rs.getInt("joueur_id"));
                    int buts = rs.getInt("buts");
                    int assist = rs.getInt("assist");
                    Carte carte = Carte.valueOf(rs.getString("carte"));
                    int score_coach = rs.getInt("score_coach");

                    PerformanceJoueur performanceJoueur = new PerformanceJoueur(joueur, buts, assist, carte, score_coach);
                    performanceJoueur.setId(id);
                    return performanceJoueur;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public List<PerformanceJoueur> getAll() throws SQLException {
        List<PerformanceJoueur> performanceJoueurs = new ArrayList<>();
        String sql = "SELECT * FROM performancejoueur";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                Utilisateur joueur = new ServiceUtilisateur().get(rs.getInt("joueur_id"));
                int buts = rs.getInt("buts");
                int assist = rs.getInt("assist");
                Carte carte = Carte.valueOf(rs.getString("carte"));
                int score_coach = rs.getInt("score_coach");

                PerformanceJoueur performanceJoueur = new PerformanceJoueur(joueur, buts, assist, carte, score_coach);
                performanceJoueur.setId(id);
                performanceJoueurs.add(performanceJoueur);
            }
        }
        return performanceJoueurs;
    }
}
