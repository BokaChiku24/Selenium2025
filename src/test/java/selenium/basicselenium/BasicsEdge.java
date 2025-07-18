package selenium.basicselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class BasicsEdge {

    @Test
    public void testEdge() {
        /* Selenium 4.X - Selenium Manager
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com");
        driver.close();
        */
        // Selenium 3.x
        System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/SeleniumDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
    }
}
