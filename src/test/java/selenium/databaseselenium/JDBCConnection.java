package selenium.databaseselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.sql.*;

public class JDBCConnection {

    @Test
    public void testJDBCConnection() throws SQLException {
        // database connection steps
        // connection URL: "jdbc:mysql://"+host+":"+port+"/databasename";
        // jdbc:mysql://"+localhost+":"+3306+"/SeleniumData";
        String localhost = "localhost";
        String portNumber = "3306";
        String userName = "root";
        String password = "password";

        Connection con = DriverManager.getConnection("jdbc:mysql://" + localhost + ":" + portNumber
                + "/SeleniumData", userName, password);

        // create a statement road map

        Statement s = con.createStatement();
        ResultSet result = s.executeQuery("select * from EmployeeInfo where name = 'kunal'");

        // result.next() if there is some result available then only it execute
        while (result.next()) {
            result.getInt("id");
            result.getString("location");
        }
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/SeleniumDrivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://login.salesforce.com");
        driver.findElement(By.xpath(".//*[@id='username']")).
                sendKeys(result.getString("id"));
        driver.findElement(By.xpath(".//*[@id='password']")).
                sendKeys(result.getString("location"));
    }
}
