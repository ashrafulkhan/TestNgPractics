package com.scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Radio {

    protected WebDriver driver;

    @BeforeMethod
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test() {
        driver.get("http://www.facebook.com");
        WebElement element = driver.findElement(By.id("u_0_7"));
        boolean status = element.isDisplayed();
        System.out.println("Male element is displayed "+ status);

        boolean isBoolean = element.isEnabled();
        System.out.println(" Male element is enable "+isBoolean);

        boolean is_Selected = element.isSelected();
        System.out.println(" male element is selected  "+is_Selected);

        element.click();

        boolean is_Selected_new = element.isSelected();
        System.out.println(" male element is selected  "+is_Selected_new);

    }

    @AfterMethod
    public void after() {
        driver .close();
    }

}
