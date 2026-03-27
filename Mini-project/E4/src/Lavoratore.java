public class Lavoratore extends Persona{
    private String lavoro;
    private double stipendio;

    public Lavoratore(String nome, int eta, double stipendio, String lavoro) {
        super(nome, eta);
        this.stipendio = stipendio;
        this.setLavoro(lavoro);
    }
    public void work(){
        System.out.println("Dalla classe lavoratore il lavoratore " + this.getNome() + " sta lavorando..");
    }

    public double getStipendio() {
        return stipendio;
    }


    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public String getLavoro() {
        return lavoro;
    }

    public void setLavoro(String lavoro) {
        this.lavoro = lavoro;
    }
}
