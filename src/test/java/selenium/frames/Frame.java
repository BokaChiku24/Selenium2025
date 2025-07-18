package selenium.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Frame {

    @Test
    public void testFrames(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
        // driver.switchTo().frame(0);
        Actions action = new Actions(driver);
        WebElement source = driver.findElement(By.cssSelector("body #draggable"));
        WebElement target = driver.findElement(By.cssSelector("body #droppable"));
        action.dragAndDrop(source,target).build().perform();
        driver.close();
    }
}
