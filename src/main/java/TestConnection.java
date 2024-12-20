import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        // Paramètres de connexion
        String url = "jdbc:sqlserver://localhost:1433;databaseName=gestionContact;encrypt=true;trustServerCertificate=true";
        String user = "";  // 
        String password = "votre_mot_de_passe";  // Remplacez par votre mot de passe SQL Server

        // Test de la connexion
        try {
            // Charger le pilote JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Établir la connexion
            Connection conn = DriverManager.getConnection(url, user, password);

            // Si connexion réussie
            if (conn != null) {
                System.out.println("Connexion à la base de données réussie !");
                conn.close();  // Fermer la connexion
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Pilote JDBC introuvable !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Échec de la connexion à la base de données !");
            e.printStackTrace();
        }
    }
}
