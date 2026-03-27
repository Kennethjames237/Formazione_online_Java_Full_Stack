public class Manager extends Lavoratore{
    private double bonus;
    public Manager(String nome, int eta, double stipendio, String lavoro,double bonus) {
        super(nome, eta, stipendio, lavoro);
        this.setBonus(bonus);
    }
    public void valutaDipendente(){
        System.out.println("il manager " + this.getNome() + " sta valutando un dipendene");
    }
    @Override
    public double getStipendio() {
        return super.getStipendio() + this.getBonus() ;
    }

    @Override
    public void work() {
        System.out.println("Dalla classe Manager il manager " + this.getNome() + " sta lavorando..");
    }

    public void  approveExpense(){
        System.out.println("Il manager " + this.nome + " ha effetuato una spesa..");
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
