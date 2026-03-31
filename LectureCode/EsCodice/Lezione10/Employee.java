package Lezione10;

/**
 * Classe base (superclasse) che rappresenta un generico dipendente.
 * Dimostra il concetto di EREDITARIETÀ:
 * altre classi potranno estendere (ereditare) questa e aggiungere funzionalità.
 */
public class Employee {
    // --- CAMPi ---
    private String name;               // Campo privato → incapsulato: accessibile solo tramite getter
    private final String employeeId;   // final → una volta assegnato, non può essere modificato
    protected double baseSalary;       // protected → accessibile dalle sottoclassi (es. Manager)

    // --- COSTRUTTORE ---
    // Ogni dipendente deve avere un nome, un ID e uno stipendio base.
    public Employee(String name, String employeeId, double baseSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
    }

    // --- METODI COMUNI ---
    public void work() {
        // Questo metodo sarà ereditato da tutte le sottoclassi (Manager, ecc.)
        System.out.println(this.name + " sta lavorando...");
    }

    public double getSalary() {
        // Metodo che restituisce lo stipendio di base.
        // Le sottoclassi possono "sovrascriverlo" (override) per modificarne il comportamento.
        return this.baseSalary;
    }

    // --- GETTER PUBBLICI ---
    public String getName() { return name; }
    public String getEmployeeId() { return employeeId; }
}