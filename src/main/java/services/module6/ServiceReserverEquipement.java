package services.module6;

import entities.module6.ReserverEquipement;
import services.BaseService;
import services.IService;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceReserverEquipement extends BaseService implements IService<ReserverEquipement> {
    @Override
    public void add(ReserverEquipement reserverEquipement) throws SQLException {
        String sql = "INSERT INTO reserverequipement (equipement_id, utilisateur_id, debut, fin) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, reserverEquipement.getEquipementId());
            ps.setInt(2, reserverEquipement.getUtilisateurId());

            // Assuming debut and fin are java.sql.Time
            ps.setTime(3, new java.sql.Time(reserverEquipement.getDebut().getTime()));
            ps.setTime(4, new java.sql.Time(reserverEquipement.getFin().getTime()));

            ps.executeUpdate();
            System.out.println("Reservation has been added!");
        } catch (SQLException e) {
            System.out.println("Error adding reservation: " + e.getMessage());
        }

    }

    @Override
    public void update(ReserverEquipement reserverEquipement) {
        String sql = "UPDATE reserverequipement SET equipement_id = ?, utilisateur_id = ?, debut = ?, fin = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, reserverEquipement.getEquipementId());
            ps.setInt(2, reserverEquipement.getUtilisateurId());
            ps.setTime(3, new java.sql.Time(reserverEquipement.getDebut().getTime()));  // Convert Date to Time
            ps.setTime(4, new java.sql.Time(reserverEquipement.getFin().getTime()));     // Convert Date to Time
            ps.setInt(5, reserverEquipement.getId());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Reservation has been updated!");
            } else {
                System.out.println("No record found with the provided ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating reservation: " + e.getMessage());
        }
    }

    @Override
    public void delete(ReserverEquipement reserverEquipement) {
        String sql = "DELETE FROM reserverequipement WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, reserverEquipement.getId());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Reservation has been deleted!");
            } else {
                System.out.println("No record found with the provided ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting reservation: " + e.getMessage());
        }


    }

    @Override
    public ReserverEquipement get(int id) {
        String sql = "SELECT * FROM reserverequipement WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int equipementId = rs.getInt("equipement_id");
                    int utilisateurId = rs.getInt("utilisateur_id");
                    Time debut = rs.getTime("debut");
                    Time fin = rs.getTime("fin");

                    ReserverEquipement reserverEquipement = new ReserverEquipement(equipementId, utilisateurId, debut, fin);
                    reserverEquipement.setId(id);  // Set the id
                    return reserverEquipement;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching reservation: " + e.getMessage());
        }
        return null;


    }

    @Override
    public List<ReserverEquipement> getAll() throws SQLException {
        List<ReserverEquipement> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reserverequipement";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int equipementId = rs.getInt("equipement_id");
                int utilisateurId = rs.getInt("utilisateur_id");
                Time debut = rs.getTime("debut");
                Time fin = rs.getTime("fin");

                ReserverEquipement reserverEquipement = new ReserverEquipement(equipementId, utilisateurId, debut, fin);
                reserverEquipement.setId(id);
                reservations.add(reserverEquipement);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching all reservations: " + e.getMessage());
        }
        return reservations;

    }
}
