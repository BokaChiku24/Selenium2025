package selenium.link;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLink {
    @Test
    public void brokenLinkTest() throws IOException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximize the browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        SoftAssert soft = new SoftAssert();

        // broken URL
        // step 1: get all urls tied up to the link using selenium
        // step 2: java method will call URL's and gets you the status code
        // step 3: if status code > 400 then that url is not working -> link which tied to url is broken
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1800)");
        String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getDomAttribute("href");
        System.out.println(url);
        HttpURLConnection con = (HttpURLConnection)new URL(url).openConnection();
        con.setRequestMethod("HEAD");
        con.connect();
        int responseCode = con.getResponseCode();
        System.out.println(responseCode);
        List<WebElement> links = driver.findElements(By.cssSelector(".gf-li a[href]"));
        for(int i = 0; i< links.size(); i++){
            String urls = links.get(i).getDomAttribute("href");
            if(!links.get(i).getDomAttribute("href").equalsIgnoreCase("#")) {
                con = (HttpURLConnection) new URL(urls).openConnection();
                con.setRequestMethod("HEAD");
                con.connect();
                responseCode = con.getResponseCode();
                //System.out.println("Link name: " + links.get(i).getText() + " - " + " Status Code: " + responseCode);
                if(responseCode > 400){
                    // Assert.assertTrue(false); hard assertion
                    soft.assertTrue(false); // soft assertion
                    System.out.println("Broken link name is: " + links.get(i).getText() + " - " + " Status Code: " + responseCode);
                }
            }
        }
        soft.assertAll();
        driver.close();

    }
}
