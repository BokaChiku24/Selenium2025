package selenium.chromedevtools.network;

import com.google.common.collect.ImmutableList;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v138.network.Network;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Optional;

public class BlockNetworkRequest {
    @Test
    public void testBlockNetworkRequest() {
        // This is a placeholder for the Block Network Request test.
        // The actual implementation will depend on the specific requirements
        // and the mocking framework used (e.g., using Chrome DevTools Protocol).
        System.out.println("Block Network Request test is not yet implemented.");
        // You can implement the logic to block network requests here.
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver"
        );
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        // It is used to block images, large image which consume more bandwidth
        devTools.send(Network.enable(Optional.empty(), Optional.empty(),
                Optional.empty(), Optional.empty()));
        devTools.send(Network.setBlockedURLs(ImmutableList.of(".jpg", ".png", ".gif" , "*.css")));
        long startTime = System.currentTimeMillis();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        driver.findElement(By.tagName("p")).getText();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        driver.close();
    }
}
