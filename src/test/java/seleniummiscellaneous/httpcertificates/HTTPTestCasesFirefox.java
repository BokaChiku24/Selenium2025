package seleniummiscellaneous.httpcertificates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class HTTPTestCasesFirefox {
    @Test
    public void httpTest() {
        FirefoxOptions option = new FirefoxOptions();
        option.setAcceptInsecureCerts(true);
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/SeleniumDrivers/geckodriver");
        WebDriver driver = new FirefoxDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
        driver.close();
    }
}
