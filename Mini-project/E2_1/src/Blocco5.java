import java.util.Scanner;

public class Blocco5 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------21) Inserimento numeri con Scanner-----------------------------------");
        int [] A = new int[5];
        System.out.println("Inserisci 5 numeri: ");
        for(int i = 0 ; i < A.length; i++){
            A[i] = input.nextInt();
        }
        System.out.print("i numeri sono: ");
        for (int n : A){
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("----------------------------22) Massimo e minimo in array-----------------------------------");
        int max = A[0];
        int min = A[0];
        //max
        for (int n : A){
            if(max < n){
                max = n;
            }
            if(min > n){
                min = n;
            }
        }
        System.out.println("Il valore massimo è: " + max);
        System.out.println("Il valore minimo è: " + min);
        System.out.println("----------------------------23) Media dei numeri-----------------------------------");
        int sum = 0;
        for (int n : A){
            sum += n;
        }
        System.out.println("La media dei numeri è: " + (sum/A.length) );
        System.out.println("----------------------------24) Conteggio di valori maggiori di 10-----------------------------------");
        int count =0;
        for( int n : A){
            if(n > 10){
                count++;
            }
        }
        System.out.println("Ci sono " + count + " numeri maggiore di 10");
        System.out.println("----------------------------25)Invertire un array con un solo for-----------------------------------");
       int temp;
        System.out.println("La matrice invertita è: ");
        for (int i = 0 , j = A.length - 1 ; i < A.length ; i++ , j--){
            if( (i-j)==1 || i == j) {
                break;
            }
           temp = A[i] ;
           A[i] = A[j];
           A[j] = temp;
        }
        for(int n : A){
            System.out.print(n + " ");
        }


        input.close();
    }
}
