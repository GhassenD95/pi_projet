package services.module2;

import entities.module1.Equipe;
import entities.module1.Utilisateur;
import entities.module2.Entrainment;
import entities.module2.InstallationSportive;
import enums.TypeEntrainment;
import services.BaseService;
import services.IService;
import services.module1.ServiceEquipe;
import services.module1.ServiceUtilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceEntrainment extends BaseService implements IService<Entrainment> {
    @Override
    public void add(Entrainment entrainment) throws SQLException {
        String sql = "INSERT INTO entrainment(equipe_id, coach_id, installationSportive_id, date, debut, fin, typeEntrainment) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, entrainment.getEquipe().getId());
            ps.setInt(2, entrainment.getCoach().getId());
            ps.setInt(3, entrainment.getInstallationSportive().getId());
            ps.setDate(4, new java.sql.Date(entrainment.getDate().getTime()));
            ps.setTime(5, entrainment.getDebut());
            ps.setTime(6, entrainment.getFin());
            ps.setString(7, entrainment.getTypeEntrainment().name());
            ps.executeUpdate();
            System.out.println("Entrainment has been added!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Entrainment entrainment) {
        String sql = "UPDATE entrainment SET equipe_id = ?, coach_id = ?, installationSportive_id = ?, date = ?, debut = ?, fin = ?, typeEntrainment = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, entrainment.getEquipe().getId());
            ps.setInt(2, entrainment.getCoach().getId());
            ps.setInt(3, entrainment.getInstallationSportive().getId());
            ps.setDate(4, new java.sql.Date(entrainment.getDate().getTime()));
            ps.setTime(5, entrainment.getDebut());
            ps.setTime(6, entrainment.getFin());
            ps.setString(7, entrainment.getTypeEntrainment().name());
            ps.setInt(8, entrainment.getId());
            ps.executeUpdate();
            System.out.println("Entrainment has been updated!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(Entrainment entrainment) {
        String sql = "DELETE FROM entrainment WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, entrainment.getId());
            ps.executeUpdate();
            System.out.println("Entrainment has been deleted!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Entrainment get(int id) {
        String sql = "SELECT * FROM entrainment WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Equipe equipe = new ServiceEquipe().get(rs.getInt("equipe_id"));
                    Utilisateur coach = new ServiceUtilisateur().get(rs.getInt("coach_id"));
                    InstallationSportive installationSportive = new ServiceInstallationSportive().get(rs.getInt("installationSportive_id")) ;
                    Date date = rs.getDate("date");
                    Time debut = rs.getTime("debut");
                    Time fin = rs.getTime("fin");
                    TypeEntrainment typeEntrainment = TypeEntrainment.valueOf(rs.getString("typeEntrainment"));

                    Entrainment entrainment = new Entrainment(equipe, coach, installationSportive, date, debut, fin, typeEntrainment);
                    entrainment.setId(id);
                    return entrainment;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public List<Entrainment> getAll() throws SQLException {
        List<Entrainment> entrainments = new ArrayList<>();
        String sql = "SELECT * FROM entrainment";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                Equipe equipe = new ServiceEquipe().get(rs.getInt("equipe_id"));
                Utilisateur coach = new ServiceUtilisateur().get(rs.getInt("coach_id"));
                InstallationSportive installationSportive = new ServiceInstallationSportive().get(rs.getInt("installationSportive_id")) ;
                Date date = rs.getDate("date");
                Time debut = rs.getTime("debut");
                Time fin = rs.getTime("fin");
                TypeEntrainment typeEntrainment = TypeEntrainment.valueOf(rs.getString("typeEntrainment"));

                Entrainment entrainment = new Entrainment(equipe, coach, installationSportive, date, debut, fin, typeEntrainment);
                entrainment.setId(id);
                entrainments.add(entrainment);
            }
        }
        return entrainments;

    }
}
