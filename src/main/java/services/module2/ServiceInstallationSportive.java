package services.module2;

import entities.module2.InstallationSportive;
import enums.StatusInstallation;
import enums.TypeInstallation;
import services.BaseService;
import services.IService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceInstallationSportive extends BaseService implements IService<InstallationSportive> {
    @Override
    public void add(InstallationSportive installationSportive) throws SQLException {
        String sql = "INSERT INTO installationsportive(nom, type, image_url, status, adresse) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, installationSportive.getNom());
            ps.setString(2, installationSportive.getTypeInstallation().name());
            ps.setString(3, installationSportive.getImage_url());
            ps.setString(4, installationSportive.getStatusInstallation().name());
            ps.setString(5, installationSportive.getAdresse());
            ps.executeUpdate();
            System.out.println("InstallationSportive has been added!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(InstallationSportive installationSportive) {
        String sql = "UPDATE installationsportive SET nom = ?, type = ?, image_url = ?, status = ?, adresse = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, installationSportive.getNom());
            ps.setString(2, installationSportive.getTypeInstallation().name());
            ps.setString(3, installationSportive.getImage_url());
            ps.setString(4, installationSportive.getStatusInstallation().name());
            ps.setString(5, installationSportive.getAdresse());
            ps.setInt(6, installationSportive.getId());
            ps.executeUpdate();
            System.out.println("InstallationSportive has been updated!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(InstallationSportive installationSportive) {
        String sql = "DELETE FROM installationsportive WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, installationSportive.getId());
            ps.executeUpdate();
            System.out.println("InstallationSportive has been deleted!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public InstallationSportive get(int id) {
        String sql = "SELECT * FROM installationsportive WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("nom");
                    TypeInstallation typeInstallation = TypeInstallation.valueOf(rs.getString("type"));
                    String imageUrl = rs.getString("image_url");
                    StatusInstallation statusInstallation = StatusInstallation.valueOf(rs.getString("status"));
                    String adresse = rs.getString("adresse");

                    InstallationSportive installationSportive = new InstallationSportive(nom, typeInstallation, imageUrl, statusInstallation, adresse);
                    installationSportive.setId(id);
                    return installationSportive;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public List<InstallationSportive> getAll() throws SQLException {
        List<InstallationSportive> installationsSportives = new ArrayList<>();
        String sql = "SELECT * FROM installationsportive";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                TypeInstallation typeInstallation = TypeInstallation.valueOf(rs.getString("type"));
                String imageUrl = rs.getString("image_url");
                StatusInstallation statusInstallation = StatusInstallation.valueOf(rs.getString("status"));
                String adresse = rs.getString("adresse");

                InstallationSportive installationSportive = new InstallationSportive(nom, typeInstallation, imageUrl, statusInstallation, adresse);
                installationSportive.setId(id);
                installationsSportives.add(installationSportive);
            }
        }
        return installationsSportives;

    }
}
