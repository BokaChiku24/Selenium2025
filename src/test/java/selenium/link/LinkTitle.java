package selenium.link;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LinkTitle {
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
        for (int i = 0; i < limitFooterSection.findElements(By.tagName("a")).size(); i++) {
            String commandMac = Keys.chord(Keys.COMMAND, Keys.RETURN); // mac
            String commandWindows = Keys.chord(Keys.CONTROL, Keys.ENTER); // windows
            limitFooterSection.findElements(By.tagName("a")).get(i).sendKeys(commandMac);
        }
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        List<String> title = new ArrayList<String>();
        while(itr.hasNext()){
                driver.switchTo().window(itr.next());
                title.add(driver.getTitle());
                driver.close();
        }
        System.out.println(title);
        driver.quit();
    }
}
