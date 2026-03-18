import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main2 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.println("===================================Esercizi sulla Gestione delle Eccezioni============================================");
        /*
        System.out.println("===================================Gestione della divisione per zero===================================================");
        System.out.println();
        System.out.print("Inserisci il primo numero: ");
        int first = input.nextInt();
        System.out.println();
        System.out.print("Inserisce il secondo numero: ");
        int second = input.nextInt();
        int out;
        try{
             out = first / second;
        }catch(ArithmeticException e){
            System.err.println("il secondo numero non può essere zero(0)");
        }
        System.out.println();
        System.out.println("===================================Conversione di input errato============================================");
        System.out.print("Inserisce un numero intero: ");
        try{
            int num = input.nextInt();

        }catch (InputMismatchException f){
            System.err.println("L'input non è un numero. :( ");
        }

        System.out.println();
        /*
        System.out.println("===================================Accesso a indice non valido============================================");
        int [] arr = new int[3];
        arr[0]=1;
        arr[1]=2;
        arr[2]=3;

        int num2 = input.nextInt();
        try{
            System.out.println("l'indice valore è: " + arr[num2]);
        }catch (ArrayIndexOutOfBoundsException r){
            System.err.println("L'indice non è valido");
        }

         */

        System.out.println("==========================================FileNotFoundException================================================");
        try{

            File file = new File("/Users/nnaminkoussekennethjames/Desktop/Java_formation/exercises/E5/src/example.txt");
        Scanner reader = new Scanner(file);

            while(reader.hasNextLine()){
                int Line = reader.nextInt();
                System.out.println(Line);
            }
        }catch(FileNotFoundException b){
            System.err.println("Il file non esiste.");
        }






    }
}
