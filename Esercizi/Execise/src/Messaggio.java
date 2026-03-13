import java.util.Scanner;

public class Messaggio {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Come ti chiami?");
        String nome = sc.nextLine();
        System.out.println("Ciao, "+ nome +"! Benvenuto in Java");

    }
}
