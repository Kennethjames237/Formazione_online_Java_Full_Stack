import com.sun.source.util.Trees;

import java.util.*;

public class Main {
    public static void main(String[] args) {
       /*
        List<String> nome= new ArrayList<>();
        nome.add("Anna");
        nome.add("Luca");
        nome.add("Marco");
        nome.add("Sara");
        nome.add("Giulia");

        List<Integer> numeri = new ArrayList<>();
        numeri.add(10);
        numeri.add(12);
        numeri.add(3);
        numeri.add(14);
        numeri.add(53);
        numeri.add(6);
        numeri.add(17);
        numeri.add(83);
        numeri.add(9);
        numeri.add(10);

        for (String n : nome){
            System.out.println(n);
        }
        System.out.println("----terza persona-----");
        if(nome.size() >= 3) {
            try {
                System.out.println(nome.get(2));
            }catch (IndexOutOfBoundsException e){
                System.err.println("Input not valido..");
            }
            //finally {
              //  System.out.println("continuamo...");
            //}
        }
        else{
            System.out.println("c'è ne sono meno gente ");
        }

        System.out.println("------modifica di una nome con set---------");
        nome.set(1,"james");
        for (String n : nome){
            System.out.println(n);
        }
        System.out.println("------rimozione di un elemento---------");
        nome.remove(nome.size()-1);
        for (String n : nome){
            System.out.println(n);
        }
        System.out.println("La lista contiene " + nome.size() + " elementi");
        System.out.println("------Verifica della presenza di un elemento---------");
        if(nome.contains("Anne")){
            System.out.println("il nome è presente");
        }else{
            System.out.println("il nome non è presente");
        }
        nome.add(1,"Mario");
        for (String n : nome){
            System.out.println(n);
        }


        System.out.println("----somma di numeri-------------");
        int sum = 0;
        for(Integer n : numeri){
            sum += n;
        }
        System.out.println("il risultato della somma è: " + sum);
        System.out.println("---------Rimozione di  numeri pari nella lista-------------");
        for (int i = numeri.size() - 1 ; i >= 0; i--){
            if( (numeri.get(i)%2) == 0 ){
                numeri.remove(i);
            }
        }
        for(Integer n : numeri){
            System.out.print(n + " ");
        }
        System.out.println();


        Collections.sort(numeri);
        System.out.println("----Dopo sort-----");
        for(Integer n : numeri){
            System.out.print(n + " ");
        }

        System.out.println();
        System.out.println("---------Dopo reverse sort-----------");
        Collections.reverse(numeri);
        for(Integer n : numeri){
            System.out.print(n + " ");
        }
        System.out.println();

        Scanner input = new Scanner(System.in);
        List<String> name = new ArrayList<>();
        String Check = "";
        while(!Check.equalsIgnoreCase("stop")){
            System.out.print("inserisci un nome or termina con 'stop': ");
            Check = input.next();
            System.out.println();
            if(!Check.equalsIgnoreCase("stop")){
                name.add(Check);
            }

        }
        for(String n : name){
            System.out.print(n + " ");
        }
        System.out.println();

        System.out.print("inserisci un nome da cercare: ");
        String search = input.next();
        System.out.println();
        if(name.contains(search)){
            System.out.println("il nome " + search + " è stato trouvato nella lista e ha indice "+ name.indexOf(search));
        }else{
            System.out.println("il nome " + search + " non esiste dentro la lista");
        }

        System.out.println("-------------------------------Media di numeri inseriti dall'utente-----------------------------");
        List<Integer> num1 = new ArrayList<>();

        int var,count = 0;
        double media = 0.0;
        do{
            System.out.print("inserisci un numero '0' per terminare: ");
            var = input.nextInt();
            if(var != 0){
                media += var;
                count++;
                num1.add(var);

            }

        }while(var != 0);

        for(Integer n : num1){
            System.out.print(n + " ");
        }
        try{
            System.out.println("la media dei numeri è: " + media/(count));
        }catch (ArithmeticException e){
            System.err.println("non è possibile dividere per zero");
        }

        */

        System.out.println();

        String [] frutti = { "Mela", "Banana", "Pera"};

        List<String> L1 = Arrays.asList(frutti);


        for( String s : L1){
            System.out.print(s + ", ");
        }
        System.out.println();


        Set<Integer> s1 = new HashSet<>();
        s1.add(-1);
        s1.add(12);
        s1.add(143);
        s1.add(12);
        s1.add(4);
        s1.add(6);
        s1.add(1);
        s1.add(7);
        s1.add(8);
        s1.add(-4);
        s1.add(-761);
        s1.add(-43);

        for (int n : s1){
            System.out.print(n + ", ");
        }
        System.out.println();
        if(s1.contains(5)){
            System.out.println("il numero esiste nella lista");
        }else{
            System.out.println("Non esiste");
        }
        System.out.println("-----------------------------");
        System.out.println();
        Set<Integer> s2 = Set.of(1,243,54,5,56,3,6,77,23,4,7,8);
        List<Integer> l3 = new ArrayList<>(s2);

        System.out.print("Da set -> lista è: " );
        for (int n : l3){
            System.out.print( n + ", ");
        }
        System.out.println();

        System.out.print("Da set -> Treeset è: ");
        TreeSet<Integer> ts = new TreeSet<>(s2);
        for (int n : ts){
            System.out.print( n + ", ");
        }

        System.out.println();

        Set<Integer> hs = new HashSet<>(s2);
        System.out.print("Da set -> Hashset è: ");

        for (int n : hs){
            System.out.print( n + ", ");
        }
        System.out.println();
        System.out.println();
        System.out.println("---------------------------New Zone -----------------------------------------------------");
        System.out.println("---------------------------Rimozione condizionale da Set --------------------------------");
        Set<Integer> s0 = new HashSet<>(s2);
        Integer [] arr = s0.toArray(new Integer[0]);
        for(int n : arr){
            if(n < 5){
                s0.remove(n);
            }
        }


        System.out.print("Da set -> lista è: " );
        for (int n : s0){
            System.out.print( n + ", ");
        }
        System.out.println();
        System.out.println("===============================Set di parole uniche============================================================");
        Scanner input = new Scanner(System.in);
        String parola = "";
        Set<String> ss = new HashSet<>();
        while(!parola.toLowerCase().equals("fine")) {
            System.out.print("inserisci una parola da aggungere: ");
            parola = input.next();
            if(!parola.toLowerCase().equals("fine")) {
                ss.add(parola);
            }
        }
        System.out.println();
        for (String n : ss){
            System.out.print(n + ", ");
        }
        System.out.println();

        System.out.println("===============================Intersezione tra Set============================================================");
        Set<Integer> ss1 = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,42,23,54,63,54));
        Set<Integer> ss2 = new HashSet<>(Arrays.asList(23,43,45,23,5,45,2,64,2,4,12,3,4,1));
        Set<Integer> ss3 = new HashSet<>();

        ss1.retainAll(ss2);
        for(int n : ss1){
            ss3.add(n);
        }
        System.out.println("Intesezione è: ");
        for(int n : ss3){
            System.out.print(n + ", ");
        }











    }
}