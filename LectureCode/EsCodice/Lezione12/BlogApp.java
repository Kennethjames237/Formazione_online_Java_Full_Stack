package Lezione12;

import java.sql.*;
import java.lang.Throwable;
public class BlogApp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/blogdb";
        String user = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Query: recupera articoli con autore
            String query = """
                SELECT a.titolo, au.nome
                FROM articoli a
                JOIN autori au ON a.autore_fk = au.autore_id
            """;

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    System.out.println(rs.getString("titolo") +
                            " - scritto da " +
                            rs.getString("nome"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
