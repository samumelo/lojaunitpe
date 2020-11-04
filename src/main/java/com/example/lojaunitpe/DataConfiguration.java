package com.example.lojaunitpe;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class  DataConfiguration {
	

@Bean
    public static void main(String[] args){
	
        String driver = "org.postgresql.Driver";
        String user   = "postgres";
        String senha = "mari";
        String url   = "jdbc:postgresql://localhost:5432/lojaUnit";

        try
        {
            Class.forName(driver);
            Connection con = null;

            con = (Connection) DriverManager.getConnection(url, user, senha);

            System.out.println("Conexão realizada com sucesso.");

        }
        catch (ClassNotFoundException ex)
        {
            System.err.print(ex.getMessage());
        } 
        catch (SQLException e)
        {
            System.err.print(e.getMessage());
        }
    }
}



