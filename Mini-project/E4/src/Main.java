public class Main {
    public static void main(String[] args) {
        System.out.println("-------------Creazione-------------");
        Persona p1 = new Persona("kenny",23);
        Studente s2 = new Studente("Nna",24,"Math");
        StudenteLavoratore sl1 = new StudenteLavoratore("kelly",23,"chemistry");
        Lavoratore m1 = new Manager("ricky",33,2500.34,"Devops",200.23);
        Lavoratore emp1 = new Impiegato("Marco",45,1800.23,"Software specialist");
        Lavoratore emp2 = new Impiegato("Andrea",26,1700.23,"Software specialist2");
        Lavoratore emp3 = new Impiegato("Belli",35,1900.23,"Software specialist3");
        Lavoratore l1 = new Lavoratore("worker",55,1500.34,"Operaio");
        Lavoratore D1 = new Director("James",55,3000,"Diretore",230.23,234.23);
        System.out.println("-------------------------");
        System.out.println();



        Lavoratore[] Employee = new Lavoratore[4];
        Employee[0] = m1;
        Employee[1] = emp1;
        Employee[2] = emp2;
        Employee[3] = emp3;
        for (Lavoratore n : Employee){
            System.out.println("il tuo nome è " + n.getNome() + " e il tuo stipendio è di "+n.getStipendio());
            System.out.println("-------------------");

        }

        System.out.println();
        System.out.println("--------------Ufficio -> Lavoratore(Manager/Impiegato)-----------------");
        System.out.println();


        Ufficio office1 = new Ufficio();
        office1.stampaSalario(emp1);
        office1.stampaSalario(m1);
        office1.stampaSalario(l1);

        System.out.println("------------instanceof ----------------------");

        for(Lavoratore n : Employee) {
            System.out.println("----------");
            System.out.println("Il lavoratore " + n.getNome() + " è un manager?: " + (n instanceof Manager));
            if ((n instanceof Manager)) {
               ((Manager) n).approveExpense();
                System.out.println();
            }else{
                System.out.println();
                System.out.println("Il lavoratore " + n.getNome() + " è un impiegato?: " + (n instanceof Impiegato));
            }
        }

        System.out.println();
        System.out.println("---------------------Stampa di tutti i salari di Employee , manager e Diretor a run time----(JVM)----------------------");
        System.out.println();

        Lavoratore[] Employee2 = new Lavoratore[4];
        Employee2[0] = m1;
        Employee2[1] = D1;
        Employee2[2] = emp2;
        Employee2[3] = emp3;

        for(Lavoratore n : Employee2){
            System.out.println("Il Lavoratore " + n.getNome()+ " ha uno stipendio di "+n.getStipendio());
        }

        System.out.println();
        System.out.println("---------------------valutaDipendente----------------------");
        System.out.println();


        ((Manager) m1).valutaDipendente();









    }
}