package selenium.chromedevtools.network;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v138.network.Network;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Optional;

public class LogNetworkActivity {
    @Test
    public void testNetworkActivity() throws InterruptedException {
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver"
        );

        // Initialize ChromeDriver for Chrome DevTools Protocol usage
        ChromeDriver driver = new ChromeDriver();
        // Log network activity using Chrome DevTools Protocol
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.addListener(Network.requestWillBeSent(), request -> {
            String url = request.getRequest().getUrl();
            System.out.println("Request URL: " + url);
            System.out.println("Request Headers: " + request.getRequest().getHeaders());
        });

        devTools.addListener(Network.responseReceived(), response -> {
            String url = response.getResponse().getUrl();
            int status = response.getResponse().getStatus();
            System.out.println("URL: " + url + " | Status: " + status);
            if (status >= 400) {
                System.out.println("Error response received for URL: " + url);
            }
        });
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
        // Close the browser
        driver.close();
    }
}
