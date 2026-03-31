package Lezione16;

import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;

/**
 * ============================================================================
 * LEZIONE 16 — JDBC: DALL’ARCHITETTURA ALLA SICUREZZA
 * ============================================================================
 * Questo programma dimostra le principali operazioni JDBC:
 * - Connessione a un database MySQL
 * - Creazione di una tabella
 * - Inserimento (con Statement e PreparedStatement)
 * - Lettura (SELECT)
 * - Aggiornamento (UPDATE)
 * - Cancellazione (DELETE)
 *
 * Include anche gestione centralizzata delle eccezioni e caricamento
 * dei parametri di connessione da file di configurazione.
 */
public class JdbcDemo {

    /**
     * Configurazione centralizzata: percorso del file contenente i parametri di connessione.
     * In un’applicazione reale, il file "db.properties" si troverebbe nella root del progetto.
     */
    private static final String PROPERTIES_PATH = "db.properties";

    // Variabili per URL, username e password del database
    private static String dbUrl;
    private static String dbUser;
    private static String dbPassword;

    // ========================================================================
    // BLOCCO DI INIZIALIZZAZIONE STATICO
    // ========================================================================
    // Questo blocco viene eseguito automaticamente una sola volta
    // quando la classe viene caricata in memoria.
    // Serve per leggere i parametri di connessione dal file di configurazione.
    static {
        try {
            // 1. Creazione di un oggetto Properties per leggere coppie chiave=valore
            Properties props = new Properties();

            // 2. Carica i dati dal file specificato
            props.load(new FileInputStream(PROPERTIES_PATH));
            // 3. Legge le singole proprietà (chiavi definite nel file)
            dbUrl = props.getProperty("db.url");
            dbUser = props.getProperty("db.user");
            dbPassword = props.getProperty("db.password");

            System.out.println(" Parametri caricati da file di configurazione.");
        } catch (Exception e) {
            // Se il file non esiste o non è leggibile, usa valori di default
            System.err.println(" Impossibile caricare db.properties, uso valori di default.");
            dbUrl = "jdbc:mysql://localhost:3306/blogdb";
            dbUser = "root";
            dbPassword = "";
        }
    }

    // ========================================================================
    // MAIN: punto di partenza del programma
    // ========================================================================
    public static void main(String[] args) {
        System.out.println("=== DEMO JDBC ===");

        // Istanzia la classe per usare i suoi metodi
        JdbcDemo demo = new JdbcDemo();

        // Esegue una serie di operazioni JDBC in sequenza

        demo.testConnection();                             // Verifica la connessione
        demo.createTableAutori();                           // Crea la tabella se non esiste
        demo.insertAutore("Ada", "ada@x.com");              // Inserimento NON sicuro (Statement)
        demo.insertAutoreSafe("O'Connor", "oconnor@example.com"); // Inserimento sicuro (PreparedStatement)
        demo.printAutori();                                 // Stampa i dati
        demo.updateEmail(1, "ada@newmail.com");             // Aggiorna una riga
        demo.deleteAutore(3);                               // Elimina una riga
    }

