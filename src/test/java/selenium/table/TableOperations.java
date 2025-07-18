package selenium.table;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TableOperations {
    @Test
    public void tableTest() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/#/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        List<WebElement> amountList = driver.findElements(By.cssSelector(".tableFixHead tbody td:nth-child(4)"));
        int total = 0;
        for (int i = 0; i < amountList.size(); i++) {
            total = total + Integer.parseInt(amountList.get(i).getText());
        }
        System.out.println("Total amount is: " + total);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        int expectedTotal = Integer.parseInt(driver.findElement(By.cssSelector("div.totalAmount")).getText().split(":")[1].trim());
        Assert.assertEquals(total, expectedTotal);
    }
}
