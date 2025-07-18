package selenium.checkbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Chechbox {
    @Test
    public void testCheckbox() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".home-dis-checkboxes div input")));
        // total checkbox count
        List<WebElement> checkboxCount = driver.findElements(By.cssSelector(".home-dis-checkboxes div input"));
        System.out.println("Total checkbox count: " + checkboxCount.size());
        // total checkbox with name
        for (int i = 0; i < checkboxCount.size(); i++) {
            System.out.println("Checkbox no: [" + i + "] - " + driver.findElements(By.cssSelector(".home-dis-checkboxes div label")).get(i).getText());
            if(driver.findElements(By.cssSelector(".home-dis-checkboxes div label")).get(i).getText().equalsIgnoreCase("Senior Citizen"))
                checkboxCount.get(i).click();
        }
       // driver.close();
    }
}
