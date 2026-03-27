import java.util.Scanner;

public class testPersona {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Persona p1 = new Persona("James",54,4,"matematica");
        Persona p2 = new Persona("kenneth",23,5,"storia");
        Persona p3 = new Persona("jal",34);
        Persona p4 = new Persona("Ricky",5,8,"informatica");

        /* p1.stampa();
        p1.saluta();

        System.out.println("---------------");

        p2.stampa();
        p2.saluta();
        p2.invecchia();
        p2.invecchia();
        p2.stampa();

        System.out.println("---------------");


        p3.stampa();
        p3.saluta();
        p3.setEta(1);
        p3.stampa();

        System.out.println("---------------");

        */

        /*
        System.out.println("---------------");
        p1.login();
        p2.login();
        p1.stampa();
        System.out.println("---------------");
        p4.stampa();
        System.out.println("-----------------");
        p2.stampa();

        System.out.println("-----------------");

        p1.descriviMateria();
        p2.descriviMateria();
        p4.descriviMateria();
        p3.descriviMateria();

         */
        /*
        System.out.println();
        System.out.println("-----------Con input del utente-----------------");
        System.out.println();
        System.out.print("Inserisci il tuo nome: ");
        String nome = input.next();
        System.out.println();
        System.out.print("Inserisci la tua età: ");
        int eta = input.nextInt();
        while(eta <= 0){
            System.out.print("l'eta è negativa inserisci di nuovo la tua età: ");
             eta = input.nextInt();
        }
        Persona User = new Persona(nome,eta);
        System.out.println("hello "+ User.getName() + " hai "+ User.getEta() + " anni");

        System.out.println("------------------------Modifica dello stato tramite input-------------------------------");
        System.out.print("Vuoi fare login? ");
        String flag = input.next();
        if(flag.contains("SI") || flag.contains("si")){
            User.login();
            System.out.println("Stato:" + User.isOnline());
            System.out.println("Collegato con successo..");
        }else if(flag.contains("no") || flag.contains("No")){
            User.logout();
            System.out.println("Stato:" + User.isOnline());
            System.out.println("Hai effettuato la logout..");
        }
        System.out.println("----------------------------------------Ciclo di creazione multipla-----------------------------------------------------");
        System.out.print("inserisci i numeri di utenti da creare: ");
        int numeroUtenti = input.nextInt();
        System.out.println();
        Persona[] Utenti = new Persona[numeroUtenti];

        for(int i = 0 , j = 1 ; i < numeroUtenti ; i++ , j++){
            System.out.print("Inserisci il nome del utente numero " + j+ " : " );
            String username = input.next();
            System.out.println();
            System.out.print("Inserisci l'età del utente numero "+ j + " : ");
            int user_age = input.nextInt();
            System.out.println();
            System.out.print("Inserisci il giorno preferito del utente numero "+ j + " : ");
            int giorno = input.nextInt();
            System.out.println();
            System.out.print("Inserisci la materia preferita del utente numero "+ j + " : ");
            String materia = input.next();
            System.out.println();
            Utenti[i] = new Persona(username,user_age,giorno,materia);
        }

        for(int i = 0 ; i < numeroUtenti ; i++){
            Utenti[i].stampa();
            Utenti[i].descriviMateria();
            System.out.println();
            System.out.println("------------------");
        }

         */

        System.out.println("---------------------------- Validazione tramite Scanner-------------------------------------");
        /*
        p1.login();
        p2.login();
        p1.presentati();
        System.out.println("------------------");
        p2.presentati();
        System.out.println("------------------");
        p3.presentati();
        System.out.println("------------------");
        p2.logout();
        p2.presentati();

         */

        System.out.print("Inserisci il tuo nome: ");
        String nome = input.next();
        System.out.println();
        System.out.print("Inserisci la tua età: ");
        int eta = input.nextInt();
        while(eta <= 0){
            System.out.print("l'eta è negativa inserisci di nuovo la tua età: ");
            eta = input.nextInt();
        }
        System.out.println();
        Persona User = new Persona(nome,eta);
        System.out.println("Scelgi tra 'login', 'logout' o 'niente'");
        String scelta = input.next().toLowerCase().trim();
        switch (scelta){
            case "login" -> {
                User.login();
                System.out.println("Connesso..");
                System.out.println("stato: " + User.isOnline());
            }
            case "logout" ->{
                User.logout();
                System.out.println("Disconnesso..");
                System.out.println("stato: " + User.isOnline());
            }
            case "niente" ->{
                System.out.println("laoding....");
                System.out.println("Nessun azione..");
            }
            default -> {
                System.out.println("Non hai fatto la scielta giusta");
            }
        };
        if(User.isAdult()){
            System.out.println("Sei Maggiorenne");
        }else{
            System.out.println("Sei minorenne");
        }

        System.out.println("---------------------------------------------------------");
        System.out.print("inserisci i numeri di utenti da creare: ");
        int numeroUtenti = input.nextInt();
        System.out.println();
        Persona[] Utenti = new Persona[numeroUtenti];

        for(int i = 0 , j = 1 ; i < numeroUtenti ; i++ , j++){
            System.out.print("Inserisci il nome del utente numero " + j+ " : " );
            String username = input.next();
            System.out.println();
            System.out.print("Inserisci l'età del utente numero "+ j + " : ");
            int user_age = input.nextInt();
            System.out.println();
            System.out.print("Inserisci il giorno preferito del utente numero "+ j + " : ");
            int giorno = input.nextInt();
            System.out.println();
            System.out.print("Inserisci la materia preferita del utente numero "+ j + " : ");
            String materia = input.next();
            System.out.println();
            Utenti[i] = new Persona(username,user_age,giorno,materia);
        }

        for(int i = 0 ; i < numeroUtenti ; i++){
            Utenti[i].stampa();
            Utenti[i].descriviMateria();
            System.out.println();
            System.out.println("------------------");
        }












    }
}