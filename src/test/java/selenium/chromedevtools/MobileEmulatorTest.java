package selenium.chromedevtools;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v138.emulation.Emulation;
import org.openqa.selenium.devtools.v138.emulation.model.ScreenOrientation;
import org.testng.annotations.Test;

import java.util.Optional;


public class MobileEmulatorTest {
    @Test
    public void testMobileEmulator() {
        // Set the path to the ChromeDriver executable
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver"
        );

        // Initialize ChromeDriver for Chrome DevTools Protocol usage
        ChromeDriver driver = new ChromeDriver();

        // Create a DevTools session
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Set the user agent to emulate a mobile device
        // Set user agent for iPhone 15 Pro Max
        String userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 17_0 like Mac OS X) " +
                "AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.0 Mobile/15E148 Safari/604.1";

        devTools.send(Emulation.setUserAgentOverride(
                userAgent,
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        ));

        // Emulate a mobile device using Chrome DevTools Protocol
        devTools.send(
                Emulation.setDeviceMetricsOverride(
                        400,
                        932,
                        3,
                        true,
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.of(new ScreenOrientation(ScreenOrientation.Type.PORTRAITPRIMARY, 0)),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty()
                )
        );

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.className("navbar-toggler-icon")).click();

        // Close the browser
        // driver.close();
    }
}
