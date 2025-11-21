package SeleniumTesting.ListenersEx;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.FileHandling.csvExample.CSVWritter;
import org.example.FileHandling.csvExample.User;
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
import java.util.ArrayList;
import java.util.List;

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
    void login(User user){

        WebDriver driver = DriverManager.getWebDriver();

        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(user.getUsername());
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(user.getPassword());
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
    public Object[] dataFromCSV() throws IOException {

        Object[][] data = CSVWritter.csvWritter();

        Object[] userList = new Object[data.length];

        for (int i = 0; i < data.length; i++) {
            User user=new User();
            for (int j = 0; j < data[i].length; j++) {
                if (j==0){
                    user.setUsername((data[i][j]).toString());
                }
                if(j==1){
                    user.setPassword((data[i][j]).toString());
                }
            }
            userList[i] = user;
        }

        return userList;
    }





    @DataProvider(name = "dp")
    public Object[][] getDataFromJson() throws Exception {
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
//                {"locked_out_user","secret_sauce"},
//                {"problem_user","secret_sauce"},
//                {"performance_glitch_user","secret_sauce"},
//                {"standard_user","secret_sauce"},
//                {"standard_user","secret_sauce"}
//        };
//        return data;
//    }
}
