package selenium.drodown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AutoSuggestiveDropdown {
    @Test
    public void testAutoSuggestiveDropdown(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='autosuggest']")));
        driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("Ind");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[id='ui-id-1'] li:nth-child(3) a")));
        driver.findElement(By.cssSelector("ul[id='ui-id-1'] li:nth-child(3) a")).click();
    }
}
