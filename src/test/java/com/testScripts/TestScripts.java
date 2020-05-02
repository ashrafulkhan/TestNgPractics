package com.testScripts;

import com.scripts.TestPractics;
import org.testng.annotations.Test;

public class TestScripts extends TestPractics{

    @Test(groups = {"smoketest"})
    public void test(){

        //WebElement element=driver.findElement(By.xpath(".//*[@id='link-to-login']/a"));
        //element.click();

        System.out.println("This first test");
    }


    @Test(groups = {"functionaltest"})
    public void test2(){
       // WebElement element=driver.findElement(By.xpath(".//*[@id='spree_user_email']"));
       // element.sendKeys("kartick017@yahoo.com");

        System.out.println("This  second test");
    }
    @Test(groups = {"smoketest"})
    public void test3(){
        //WebElement element=driver.findElement(By.id("spree_user_password"));
       // element.sendKeys("bangladesh");
        System.out.println("This thidr test");
    }
    @Test(groups = {"regration"})
    public void test4(){
        //WebElement element=driver.findElement(By.xpath(".//form[@id='new_spree_user']//input[@type='submit']"));
       // element.click();
        System.out.println("This forth test");
    }
    @Test
    public void test5(){

        System.out.println("This fifth test");
    }
}
