package action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class CapitalLetter {
    @Test
    public void testCapitalLetter() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.amazon.in/");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector(".nav-search-field  #twotabsearchtextbox"))).click()
                .keyDown(Keys.SHIFT).sendKeys("PlayStation ").keyUp(Keys.SHIFT).sendKeys("5").build().perform();
        driver.close();
    }
}
