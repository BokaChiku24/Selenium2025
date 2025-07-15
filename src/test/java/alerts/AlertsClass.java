package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertsClass {
    @Test
    public void alertTest(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("enter-name")));
        driver.findElement(By.name("enter-name")).sendKeys("Kunal Chavan");
        driver.findElement(By.id("alertbtn")).click();
        // alert button with ok
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals(alertMessage,"Hello Kunal Chavan, share this practice page and share your knowledge");
        alert.accept();
        // alert with confirmation
        driver.findElement(By.name("enter-name")).sendKeys("Kunal Chavan");
        driver.findElement(By.id("confirmbtn")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alertMessage = alert.getText();
        Assert.assertEquals(alertMessage,"Hello Kunal Chavan, Are you sure you want to confirm?");
        alert.dismiss();
        driver.close();
    }
}
