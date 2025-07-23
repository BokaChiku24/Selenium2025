package selenium.chromedevtools.network;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v138.fetch.Fetch;
import org.openqa.selenium.devtools.v138.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v138.network.model.ErrorReason;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class NetworkFailedTest {
    @Test
    public void testNetworkFailed() {
        // This is a placeholder for the Network Failed test.
        // The actual implementation will depend on the specific requirements
        // and the mocking framework used (e.g., using Chrome DevTools Protocol).
        System.out.println("Network Failed test is not yet implemented.");
        System.out.println("Network Mocking test is not yet implemented.");
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver"
        );
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        Optional<List<RequestPattern>> pattern = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook**"), Optional.empty(),
                Optional.empty())));
        devTools.send(Fetch.enable(pattern, Optional.empty()));
        devTools.addListener(Fetch.requestPaused(), request -> {
            devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
        });
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
        driver.close();
    }
}
