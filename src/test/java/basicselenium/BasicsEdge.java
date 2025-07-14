package basicselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class BasicsEdge {

    @Test
    public void testEdge() {
        System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/SeleniumDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
    }
}
