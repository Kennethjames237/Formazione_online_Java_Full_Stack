import java.lang.reflect.Array;
import java.util.ArrayList;

public class Garage {
    private ArrayList<Veicolo> veicolo = new ArrayList<>();

    public Garage(ArrayList<Veicolo> veicolo) {
        this.veicolo = veicolo;
    }
    public Garage(){

    }
    public void muovi(){
        for(Veicolo n : veicolo){
            n.muovi();
        }
    }
    public void muoviSinoloVeicolo( Veicolo veicolo){
        veicolo.muovi();
    }
}

