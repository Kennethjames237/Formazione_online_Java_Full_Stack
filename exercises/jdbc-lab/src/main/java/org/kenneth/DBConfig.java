package org.kenneth;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.*;

public class DBConfig {
    private static String url;
    private static String user;
    private static String password;
    private static Connection conn;


    public  DBConfig(){
        Properties props = new Properties();
        try(FileInputStream file = new FileInputStream("src/main/resources/db.properties")){
            props.load(file);
            this.url = props.getProperty("url");
            this.user = props.getProperty("user");
            this.password = props.getProperty("password");
            this.conn = DriverManager.getConnection(this.url, this.user, this.password);
            this.setConnection();
        }catch(IOException e ){
            System.err.println("il file non è stato trovato");
        }catch (SQLException e){
            System.err.println(e.getSQLState());
        }

    }
    public void setConnection(){
        try {
            if(!this.conn.isClosed()) {
                System.out.println("Connesso con successo...");
            }

        } catch (Exception e) {
            System.err.println("Errore di connessione: ");
            System.err.println(e.getMessage());
        }

    }
    public Connection getdbConnection(){
        return conn;
    }



}
