package com.scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class KeyBoardEvent2 {


    private WebDriver driver;

    @BeforeMethod
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://the-internet.herokuapp.com/key_presses?");

    }
    @Test
    public void keyBoardEventTest(){
        Actions act=new Actions(driver);

        act.sendKeys(Keys.ESCAPE).perform();


        if(driver.findElement(By.xpath("//p[@id='result']")).getText().contains("ESCAPE")){

            System.out.println("You have keys press");

        }

    }




    @AfterMethod
    public void after(){
        // driver.quit();
    }


}
