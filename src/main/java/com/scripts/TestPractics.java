package com.scripts;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestPractics {
      protected WebDriver driver;

      @BeforeMethod
      public void beforeMethod(){
            ChromeDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("http://spree.shiftedtech.com");


      }


      @AfterMethod
      public void afterMethod(){
       driver.close();

      }



}
