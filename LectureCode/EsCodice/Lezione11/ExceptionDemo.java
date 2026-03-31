package Lezione11;

// Import delle classi necessarie per leggere file e gestire eccezioni
import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("Inizio del programma.");

        // Dichiarazione della variabile fuori dal try per poterla usare nel finally
        Scanner myReader = null;
        try {
            // --- BLOCCO TRY ---
            // Qui si inserisce codice che può generare eccezioni
            File myFile = new File("inesistente.txt"); // Il file non esiste
            myReader = new Scanner(myFile); // Può lanciare FileNotFoundException

            // Se il file fosse valido, leggiamo il contenuto riga per riga
               while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
               }

            } catch (FileNotFoundException e) {
            // --- BLOCCO CATCH ---
            // Qui si gestisce l'errore in caso di eccezione
            // (checked exception → deve essere gestita obbligatoriamente)
            System.err.println("ERRORE: Il file non è stato trovato.");
             e.printStackTrace(); // (opzionale) mostra i dettagli tecnici dell'errore, utile per debug

        } finally {
            // --- BLOCCO FINALLY ---
            // Questo blocco viene SEMPRE eseguito, sia in caso di successo che di errore.
            // Serve per "pulire" le risorse aperte (es. file, connessioni, ecc.)
            System.out.println("Blocco finally eseguito.");
            if (myReader != null) {
                myReader.close(); // Chiusura del file scanner per evitare memory leak
            }
        }

        // Questo messaggio viene eseguito anche se c'è stata un’eccezione
        System.out.println("Fine del programma.");
    }
}