package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HappyPath {
    WebDriver driver;
    WebDriverWait wait;
    @Test
    public void loginTest() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        String username = "Kunal";
        String password = getPassword(driver);
        driver.findElement(By.xpath("//button[text()='Go to Login']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputUsername")));
        driver.findElement(By.id("inputUsername")).sendKeys(username);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",driver.findElement(By.cssSelector("#chkboxOne")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",driver.findElement(By.xpath(".//div[@class='checkbox-container']/span/input[@name='chkboxTwo']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",driver.findElement(By.xpath(".//button[contains(@type,'submit')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Log Out']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".login-container p")));
        WebElement loginSuccessMessage = driver.findElement(By.cssSelector(".login-container p"));
        Assert.assertEquals(loginSuccessMessage.getText(), "You are successfully logged in.");
        String loginMessage = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(loginMessage, "Hello " + username + ",");
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        driver.close();
    }

    public String getPassword(WebDriver driver){
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
        return temporaryPassword;
    }
}
