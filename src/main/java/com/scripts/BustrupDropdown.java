package com.scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BustrupDropdown {
    private WebDriver driver;

    @BeforeMethod
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("http://seleniumpractise.blogspot.in/2016/08/bootstrap-dropdown-example-for-selenium.html");

    }

    @Test
    public void test(){

        WebElement dropDown = driver.findElement(By.id("menu1"));
        dropDown.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement>  list = driver.findElements(By.xpath("//ul [@class='dropdown-menu']//li/a"));

        for(WebElement ele : list){

            System.out.println("value : "+ele.getAttribute("innerHTML"));



            if (ele.getAttribute("innerHTML").contains("JavaScript")){
                ele.click();
                break;
            }



        }




    }

    @AfterMethod
    public void after(){
        driver.quit();
    }


}
