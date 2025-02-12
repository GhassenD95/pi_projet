package services.module3;

import entities.module3.MatchSportif;
import enums.Sport;
import enums.TypeMatch;
import services.BaseService;
import services.IService;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceMatchSportif extends BaseService implements IService<MatchSportif> {
    @Override
    public void add(MatchSportif matchSportif) throws SQLException {
        String sql = "INSERT INTO matchsportif(sport, equipe_id, equipe_opposant, date, debut, fin, adresse, match_type, tournois_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, matchSportif.getSport().name());
            ps.setInt(2, matchSportif.getEquipe_id());
            ps.setString(3, matchSportif.getEquipe_opposant());
            ps.setDate(4, new java.sql.Date(matchSportif.getDate().getTime()));
            ps.setTime(5, matchSportif.getDebut());
            ps.setTime(6, matchSportif.getFin());
            ps.setString(7, matchSportif.getAdresse());
            ps.setString(8, matchSportif.getMatch().name());
            ps.setInt(9, matchSportif.getTournois_id());
            ps.executeUpdate();
            System.out.println("MatchSportif has been added!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(MatchSportif matchSportif) {
        String sql = "UPDATE matchsportif SET sport = ?, equipe_id = ?, equipe_opposant = ?, date = ?, debut = ?, fin = ?, adresse = ?, match_type = ?, tournois_id = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, matchSportif.getSport().name());
            ps.setInt(2, matchSportif.getEquipe_id());
            ps.setString(3, matchSportif.getEquipe_opposant());
            ps.setDate(4, new java.sql.Date(matchSportif.getDate().getTime()));
            ps.setTime(5, matchSportif.getDebut());
            ps.setTime(6, matchSportif.getFin());
            ps.setString(7, matchSportif.getAdresse());
            ps.setString(8, matchSportif.getMatch().name());
            ps.setInt(9, matchSportif.getTournois_id());
            ps.setInt(10, matchSportif.getId());
            ps.executeUpdate();
            System.out.println("MatchSportif has been updated!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(MatchSportif matchSportif) {
        String sql = "DELETE FROM matchsportif WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, matchSportif.getId());
            ps.executeUpdate();
            System.out.println("MatchSportif has been deleted!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public MatchSportif get(int id) {
        String sql = "SELECT * FROM matchsportif WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Sport sport = Sport.valueOf(rs.getString("sport"));
                    int equipe_id = rs.getInt("equipe_id");
                    String equipe_opposant = rs.getString("equipe_opposant");
                    Date date = rs.getDate("date");
                    Time debut = rs.getTime("debut");
                    Time fin = rs.getTime("fin");
                    String adresse = rs.getString("adresse");
                    TypeMatch match = TypeMatch.valueOf(rs.getString("match_type"));
                    int tournois_id = rs.getInt("tournois_id");

                    MatchSportif matchSportif = new MatchSportif(sport, date, equipe_id, equipe_opposant, debut, fin, adresse, match, tournois_id);
                    matchSportif.setId(id);
                    return matchSportif;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }



    @Override
    public List<MatchSportif> getAll() throws SQLException {
        List<MatchSportif> matchSportifs = new ArrayList<>();
        String sql = "SELECT * FROM matchsportif";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                Sport sport = Sport.valueOf(rs.getString("sport"));
                int equipe_id = rs.getInt("equipe_id");
                String equipe_opposant = rs.getString("equipe_opposant");
                Date date = rs.getDate("date");
                Time debut = rs.getTime("debut");
                Time fin = rs.getTime("fin");
                String adresse = rs.getString("adresse");
                TypeMatch match = TypeMatch.valueOf(rs.getString("match_type"));
                int tournois_id = rs.getInt("tournois_id");

                MatchSportif matchSportif = new MatchSportif(sport, date, equipe_id, equipe_opposant, debut, fin, adresse, match, tournois_id);
                matchSportif.setId(id);
                matchSportifs.add(matchSportif);
            }
        }
        return matchSportifs;
    }
}
