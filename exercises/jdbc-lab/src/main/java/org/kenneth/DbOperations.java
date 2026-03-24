package org.kenneth;

import java.sql.*;
import java.util.List;

public class DbOperations {
    private static final DBConfig db = new DBConfig();
    private static final Connection conn = db.getdbConnection();

    //per stampare a schemo dati dal database
    private void stampa(ResultSet result){
        try {
            while (result.next()) {
                int id = result.getInt("autore_id");
                String nome = result.getString("nome");
                String email = result.getString("email");
                System.out.println(id + " - " + nome + " - " + email);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


    //creare una tabella specifica
    public void createTableAutore() {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS autori (" +
                            "autore_id BIGINT PRIMARY KEY AUTO_INCREMENT," +
                            "nome VARCHAR(50) NOT NULL," +
                            "email VARCHAR(50) NOT NULL" +
                            ")"
            );

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    //inserire un autore
    public void insertAutore(Autore autore){
        String nome = autore.getNome();
        String email = autore.getEmail();
        try{

            PreparedStatement ps= conn.prepareStatement("INSERT INTO " +
                                                                 "autori(nome,email)" +
                                                                  "VALUES(?,?)"
            );
            ps.setString(1,nome);
            ps.setString(2,email);

            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    //visualizare tutti i autori nel database
    public void getAutori(){
        try{
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * " +
                                                       "FROM autori");
            this.stampa(result);

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    //Vissualizza un solo user passando id
    public void getAutore(int id){
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT *" +
                                                                "FROM autori" +
                                                                 " WHERE autore_id = ?");
            ps.setInt(1,id);
            ResultSet result = ps.executeQuery();

            this.stampa(result);

        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

    }

    //per fare un update
    public void updateAutore(Autore autore,String email){
        int  id = autore.getAutore_id();

        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE autori" +
                    " SET email = ?" +
                    " WHERE autore_id = ?"
            );
            ps.setString(1,email);
            ps.setInt(2,id);
            ps.executeUpdate();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

    }

    //per eliminare un utente
    public void deleteAutore(Autore autore){
        int id = autore.getAutore_id();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE " +
                                                                " FROM autori" +
                                                                    " WHERE autore_id = ?"
            );
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public void insertAutoriBatch(List<Autore> autori){
        for (Autore n : autori){
            this.insertAutore(n);
        }
    }







}
