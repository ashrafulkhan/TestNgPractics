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

public class MouseHover {



    private WebDriver driver;

    @BeforeMethod
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("http://www.naukri.com");

    }

    @Test
    public void test(){

        Actions actions = new Actions(driver);

        driver.findElement(By.id("qsb-keyword-sugg")).sendKeys("test");


        Actions actions1 = new Actions(driver);
        WebElement ele=driver.findElement(By.xpath("//div [@id ='sugDrp_qsb-keyword-sugg']/ul/li[1]"));
        actions1.moveToElement(ele).build().perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actions1.click(ele).build().perform();


    }

    @AfterMethod
    public void after(){
        // driver.quit();
    }


}
