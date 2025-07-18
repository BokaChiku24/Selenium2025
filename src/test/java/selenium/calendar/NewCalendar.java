package selenium.calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class NewCalendar {
    @Test
    public void calendarTest() throws InterruptedException {
        String monthNumber = "6";
        String date = "15";
        String year = "2028";
        String expectedDate = 0+monthNumber+"/"+date+"/"+year;
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Top Deals")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        while (itr.hasNext()){
            driver.switchTo().window(itr.next());
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.className("react-date-picker__calendar-button")));
        driver.findElement(By.className("react-date-picker__calendar-button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".react-calendar__navigation__label > span")));
        driver.findElement(By.cssSelector(".react-calendar__navigation__label > span")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        /*
        List<WebElement> yearList = driver.findElements(By.cssSelector(".react-calendar__decade-view__years button"));
        for(int i = 0; i< yearList.size(); i++){
            if(yearList.get(i).getText().equalsIgnoreCase(year)){
                yearList.get(i).click();
                break;
            }
        }
        */
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        driver.findElements(By.className("react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();

        String actualDate = 0 + driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']/input[@class='react-date-picker__inputGroup__input react-date-picker__inputGroup__month react-date-picker__inputGroup__input--hasLeadingZero']")).getDomAttribute("value");
        String actualMonth = driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']/input[@class='react-date-picker__inputGroup__input react-date-picker__inputGroup__day']")).getDomAttribute("value");
        String actualYear = driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']/input[@class='react-date-picker__inputGroup__input react-date-picker__inputGroup__year']")).getDomAttribute("value");

        Assert.assertEquals(actualDate+"/"+actualMonth+"/"+actualYear,expectedDate);
        driver.close();
        driver.switchTo().window(parentWindow);
        driver.close();
        /*
        List<WebElement> monthList = driver.findElements(By.cssSelector(".react-calendar__year-view__months > button > abbr"));
        List<String> months = new ArrayList<String>();
        for (int i = 0; i < monthList.size(); i++) {
            months.add(monthList.get(i).getText());
            if(months.get(i).equals(monthList.get(i).getText())){
                monthList.get(i+1).click();
            }
        }
         */
    }

}
