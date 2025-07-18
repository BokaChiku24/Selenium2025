package selenium.basicselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BasicsFirefox {

    @Test
    public void testFirefox() {
        /* Selenium 4.X - Selenium Manager
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        driver.close();
        */
        // Selenium 3.x
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/SeleniumDrivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
    }
}