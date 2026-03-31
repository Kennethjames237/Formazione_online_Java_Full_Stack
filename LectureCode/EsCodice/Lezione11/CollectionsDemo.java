package Lezione11;

// Import dei pacchetti necessari per usare le collezioni Java
import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {

        // --- LISTA ORDINATA (List / ArrayList) ---
        // Una "List" è una collezione che mantiene l'ordine di inserimento
        // e consente duplicati. ArrayList è un'implementazione basata su array dinamico.
        List<String> names = new ArrayList<>(); // Si programma contro l'interfaccia (buona pratica OOP)

        // Aggiunta di elementi alla lista
        // I duplicati sono consentiti (es. due "Alice")
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Alice"); // duplicato valido
        names.add("Davide");
        // Stampa dell'intera lista: l'ordine di inserimento è mantenuto
        System.out.println("Lista completa: " + names);

        // Accesso tramite indice (0-based)
        System.out.println("Il secondo elemento è: " + names.get(1)); // Stampa "Bob"

        // Rimozione di un elemento tramite indice
        // In questo caso viene rimosso il primo elemento (indice 0 → "Alice")
        names.remove(0);
        System.out.println("Lista dopo rimozione: " + names);

        // Iterazione di tutti gli elementi con un ciclo for-each
        for (String n : names) {
            System.out.println("Nome: " + n);
        }
//  Inizializzazione immediata con Arrays.asList()
        // Arrays.asList(...) restituisce una lista "fissa": si possono modificare gli ELEMENTI (set),
        // ma NON si può cambiare la dimensione (niente add/remove). È collegata all'array sottostante.
        List<String> lista2 = Arrays.asList("Rosso", "Verde", "Blu");
        System.out.println("2) Con Arrays.asList(): " + lista2);
        // Esempio (commentato) di operazione NON consentita: provo ad aggiungere un elemento
        // lista2.add("Giallo"); //  UnsupportedOperationException a runtime

        //  Conversione di Arrays.asList() in una lista veramente modificabile
        // Wrappiamo il risultato in un nuovo ArrayList, così otteniamo una lista RIDIMENSIONABILE.
        List<String> lista3 = new ArrayList<>(Arrays.asList("Cane", "Gatto", "Coniglio"));
        // Ora possiamo aggiungere elementi liberamente
        lista3.add("Pappagallo");
        System.out.println("3) Arrays.asList() + new ArrayList<>(): " + lista3);

        //  Inizializzazione con List.of() (Java 9+)
        // List.of(...) crea una lista IMMUTABILE: non si può fare né add/remove né set.
        // È utile quando vogliamo una collezione costante, compatta ed efficiente.
        List<Integer> lista4 = List.of(1, 2, 3, 4, 5);
        System.out.println("4) Con List.of(): " + lista4);
        // Operazioni NON consentite su List.of():
        // lista4.add(6);      //  UnsupportedOperationException
        // lista4.set(0, 99);  //  UnsupportedOperationException

        //  Inizializzazione con Collections.singletonList()
        // Crea una lista IMMUTABILE contenente un solo elemento.
        // È molto compatta e chiara quando sappiamo che la lista deve avere 1 solo valore.
        List<String> lista5 = Collections.singletonList("UnicoElemento");
        System.out.println("5) Con Collections.singletonList(): " + lista5);
        // Non possiamo cambiarne la dimensione o il valore:
        // lista5.add("Altro");     //  UnsupportedOperationException
        // lista5.set(0, "Nuovo");  //  UnsupportedOperationException

        //  Inizializzazione con Arrays.stream() e toList() (Java 16+)
        // Partiamo da un array di String e lo trasformiamo in una lista in stile "funzionale".
        String[] nomi = {"Anna", "Luca", "Marco"};
        // toList() (Java 16+) restituisce una lista IMMUTABILE (implementazione non specificata).
        List<String> lista6 = Arrays.stream(nomi).toList();
        System.out.println("6) Con stream().toList(): " + lista6);
        // Se avessimo bisogno di una lista modificabile, potremmo fare:
        // List<String> lista6Modificabile = new ArrayList<>(Arrays.stream(nomi).toList());

        //  Inizializzazione tramite un blocco di inizializzazione anonimo (double brace initialization)
        // Crea una sottoclasse anonima di ArrayList e chiama add() nel blocco.
        // PRO: sintassi compatta. CONTRO: crea una classe anonima (overhead) e mantiene un riferimento implicito alla classe esterna.
        List<String> lista7 = new ArrayList<>() {{
            add("Roma");
            add("Milano");
            add("Napoli");
        }};
        System.out.println("7) Con blocco anonimo: " + lista7);

        //  Copiare un'altra lista esistente
        // Creiamo una NUOVA lista contenente gli stessi elementi di lista7.
        // È utile per evitare di modificare accidentalmente la lista originale.
        List<String> lista8 = new ArrayList<>(lista7);
        // Ora possiamo modificarla indipendentemente dall'originale
        lista8.add("Torino");
        System.out.println("8) Copia di un'altra lista: " + lista8);

        //  Lista vuota con Collections.emptyList()
        // Restituisce una lista IMMUTABILE e VUOTA: ottima per evitare di restituire null.
        List<String> lista9 = Collections.emptyList();
        System.out.println("9) Con Collections.emptyList(): " + lista9);
        // Non si può aggiungere nulla:
        // lista9.add("qualcosa"); // UnsupportedOperationException

        //  Lista creata e popolata con logica personalizzata (ciclo for)
        // Partiamo da una lista vuota e aggiungiamo numeri generati dal ciclo.
        List<Integer> lista10 = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {          // i varia da 1 a 5 inclusi
            lista10.add(i * 10);               // aggiungiamo multipli di 10: 10, 20, 30, 40, 50
        }
        System.out.println("10) Popolata con ciclo for: " + lista10);


System.out.println("---------------------------------------------------");
        // --- INSIEME NON ORDINATO (Set / HashSet) ---
        // Un "Set" non ammette duplicati e non mantiene l'ordine.
        // HashSet è un'implementazione che usa una tabella hash per efficienza.
        Set<Integer> uniqueNumbers = new HashSet<>();

        // Aggiunta di elementi
        uniqueNumbers.add(10);
        uniqueNumbers.add(20);
        uniqueNumbers.add(30);


        // Tentativo di aggiungere un duplicato (10)
        // L'operazione fallisce silenziosamente e restituisce false
        boolean addedAgain = uniqueNumbers.add(10);

        // Stampa del set: l'ordine non è garantito
        System.out.println("Set di numeri: " + uniqueNumbers);
        System.out.println("Duplicato aggiunto? " + addedAgain); // false

        // Controllo rapido di appartenenza
        if (uniqueNumbers.contains(20)) {
            System.out.println("Il set contiene il numero 20.");
        }

            // Inizializzazione diretta con Set.of() (Java 9+)
            // Set.of() restituisce un insieme IMMUTABILE
            Set<Integer> set2 = Set.of(1, 2, 3, 4);
            System.out.println("2) Con Set.of(): " + set2);
            // Operazioni NON consentite:
            // set2.add(5); //  UnsupportedOperationException

            //  Creazione con Arrays.asList() + HashSet
            // Arrays.asList() crea una lista, poi la convertiamo in HashSet per eliminare duplicati
            Set<String> set3 = new HashSet<>(Arrays.asList("Roma", "Milano", "Roma", "Torino"));
            System.out.println("3) Da Arrays.asList() a HashSet: " + set3);

            //  Inizializzazione tramite Collections.singleton()
            // Restituisce un Set IMMUTABILE con un solo elemento
            Set<String> set4 = Collections.singleton("Unico");
            System.out.println("4) Con Collections.singleton(): " + set4);

            // Conversione da un’altra collezione (List → Set)
            // I duplicati vengono automaticamente rimossi
            List<String> listaDuplicati = Arrays.asList("A", "B", "A", "C", "B");
            Set<String> set5 = new HashSet<>(listaDuplicati);
            System.out.println("5) Conversione da List (senza duplicati): " + set5);

            //  Inizializzazione tramite Stream
            // Metodo funzionale con Java 8+: creiamo un Set da una lista o da un array
            Set<String> set6 = new HashSet<>(Arrays.asList("Anna", "Luca", "Marco"));
            System.out.println("6) Con Stream/ArrayList: " + set6);

            //  Set ordinato con TreeSet (ordina automaticamente gli elementi)
            Set<String> set7 = new TreeSet<>(Arrays.asList("Zebra", "Aquila", "Cane"));
            System.out.println("7) TreeSet (ordinato): " + set7);

            //  Set che mantiene l'ordine di inserimento (LinkedHashSet)
            Set<String> set8 = new LinkedHashSet<>();
            set8.add("Primo");
            set8.add("Secondo");
            set8.add("Terzo");
            System.out.println("8) LinkedHashSet (ordine di inserimento): " + set8);

            System.out.println("\n=== ESEMPI DI INIZIALIZZAZIONE MAP ===\n");

            //  Creazione classica con HashMap e put()
            // Una Map associa una CHIAVE a un VALORE
            Map<Integer, String> map1 = new HashMap<>();
            map1.put(1, "Uno");
            map1.put(2, "Due");
            map1.put(3, "Tre");
            System.out.println("1) Con put(): " + map1);

            //  Inizializzazione con Map.of() (Java 9+)
            // Crea una mappa IMMUTABILE
            Map<String, Integer> map2 = Map.of(
                    "Rosso", 1,
                    "Verde", 2,
                    "Blu", 3
            );
            System.out.println("2) Con Map.of(): " + map2);
            // map2.put("Giallo", 4); //  UnsupportedOperationException

            //  Inizializzazione con Map.ofEntries() per più coppie (Java 9+)
            // Più leggibile per molte chiavi/valori
            Map<String, String> map3 = Map.ofEntries(
                    Map.entry("IT", "Italia"),
                    Map.entry("FR", "Francia"),
                    Map.entry("ES", "Spagna")
            );
            System.out.println("3) Con Map.ofEntries(): " + map3);

            // Inizializzazione classica con blocco anonimo
            Map<String, Double> map4 = new HashMap<>() {{
                put("Pasta", 1.20);
                put("Pane", 0.90);
                put("Latte", 1.50);
            }};

            System.out.println("4) Con blocco anonimo: " + map4);

            //  Mappa ordinata per chiave (TreeMap)
            Map<String, Integer> map5 = new TreeMap<>();
            map5.put("Zebra", 10);
            map5.put("Aquila", 5);
            map5.put("Cane", 8);
            System.out.println("5) TreeMap (ordinata per chiave): " + map5);


            // Mappa che mantiene l'ordine di inserimento (LinkedHashMap)
            Map<String, Integer> map6 = new LinkedHashMap<>();
            map6.put("Primo", 100);
            map6.put("Secondo", 200);
            map6.put("Terzo", 300);
            System.out.println("6) LinkedHashMap (ordine di inserimento): " + map6);

            //  Mappa vuota e immutabile con Collections.emptyMap()
            Map<String, String> map7 = Collections.emptyMap();
            System.out.println("7) Collections.emptyMap(): " + map7);
            // map7.put("Chiave", "Valore"); //  UnsupportedOperationException

            //  Conversione da lista di oggetti a mappa (esempio avanzato)
            // Usiamo una lista di nomi e creiamo una mappa (nome → lunghezza del nome)
            List<String> nomi1 = Arrays.asList("Anna", "Giovanni", "Luca");
            Map<String, Integer> map8 = new HashMap<>();
            for (String n : nomi1) {
                map8.put(n, n.length());
            }
            System.out.println("8) Conversione da lista a mappa: " + map8);


    }
}