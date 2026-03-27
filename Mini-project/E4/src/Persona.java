import java.util.Objects;

public class Persona {
    protected String nome;
    protected int eta;

    public Persona(){

    }

    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
        System.out.println("Esecuzione di costrutore persona...");
    }

    public String presentati(){
        return "Ciao sono " + this.nome + " ho " + this.eta + " anni";
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Persona persona)) return false;
        return eta == persona.eta && Objects.equals(nome, persona.nome);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", eta=" + eta +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, eta);
    }
}
