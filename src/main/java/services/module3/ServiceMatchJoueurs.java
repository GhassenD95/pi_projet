package services.module3;

import entities.module3.MatchJoueurs;
import services.BaseService;
import services.IService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceMatchJoueurs extends BaseService implements IService<MatchJoueurs> {
    @Override
    public void add(MatchJoueurs matchJoueurs) throws SQLException {
        String sql = "INSERT INTO matchjoueurs(joueur_id, match_id, minutesjoues) VALUES(?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, matchJoueurs.getJoueur_id());
            ps.setInt(2, matchJoueurs.getMatch_id());
            ps.setInt(3, matchJoueurs.getMinutesjoues());
            ps.executeUpdate();
            System.out.println("MatchJoueurs has been added!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(MatchJoueurs matchJoueurs) {
        String sql = "UPDATE matchjoueurs SET joueur_id = ?, match_id = ?, minutesjoues = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, matchJoueurs.getJoueur_id());
            ps.setInt(2, matchJoueurs.getMatch_id());
            ps.setInt(3, matchJoueurs.getMinutesjoues());
            ps.setInt(4, matchJoueurs.getId());
            ps.executeUpdate();
            System.out.println("MatchJoueurs has been updated!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(MatchJoueurs matchJoueurs) {
        String sql = "DELETE FROM matchjoueurs WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, matchJoueurs.getId());
            ps.executeUpdate();
            System.out.println("MatchJoueurs has been deleted!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public MatchJoueurs get(int id) {
        String sql = "SELECT * FROM matchjoueurs WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int joueur_id = rs.getInt("joueur_id");
                    int match_id = rs.getInt("match_id");
                    int minutesjoues = rs.getInt("minutesjoues");

                    MatchJoueurs matchJoueurs = new MatchJoueurs(joueur_id, match_id, minutesjoues);
                    matchJoueurs.setId(id);
                    return matchJoueurs;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public List<MatchJoueurs> getAll() throws SQLException {
        List<MatchJoueurs> matchJoueursList = new ArrayList<>();
        String sql = "SELECT * FROM matchjoueurs";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int joueur_id = rs.getInt("joueur_id");
                int match_id = rs.getInt("match_id");
                int minutesjoues = rs.getInt("minutesjoues");

                MatchJoueurs matchJoueurs = new MatchJoueurs(joueur_id, match_id, minutesjoues);
                matchJoueurs.setId(id);
                matchJoueursList.add(matchJoueurs);
            }
        }
        return matchJoueursList;

    }
}
