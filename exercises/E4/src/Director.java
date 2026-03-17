public class Director extends Manager{
    private double directorBonus;
    public Director(String nome, int eta, double stipendio, String lavoro, double bonus, double directorBonus) {
        super(nome, eta, stipendio, lavoro, bonus);
        this.directorBonus = directorBonus;
    }

    @Override
    public double getStipendio() {
        return super.getStipendio() + this.getBonus() + this.getDirectorBonus();
    }

    public double getDirectorBonus() {
        return directorBonus;
    }

    public void setDirectorBonus(double directorBonus) {
        this.directorBonus = directorBonus;
    }
}
