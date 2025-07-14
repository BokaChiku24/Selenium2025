package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParentToChildLocator {
    @Test
    public void locators() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // Sibling - Child To Parent
        // cssSelector
        driver.findElement(By.cssSelector("header[class='jumbotron text-center header_style'] div button:nth-child(3)"));
        // xpath
        driver.findElement(By.xpath("//header[@class='jumbotron text-center header_style']/div//following-sibling::button[text()='Practice']"));
        driver.close();
    }
}
