package com.scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchBus {

    public WebDriver driver;

    @BeforeMethod
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.redbus.in/");

    }


    @Test
    public void checkBuses()
    {

        Utility.isElementPresnt(driver,".//*[@id='txtSource']", 20).sendKeys("Bangalore");

        Utility.isElementPresnt(driver,".//*[@id='txtDestination']", 20).sendKeys("Chennai");
    }


    @AfterMethod
    public void after(){
        // driver.quit();
    }

}
