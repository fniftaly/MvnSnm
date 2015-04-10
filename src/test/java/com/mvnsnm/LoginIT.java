/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvnsnm;

import com.app.properti.AppProperties;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author def
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginIT {
    
     static private Map<String, String> properties;
     static private WebDriver driver;
     static private Reuseable rs;
     static private Register rgs;
     static private Tabviews tbv;
     
    public LoginIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
       properties = AppProperties.getProperties();
        
       driver = new FirefoxDriver();
       
       rs  = new Reuseable(driver);
       
       rgs = new Register(driver);
       
       tbv = new Tabviews(driver);
       
       driver.get("http://localhost:8801");
       
       driver.manage().window().maximize();
    }
    
    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test1Loging() {
      String username = properties.get("badusername"); 
      String password = properties.get("badpassword");
     rs.login(username,password);
         
      WebElement link =driver.findElement(By.xpath("//li[@id='logresult']"));
        
      System.out.println(link.getText());
     
    }
    
    @Test
    public void test2register(){
        
     rgs.register();
     
     Reuseable.sleep(3);
     
     rs.login(properties.get("username"),properties.get("password"));
     
     Reuseable.sleep(3);
     
    }
    
    @Test
    public void test3campaign(){
        
      tbv.campaign();
      
      Reuseable.sleep(3);
    }
    @Test
    public void test4deleteuser(){
        
      rgs.deleteuser();
      
      Reuseable.sleep(3);
    }
    
    
    
}
