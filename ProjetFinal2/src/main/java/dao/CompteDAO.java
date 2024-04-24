package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Compte;

public class CompteDAO {
    
    public static ArrayList<Compte> getAll() {
        ArrayList<Compte> liste = new ArrayList<>();
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM compte");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String login = rs.getString("login");
                String password = rs.getString("password");
                liste.add(new Compte(id, login, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }
    
    public static boolean existe(String login, String password) {
        boolean existe = false;
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM compte WHERE login = ? AND password = ?")) {

            ps.setString(1, login);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    existe = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existe;
    }


public static void ajouter(Compte compte) {
    try (Connection conn = DBConnection.getInstance().getConnection();
         PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (login, password) VALUES (?, ?)")) {
        
        ps.setString(1, compte.getLogin());
        ps.setString(2, compte.getPassword());
        ps.executeUpdate();
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public static void supprimer(int id) {
    try (Connection conn = DBConnection.getInstance().getConnection();
         PreparedStatement ps = conn.prepareStatement("DELETE FROM compte WHERE id = ?")) {
        
        ps.setInt(1, id);
        ps.executeUpdate();
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public static void modifier(Compte compte) {
    try (Connection conn = DBConnection.getInstance().getConnection();
         PreparedStatement ps = conn.prepareStatement("UPDATE compte SET login = ?, password = ? WHERE id = ?")) {
        
        ps.setString(1, compte.getLogin());
        ps.setString(2, compte.getPassword());
        ps.setInt(3, compte.getId());
        ps.executeUpdate();
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public static Compte getById(int id) {
    Compte compte = null;
    try (Connection conn = DBConnection.getInstance().getConnection();
         PreparedStatement ps = conn.prepareStatement("SELECT * FROM compte WHERE id = ?")) {
        
        ps.setInt(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                compte = new Compte(rs.getInt("id"), rs.getString("login"), rs.getString("password"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return compte;
}

public static Compte getByLogin(String login) {
    Compte compte = null;
    try (Connection conn = DBConnection.getInstance().getConnection();
         PreparedStatement ps = conn.prepareStatement("SELECT * FROM compte WHERE login = ?")) {
        
        ps.setString(1, login);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                compte = new Compte(rs.getInt("id"), rs.getString("login"), rs.getString("password"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return compte;
}
}
