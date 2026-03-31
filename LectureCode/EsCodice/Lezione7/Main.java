package Lezione7;

// File: Main.java

// Importiamo le librerie standard di Java necessarie
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        // --- 1. Decomposizione del Problema ---
        // Vogliamo gestire utenti in un sistema:
        // - Creare un nuovo utente
        // - Recuperare utenti dal database

        // --- 2. Connessione al Database ---
        // Stringa di connessione JDBC (Java Database Connectivity)
        // Nota: in un ambiente reale, user, password e URL vengono esternalizzati
        String url = "jdbc:mysql://localhost:3306/miodb";
        String user = "root";
        String password = "password";

        try {
            // Stabilisco la connessione con il database MySQL
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connessione riuscita al database!");

            // --- 3. Creazione di un Utente (Persistenza dei dati) ---
            String insertQuery = "INSERT INTO utenti (nome, email) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insertQuery);
            stmt.setString(1, "Mario Rossi");      // Parametro 1 = nome
            stmt.setString(2, "mario@example.com");// Parametro 2 = email
            stmt.executeUpdate(); // Esegue l’inserimento
            System.out.println("👤 Utente inserito con successo!");

            // --- 4. Recupero Dati (Algoritmo CRUD - Read) ---
            String selectQuery = "SELECT * FROM utenti";
            ResultSet rs = conn.createStatement().executeQuery(selectQuery);

            System.out.println("\n📋 Lista utenti:");
            while (rs.next()) { // Iteriamo riga per riga sui record
                // Riconoscimento di Pattern: stessa logica usata per ogni riga
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                System.out.println("ID: " + id + " | Nome: " + nome + " | Email: " + email);
            }

            conn.close(); // Chiudiamo la connessione
        } catch (Exception e) {
            // Se qualcosa va storto, catturiamo l’eccezione e stampiamo un errore
            System.err.println("❌ Errore: " + e.getMessage());
        }
    }
}
