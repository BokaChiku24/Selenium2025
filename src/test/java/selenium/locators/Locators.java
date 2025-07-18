package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Locators {

    @Test
    public void testLocators() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); for all elements
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("Kunal");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.xpath(".//input[@value='rmbrUsername']")).click();
        driver.findElement(By.xpath(".//div[@class='checkbox-container']/span/input[@name='chkboxTwo']")).click();
        driver.findElement(By.xpath(".//button[contains(@type,'submit')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//form/p[@class='error']")));
        WebElement element = driver.findElement(By.xpath(".//form/p[@class='error']"));
        String errorMessage = element.getText();
        System.out.println(errorMessage);
        driver.findElement(By.linkText("Forgot your password?")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("form[action='#'] > input[placeholder='Name']"))));
        driver.findElement(By.cssSelector("form[action='#'] > input[placeholder='Name']")).sendKeys("Kunal");
        driver.findElement(By.cssSelector("form[action='#'] > input[placeholder='Email']")).sendKeys("kunalchavan24@gmail.com");
        driver.findElement(By.cssSelector("form[action='#'] > input[placeholder='Phone Number']")).sendKeys("1234567890");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("p.infoMsg"))));
        WebElement resetLoginMessage = driver.findElement(By.cssSelector("p.infoMsg"));
        String resetMessage = resetLoginMessage.getText();
        String[] splitResetLoginMessage = resetMessage.split("'");
        String temporaryPassword = splitResetLoginMessage[1];
        System.out.println("The temporary password is: " + temporaryPassword);
        driver.close();
    }
}
