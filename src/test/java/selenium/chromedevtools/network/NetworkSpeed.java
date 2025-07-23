package selenium.chromedevtools.network;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v138.network.Network;
import org.openqa.selenium.devtools.v138.network.model.ConnectionType;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Optional;

public class NetworkSpeed {
    @Test
    public void testNetworkSpeed() {
        // This is a placeholder for the Network Speed test.
        // The actual implementation will depend on the specific requirements
        // and the mocking framework used (e.g., using Chrome DevTools Protocol).
        System.out.println("Network Speed test is not yet implemented.");
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver"
        );
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        // Apply delay to simulate slow network speed i.e. 2 seconds - 3 seconds
        // This is applied for flanky and inconsistent network or test cases
        // Latency - Delay in milliseconds
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(
                false,
                2000,
                15000,
                10000,
                Optional.of(ConnectionType.CELLULAR2G),
                Optional.empty(),
                Optional.empty(),
                Optional.empty())
        );
        devTools.addListener(Network.loadingFailed(), loadingFailed -> {;
            System.out.println("Loading failed for URL: " + loadingFailed.getRequestId() +
                    " with error: " + loadingFailed.getErrorText());
            System.out.println("Loading failed for time stamp: " + loadingFailed.getTimestamp());
        });
        long startTime = System.currentTimeMillis();
        //driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.get("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
        driver.findElement(By.name("q")).sendKeys("netflix", Keys.RETURN);
        driver.findElements(By.cssSelector(".LC20lb")).getFirst().click();
        String title = driver.findElement(By.cssSelector(".our--story--card--title")).getText();
        System.out.println(title);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime + " milliseconds");
        driver.close();
    }
}
