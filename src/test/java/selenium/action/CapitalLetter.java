package selenium.action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * This class demonstrates how to use Selenium WebDriver and Actions
 * to type text in uppercase in Amazon's search box.
 */
public class CapitalLetter {

    /**
     * Test method to open Amazon, focus the search box, and type "PlayStation 5"
     * with "PlayStation" in uppercase using the SHIFT key.
     */
    @Test
    public void testCapitalLetter() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");

        // Initialize Chrome WebDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set an implicit wait of 5 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navigate to Amazon India homepage
        driver.get("https://www.amazon.in/");

        // Create Actions instance for keyboard and mouse actions
        Actions action = new Actions(driver);

        // Focus the search box, hold SHIFT, type "PlayStation ", release SHIFT, then type "5"
        action.moveToElement(driver.findElement(By.cssSelector(".nav-search-field  #twotabsearchtextbox")))
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("PlayStation ")
                .keyUp(Keys.SHIFT)
                .sendKeys("5")
                .build()
                .perform();

        // Close the browser
        driver.close();
    }
}