package Lezione10;

/**
 * Classe ASTRATTA: non può essere istanziata direttamente.
 * Serve solo come modello comune per le sottoclassi.
 *
 * Introduce il concetto di ASTRAZIONE  → definire il "cosa"deve essere fatto,
 * ma non "come" farlo.
 */
public abstract class Shape {

    // Metodo concreto → tutte le figure hanno un colore di default
    public String getColor() {
        return "Nero";
    }

    // Metodo astratto → non ha corpo! Le sottoclassi DEVONO implementarlo
    public abstract double calculateArea();

}