import java.util.Scanner;

public class Blocco1 {
    public static void main(String[] args) {
        System.out.println("------------Esercizio 1 - 5 ----------------------------------------");
    Scanner sc = new Scanner(System.in);

       /* System.out.print("Inserisci un numero: ");
        int num = sc.nextInt();
        System.out.println();

        */

        System.out.println("-----------------------1) stapa numeri da 1 a 20------------------------------------------");
        for(int i = 1; i <= 20; i++){
            System.out.println("Valore: "+ i);
        }
        System.out.println("----------------------2) Numeri pari da 2 a 50--------------------------------");

        System.out.print("i valori pari sono: ");
        for(int i = 2; i <= 50; i++){
            if( (i % 2) == 0){
                System.out.print( i + " ");
            }
        }
        System.out.println();
        System.out.println("----------------------3)Somma numeri da 1 a 100 --------------------------------");
        int sum = 0;
        for(int i = 1 ; i <= 100 ; i++){
          sum += i;
        }
        System.out.println("La somma è: "+ sum);
        System.out.println("----------------------2) Tabellina di un numero in input--------------------------------");
        System.out.print("Inserice un numero: ");
        int n = sc.nextInt();
        System.out.println();
        for(int i = 1 ; i <= 10 ; i++ ){
            System.out.println(n + " * " + i + " = " + n*i);
        }
        System.out.println("----------------------2) Controllo divisibilità--------------------------------");
        System.out.print("Inserisci un numero per vedere la divisibilità ");
        int m = sc.nextInt();
        System.out.println();
        System.out.print("Valori divisibili per  " + m + " sono : ");
        for(int i=1; i<=100; i++){
            if((i % m) == 0){
                System.out.print(i + " ");
            }
        }


        sc.close();
    }
}