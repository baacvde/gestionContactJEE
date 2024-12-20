package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactModel {

    private static final String URL = "jdbc:sqlserver://joob\\SQLEXPRESS;databaseName=gestionContact;encrypt=false";
    private static final String USER = "jooba";
    private static final String PASSWORD = "JOOBA1234@";

    // Ajouter un contact
    public boolean ajouterContact(String nom, String prenom, String email, String telephone, int age) {
        String query = "INSERT INTO contact (nom, prenom, email, telephone, age) VALUES (?, ?, ?, ?, ?)";
        try {
            // Charger le driver JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, nom);
                stmt.setString(2, prenom);
                stmt.setString(3, email);
                stmt.setString(4, telephone);
                stmt.setInt(5, age);
                return stmt.executeUpdate() > 0;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lire les contacts
    public static List<String[]> afficherContact() {
        List<String[]> contacts = new ArrayList<>();
        String query = "SELECT * FROM contact";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    String[] contact = {
                            String.valueOf(rs.getInt("id_contact")),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("email"),
                            rs.getString("telephone"),
                            String.valueOf(rs.getInt("age"))
                    };
                    System.out.println("Contact récupéré : " + Arrays.toString(contact)); 
                    contacts.add(contact);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Liste complète des contacts : " + contacts);
        return contacts;
    }


    // Mettre à jour un contact
    public boolean modifierContact(int id, String nom, String prenom, String email, String telephone, int age) {
        String query = "UPDATE contact SET nom = ?, prenom = ?, email = ?, telephone = ?, age = ? WHERE id_contact = ?";
        try {
            // Charger le driver JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, nom);
                stmt.setString(2, prenom);
                stmt.setString(3, email);
                stmt.setString(4, telephone);
                stmt.setInt(5, age);
                stmt.setInt(6, id);
                return stmt.executeUpdate() > 0;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Supprimer un contact
    public boolean supprimerContact(int id) {
        String query = "DELETE FROM contact WHERE id_contact = ?";
        try {
            // Charger le driver JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, id);
                return stmt.executeUpdate() > 0;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
