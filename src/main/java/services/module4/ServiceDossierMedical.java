package services.module4;

import models.module1.Utilisateur;
import models.module4.DossierMedical;
import services.BaseService;
import services.IService;
import services.module1.ServiceUtilisateur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceDossierMedical extends BaseService implements IService<DossierMedical> {
    @Override
    public void add(DossierMedical dossierMedical) throws SQLException {
        String sql = "INSERT INTO dossiermedical(joueur_id, allergies, historiqueblessures, derniercheckup) VALUES(?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, dossierMedical.getJoueur().getId());
            ps.setString(2, dossierMedical.getAllergies());
            ps.setString(3, dossierMedical.getHistoriqueBlessures());
            ps.setDate(4, new java.sql.Date(dossierMedical.getDernierCheckup().getTime()));
            ps.executeUpdate();
            System.out.println("Dossier Medical has been added!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(DossierMedical dossierMedical) {
        String sql = "UPDATE dossiermedical SET joueur_id = ?, allergies = ?, historiqueblessures = ?, derniercheckup = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, dossierMedical.getJoueur().getId());
            ps.setString(2, dossierMedical.getAllergies());
            ps.setString(3, dossierMedical.getHistoriqueBlessures());
            ps.setDate(4, new java.sql.Date(dossierMedical.getDernierCheckup().getTime()));
            ps.setInt(5, dossierMedical.getId());
            ps.executeUpdate();
            System.out.println("Dossier Medical has been updated!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(DossierMedical dossierMedical) {
        String sql = "DELETE FROM dossiermedical WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, dossierMedical.getId());
            ps.executeUpdate();
            System.out.println("Dossier Medical has been deleted!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public DossierMedical get(int id) {
        String sql = "SELECT * FROM dossiermedical WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Utilisateur joueur = new ServiceUtilisateur().get(rs.getInt("joueur_id"));
                    String allergies = rs.getString("allergies");
                    String historiqueBlessures = rs.getString("historiqueblessures");
                    Date dernierCheckup = rs.getDate("derniercheckup");

                    DossierMedical dossierMedical = new DossierMedical(joueur, allergies, historiqueBlessures, dernierCheckup);
                    dossierMedical.setId(id);
                    return dossierMedical;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public List<DossierMedical> getAll() throws SQLException {
        List<DossierMedical> dossiersList = new ArrayList<>();
        String sql = "SELECT * FROM dossiermedical";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                Utilisateur joueur = new ServiceUtilisateur().get(rs.getInt("joueur_id"));
                String allergies = rs.getString("allergies");
                String historiqueBlessures = rs.getString("historiqueblessures");
                Date dernierCheckup = rs.getDate("derniercheckup");

                DossierMedical dossierMedical = new DossierMedical(joueur, allergies, historiqueBlessures, dernierCheckup);
                dossierMedical.setId(id);
                dossiersList.add(dossierMedical);
            }
        }
        return dossiersList;
    }

}

