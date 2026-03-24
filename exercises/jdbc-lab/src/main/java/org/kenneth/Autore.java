package org.kenneth;

public class Autore {
    //static count shared by all instance
    private static int counter = 0;

    //finall instance id assigned once when the object is created
    private final int autore_id;
    private String nome;
    private String email;

    public Autore(String nome,String email) {
        counter++;
        this.autore_id = counter;
        this.email = email;
        this.nome = nome;
    }

    public int getAutore_id() {
        return autore_id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
