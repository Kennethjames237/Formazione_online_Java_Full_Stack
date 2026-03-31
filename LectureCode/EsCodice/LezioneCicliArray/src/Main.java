import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Stampa dei numeri da 1 a 10 utilizzando un ciclo for
        // Struttura: for (inizializzazione; condizione; incremento)
        for (int i = 1; i <= 10; i++) {
            System.out.println("Numero: " + i);


            // Note:
            // - int i = 1 -> variabile di controllo inizializzata
            // - i <= 10 -> condizione da verificare a ogni ciclo
            // - i++ -> incremento di 1 dopo ogni iterazione
        }
        System.out.println("---------------------------------------------");
        String risposta = "";

        // Il ciclo continua fino a quando l'utente non digita "esci"
        while (!risposta.equalsIgnoreCase("esci")) {
            System.out.print("Digita qualcosa (o 'esci' per terminare): ");
            risposta = input.nextLine();
        }

        System.out.println("Ciclo terminato!");

        System.out.println("---------------------------------------------");

        int numero;

        // Il corpo viene eseguito almeno una volta prima di controllare la condizione
        do {
            System.out.print("Inserisci un numero positivo: ");
            numero = input.nextInt();
        } while (numero <= 0);
        System.out.println("Hai inserito un numero valido: " + numero);



        System.out.println("---------------------------------------------");

        int[] numeri = {10, 20, 30, 40, 50};

        // Il ciclo for-each scorre tutti gli elementi dell'array
        for (int n : numeri) {
            System.out.println("Valore: " + n);

// Non abbiamo bisogno di usare un indice (come numeri[i])
            // Più leggibile, ma non permette di modificare direttamente gli elementi
        }
        System.out.println("---------------------------------------------");

        int[] numeri1 = new int[5];

        // Assegnazione dei valori
        numeri1[0] = 10;
        numeri1[1] = 20;
        numeri1[2] = 30;
        numeri1[3] = 40;
        numeri1[4] = 50;

        // Stampa dei valori con ciclo for
        for (int i = 0; i < numeri1.length; i++) {
            System.out.println("Elemento in posizione " + i + ": " + numeri1[i]);

        }

        // Note:
        // - numeri.length restituisce la lunghezza dell’array
        // - gli indici partono da 0 fino a length - 1

        System.out.println("---------------------------------------------");
        // Creazione e inizializzazione di una matrice 3x4
        int[][] matrice = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        // Stampa della matrice con due cicli annidati
        for (int i = 0; i < matrice.length; i++) {          // Scorre le righe
            for (int j = 0; j < matrice[i].length; j++) {   // Scorre le colonne
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println(); // A capo dopo ogni riga
        }
        System.out.println("---------------------------------------------");
        int[][] matrice2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int somma = 0;

        for (int i = 0; i < matrice2.length; i++) {
            for (int j = 0; j < matrice2[i].length; j++) {
                somma += matrice2[i][j];
            }
        }

        System.out.println("Somma totale: " + somma);
        System.out.println("---------------------------------------------");
        int[][] matrice3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}

        };

        System.out.println("Diagonale principale:");
        for (int i = 0; i < matrice3.length; i++) {
            System.out.println(matrice3[i][i]);
        }
        System.out.println("---------------------------------------------");
        int[][] matrice4 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int righe = matrice4.length;          // 2 righe
        int colonne = matrice4[0].length;     // 3 colonne

        int[][] trasposta = new int[colonne][righe]; // Invertiamo dimensioni


        // Ciclo doppio per invertire righe e colonne
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                trasposta[j][i] = matrice4[i][j];
            }
        }

        // Stampa della matrice trasposta
        System.out.println("Matrice trasposta:");
        for (int i = 0; i < trasposta.length; i++) {
            for (int j = 0; j < trasposta[i].length; j++) {
                System.out.print(trasposta[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------");

        double[] voti = new double[5];
        double somma1 = 0;

        // Inserimento voti con ciclo for
        for (int i = 0; i < voti.length; i++) {
            System.out.print("Inserisci il voto " + (i + 1) + ": ");
            voti[i] = input.nextDouble();
            somma1 += voti[i];
        }

        double media = somma1 / voti.length;

        System.out.println("Media dei voti: " + media);
        input.close();
    }
}