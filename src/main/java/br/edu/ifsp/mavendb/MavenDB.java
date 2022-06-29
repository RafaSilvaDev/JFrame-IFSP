/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.edu.ifsp.mavendb;

/**
 *
 * @author AG
 */
public class MavenDB {

    public static void main(String[] args) {
        System.out.println("Hello World! Maven !");
        
        DAOUser daouser = new DAOUser();
        daouser.connect();
//        daouser.updateChar();
        daouser.select();
        daouser.disconnect();
    }
    
  
}
