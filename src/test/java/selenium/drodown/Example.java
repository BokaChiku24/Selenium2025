package selenium.drodown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Example {
    @Test
    public void dropdownTestcase() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("divpaxinfo")).click();

        Thread.sleep(2000L);

   /*int i=1;

while(i<5)

{

driver.findElement(By.id("hrefIncAdt")).click();

i++;

}*/

        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        for (int i = 1; i < 5; i++) {

            driver.findElement(By.id("hrefIncAdt")).click();

        }

        driver.findElement(By.id("btnclosepaxoption")).click();

        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        driver.close();
    }
}