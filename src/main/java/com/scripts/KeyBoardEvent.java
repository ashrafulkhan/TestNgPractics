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

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class KeyBoardEvent {


    private WebDriver driver;

    @BeforeMethod
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://www.facebook.com/");

    }
    @Test
    public void keyBoardEventTest(){
        Actions act=new Actions(driver);
        driver.findElement(By.id("u_0_m")).sendKeys("selenium");

        act.sendKeys(Keys.TAB)
                .sendKeys("webdriver")

                .pause(Duration.ofSeconds(1))

                .sendKeys(Keys.TAB)

                .pause(Duration.ofSeconds(1))

                .sendKeys("898989898")

                .pause(Duration.ofSeconds(1))

                .sendKeys(Keys.TAB)

                .pause(Duration.ofSeconds(1))

                .sendKeys("abckd").build().perform();




    }




    @AfterMethod
    public void after(){
        // driver.quit();
    }


}
