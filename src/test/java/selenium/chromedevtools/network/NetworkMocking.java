package selenium.chromedevtools.network;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v138.fetch.Fetch;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Optional;

public class NetworkMocking {
    @Test
    public void testNetworkMocking() {
        // This is a placeholder for the Network Mocking test.
        // The actual implementation will depend on the specific requirements
        // and the mocking framework used (e.g., using Chrome DevTools Protocol).
        System.out.println("Network Mocking test is not yet implemented.");
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver"
        );
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
        devTools.addListener(Fetch.requestPaused(), request -> {
            if (request.getRequest().getUrl().contains("shetty")) {
                // Continue with the request if it is not from the specified domain
                String newURL = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
                devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(newURL), Optional.of(request.getRequest().getMethod()),
                        request.getRequest().getPostData(), Optional.empty(), Optional.empty()));
            } else {
                devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()),
                        request.getRequest().getPostData(), Optional.empty(), Optional.empty()));
            }
        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
        System.out.println(driver.findElement(By.tagName("p")).getText());// Close the browser
        driver.close();
    }
}
