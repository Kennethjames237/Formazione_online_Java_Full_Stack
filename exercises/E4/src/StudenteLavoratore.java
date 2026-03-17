public class StudenteLavoratore extends Studente{
    public StudenteLavoratore(String nome, int eta, String corsoDiStudio) {
        super(nome, eta, corsoDiStudio);
    }
    public void lavora(){
        System.out.println("sono uno studente lavoratore");
    }
    @Override
    public String presentati(){
       return super.presentati();
    }
    @Override
    public void studia(){
        super.studia();
        System.out.println("e sono uno studente lavoratore");
    }
}
