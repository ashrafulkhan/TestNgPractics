package com.scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DragAndDrop {


    private WebDriver driver;

    @BeforeMethod
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("http://jqueryui.com/resources/demos/droppable/default.html");

    }

    @Test
    public void test(){

        Actions actions = new Actions(driver);




        WebElement drag=driver.findElement(By.xpath(".//*[@id='draggable']"));
        WebElement drop=driver.findElement(By.xpath(".//*[@id='droppable']"));

        actions.dragAndDrop(drag,drop).build().perform();

    }

    @AfterMethod
    public void after(){
       // driver.quit();
    }

}
