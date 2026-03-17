import java.util.Objects;

public class Ufficio {

    public Ufficio() {

    }

    public void stampaSalario(Lavoratore lavoratore){
        System.out.println("Da la classe Ufficio il lavoratore " + lavoratore.getNome() + " ha uno stipendio di " + lavoratore.getStipendio());
    }



}
