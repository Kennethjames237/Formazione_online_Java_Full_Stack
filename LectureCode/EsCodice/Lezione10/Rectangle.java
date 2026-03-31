package Lezione10;

/**
 * Altra sottoclasse concreta di Shape.
 * Dimostra l’uso dell’OVERRIDING per definire comportamenti specifici.
 */
public class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double w, double h) {
        this.width = w;
        this.height = h;
    }

    @Override
    public double calculateArea() {
        // Formula dell’area del rettangolo: base * altezza
        return width * height;
    }
}