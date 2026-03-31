package Lezione10;

/**
 * Classe di servizio che utilizza il POLIMORFISMO.
 * Riceve oggetti di tipo Employee, ma può elaborare anche i Manager,
 * grazie al fatto che Manager estende Employee.
 */
public class Payroll {

    // Metodo che accetta un Employee (ma può ricevere anche sottoclassi)
    public void printSalaryDetails(Employee e) {
        System.out.println("Dipendente: " + e.getName() +
                " | ID: " + e.getEmployeeId() +
                " | Stipendio: " + e.getSalary());
        // Se 'e' è un Manager, verrà chiamato automaticamente il metodo ridefinito in Manager
    }
}