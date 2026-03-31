package Lezione10;

/**
 * Implementazione concreta di Shape.
 * Mostra come una sottoclasse deve implementare il metodo astratto.
 */
public class Circle extends Shape {
    private double radius; // raggio del cerchio

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        // Formula dell’area del cerchio: π * r²
        return Math.PI * radius * radius;
    }
}