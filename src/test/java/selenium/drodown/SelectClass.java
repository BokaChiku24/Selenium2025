package selenium.drodown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SelectClass {
    @Test
    public void dropdownTestcase() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_mainContent_DropDownListCurrency")));
        WebElement currencyDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select select = new Select(currencyDropdown);
        select.selectByVisibleText("USD");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByIndex(2);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByValue("INR");
        System.out.println(select.getFirstSelectedOption().getText());
        driver.close();
    }
}
