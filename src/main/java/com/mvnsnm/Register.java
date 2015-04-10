/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvnsnm;

/**
 *
 * @author def
 */
import com.app.properti.AppProperties;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


/**
 *
 * @author def
 */
public class Register {
    
   private WebDriver driver;
   
   protected Map<String, String> properties;
   
   public Register(WebDriver driver){
       
       this.driver = driver;
       
       properties = AppProperties.getProperties();
   
   }
    
   public void register(){
       
        WebElement register = driver.findElement(By.xpath("//a[@id='new_register']"));
      
      final String text_a = "Register";
      
       Assert.assertEquals(register.getText(), text_a);
      
       register.click();
    
       WebElement first = driver.findElement(By.xpath("//input[@id='first']"));
        
        first.sendKeys(properties.get("first"));
        
        WebElement last = driver.findElement(By.xpath("//input[@id='last']"));
        
        last.sendKeys(properties.get("last"));
        
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        
        email.sendKeys(properties.get("email"));
        
        WebElement phone = driver.findElement(By.xpath("//input[@id='phonenum']"));
        
        phone.sendKeys(properties.get("phonenum"));
        
        WebElement address = driver.findElement(By.xpath("//input[@id='address']"));
        
        address.sendKeys(properties.get("address"));
        
        WebElement city = driver.findElement(By.xpath("//input[@id='city']"));
        
        city.sendKeys(properties.get("city"));
        
        WebElement state = driver.findElement(By.xpath("//input[@id='state']"));
        
        state.sendKeys(properties.get("state"));
        
        WebElement country = driver.findElement(By.xpath("//input[@id='country']"));
        
        country.sendKeys(properties.get("country"));
        
        WebElement zipcode = driver.findElement(By.xpath("//input[@id='zipcode']"));
        
        zipcode.sendKeys(properties.get("zipcode"));
        
        WebElement newuser = driver.findElement(By.xpath("//input[@id='username']"));
        
        newuser.sendKeys(properties.get("username"));
        
        WebElement passd = driver.findElement(By.xpath("//input[@id='password']"));
        
        passd.sendKeys(properties.get("password"));
        
        WebElement create = driver.findElement(By.xpath("//input[@id='savedata']"));
        
        create.click();
        
        driver.get("http://localhost:8801");
   
   }
   
   public void deleteuser(){
       
       driver.get("http://localhost:8801");
       
       driver.findElement(By.linkText("Change Password")).click();
       
       //Change Password
       final String userdelete = "Delete User";
       
       WebElement deleteuser = driver.findElement(By.xpath("//span[@id='userdelete']"));
       
       deleteuser.click();
       
       Assert.assertEquals(userdelete, deleteuser.getText());
       
       driver.findElement(By.xpath("//input[@id='username']")).sendKeys(properties.get("username"));
       
       driver.findElement(By.xpath("//input[@id='password']")).sendKeys(properties.get("password"));
       
       Reuseable.sleep(3);
       
       driver.findElement(By.xpath("//input[@id='deleteaccount']")).click();
       
       Reuseable.sleep(5);
       
       Assert.assertEquals(properties.get("accountdeleted"), 
               driver.findElement(By.xpath("//li[@id='useraccountdeleted']")).getText());
       
   }
    
}
