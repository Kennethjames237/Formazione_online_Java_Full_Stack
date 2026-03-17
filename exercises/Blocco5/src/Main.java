import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Veicolo> tuttiVeicoli = new ArrayList<>();

        Veicolo v1 = new Auto();
        Veicolo v2 = new Bicicletta();
        Veicolo v3 = new Auto();
        Veicolo v4 = new Bicicletta();
        tuttiVeicoli.add(v1);
        tuttiVeicoli.add(v2);
        tuttiVeicoli.add(v3);
        tuttiVeicoli.add(v4);

        Garage g1 = new Garage(tuttiVeicoli);
        g1.muovi();

        g1.muoviSinoloVeicolo(v4);


    }
}