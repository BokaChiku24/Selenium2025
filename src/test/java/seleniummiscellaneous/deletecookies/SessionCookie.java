package seleniummiscellaneous.deletecookies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SessionCookie {
    @Test
    public void cookiTest(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximize the browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        driver.get("https://expired.badssl.com/");
        driver.manage().deleteCookieNamed("sessionKey"); // delete specific cookie
        driver.findElement(By.tagName("a")).click();
        // verify it navigates to the login screen when click on the any link
        System.out.println(driver.getTitle());
        driver.close();
    }
}
