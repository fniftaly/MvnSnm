/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvnsnm;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author def
 */
public class Tabviews {

    private WebDriver driver;

    public Tabviews(WebDriver driver) {

        this.driver = driver;

    }

    public void campaign() {
     
      WebElement tabhome = driver.findElement(By.xpath("//a[@id='ui-id-1']"));
      
      final String text_a = "Home";
      
       Assert.assertEquals(text_a, tabhome.getText());  
     
     driver.findElement(By.id("ui-id-2")).click();
   
     driver.findElement(By.xpath("//input[@id='campname']")).sendKeys("Hello Test");

        WebElement select = driver.findElement(By.xpath("//select[@id='lstkeyword']"));

        List<WebElement> allOptions = select.findElements(By.tagName("option"));

        for (WebElement option : allOptions) {

            System.out.println(String.format("Value is: %s", option.getAttribute("value")));
            String optval = option.getAttribute("value");
            if (optval.equals("103")) {
                option.click();
            }
        }
        //smsmessage  smssendtime  smssubmit
        WebElement msg = driver.findElement(By.xpath("//textarea[@id='smsmessage']"));

        msg.sendKeys("This message bodey was set from selenium automation and should save in db");

        WebElement sendtime = driver.findElement(By.xpath("//input[@id='smssendtime']"));

        sendtime.sendKeys("2015/02/04 10:30:00");

        WebElement submit = driver.findElement(By.xpath("//input[@id='smssubmit']"));

        submit.click();

        WebElement chweekly = driver.findElement(By.xpath("//input[@id='weekly']"));

        chweekly.click();

        WebElement monthslct = driver.findElement(By.xpath("//select[@id='weekofmonth']"));

        List<WebElement> weekopt = monthslct.findElements(By.tagName("option"));

        for (WebElement option : weekopt) {

            System.out.println(String.format("Value is: %s", option.getAttribute("value")));
            String optval = option.getAttribute("value");
            if (optval.equals("3")) {
                option.click();
            }
        }
        //createmoremsg
        WebElement weekmsg = driver.findElement(By.xpath("//textarea[@id='createmoremsg']"));

        weekmsg.sendKeys("This message bodey was set for weekly report and can be saved in db");

        //moremsgsave
        WebElement more_msg = driver.findElement(By.xpath("//input[@id='moremsgsave']"));

        more_msg.click();

        chweekly.click();

        WebElement monthly = driver.findElement(By.xpath("//input[@id='monthly']"));

        monthly.click();

        WebElement monthofyear = driver.findElement(By.xpath("//select[@id='monthofyear']"));

        List<WebElement> monthopt = monthofyear.findElements(By.tagName("option"));

        for (WebElement option : monthopt) {

            System.out.println(String.format("Value is: %s", option.getAttribute("value")));
            String optval = option.getAttribute("value");
            if (optval.equals("7")) {
                option.click();
            }
        }
        //createmoremsg
        WebElement monthlymsg = driver.findElement(By.xpath("//textarea[@id='monthlymsgmore']"));

        monthlymsg.sendKeys("This message bodey was set for weekly report and can be saved in db");

        //moremsgsave
        WebElement monthlymsgsave = driver.findElement(By.xpath("//input[@id='monthlymsgsave']"));

        monthlymsgsave.click();

        monthly.click();

    }

}
