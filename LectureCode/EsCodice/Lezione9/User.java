package Lezione9;

/**
 * ESEMPIO 2 - PROGRAMMAZIONE ORIENTATA AGLI OGGETTI
 * Qui definiamo un "modello" (classe) che rappresenta un utente.
 * La classe racchiude (incapsula) dati e comportamenti.
 */
public class User { // Definizione della classe User

    // --- CAMPI PRIVATI: rappresentano lo stato interno dell'oggetto ---
    private String username;   // Nome dell’utente
    private String email;      // Email (con validazione)
    private boolean isLoggedIn; // Stato di accesso (vero/falso)



    // --- COSTRUTTORE ---
    // Viene invocato automaticamente quando si crea un nuovo oggetto User
    public User(String username, String email) {
        this.username = username;
        this.setEmail(email);
        this.isLoggedIn = false;
    }
    public User(){

    }
    // --- GETTER: metodi pubbl   public User(String username, String email) {
    //        System.out.println("Costruttore invocato → Creazione utente: " + username);
    //        this.username = username; // "this" indica che stiamo accedendo al campo dell'istanza corrente
    //        this.setEmail(email);     // Usiamo il setter per applicare la validazione dell'email
    //        this.isLoggedIn = false;  // Tutti gli utenti nascono disconnessi
    //    }ici che permettono di leggere i dati privati ---
    public String getUsername() { // Restituisce il nome dell’utente
        return this.username;     // "this" è facoltativo ma aumenta la chiarezza
    }

    public String getEmail() {    // Restituisce l'email dell'utente
        return this.email;
    }

    public boolean isLoggedIn() { // Restituisce lo stato di accesso (convenzionalmente "is" per boolean)
        return this.isLoggedIn;
    }

    // --- SETTER: metodi pubblici per modificare i campi privati in modo controllato ---
    public void setEmail(String email) {
        // Validazione di base: l’email deve contenere il simbolo "@"
        if (email != null && email.contains("@")) {
            this.email = email; // Se valida, aggiorna il campo
        } else {
            System.out.println(" Errore: formato email non valido per " + this.username);
        }
    }

    // --- METODI DI COMPORTAMENTO ---
    // Questi metodi rappresentano ciò che un utente "può fare"
    public void login() {
        this.isLoggedIn = true; // Cambia lo stato interno dell’oggetto
        System.out.println(this.username + " ha effettuato l'accesso.");
    }

    public void logout() {
        this.isLoggedIn = false; // Aggiorna lo stato interno
        System.out.println(this.username + " ha effettuato il logout.");
    }
}