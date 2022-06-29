/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.ifsp.test;

import br.edu.ifsp.mavendb.DAOUser;
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
public class HelloTest {
    
    DAOUser dao;
    
    public HelloTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dao = new DAOUser();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     //@Test
     public void test1() {
         dao = new DAOUser();
         dao.select();
         assertTrue(true);
     }
     
     //@Test
     public void test2() {
         dao = new DAOUser();
         dao.select();
         assertTrue(true);
     }
}
