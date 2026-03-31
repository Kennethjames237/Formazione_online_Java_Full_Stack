package Lezione8;
import java.util.Scanner;
// File: Fundamentals.java JDK

// Definiamo una classe pubblica con lo stesso nome del file
public class Fundamentals {

    // Metodo principale: punto di ingresso del programma
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1. "Hello, World!" - il programma minimale
        System.out.print("Hello, World!"); // Stampa un messaggio nella console
        System.out.print("Hello, World!");


       // 2. Variabili e tipizzazione statica forte
        int myNumber; // Una variabile intera
           myNumber =1;
        // myNumber = "ciao"; // ❌ Errore: Java non permette di cambiare tipo
      System.out.println("-----------------------------------------------");





        // 3. Tipi di dati primitivi
        byte small = 127;              // byte: da -128 a 127
        short medium = 20000;          // short: 16 bit
        int normal = 1_000_000_000;        // int: tipo intero predefinito
        long big = 12_345_678_901L;       // long: serve il suffisso L
        float piApprox = 3.140F;        // float: 32 bit, suffisso f
        double piExact = 3.1_415_926_535; // double: 64 bit
        char letter = 'A';             // char: un carattere singolo
        boolean isJavaFun = true;      // boolean: true o false
        String nome= "davide";

        System.out.println("Tipi primitivi: " + small + ", " + medium + ", " +
                normal + ", " + big + ", " + piApprox + ", " + piExact + ", " +
                letter + ", " + isJavaFun);

System.out.println("-----------------------------------------------");



   // 4. String: oggetto immutabile
        String greeting = "Ciao";
        String message = greeting + ", Mondo!"; // Crea un nuovo oggetto String
        System.out.println(message);

        // Confronto tra stringhe
        String a = new String("test");
        String b = new String("test");
        System.out.println(a == b);        // false: confronta i riferimenti
        System.out.println(a.equals(b));   // true: confronta il contenuto

System.out.println("-----------------------------------------------");


 
/*        // 5. Operatori
        int x , y;
        x=9;
        y=4;

        System.out.println("x + y = " + (x + y)); // Somma
        System.out.println("x / y = " + (x / y)); // Divisione intera → 2
        System.out.println("x % y = " + (x % y)); // Modulo → 1

        // Operatori logici
        boolean cond1 = true;
        boolean cond2 = false;
        System.out.println( (cond2 && cond1) || (cond1 && cond2)); // AND
        System.out.println("cond1 || cond2 = " + (cond1 || cond2)); // OR
        System.out.println("!cond1 = " + (!cond1)); // NOT

System.out.println("-----------------------------------------------");
*/
  /*
         //6. Strutture di controllo - if/else
        int score = 85;
        char grade;
        if (score >= 90) {
            grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else if (score >= 70) {
            grade = 'C';
        } else {
            grade = 'F';
        }
        System.out.println("Il tuo voto è: " + grade);

System.out.println("-----------------------------------------------");
        int numero = 10;

        if (numero > 5) {
            System.out.println("Il numero è maggiore di 5");
        }

        int numero = 3;

        if (numero > 5) {
            System.out.println("Maggiore di 5");
        } else {
            System.out.println("Minore o uguale a 5");
        }
System.out.println("-----------------------------------------------");
        int eta = 20;
        boolean haPatente = true;

        if (eta >= 18) {
            if (haPatente) {
                System.out.println("Puoi guidare");
            } else {
                System.out.println("Hai l'età, ma non la patente");
            }
        } else {
            System.out.println("Sei troppo giovane per guidare");
        }
System.out.println("-----------------------------------------------");
        int eta = 25;
        boolean haPatente = true;

        if (eta >= 18 && haPatente) {
            System.out.println("Puoi guidare");
        }

        if (eta < 18 || !haPatente) {
            System.out.println("Non puoi guidare");
        }
        int numero = 10;
        String risultato = (numero % 2 == 0) ? "Pari" : "Dispari";
        System.out.println(risultato);
System.out.println("-----------------------------------------------");
        void stampaPositivo(int numero) {
            if (numero <= 0) {
                System.out.println("Numero non valido");
                return; // esce dal metodo
            }

            System.out.println("Numero positivo: " + numero);
        }
System.out.println("-----------------------------------------------");
        if (numero > 0)
            System.out.println("Positivo");
        else
            System.out.println("Negativo o zero");
System.out.println("-----------------------------------------------");
        boolean attivo = true;

        if (attivo) {
            System.out.println("Il sistema è attivo");
        }

        if (!attivo) {
            System.out.println("Il sistema è inattivo");
        }
        System.out.println("-----------------------------------------------");
/*

   /*
        // 7. Struttura switch classica
        int dayOfWeek = 3;
        String dayName;
        switch (dayOfWeek) {
            case 1:
                dayName = "Lunedì";
                break; // senza break → fall-through
            case 2:
                dayName = "Martedì";
                break;
            case 3:
                dayName = "Mercoledì";
                break;
            case 4:
                dayName = "Giovedì";
                break;
            case 5:
                dayName = "Venerdì";
                break;
            default:
                dayName = "Weekend";
                break;
        }
        System.out.println("Giorno classico: " + dayName);
       System.out.println("-----------------------------------------------");


 */
     /*   // 8. Struttura switch moderna (Java 14+)
        String dayNameModern = switch (dayOfWeek) {
            case 1 -> "Lunedì";
            case 2 -> "Martedì";
            case 3 -> "Mercoledì";
            case 4 -> "Giovedì";
            case 5 -> "Venerdì";
            default -> "Weekend";
        };
        System.out.println("Giorno moderno: " + dayNameModern);
         System.out.println("-----------------------------------------------");
       */

/*
        // --- 2. Esempio base: leggere un numero ---
        System.out.print("Inserisci un numero intero: ");
        int myNumber = scanner.nextInt(); // Legge un intero dalla tastiera
        System.out.println("Hai inserito: " + myNumber);
System.out.println("-----------------------------------------------");

        // --- 3. Esempio con stringhe ---
        System.out.print("Come ti chiami? ");
        scanner.nextLine(); // ⚠️ serve per “consumare” il newline rimasto dal nextInt()
        String name = scanner.nextLine(); // Legge una riga di testo
        System.out.println("Ciao, " + name + "!");

System.out.println("-----------------------------------------------");
 */

/*
   // --- 4. Esempio di condizione con input ---
        System.out.print("Inserisci la tua età: ");
        int age = scanner.nextInt();

        if (age >= 18) {
            System.out.println("Sei maggiorenne ✅");
        } else {
            System.out.println("Sei minorenne 🚫");
        }

System.out.println("-----------------------------------------------");
 */

