package selenium4.multiplewindowtab;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class MultipleWindow {

    @Test
    public void mulipleWindowTest() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> itr = handles.iterator();
        String parentWindow = itr.next();
        String childWindow = itr.next();
        driver.switchTo().window(childWindow);
        driver.get("https://rahulshettyacademy.com/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        String courseName = driver.findElement(By.cssSelector("div.courses-block:nth-child(1) h2 a")).getText();
        driver.close();
        driver.switchTo().window(parentWindow);
        driver.findElement(By.cssSelector("div[class='form-group'] input[name='name']")).sendKeys(courseName);
        driver.close();
    }
}
