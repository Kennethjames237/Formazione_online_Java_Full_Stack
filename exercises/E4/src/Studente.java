public class Studente extends Persona{
    private String corsoDiStudio;
    private String nome;

    Studente(String nome, int eta, String corsoDiStudio){
        //super(nome,eta);
        super.nome = nome;
        super.eta = eta;
        this.setCorsoDiStudio(corsoDiStudio);
    }

    public void studia(){
        System.out.println("sto studiando...");
    }

    @Override
    public String presentati() {
        return super.presentati() + " e studio " + this.corsoDiStudio;
    }

    public String getCorsoDiStudio() {
        return corsoDiStudio;
    }

    public void setCorsoDiStudio(String corsoDiStudio) {
        this.corsoDiStudio = corsoDiStudio;
    }
}
