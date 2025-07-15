package linkcount;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class OpenLinks {
    @Test
    public void testOpenLinks() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1600)");
        WebElement footerSection = driver.findElement(By.cssSelector("#gf-BIG .gf-t")); // limiting WebDriver scope
        System.out.println("Footer total links: " + footerSection.findElements(By.tagName("a")).size());
        WebElement limitFooterSection = driver.findElement(By.cssSelector("#gf-BIG .gf-t td:nth-child(1) ul"));
        System.out.println("1st Column Footer total links: " + limitFooterSection.findElements(By.tagName("a")).size());

        driver.close();
    }
}
