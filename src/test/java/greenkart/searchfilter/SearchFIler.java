package greenkart.searchfilter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SearchFIler {
    @Test
    public void seahFilterTest(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10L));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div input#search-field")));
        driver.findElement(By.cssSelector("div input#search-field")).sendKeys("Rice");
        List<WebElement> searchList = driver.findElements(By.cssSelector("tbody td:nth-child(1)"));
        List<WebElement> filteredList = searchList.stream().filter(s->s.getText()
                .contains("Rice")).collect(Collectors.toList());
        Assert.assertEquals(searchList.size(), filteredList.size());
        driver.close();
    }
}
