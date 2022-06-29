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
 *
 * @author AG
 */
public class TestCep {
   
    private Gson gson = new Gson();
   
    @Test
    public void coletaJsonCepDoViaCepParaIFSPHTO() throws Exception {
       
       final String CEP_IFSP_HTO = "13183-250"; 
       final String URL_COMPLETA = "https://viacep.com.br/ws/" + CEP_IFSP_HTO + "/json/";
       URL viaCep = new URL(URL_COMPLETA );
     
       String temp = "";
       HttpURLConnection conn = (HttpURLConnection)
               viaCep.openConnection();
	conn.setRequestMethod("GET");
	conn.connect();
	if(conn.getResponseCode() == 200) {
		Scanner scan = new Scanner(viaCep.openStream());
		while(scan.hasNext()) {
			temp = temp + scan.nextLine();
                }
            }
       
        System.out.print(temp);
        
        ViaCep end = gson.fromJson(temp, ViaCep.class);
        
        System.out.print(end.getBairro() + "!!!"); 
        
        boolean isFound = temp.contains(CEP_IFSP_HTO); 
        assert(isFound);
    }
   
    
    @Test
    public void coletarJsonRemoto() throws Exception {
        
       final String CEP_IFSP_HTO = "13183-250"; 
       final String URL_COMPLETA = "https://viacep.com.br/ws/" + CEP_IFSP_HTO + "/json/";
       URL viaCep = new URL(URL_COMPLETA );
     
       String temp = "";
       HttpURLConnection conn = (HttpURLConnection)
               viaCep.openConnection();
	conn.setRequestMethod("GET");
	conn.connect();
	if(conn.getResponseCode() == 200) {
		Scanner scan = new Scanner(viaCep.openStream());
		while(scan.hasNext()) {
			temp = temp + scan.nextLine();
                }
            }
       
        System.out.print(temp);
        //assertEquals("test","test2");
    }

    //@Test
    public void testGerarJsonAPartirDoObjeto() {
        String strEnd = gson.toJson(ender);
        System.out.print(strEnd);
        assertNotNull(strEnd);
    }
    
    
    
    //@Test
    public void testGerarObjetoAPartirDoJson() {
        assertEquals("test","test2");
    }
    
   
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private ViaCep ender = new ViaCep();
    @Before
    public void setUp() {
        ender.setCep("13183-250");
        ender.setLogradouro("Av. Ana Thereza");
        ender.setComplemento("IFSP HTO");
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
