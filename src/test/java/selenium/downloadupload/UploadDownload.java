package selenium.downloadupload;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

public class UploadDownload {
    @Test
    public void testUploadDownload() throws IOException {
        String fruitName = "Apple";
        String updatedValue = "603";
        String filePath = "/Users/kunalchavan/Downloads/download.xlsx";
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");

        // Download existing excel
        driver.findElement(By.cssSelector("#downloadButton")).click();

        //Edit excel - getColumnNumber of Price -getRownumber of Apple-> update excel with row,col
        int col =getColumnNumber(filePath,"price");
        int row = getRowNumber(filePath,"Apple");
        Assert.assertTrue(updateCell(filePath,row,col,updatedValue));

        // upload to modify excel
        WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
        upload.sendKeys(filePath);

        //wait for success message to show up and wait for disappear
        By toastLocator = By.cssSelector(".Toastify__toast-body div:nth-child(2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
        String toastText = driver.findElement(toastLocator).getText();
        System.out.println(toastText);
        Assert.assertEquals("Updated Excel Data Successfully.",toastText);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));

        //WebElement element = driver.findElement(By.xpath(".//div[text()='" + fruitName + "']/parent::div/parent::div/div[4]"));
        //Assert.assertEquals(element.getText(), String.valueOf(700));

        //verify updated excel data showing in the web table
        String priceColumn= driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
        String actualPrice = driver.findElement(By.xpath("//div[text()='"+fruitName+"']/parent::div/parent::div/div[@id='cell-"+priceColumn+"-undefined']")).getText();
        System.out.println(actualPrice);
        Assert.assertEquals(updatedValue, actualPrice);

        driver.close();

    }

    private boolean updateCell(String filePath, int rowNumber, int columnNumber, String number) throws IOException {
        ArrayList<String> a = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        Row rowField = sheet.getRow(rowNumber - 1);
        Cell cellField = rowField.getCell(columnNumber - 1);
        cellField.setCellValue(number);
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        workbook.close();
        fis.close();
        return true;
    }

    private int getRowNumber(String filePath, String apple) throws IOException {
        DataFormatter format = new DataFormatter();
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        //Identify Testcases coloum by scanning the entire 1st row
        Iterator<Row> rows = sheet.iterator();
        // sheet is collection of rows
        int k = 1;
        int rowIndex = -1;
        while (rows.hasNext()) {
            Row row = rows.next();
            Iterator<Cell> cells = row.cellIterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                if (cell.getCellTypeEnum() == CellType.STRING && cell.getStringCellValue().equalsIgnoreCase(apple)) {
                    rowIndex = k;
                }
            }
            k++;
        }
        return rowIndex;
    }

    private int getColumnNumber(String filePath, String price) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        //Identify Testcases coloum by scanning the entire 1st row
        Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
        Row firstrow = rows.next();
        Iterator<Cell> ce = firstrow.cellIterator();//row is collection of cells
        int k = 1;
        int coloumn = 0;
        while (ce.hasNext()) {
            Cell value = ce.next();
            if (value.getStringCellValue().equalsIgnoreCase(price)) {
                coloumn = k;
            }
            k++;
        }
        System.out.println(coloumn);
        return coloumn;

    }
}
