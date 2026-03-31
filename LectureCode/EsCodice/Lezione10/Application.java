package Lezione10;

/**
 * Classe principale dell’applicazione (punto di ingresso).
 * Mostra in azione EREDITARIETÀ, POLIMORFISMO e ASTRAZIONE.
 */
public class Application {
    public static void main(String[] args) {

        // --- EREDITARIETÀ E POLIMORFISMO ---
        Employee emp1 = new Employee("Mario Rossi", "E123", 50000);
        Employee emp2 = new Manager("Luigi Verdi", "M456", 70000, 1500); // Polimorfismo: dichiarato come Employee, ma è un Manager


        Payroll payroll = new Payroll(); // Oggetto che utilizza metodi polimorfici

        // Stampa lo stipendio: viene chiamata la versione appropriata di getSalary()
        payroll.printSalaryDetails(emp1); // usa Employee.getSalary()
        payroll.printSalaryDetails(emp2); // usa Manager.getSalary() (overriding)

        // --- DOWNCASTING CON INSTANCEOF (pattern matching moderno) ---
        if (emp2 instanceof Manager manager) { // se emp2 è davvero un Manager
            manager.approveExpense(); // chiama un metodo specifico non presente in Employee
        }

        // --- ASTRAZIONE ---
        // Shape è una classe astratta → non posso fare "new Shape()"
        Shape circle = new Circle(5);         // Polimorfismo → la variabile è di tipo Shape, ma l’oggetto è un Circle
        Shape rectangle = new Rectangle(4, 6); // idem, ma con un rettangolo

        System.out.println("\n--- CALCOLO AREE (ASTRAZIONE E POLIMORFISMO) ---");
        System.out.println("Area cerchio: " + circle.calculateArea());       // chiama Circle.calculateArea()
        System.out.println("Area rettangolo: " + rectangle.calculateArea()); // chiama Rectangle.calculateArea()
    }
}