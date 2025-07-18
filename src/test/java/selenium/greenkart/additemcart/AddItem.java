package selenium.greenkart.additemcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AddItem {
    @Test
    public void addItemToCart(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='products']/div/h4")));
        List<WebElement> itemName = driver.findElements(By.xpath(".//div[@class='products']/div/h4"));
        List<WebElement> itemAdd = driver.findElements(By.xpath("//div[@class='products']/div/div/button"));
        String[] items = {"Walnuts - 1/4 Kg","Water Melon - 1 Kg","Cucumber - 1 Kg","Banana - 1 Kg","Brinjal - 1 Kg"};
        int countLoop = 0;
        for(int i = 0; i<itemName.size(); i++){
            for(String name: items) {
                if (itemName.get(i).getText().equalsIgnoreCase(name)) {
                    countLoop++;
                    itemAdd.get(i).click();
                    break;
                }
                if(countLoop==items.length)
                    break;
            }
        }
        /*
        List<String> name = Arrays.asList(items);
         for(int i = 0; i<itemName.size(); i++){
                if (itemName.get(i).getText().equalsIgnoreCase(name.contains(itemName.get(i).getText())) {
                    itemAdd.get(i).click();
                    break;
                }
            }
         */
    //    driver.close();
    }
}
