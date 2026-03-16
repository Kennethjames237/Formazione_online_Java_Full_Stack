public class Persona {
    private String name;
    private int eta;
    private boolean isOnline;
    private int giornoPreferito;
    private String materiaPreferita;

    Persona(String name, int eta,int giornoPreferito,String materiaPreferita) {
        this.name = name;
        this.setEta(eta);
        this.saluta();
        this.setGiornoPreferito(giornoPreferito);
        this.setMateriaPreferita(materiaPreferita);
    }
    Persona(String name,int eta){
        this.name=name;
        this.setEta(eta);
    }

    Persona() {
        this.name = "Sconosciuto";
        this.eta = 0;
        this.giornoPreferito = 0;
        this.materiaPreferita = "NULL";
    }

    public int getEta() {
        return eta;
    }

    public void setEta( int eta) {
        if (eta > 0) {
            this.eta = eta;
        } else if(eta <= 0){
            System.out.println("L'età non può essere negativa o zero :( ");
        }
    }

    public String getName() {
        return name;
    }

    public void stampa() {
        System.out.println("nome: " + this.getName());
        System.out.println("Età: " + this.getEta());
        System.out.println("Il giorno preferito è: " + this.getNomeGiorno());
        System.out.println("Connesso: " + this.isOnline());
    }

    public void saluta() {
        //Questo è un nome locale visibile solo nel metodo saluta
        // String nome = "Mario";
        //System.out.println("Ciao "+nome + ": --> un nome locale");
        System.out.println("Ciao il tuo nome è: " + this.name);
    }

    public void invecchia() {
        this.eta += 1;
    }

    public boolean isOnline() {
        return this.isOnline;
    }

    public void login() {
        this.isOnline = true;
    }

    public void logout() {
        this.isOnline = false;
    }

    public int getGiornoPreferito() {
        return giornoPreferito;
    }

    public void setGiornoPreferito(int giornoPreferito) {
        if(giornoPreferito >= 1 && giornoPreferito <= 7) {
            this.giornoPreferito = giornoPreferito;
        }else{
            this.giornoPreferito=-1;
        }
    }

    public String getNomeGiorno() {
        int giorno = getGiornoPreferito();
        return switch (giorno) {
            case 1 -> "Lunedì";
            case 2 ->  "Martedì";
            case 3 ->"Mercoledì";
            case 4 ->  "Giovedì";
            case 5 -> "Venerdì";
            case 6 -> "Sabato";
            case 7 -> "Domenica";
            default -> "Giorno non valido";
        };
    }

    public String getMateriaPreferita() {
        return materiaPreferita;
    }

    public void setMateriaPreferita(String materiaPreferita) {
        this.materiaPreferita = materiaPreferita;
    }
    public void descriviMateria(){
        String matria = this.getMateriaPreferita();
        switch (matria){
            case "matematica" -> System.out.println("Grande hai scelto la matematica :)");
            case "storia" -> System.out.println("Bella le storie per lo svillupo personale :)");
            case "informatica" -> System.out.println("Bravissimo farai algoritmi");
             default -> System.out.println("Non è nella rubrica :(");
        };
    }
    public void presentati(){
        System.out.println("Il name è: " + this.getName());
        System.out.println("L'età è: " + this.getEta());
        if(this.isOnline()){
            System.out.println("Connesso...");
        }else{
            System.out.println("Disconnesso...");
        }
    }
    public boolean isAdult(){
        return this.getEta()>=18;
    }
}

