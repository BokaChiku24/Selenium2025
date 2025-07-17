package link;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class OpenLinks {
    @Test
    public void testOpenLinks() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1600)");
        WebElement footerSection = driver.findElement(By.cssSelector("#gf-BIG .gf-t")); // limiting WebDriver scope
        System.out.println("Footer total links: " + footerSection.findElements(By.tagName("a")).size());
        WebElement limitFooterSection = driver.findElement(By.cssSelector("#gf-BIG .gf-t td:nth-child(1) ul"));
        System.out.println("1st Column Footer total links: " + limitFooterSection.findElements(By.tagName("a")).size());
        Actions action = new Actions(driver);
        List<WebElement> linkOpen = limitFooterSection.findElements(By.tagName("a"));
        for(int i = 0; i < linkOpen.size(); i++){
            action.keyDown(Keys.COMMAND).click(linkOpen.get(i)).keyUp(Keys.COMMAND).build().perform();
            // Keys.chord(Keys.COMMAND,Keys.RETURN);
        }
        /*
        OR
         for(int i = 0; i < limitFooterSection.findElements(By.tagName("a")).size()); i++){
            String commandMac = Keys.chord(Keys.COMMAND, Keys.Return); // mac
            String commandWindows = Keys.chord(Keys.CONTROL, Keys.ENTER); // windows
            limitFooterSection.findElements(By.tagName("a")).get(i).sendKeys(command);
        }
         */
        driver.close();
    }
}
