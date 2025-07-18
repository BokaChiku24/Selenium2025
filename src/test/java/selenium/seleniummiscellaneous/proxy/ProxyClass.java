package selenium.seleniummiscellaneous.proxy;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProxyClass {
    @Test
    public void httpTest() {
        ChromeOptions option = new ChromeOptions();
        option.setAcceptInsecureCerts(true);
        Proxy pr = new Proxy();
        pr.setHttpProxy("ipaddress:4444");
        option.setCapability("proxy",pr);
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
        driver.close();
    }
}
