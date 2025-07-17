package selenium4.webelementscreenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WebElementScreenshot {
    @Test
    public void elementScreenshotTest() throws IOException {
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
        WebElement name = driver.findElement(By.cssSelector("div[class='form-group'] input[name='name']"));
        name.sendKeys(courseName);
        File elementScreenshot = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(elementScreenshot, new File(System.getProperty("user.dir") +
                "/selenium4/webelementscreenshot/element.png"));
        driver.close();
    }
}
