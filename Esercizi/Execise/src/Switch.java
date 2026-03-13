import java.util.Scanner;

public class Switch {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number that corresponds to a day: ");
        int day = sc.nextInt();
        if(day >= 1 && day <= 7) {
            switch (day) {
                case 1 -> System.out.println("oggi è lunedì");
                case 2 -> System.out.println("Oggi è martedi");
                case 3 -> System.out.println("Oggi è mercoledì");
                case 4 -> System.out.println("Oggi è giovedì");
                case 5 -> System.out.println("Oggi è venerdì");
                case 6 -> System.out.println("Oggi è sabato");
                case 7 -> System.out.println("Oggi è domenica");
            }
        }
        else{
            System.out.println("Number you inserted does not correspond to a day of a week...");

        }
    }
}
