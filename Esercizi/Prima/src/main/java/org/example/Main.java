package org.example;
// this is just to say that the present code is just in the package org.example//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Hello, world!\n");
        System.out.println("Hello world!");


        /// /////////////////Variabile
        double myNumber;
        myNumber = 123.0;
        System.out.println(myNumber);

        //Variable type
        byte small = 127; //byte from -128 to 127
        short medium = 20000; //short: 16 bit
        int normal = 1_000_000_000; // int : tipo intero predefinitito
        long big = 12_245_678_901L; // long: server il suffisso L
        float piApprox = 3.14F; // foat: 32 bit , suffisso f
        double piExact = 3.1_415_926_535; //double: 64 bit
        char letter = 'A'; //
        boolean isJavaFun = true; //
        String nome = "Kenny";

        System.out.println("Primitive types are : " + small +", "+ medium +", "+ normal +", "+ big +", "+ piApprox
                +", "+ piExact +", "+ letter +", "+ isJavaFun +", "+ nome);
        System.out.println("---------------------------------------------------------------------------------------------------------------");

        //String : immutable object
        String greeting = "Ciao";
        String message = greeting + ", Mondo!";
        System.out.println(message);

        //Contfronto tre stringhe
        String a = new String("test");
        String b = new String ("test");

        System.out.println(a == b); // confronta il riferimento
        System.out.println(a.equals(b)); // confronta il contenuto(l'ogetto in memoria)
    inizia();
    Person james = new Person(25 ,"james");
        System.out.println(james.printPerson());


    }
    public static void inizia(){
        System.out.println("il processo di inizio è stato attivato..");
    }
}
