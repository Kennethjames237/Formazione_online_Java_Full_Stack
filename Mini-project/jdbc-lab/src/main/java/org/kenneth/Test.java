package org.kenneth;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {
        DbOperations db = new DbOperations();

        db.createTableAutore();
        Autore A1 = new Autore("kenneth","kenneth@gmail.com");
        Autore A2 = new Autore("james","james@gmail.com");
        Autore A3 = new Autore("nna","nna@gmail.com");
        Autore A4 = new Autore("minkousse","minkousse@gmail.com");
        Autore A5 = new Autore("ricky","ricky@gmail.com");
        Autore A6 = new Autore("nelson","nelson@gmail.com");

        ArrayList<Autore> autori = new ArrayList<>();
        autori.add(A1);
        autori.add(A2);
        autori.add(A3);
        autori.add(A4);
        autori.add(A5);
        autori.add(A6);



        db.insertAutoriBatch(autori);




    }
}
