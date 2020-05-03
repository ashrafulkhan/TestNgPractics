package com.scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWait {


    private WebDriver driver;

    @BeforeMethod
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");

    }
    @Test
    public void ExpliciteWaitTest(){


        driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement element = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()= 'WebDriver']")));

        boolean status = element.isDisplayed();

        if(status==true){
            System.out.println("WebDriver is displayed ");
        }else {
            System.out.println("WebDriver is not displayed ");
        }


    }




    @AfterMethod
    public void after(){
        // driver.quit();
    }


}
