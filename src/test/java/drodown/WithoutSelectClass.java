package drodown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class WithoutSelectClass {
    @Test
    public void dropdownTestcase() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='divpaxinfo']")));
        driver.findElement(By.xpath(".//div[@id='divpaxinfo']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hrefIncAdt")));
        int adult = 1;
        while (adult < 5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            adult++;
        }
        int child = 1;
        while (child < 3) {
            driver.findElement(By.id("hrefIncChd")).click();
            child++;
        }
        driver.findElement(By.cssSelector("#hrefIncInf")).click();
        System.out.println("Final text is: " + driver.findElement(By.className("paxinfo")).getText());
        driver.close();
    }
}
