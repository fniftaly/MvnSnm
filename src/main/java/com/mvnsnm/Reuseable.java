/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvnsnm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author def
 */
public class Reuseable {
    
    protected WebDriver driver;
    
  public Reuseable(WebDriver driver){
      
      this.driver = driver;
  }
  
  public void login(String username, String password){
    
      driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        
      driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);;
        
      driver.findElement(By.xpath("//input[@id='logchek']")).click();
    
    }
  
   public static void sleep(int sec){
        
        try{
            
          Thread.sleep(sec*1000);
        
        }catch(InterruptedException e){
        
        }
    
    }
  
}
