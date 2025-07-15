package calendar;

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

public class Calendar {
    @Test
    public void testValidation() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        // one way
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table[id*='rbtnl_Trip'] tbody tr td:nth-child(1) input")));
        System.out.println((driver.findElement(By.xpath("//div[@id='Div1']")).getDomAttribute("style")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='Div1']")).getDomAttribute("style").equals("display: block; opacity: 0.5;"));
        Assert.assertTrue(driver.findElement(By.cssSelector("table[id*='rbtnl_Trip'] tbody tr td:nth-child(1) input")).isSelected());
        driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-state-active")));
        driver.findElement(By.className("ui-state-active")).click();
        // round trip
        Assert.assertFalse(driver.findElement(By.cssSelector("table[id*='rbtnl_Trip'] tbody tr td:nth-child(2) input")).isSelected());
        driver.findElement(By.cssSelector("table[id*='rbtnl_Trip'] tbody tr td:nth-child(2) input")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='Div1']")).getDomAttribute("style").equals("display: block; opacity: 1;"));
        driver.findElement(By.xpath("//div[@id='Div1']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//table[@class='ui-datepicker-calendar']/tbody/tr/td/a")));
        List<WebElement>  activeDate = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for(WebElement date : activeDate){
            if(date.getText().equalsIgnoreCase("20"))
                date.click();

        }
       // driver.close();
    }
}
