package selenium.selenium4.relativelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Below {
    @Test
    public void belowTest(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
        driver.findElement(By.cssSelector("[name='name']")).click();
        driver.findElement(By.cssSelector("[name='email']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//div[@class='alert alert-danger' and text()='Name is required']"),"Name is required"));
        String text = driver.findElement(RelativeLocator.with(By.xpath(".//div[@class='alert alert-danger' and text()='Name is required']"))
                .below(nameEditBox)).getText();
        System.out.println("Name is: " + text);
        driver.close();
    }
}
