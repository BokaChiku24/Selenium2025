package selenium.chromedevtools;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;

import org.openqa.selenium.Keys;
import java.util.HashMap;
import java.util.Map;

public class GEOLocation {
    @Test
    public void testGEOLocation(){
        // This test is a placeholder for future implementation of geolocation commands using CDP.
        // You can implement the geolocation commands here as needed.
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver"
        );

        // Initialize ChromeDriver for Chrome DevTools Protocol usage
        ChromeDriver driver = new ChromeDriver();

        // Create a DevTools session
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        // Set geolocation parameters

        // Example: Set geolocation to New York City (latitude, longitude, accuracy)

        Map<String, Object> ccordinates = new HashMap<String, Object>();
        ccordinates.put("latitude", 40.7128);
        ccordinates.put("longitude", -74.0060);
        ccordinates.put("accuracy", 100);

        driver.executeCdpCommand("Emulation.setGeolocationOverride", ccordinates);

        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("netflix", Keys.RETURN);
        driver.findElements(By.cssSelector(".LC20lb")).getFirst().click();
        String title = driver.findElement(By.cssSelector(".our-story-card-title")).getText();
        System.out.println(title);

        // Implement geolocation commands here
        driver.close();
    }
}
