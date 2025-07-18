package selenium.drodown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicDropdown {
    @Test
    public void dropdownTestcase() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")));
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//a[@value='BOM']"
        )));
        driver.findElement(By.xpath(".//a[@value='BOM']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='HYD']")));
        driver.findElement(By.xpath(".//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='HYD']")).click();
       // driver.close();
    }
}
