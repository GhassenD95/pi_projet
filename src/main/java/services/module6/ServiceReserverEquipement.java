package services.module6;

import models.module1.Utilisateur;
import models.module6.Equipement;
import models.module6.ReserverEquipement;
import services.BaseService;
import services.IService;
import services.module1.ServiceUtilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceReserverEquipement extends BaseService implements IService<ReserverEquipement> {
    @Override
    public void add(ReserverEquipement reserverEquipement) throws SQLException {
        String sql = "INSERT INTO reserver_equipement (utilisateur_id, equipement_id, debut, fin) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, reserverEquipement.getUtilisateur().getId());
            ps.setInt(2, reserverEquipement.getEquipement().getId());
            ps.setDate(3, new java.sql.Date(reserverEquipement.getDebut().getTime()));
            ps.setDate(4, new java.sql.Date(reserverEquipement.getFin().getTime()));

            ps.executeUpdate();
            System.out.println("Reservation added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding reservation: " + e.getMessage());
        }

    }

    @Override
    public void update(ReserverEquipement reserverEquipement) {
        String sql = "UPDATE reserverequipement SET equipement_id = ?, utilisateur_id = ?, debut = ?, fin = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, reserverEquipement.getEquipement().getId());
            ps.setInt(2, reserverEquipement.getUtilisateur().getId());
            ps.setDate(3, new java.sql.Date(reserverEquipement.getDebut().getTime()));
            ps.setDate(4, new java.sql.Date(reserverEquipement.getFin().getTime()));
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
                    Equipement equipement = new ServiceEquipement().get(rs.getInt("equipement_id"));
                    Utilisateur utilisateur = new ServiceUtilisateur().get(rs.getInt("utilisateur_id"));
                    Date debut = rs.getDate("debut");
                    Time fin = rs.getTime("fin");

                    ReserverEquipement reserverEquipement = new ReserverEquipement(utilisateur, debut, fin, equipement);
                    reserverEquipement.setId(id);
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
                Equipement equipement = new ServiceEquipement().get(rs.getInt("equipement_id"));
                Utilisateur utilisateur = new ServiceUtilisateur().get(rs.getInt("utilisateur_id"));
                Date debut = rs.getDate("debut");
                Time fin = rs.getTime("fin");

                ReserverEquipement reserverEquipement = new ReserverEquipement(utilisateur, debut, fin, equipement);
                reserverEquipement.setId(id);
                reservations.add(reserverEquipement);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching all reservations: " + e.getMessage());
        }
        return reservations;

    }
}
