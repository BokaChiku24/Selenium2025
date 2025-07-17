package greenkart.searchfilter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10L));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.id("search-field")).sendKeys("Rice");

        List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));

        //1 results

        List<WebElement> filteredList= veggies.stream().filter(veggie->veggie.getText().contains("Rice")).

                collect(Collectors.toList());

        //1 result

        Assert.assertEquals(veggies.size(), filteredList.size());
        driver.close();
    }


}
