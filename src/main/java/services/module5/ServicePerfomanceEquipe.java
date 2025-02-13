package services.module5;

import entities.module1.Equipe;
import entities.module5.PerformanceEquipe;
import entities.module5.Tournois;
import services.BaseService;
import services.IService;
import services.module1.ServiceEquipe;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServicePerfomanceEquipe extends BaseService implements IService<PerformanceEquipe> {
    @Override
    public void add(PerformanceEquipe performanceEquipe) throws SQLException {
        String sql = "INSERT INTO performanceequipe(equipe_id, tournois_id, victoires, pertes, rang) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, performanceEquipe.getEquipe().getId());
            ps.setInt(2, performanceEquipe.getTournois().getId());
            ps.setInt(3, performanceEquipe.getVictoires());
            ps.setInt(4, performanceEquipe.getPertes());
            ps.setInt(5, performanceEquipe.getRang());
            ps.executeUpdate();
            System.out.println("PerformanceEquipe has been added!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(PerformanceEquipe performanceEquipe) {
        String sql = "UPDATE performanceequipe SET equipe_id = ?, tournois_id = ?, victoires = ?, pertes = ?, rang = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, performanceEquipe.getEquipe().getId());
            ps.setInt(2, performanceEquipe.getTournois().getId());
            ps.setInt(3, performanceEquipe.getVictoires());
            ps.setInt(4, performanceEquipe.getPertes());
            ps.setInt(5, performanceEquipe.getRang());
            ps.setInt(6, performanceEquipe.getId());
            ps.executeUpdate();
            System.out.println("PerformanceEquipe has been updated!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(PerformanceEquipe performanceEquipe) {
        String sql = "DELETE FROM performanceequipe WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, performanceEquipe.getId());
            ps.executeUpdate();
            System.out.println("PerformanceEquipe has been deleted!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public PerformanceEquipe get(int id) {
        String sql = "SELECT * FROM performanceequipe WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Equipe equipe = new ServiceEquipe().get(rs.getInt("equipe_id"));
                    Tournois tournois = new ServiceTournois().get(rs.getInt("tournois_id"));
                    int victoires = rs.getInt("victoires");
                    int pertes = rs.getInt("pertes");
                    int rang = rs.getInt("rang");

                    PerformanceEquipe performanceEquipe = new PerformanceEquipe(equipe, victoires, pertes, rang, tournois);
                    performanceEquipe.setId(id);
                    return performanceEquipe;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    @Override
    public List<PerformanceEquipe> getAll() throws SQLException {
        List<PerformanceEquipe> performanceEquipeList = new ArrayList<>();
        String sql = "SELECT * FROM performanceequipe";
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                Equipe equipe = new ServiceEquipe().get(rs.getInt("equipe_id"));
                Tournois tournois = new ServiceTournois().get(rs.getInt("tournois_id"));
                int victoires = rs.getInt("victoires");
                int pertes = rs.getInt("pertes");
                int rang = rs.getInt("rang");

                PerformanceEquipe performanceEquipe = new PerformanceEquipe(equipe, victoires, pertes, rang, tournois);
                performanceEquipe.setId(id);
                performanceEquipeList.add(performanceEquipe);
            }
        }
        return performanceEquipeList;

    }
}
