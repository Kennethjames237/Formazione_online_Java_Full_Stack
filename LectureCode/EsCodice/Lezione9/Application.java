package Lezione9; // Package coerente con gli altri file

/**
 * ESEMPIO 3 - DAL PROCEDURALE ALL’OOP
 * Qui si mostra l’uso pratico della classe User.
 * Ogni oggetto gestisce il proprio stato e comportamento.
 */
public class Application {
    public static void main(String[] args) { // Metodo principale di esecuzione
        System.out.println("=== PROGRAMMAZIONE ORIENTATA AGLI OGGETTI ===\n");

        // Creiamo due oggetti User (istanze distinte della stessa classe)
        User user1 = new User("MarioRossi", "mario.rossi@example.com"); // Invoca il costruttore
        User user2  = new User("LuigiVerdi", "luigi.verdi@example.com"); // Secondo oggetto indipendente
        User user3= new User("Paolo Bianchi","paolo@examole.com");
        User user4= new User("Paolo Bianchi", "paolo@examole.com");
        // Ogni utente può eseguire operazioni sul proprio stato
        user1.login();  // Cambia lo stato interno di user1
        user2.login();  // Cambia lo stato interno di user2
        user1.logout(); // Solo user1 effettua il logout → user2 resta loggato
  user2.logout();
  user4.login();

  user3.setEmail("udgfyerg@yweugrf");
        // Controlliamo lo stato dei due utenti tramite i getter
        System.out.println("\nVerifica stato:");
        System.out.println(user1.getUsername() + " è loggato? " + user1.isLoggedIn()); // False
        System.out.println(user2.getUsername() + " è loggato? " + user2.isLoggedIn()); // True

        // Proviamo a impostare un’email errata per user2
        System.out.println("\nTentativo di modificare l’email con un valore non valido...");
        user2.setEmail("luigi.verdi"); // Il setter rifiuta l’email (assenza di "@")

        // Controlliamo che l'oggetto mantenga la coerenza dei dati
        System.out.println("\nI dati restano coerenti: l'oggetto ha rifiutato un valore errato.");
        System.out.println("Email attuale di " + user2.getUsername() + ": " + user2.getEmail());

        // Conclusione concettuale
        System.out.println("\nOgni oggetto è una piccola 'unità autonoma' con regole proprie.");
        System.out.println("Questo è il cuore della programmazione orientata agli oggetti.");
    }
}
