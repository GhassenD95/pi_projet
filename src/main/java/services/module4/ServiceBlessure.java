package services.module4;

import entities.module4.Blessure;
import enums.TypeBlessure;
import services.BaseService;
import services.IService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceBlessure extends BaseService implements IService<Blessure> {
    @Override
    public void add(Blessure blessure) throws SQLException {
        String sql = "INSERT INTO blessure(joueur_id, type, description, date, date_retour) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, blessure.getJoueur_id());
            ps.setString(2, blessure.getType().toString());
            ps.setString(3, blessure.getDescription());
            ps.setDate(4, new java.sql.Date(blessure.getDate().getTime()));
            ps.setDate(5, new java.sql.Date(blessure.getDate_retour().getTime()));
            ps.executeUpdate();
            System.out.println("Blessure has been added!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(Blessure blessure) {
        String sql = "UPDATE blessure SET joueur_id = ?, type = ?, description = ?, date = ?, date_retour = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, blessure.getJoueur_id());
            ps.setString(2, blessure.getType().toString());
            ps.setString(3, blessure.getDescription());
            ps.setDate(4, new java.sql.Date(blessure.getDate().getTime()));
            ps.setDate(5, new java.sql.Date(blessure.getDate_retour().getTime()));
            ps.setInt(6, blessure.getId());
            ps.executeUpdate();
            System.out.println("Blessure has been updated!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(Blessure blessure) {
        String sql = "DELETE FROM blessure WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, blessure.getId());
            ps.executeUpdate();
            System.out.println("Blessure has been deleted!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Blessure get(int id) {
        String sql = "SELECT * FROM blessure WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int joueur_id = rs.getInt("joueur_id");
                    TypeBlessure type = TypeBlessure.valueOf(rs.getString("type"));
                    String description = rs.getString("description");
                    Date date = rs.getDate("date");
                    Date date_retour = rs.getDate("date_retour");

                    Blessure blessure = new Blessure(id, type, description, date, date_retour);
                    blessure.setJoueur_id(joueur_id);
                    return blessure;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public List<Blessure> getAll() throws SQLException {
        List<Blessure> blessuresList = new ArrayList<>();
        String sql = "SELECT * FROM blessure";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int joueur_id = rs.getInt("joueur_id");
                TypeBlessure type = TypeBlessure.valueOf(rs.getString("type"));
                String description = rs.getString("description");
                Date date = rs.getDate("date");
                Date date_retour = rs.getDate("date_retour");

                Blessure blessure = new Blessure(id, type, description, date, date_retour);
                blessure.setJoueur_id(joueur_id);
                blessuresList.add(blessure);
            }
        }
        return blessuresList;

    }
}
