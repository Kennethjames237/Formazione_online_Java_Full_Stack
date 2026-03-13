import java.util.Scanner;
import java.util.Random;
public class Blocco2 {
    public static void main(String[] args) {
        System.out.println("----Blocco Ciclo while-------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------Stampa numeri da 10 a 1--------------------------------");
        int number = 10;
        while (number >= 1) {
            System.out.print(number + " ");
            number--;
        }
        System.out.println();
        System.out.println("------------------------Somma numeri finché l’utente vuole--------------------------------");
        int sum = 0;
        while (true) {
            System.out.print("Inerisci un valore da sommare(In caso di terminazione inserisci 0): ");
            if(sc.hasNextInt()) {
                int n = sc.nextInt();
                if (n == 0) {
                    break;
                } else {
                    sum += n;
                }
                System.out.println();
            }
        }
        System.out.println("la somma è: " + sum);
        System.out.println("------------------------Validazione input positivo-------------------------------");
        while(true) {
            System.out.print("inserisci un valore positivo: ");
            int num = sc.nextInt();
            if(num >= 0) {
                break;
            }
        }
        System.out.println("------------------------Conta numeri negativi-------------------------------");
        int [] A = new int[10];
        int i = 0;
        System.out.println("Inserisci 10 numeri");
        while(i < 10){
            System.out.print("inserisci il "+ i + " numero: ");
            A[i] = sc.nextInt();
            i++;
        }
        int j = 0;
        System.out.println("i valori negativi sono: ");
        while(j < 10){
            if(A[j] < 0 ){
                System.out.print(A[j] + " ");
            }
            j++;
        }

        sc.close();
    }
}
