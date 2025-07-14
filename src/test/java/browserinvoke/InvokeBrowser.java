package browserinvoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeBrowser {

    public static void main(String[] args){
        /* Selenium 4.X - Selenium Manager
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.close();
        */
        // Selenium 3.x
        System.out.println(System.getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.close();
    }

}
