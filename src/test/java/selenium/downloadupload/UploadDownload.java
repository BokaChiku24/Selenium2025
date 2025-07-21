package selenium.downloadupload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class UploadDownload {
    @Test
    public void testUploadDownload() {
        String filePath = "/Users/kunalchavan/Downloads/download.xlsx";
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");

        // Download existing excel
        driver.findElement(By.id("downloadButton")).click();

        // upload to modify excel
        WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
        upload.sendKeys(filePath);

        // wait for success message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Toastify__toast-body")));
        String toastMessage = driver.findElement(By.cssSelector(".Toastify__toast-body")).getText();
        Assert.assertEquals(toastMessage, "Updated Excel Data Successfully.");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".Toastify__toast-body")));

        String product = "Apple";
        WebElement element = driver.findElement(By.xpath(".//div[text()='" + product + "']/parent::div/parent::div/div[4]"));
        System.out.println(product + " price is: " + element.getText());
        Assert.assertEquals(element.getText(),String.valueOf(345));

        // edit the existing excel
        int columnNumber = getColumnNumber(filePath,"Price");
        int rowNumber = getRowNumber(filePath,"Apple");
        updateCell(filePath,rowNumber,columnNumber,"599");

        driver.close();


    }

    private void updateCell(String filePath, int rowNumber, int columnNumber, String number) {
    }

    private int getRowNumber(String filePath, String apple) {
    }

    private int getColumnNumber(String filePath, String price) {
    }
}
