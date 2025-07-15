package windowhandles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandle {
    @Test
    public void testWindowHandle(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.partialLinkText("Free Access")).click();
        //String parent = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles(); // [ParentID, ChildID, SubChildID]
        Iterator<String> itr = set.iterator();
        String parentID = itr.next();
        String childID = itr.next();
        driver.switchTo().window(childID);
        String email = driver.findElement(By.cssSelector(".col-md-8 .im-para.red a")).getText();
        driver.close();
        driver.switchTo().window(parentID);
        driver.findElement(By.id("username")).sendKeys(email);
    }
}
