package Lezione10;

/**
 * La classe Manager è una sottoclasse di Employee.
 * Dimostra la relazione "IS-A" → un Manager È UN Employee.
 *
 * Introduce il concetto di OVERRIDING e aggiunge un comportamento specifico.
 */
public class Manager extends Employee {
    private double managementBonus; // Bonus manageriale aggiuntivo rispetto allo stipendio base

    // Costruttore: richiama il costruttore della superclasse con super(...)
    public Manager(String name, String employeeId, double baseSalary, double managementBonus) {
        super(name, employeeId, baseSalary); // inizializza i campi ereditati
        this.managementBonus = managementBonus;
    }

    // Metodo specifico del Manager, NON presente nella superclasse
    public void approveExpense() {
        System.out.println("Manager " + this.getName() + " ha approvato una spesa.");
    }

    // --- OVERRIDING ---
    // Ridefinizione del metodo getSalary() per aggiungere il bonus
    @Override
    public double getSalary() {
        // Richiama il metodo originale della superclasse con super.getSalary()
        // e aggiunge la logica personalizzata
        return super.getSalary() + this.managementBonus;

    }

}