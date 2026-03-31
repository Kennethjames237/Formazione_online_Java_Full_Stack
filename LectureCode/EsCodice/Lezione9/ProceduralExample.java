package Lezione9;
/**
 * ESEMPIO 1 - PROGRAMMAZIONE PROCEDURALE
 * Mostra un approccio in cui dati e funzioni sono separati,
 * senza il concetto di "oggetto".
 */
public class ProceduralExample { // Definizione della classe che contiene il main (punto di ingresso)
    public static void main(String[] args) { // Metodo principale: esecuzione del programma
        // Dichiarazione di variabili indipendenti per il primo utente
        String username1 = "MarioRossi";             // Nome utente
        String email1 = "mario.rossi@example.com";   // Email
        boolean isLoggedIn1 = false;                 // Stato di accesso (inizialmente falso)

        // Dichiarazione di variabili indipendenti per il secondo utente
        String username2 = "LuigiVerdi";             // Nome utente
        String email2 = "luigi.verdi@example.com";   // Email
        boolean isLoggedIn2 = false;                 // Stato di accesso (inizialmente falso)

        // Stampa un’introduzione esplicativa
        System.out.println("=== PROGRAMMAZIONE PROCEDURALE ===");
        System.out.println("I dati di ciascun utente sono scollegati tra loro.\n");

        // Simulazione del login di Mario (aggiorna manualmente la variabile)
        isLoggedIn1 = true; // Mario ora è loggato
        System.out.println(username1 + " ha effettuato l'accesso.");

        // Simulazione del logout di Mario (di nuovo manuale)
        isLoggedIn1 = false; // Mario ora è disconnesso
        System.out.println(username1 + " ha effettuato il logout.");

        // Introduciamo un errore logico (nessun controllo di validità)
        email2 = "luigi.verdi"; // Email invalida: manca la chiocciola "@"
        System.out.println("\nEmail di " + username2 + " aggiornata manualmente a: " + email2);
        System.out.println("→ Nessun controllo: l'email è ora invalida!");

        // Conclusione didattica
        System.out.println("\nQuesto approccio è fragile: i dati possono diventare incoerenti.");
    }
}