    // ========================================================================
    //  ESEMPIO DI CONNESSIONE JDBC
    // ========================================================================
    public void testConnection() {
        // try-with-resources: chiude automaticamente la connessione al termine del blocco
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {

            // Verifica che la connessione sia effettivamente aperta
            if (!conn.isClosed()) {
                System.out.println(" Connessione riuscita al database.");
            }

            // Ottiene informazioni sul driver JDBC usato
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println("Driver: " + meta.getDriverName() +
                    " v" + meta.getDriverVersion());

        } catch (SQLException e) {
            // Gestione di eventuali errori di connessione
            System.err.println(" Errore di connessione: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
        }
    }

    // ========================================================================
    //  CREAZIONE DELLA TABELLA
    // ========================================================================
    public void createTableAutori() {
        // SQL per creare la tabella se non esiste già
        String sql = """
            CREATE TABLE IF NOT EXISTS autori (
                autore_id INT AUTO_INCREMENT PRIMARY KEY,
                nome VARCHAR(100),
                email VARCHAR(100)
            )
        """;

        // Apertura connessione + creazione di uno Statement per eseguire comandi statici
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             Statement stmt = conn.createStatement()) {

            // Esegue l’istruzione SQL (CREATE TABLE)
            stmt.executeUpdate(sql);
            System.out.println(" Tabella 'autori' creata (se non esiste).");

        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    // ========================================================================
    //  INSERIMENTO BASE con Statement (ESEMPIO VULNERABILE)
    // ========================================================================
    public void insertAutore(String nome, String email) {
        // ESEMPIO INSCURO: la concatenazione diretta dei valori
        // può portare a SQL injection se l'input contiene caratteri speciali.
        String sql = "INSERT INTO autori(nome, email) VALUES ('" + nome + "', '" + email + "')";
        System.out.println("Esecuzione query (potenzialmente vulnerabile): " + sql);

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             Statement stmt = conn.createStatement()) {

            // Esecuzione dell'inserimento
            stmt.executeUpdate(sql);
            System.out.println(" Autore inserito con successo.");

        } catch (SQLException e) {
            // Mostra errore, utile per comprendere i rischi dell'injection
            System.err.println(" Errore SQL (dimostrazione rischio injection): " + e.getMessage());
        }
    }

    // ========================================================================
    //  INSERIMENTO SICURO con PreparedStatement
    // ========================================================================
    public void insertAutoreSafe(String nome, String email) {
        // SQL con parametri segnaposto (?)
        String sql = "INSERT INTO autori(nome, email) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             // PreparedStatement precompila la query e permette di passare i valori in modo sicuro
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Imposta i parametri (1° e 2° segnaposto)
            pstmt.setString(1, nome);
            pstmt.setString(2, email);

            // Esegue l’inserimento
            pstmt.executeUpdate();

            System.out.println(" Inserimento sicuro effettuato per: " + nome);

        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    // ========================================================================
    //  LETTURA DATI (SELECT)
    // ========================================================================
    public void printAutori() {
        String sql = "SELECT * FROM autori";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             Statement stmt = conn.createStatement();
             // Esegue la query e ottiene i risultati in un ResultSet
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("--- Elenco Autori ---");

            // Scorre tutte le righe del risultato
            while (rs.next()) {
                // Estrae i valori delle colonne per ciascun record
                int id = rs.getInt("autore_id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");

                // Stampa in formato leggibile
                System.out.printf("ID: %d | Nome: %s | Email: %s%n", id, nome, email);
            }

        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    // ========================================================================
    // UPDATE e DELETE (operazioni di modifica e cancellazione)
    // ========================================================================
    public void updateEmail(String nuovaEmail, int autoreId) {
        String sql = "UPDATE autori SET email=? WHERE autore_id=?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Imposta i parametri (nuova email e id)
            pstmt.setString(1, nuovaEmail);
            pstmt.setInt(2, autoreId);

            // Esegue l’aggiornamento e ritorna il numero di righe modificate
            int rows = pstmt.executeUpdate();

            System.out.println(" Email aggiornata (" + rows + " riga/e).");

        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    public void deleteAutore(int autoreId) {
        String sql = "DELETE FROM autori WHERE autore_id=?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Imposta il parametro (id dell’autore da eliminare)
            pstmt.setInt(1, autoreId);

            // Esegue la cancellazione
            int rows = pstmt.executeUpdate();

            System.out.println("  Autore eliminato (" + rows + " riga/e).");

        } catch (SQLException e) {
            handleSQLException(e);
        }
    }

    // ========================================================================
    //  GESTIONE CENTRALIZZATA DELLE ECCEZIONI SQL
    // ========================================================================
    // Questo metodo stampa informazioni utili per il debug:
    // - messaggio descrittivo
    // - codice di errore del database
    // - SQLState standardizzato
    private void handleSQLException(SQLException e) {
        System.err.println(" Errore SQL: " + e.getMessage());
        System.err.println("Codice: " + e.getErrorCode());
        System.err.println("SQLState: " + e.getSQLState());
    }
}