import java.util.Scanner;

public class Informazione {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("qualè il tuo nome?: ");
        String name = sc.nextLine();
        System.out.print("qual'è la tua età?: ");
        int age = sc.nextInt();
        System.out.print("Qual'è la tua cità?: ");
        String città = sc.next();

        System.out.println("Mi chiamo "+ name.toUpperCase() + " ho " +age+ " anni " + "e vivo a " + città );



    }
}
