import java.util.Scanner;

public class Blocco3 {
 public static void main(String[] args){
     Scanner input = new Scanner(System.in);
     System.out.println("-------------------------------11)Chiedi nome almeno una volta-----------------------------------");
             String nome = "";
             do{
                 System.out.print("inserisci il tuo nome: ");
                  nome = input.next();
                if(nome.length() <= 3){
                    System.out.println("il tuo nome è troppo corto..!!");
                }
             }while(nome.length() <= 3);
     System.out.println("Bravo hai completato con sucesso...");

     System.out.println("-------------------------------12)Somma con controllo successivo-----------------------------------");
     int sum = 0;
     int num = 0;
     do{
            System.out.print("inserisci il valore da sommmare al precedente: ");
             num = input.nextInt();
            if((sum + num) <= 100){
                sum += num;
            }else{
                break;
            }

        }while(sum < 100);
     System.out.println();
     System.out.println("la somma totale è: " + sum);

     System.out.println("-------------------------------13)Conferma uscita-----------------------------------");
     char letter;
     do{
          System.out.print("inserisci 's' per uscire e 'n' per continuare..");
           letter = input.next().charAt(0);
        }while(letter != 's' && letter != 'S');

     System.out.println("-------------------------------14)Input multiplo con controllo-----------------------------------");
        int num1;
        do{
            System.out.print("Inserisci un numero positivo: ");
            num1 = input.nextInt();
        }while(num1 > 0);

     System.out.println("-------------------------------15) Menu interattivo-----------------------------------");
        int scelta;
         do{
             System.out.println();
             System.out.println("1- Pasta al pesto");
             System.out.println("2- Pasta al pomodoro");
             System.out.println("3 - Pizza");
             System.out.print("fai una scielta :");
             scelta = input.nextInt();
             switch(scelta){
                 case 1 -> System.out.println("OK! Pasta al pesto, :)");
                 case 2 -> System.out.println("OK! Pasta al pomodoro, :)");
                 case 3 -> System.out.println("OK! 3-Pizza :)");
                 case 0 -> System.out.println("Uscito dal menu:(");
                 default -> System.out.println("Non è una scielta giusta :(");
             }
        }while(scelta != 0);

     input.close();
 }
}
