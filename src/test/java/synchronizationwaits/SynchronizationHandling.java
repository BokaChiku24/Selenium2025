package synchronizationwaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SynchronizationHandling {
    static WebDriverWait wait;
    @Test
    public void synchronizationTest(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='products']/div/h4")));
        addItemToCart(driver);
        cartTestCases(driver);
        driver.close();
    }
    public static void addItemToCart(WebDriver driver){
        List<WebElement> itemName = driver.findElements(By.xpath(".//div[@class='products']/div/h4"));
        List<WebElement> itemAdd = driver.findElements(By.xpath("//div[@class='products']/div/div/button"));
        String[] items = {"Beetroot - 1 Kg","Walnuts - 1/4 Kg","Water Melon - 1 Kg","Cucumber - 1 Kg","Banana - 1 Kg","Brinjal - 1 Kg"};
        List<String> name = new ArrayList<>();
        for(int i = 0; i< items.length; i++){
            name.add(items[i].split("-")[0].trim());
        }
        int countLoop = 0;
        for(int i = 0; i<itemName.size(); i++) {
            for(int j = 0; j<name.size();j++) {
                if (itemName.get(i).getText().contains(name.get(j))) {
                    countLoop++;
                    itemAdd.get(i).click();
                }
            }
            if (countLoop == name.size()) {
                break;
            }
        }
    }

    public static void cartTestCases(WebDriver driver){
        driver.findElement(By.cssSelector(".cart-icon img[alt='Cart']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='action-block']/button[text()='PROCEED TO CHECKOUT']")));
        driver.findElement(By.xpath("//div[@class='action-block']/button[text()='PROCEED TO CHECKOUT']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
        driver.findElement(By.className("promoCode")).sendKeys("Kunal");
        driver.findElement(By.cssSelector(".promoBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
        Assert.assertEquals(driver.findElement(By.className("promoInfo")).getText(),"Invalid code ..!");
        driver.findElement(By.className("promoCode")).clear();
        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector(".promoBtn")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("promoInfo"),"Code applied ..!"));
        Assert.assertEquals(driver.findElement(By.className("promoInfo")).getText(),"Code applied ..!");
    }
}
