package selenium.seleniummiscellaneous.downloaddirectory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Directory {
    @Test
    public void directoryTest(){
        ChromeOptions option = new ChromeOptions();
        option.setAcceptInsecureCerts(true);
        Map<String,Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory","/directory/path");
        option.setExperimentalOption("prefs",prefs);
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
