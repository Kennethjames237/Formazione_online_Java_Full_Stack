import java.util.Scanner;

public class Numero {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        if (number < 0){
            System.out.println("The number is negative..");
        }
        else if(number > 0){
            System.out.println("The number is positive..");
        }
        else
            System.out.println("the number is zero");
       if(number % 2 == 0){
           System.out.println("pari");
       }else{
           System.out.println("dispari");
       }
    }

}
