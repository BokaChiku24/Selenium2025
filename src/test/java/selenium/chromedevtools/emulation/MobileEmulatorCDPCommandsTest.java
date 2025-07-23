package selenium.chromedevtools.emulation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;

public class MobileEmulatorCDPCommandsTest {
    @Test
    public void testMobileEmulatorCDPCommands() throws InterruptedException {
        // This test is a placeholder for future implementation of mobile emulator commands using CDP.
        // Currently, it does not perform any actions.
        // You can implement the mobile emulator commands here as needed.
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver"
        );

        // Initialize ChromeDriver for Chrome DevTools Protocol usage
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        HashMap map = new HashMap();
        map.put("width", 400);
        map.put("height", 932);
        map.put("deviceScaleFactor", 3);
        map.put("mobile", true);
        map.put("screenOrientation", new HashMap<String, Object>() {{
            put("type", "portraitPrimary");
            put("angle", 0);
        }});

        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", map);

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.className("navbar-toggler-icon")).click();
       Thread.sleep(Duration.ofSeconds(3));
        driver.findElement(By.linkText("Library")).click();
        // Close the browser
        driver.close();
    }
}
