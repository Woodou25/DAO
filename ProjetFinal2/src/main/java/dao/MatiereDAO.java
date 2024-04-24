package dao;

import model.Matiere;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatiereDAO {

    public List<Matiere> getAllMatieres() {
        List<Matiere> matieres = new ArrayList<>();
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM matiere")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                matieres.add(new Matiere(rs.getString("nom")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matieres;
    }

    public void ajouterMatiere(Matiere matiere) {
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO matiere (nom) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, matiere.getNom());
            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating matiere failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    matiere.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating matiere failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierMatiere(int id, String nom) {
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE matiere SET nom = ? WHERE id = ?")) {
            ps.setString(1, nom);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerMatiere(int id) {
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM matiere WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Matiere obtenirMatiereById(int id) {
        Matiere matiere = null;
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM matiere WHERE id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                matiere = new Matiere(rs.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matiere;
    }
}
