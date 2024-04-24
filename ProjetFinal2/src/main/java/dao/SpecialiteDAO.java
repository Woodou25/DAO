package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpecialiteDAO {

    public void addSpecialite(int idCompte, int idMatiere) {
        String sql = "INSERT INTO specialite (idcompte, idmatiere) VALUES (?, ?)";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCompte);
            ps.setInt(2, idMatiere);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSpecialite(int idCompte, int idMatiere) {
        String sql = "DELETE FROM specialite WHERE idcompte = ? AND idmatiere = ?";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCompte);
            ps.setInt(2, idMatiere);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> getSpecialitesByCompte(int idCompte) {
        List<Integer> idMatieres = new ArrayList<>();
        String sql = "SELECT idmatiere FROM specialite WHERE idcompte = ?";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCompte);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    idMatieres.add(rs.getInt("idmatiere"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idMatieres;
    }

    public boolean exists(int idCompte, int idMatiere) {
        boolean exists = false;
        String sql = "SELECT 1 FROM specialite WHERE idcompte = ? AND idmatiere = ?";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCompte);
            ps.setInt(2, idMatiere);
            try (ResultSet rs = ps.executeQuery()) {
                exists = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }
}
