package selenium.selenium4.relativelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DateOfBirth {
    @Test
    public void belowTest() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)");
        WebElement dob = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
        driver.findElement(RelativeLocator.with(By.tagName("input")).below(dob)).sendKeys("24/09/1991");
        driver.close();
    }
}
