package selenium.chromedevtools.logconsoleerros;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LogErrors {
    @Test
    public void testLogErrors(){
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver"
        );
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        // Listeners - TestFailed TestNG
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.partialLinkText("Selenium")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        driver.findElement(By.linkText("Cart")).click();
        try {
            Thread.sleep(Duration.ofSeconds(3));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("exampleInputEmail1")).clear();
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");

        LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> log = entries.getAll();
        for (LogEntry entry : log) {
            System.out.println("Log: " + entry.getMessage());
            if (entry.getLevel().toString().equals("SEVERE")) {
                System.out.println("Error found: " + entry.getMessage());
            }
        }
        driver.close();
    }
}
