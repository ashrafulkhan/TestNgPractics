package com.scripts;

import com.google.common.base.Function;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FluentWaitTest {


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



        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);


        wait.pollingEvery(1, TimeUnit.SECONDS);
        wait.withTimeout(20, TimeUnit.SECONDS);  // if you put 10 second then application will fail.
        WebElement element = wait.until(new Function<WebDriver, WebElement>(){


            // apply method- which accept webdriver as input



            @Override
            public WebElement apply(WebDriver arg0)
            {

                // find the element

                WebElement ele = arg0.findElement(By.xpath("//p[@id='demo']"));

// Will capture the inner Text and will compare will WebDriver

// If condition is true then it will return the element and wait will be over

                if (ele.getAttribute("innerHTML").equalsIgnoreCase("WebDriver"))
                {

                    System.out.println("Value is >>> " + ele.getAttribute("innerHTML"));

                    return ele;

                }

// If condition is not true then it will return null and it will keep checking until condition is not true

                else {
                    System.out.println("Value is >>> " + ele.getAttribute("innerHTML"));

                    return null;

                }

            }

        });

        System.out.println("Final visible status is >>>>> " + element.isDisplayed());

    }







            @AfterMethod
            public void after() {
                // driver.quit();
            }





}

