package SeleniumTesting.ListenersEx;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.FileHandling.csvExample.CSVWritter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.*;
import java.sql.Driver;
import java.time.Duration;

public class BasicLoginTest {

    WebDriver webDriver;

    WebDriverWait webDriverWait;

    @BeforeMethod
    @Parameters({"browser"})
    void openBrowser(@Optional("chrome") String browser){

       switch (browser){
           case "chrome" : webDriver = new ChromeDriver(); break;
           case "edge" : webDriver = new EdgeDriver(); break;
           case "firefox" : webDriver = new FirefoxDriver(); return;
           default:
               System.out.println("Invalid Browser..");
        }

        DriverManager.setWebDriver(webDriver);

       webDriverWait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(10));
       DriverManager.getWebDriver().get("https://www.saucedemo.com/");
    }

    @Test(dataProvider = "data-from-csv", threadPoolSize = 5)
    void login(String username,String pswd){

        WebDriver driver = DriverManager.getWebDriver();

        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(pswd);
        driver.findElement(By.xpath("//*[@id='login-button']")).click();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
     }

    @AfterMethod
    public void closeBrowser(){
        DriverManager.getWebDriver().quit();
        DriverManager.removeWebDriver();
    }

    @DataProvider(name = "data-from-csv", parallel = true)
    public Object[][] dataFromCSV() throws IOException {

        return CSVWritter.csvWritter();
    }





    @DataProvider(name = "dp")
    public Object[][] getJsonData() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        File file = new File("C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice" +
                "\\Automation-testing\\src\\test\\java\\SeleniumTesting\\ListenersEx\\data.json");

        JsonNode node = mapper.readTree(file);

        Object[][] data = new Object[node.size()][2];

        for (int i = 0; i < node.size(); i++) {
            data[i][0] = node.get(i).get("username").asText();
            data[i][1] = node.get(i).get("password").asText();
        }
        return data;
    }

//
//    @DataProvider(name="dp")
//    Object[][] loginData(){
//        Object[][] data = {
//                {"standard_user","secret_sauce"},
////                {"locked_out_user","secret_sauce"},
//                {"problem_user","secret_sauce"},
//                {"performance_glitch_user","secret_sauce"},
//                {"standard_user","secret_sauce"},
//                {"standard_user","secret_sauce"}
//        };
//        return data;
//    }
}
