package selenium.seleniummiscellaneous.httpcertificates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class HTTPTestCasesEdge {
    @Test
    public void httpTest() {
        EdgeOptions option = new EdgeOptions();
        option.setAcceptInsecureCerts(true);
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/SeleniumDrivers/msedgedriver");
        WebDriver driver = new EdgeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
        driver.close();
    }
}
