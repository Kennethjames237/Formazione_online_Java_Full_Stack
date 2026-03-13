import java.util.Scanner;

public class Blocco4 {
    public static void main(String[] args){
        System.out.println("-----------------------------16)Stampa elementi di un array----------------------------------");

        //Array usato per tutto l'esercizio
        int [] A = new int[10];
        for(int i = 0 ; i <A.length; i++){
            A[i] = i;
        }
        System.out.print("I numeri dentro l'array sono: ");
        for(int n : A){
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("-----------------------------17) Somma array----------------------------------");
        int sum = 0;
        for (int n : A){
          sum += n;
        }
        System.out.println("la somme di questi numeri è: "+ sum);
        System.out.println("-----------------------------18) Elementi pari di un array----------------------------------");
        for(int n : A){
            if(n % 2 == 0){
                System.out.print(n + " ");
            }
        }
        System.out.println("-----------------------------19) Ricerca di un elemento---------------------------------");
        Scanner input = new Scanner(System.in);
        System.out.print("inserisci il numero da cercare: ");
        int num = input.nextInt();
        boolean flag = false;
        for( int n : A ){
            if(num == n){
                System.out.println("Il numero " + n + " è stato trouvato");
                 flag = true;
            }
        }
        if(flag == false){
            System.out.println("il numero non esiste nel array");
        }
        System.out.println("-----------------------------------20) Concatena stringhe----------------------------------------");
        String [] B = new String[4];
        String result = "", temp;

        for( String n : B){
            System.out.print("inserisci una stringa da concatenare: ");
            temp = input.next();
            result += temp;
        }
        System.out.println("La stringa concatenata è: " + result);
input.close();
    }

}
