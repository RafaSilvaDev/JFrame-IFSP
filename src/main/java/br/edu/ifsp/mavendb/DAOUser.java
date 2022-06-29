/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.mavendb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUser {
    
    private static final String HOST = "jdbc:mysql://localhost/";
    private static final String DB = "world";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    private Connection conn;
    
    public boolean connect() {
        boolean status = false;
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(HOST+DB,USER,PASSWORD);
            status = true;
            System.out.println("conectado");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        return status;
    }
    
    public boolean disconnect() {
        boolean status = false;
        
        try {
            //conn.commit();
            conn.close(); 
            status = true;
            System.out.println("desconectado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return status;
        
    }
    
    public void select() {
        String cidade = "";
        int populacao = 0;
        /*
        final String sqlQuery = 
                "SELECT ID, NAME, POPULATION FROM City "
                + " WHERE CountryCode = ? "
                + " ORDER BY POPULATION desc";
         */
        String sqlQuery = "SELECT NAME, MAX(population) FROM city WHERE CountryCode = ?";

        try {
            PreparedStatement preparedSelect = conn.prepareStatement(sqlQuery);
            preparedSelect.setString(1, "BRA");
            
            ResultSet rs = preparedSelect.executeQuery();

            if(rs != null && rs.next()){
                cidade = rs.getString("NAME");
                populacao = rs.getInt(2);

                GetSQL getSQL = new GetSQL();
                getSQL.setCidade(cidade, populacao);

            }

            System.out.println("Os dados coletados foram: \nCidade: " + cidade + "\tPopulação: " + populacao);

//            int i;
//            while (rs.next()) {
//                i = 0;
//                int id = rs.getInt(++i);
//                String name = rs.getString(++i);
//                int population = rs.getInt(++i);
//                System.out.printf("%d\t%s\t%d\n",id,name,population);
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }        
 
    }
    
    public void updateChar() {
        final String sqlQuery = 
                "UPDATE City set name = concat( name, ':') where id = ?";

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //conn = DriverManager.getConnection(HOST+DB,USER,PASSWORD);
            
            //conn.setAutoCommit(false);
            
            PreparedStatement preparedSelect = conn.prepareStatement(sqlQuery);
            preparedSelect.setInt(1, 206);

            int i = preparedSelect.executeUpdate();
            
            System.out.println("atualizado:" + i);
             
            //conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }        
 
    }
    
}