        /*
       // --- 5. Esempio con switch (giorni della settimana) ---
        System.out.print("Inserisci un numero da 1 a 7 per il giorno della settimana: ");
        int dayOfWeek = scanner.nextInt();

        String dayName;
        switch (dayOfWeek) {
            case 1 -> dayName = "Lunedì";
            case 2 -> dayName = "Martedì";
            case 3 -> dayName = "Mercoledì";
            case 4 -> dayName = "Giovedì";
            case 5 -> dayName = "Venerdì";
            case 6 -> dayName = "Sabato";
            case 7 -> dayName = "Domenica";
            default -> dayName = "Numero non valido!";
        }
        System.out.println("Hai scelto: " + dayName);

System.out.println("-----------------------------------------------");

         */

 /*       // --- 6. Esempio con ciclo e Scanner ---
        System.out.println("\nOra inserisci 5 numeri (uno per riga):");
        int somma = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.print("Numero " + i + ": ");
            int n = scanner.nextInt();
            somma += n;
        }
        System.out.println("La somma dei numeri è: " + somma);

System.out.println("-----------------------------------------------");

  */
     /*   // --- 7. Esempio bonus: scelta con stringhe ---
        scanner.nextLine(); // pulizia buffer
        System.out.print("\nInserisci la tua materia preferita: ");
        String subject = scanner.nextLine();

        switch (subject.toLowerCase()) {
            case "matematica" -> System.out.println("Ti piacciono i numeri!");
            case "storia" -> System.out.println("Ami il passato!");
            case "informatica" -> System.out.println("Adori il codice 💻");
            default -> System.out.println("Materia interessante!");
        }
        System.out.println("-----------------------------------------------");


      */
// --- 8. Chiusura dello scanner ---
        scanner.close(); // chiudi sempre lo Scanner per liberare risorse

    }

}