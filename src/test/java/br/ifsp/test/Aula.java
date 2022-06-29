/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.ifsp.test;

import br.edu.ifsp.mavendb.TO.ViaCep;
import com.google.gson.Gson;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Esta classe faz o teste ....
 * @author AG
 */
public class Aula {
    
    private Gson gson = new Gson();
    
    public Aula() {
    }
    
    @Test
    public void coletarJsonRemoto() throws Exception {
        
       final String CEP_IFSP_HTO = "13183-250"; 
       final String URL_COMPLETA = "https://viacep.com.br/ws/" + CEP_IFSP_HTO + "/json/";
       URL url = new URL(URL_COMPLETA );
     
       String temp = "";
       HttpURLConnection conn = (HttpURLConnection)
               url.openConnection();
	conn.setRequestMethod("GET");
	conn.connect();
	if(conn.getResponseCode() == 200) {
		Scanner scan = new Scanner(url.openStream());
		while(scan.hasNext()) {
			temp = temp + scan.nextLine();
                }
            }
       
        System.out.print(temp);
        
        boolean isFound = temp.contains(CEP_IFSP_HTO); 
        assert(isFound);
        
        ViaCep viacep = gson.fromJson(temp, ViaCep.class);
        System.out.println("\nviacep:" + viacep);
        assertEquals(viacep.getIbge(), "3519071");
    }
    
    private String json;
    //@Test
    public void tranformarJsonEmObjeto() throws Exception {
        
        ViaCep viacep = gson.fromJson(json, ViaCep.class);
        assertEquals(viacep.getIbge(), "3519071");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
