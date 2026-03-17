public class Impiegato extends Lavoratore{
    public Impiegato(String nome, int eta, double stipendio, String lavoro) {
        super(nome, eta, stipendio, lavoro);
    }

    @Override
    public double getStipendio() {
        return super.getStipendio();
    }
    public void foo(){
        System.out.println("hello");
    }

}
