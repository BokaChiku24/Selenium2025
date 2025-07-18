package selenium.selenium4;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class NewWindow {
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        driver.get("https://rahulshettyacademy.com/angularpractice/");

//Switching Window

        driver.switchTo().newWindow(WindowType.WINDOW);

        Set<String> handles = driver.getWindowHandles();

        Iterator<String> it = handles.iterator();

        String parentWindowId = it.next();

        String childWindow = it.next();

        driver.switchTo().window(childWindow);

        driver.get("https://rahulshettyacademy.com/");

        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))

                .get(1).getText();

        driver.switchTo().window(parentWindowId);

        WebElement name = driver.findElement(By.cssSelector("[name='name']"));

        name.sendKeys(courseName);

//Screenshot

        File file = name.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(file, new File("logo.png"));

//driver.quit();

//GEt Height & Width

        System.out.println(name.getRect().getDimension().getHeight());

        System.out.println(name.getRect().getDimension().getWidth());
        driver.quit();
    }


}
