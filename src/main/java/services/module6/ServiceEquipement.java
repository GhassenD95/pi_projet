package services.module6;

import entities.module6.Equipement;
import enums.Sport;
import enums.StatusEquipement;
import services.BaseService;
import services.IService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceEquipement extends BaseService implements IService<Equipement> {
    @Override
    public void add(Equipement equipement) throws SQLException {
        String sql = "INSERT INTO equipement(nom, sport, installation_sportive_id, etat, image_url) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, equipement.getNom());
            ps.setString(2, equipement.getSport().name());
            ps.setInt(3, equipement.getInstallationSportiveId());
            ps.setString(4, equipement.getEtat().name());
            ps.setString(5, equipement.getImage_url());
            ps.executeUpdate();
            System.out.println("Equipement has been added!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(Equipement equipement) {
        String sql = "UPDATE equipement SET nom = ?, sport = ?, installation_sportive_id = ?, etat = ?, image_url = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // Setting values for the update query
            ps.setString(1, equipement.getNom());
            ps.setString(2, equipement.getSport().name());
            ps.setInt(3, equipement.getInstallationSportiveId());
            ps.setString(4, equipement.getEtat().name());
            ps.setString(5, equipement.getImage_url());
            ps.setInt(6, equipement.getId());
            // Execute the update
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Equipement has been updated!");
            } else {
                System.out.println("No record found with the provided ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating equipment: " + e.getMessage());
        }

    }

    @Override
    public void delete(Equipement equipement) {
        String sql = "DELETE FROM equipement WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, equipement.getId());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Equipement has been deleted!");
            } else {
                System.out.println("No record found with the provided ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting equipment: " + e.getMessage());
        }
    }

    @Override
    public Equipement get(int id) {
        String sql = "SELECT * FROM equipement WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("nom");
                    Sport sport = Sport.valueOf(rs.getString("sport"));
                    int installationSportiveId = rs.getInt("installation_sportive_id");
                    StatusEquipement etat = StatusEquipement.valueOf(rs.getString("etat"));
                    String imageUrl = rs.getString("image_url");
                    Equipement equipement = new Equipement(nom, sport, installationSportiveId, etat, imageUrl);
                    equipement.setId(id);
                    return equipement;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching equipment: " + e.getMessage());
        }
        return null;

    }

    @Override
    public List<Equipement> getAll() throws SQLException {
        List<Equipement> equipements = new ArrayList<>();
        String sql = "SELECT * FROM equipement";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                Sport sport = Sport.valueOf(rs.getString("sport"));
                int installationSportiveId = rs.getInt("installation_sportive_id");
                StatusEquipement etat = StatusEquipement.valueOf(rs.getString("etat"));
                String imageUrl = rs.getString("image_url");
                Equipement equipement = new Equipement(nom, sport, installationSportiveId, etat, imageUrl);
                equipement.setId(id);
                equipements.add(equipement);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching all equipments: " + e.getMessage());
        }
        return equipements;

    }
}
