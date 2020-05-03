package com.scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RightClick {


    private WebDriver driver;

    @BeforeMethod
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://www.google.com/search?ei=JC-uXvxo-6DK0w_mqY7oDg&q=http%3A%2F%2Fwww.google.com&oq=http%3A%2F%2Fwww.google.com&gs_lcp=CgZwc3ktYWIQAzICCAAyAggAMgIIADICCAAyAggAMgIIADICCAAyAggAMgIIADICCAA6BAgAEEc6BggAEBYQHjoECAAQDVDxzh1YuNQdYKngHWgAcAZ4AIABSYgB_AKSAQE2mAEAoAEBqgEHZ3dzLXdpeg&sclient=psy-ab&ved=0ahUKEwj8ir221ZbpAhV7kHIEHeaUA-0Q4dUDCAw&uact=5");

    }
    @Test
    public void rightClick(){
        Actions act=new Actions(driver);
        act.contextClick(driver.findElement(By.xpath("//a[@id='hdtb-tls']"))).perform();



    }




    @AfterMethod
    public void after(){
        // driver.quit();
    }

}
