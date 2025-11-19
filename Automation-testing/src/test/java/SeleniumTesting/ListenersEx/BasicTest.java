package SeleniumTesting.ListenersEx;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;
import java.util.Objects;

public class BasicTest {

    WebDriver webDriver;
    WebDriverWait webDriverWait;
    @BeforeTest
    @Parameters({"browser"})
    void openBrowser(@Optional("chrome") String browser){

        if (browser == null) {
            browser = System.getProperty("browser", "chrome");
        }
       switch (browser){
           case "chrome" : webDriver = new ChromeDriver(); break;
           case "edge" : webDriver = new EdgeDriver(); break;
           case "firefox" : webDriver = new FirefoxDriver(); return;
           default:
               System.out.println("Invalid Browser..");
        }
       webDriverWait = new WebDriverWait(webDriver,Duration.ofSeconds(10));
       webDriver.get("https://www.saucedemo.com/");
       webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(dataProvider = "dp")
    void login(String username,String pswd){
        webDriver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(username);
        webDriver.findElement(By.xpath("//*[@id='password']")).sendKeys(pswd);
        webDriver.findElement(By.xpath("//*[@id='login-button']")).click();

//        webDriver.findElement(By.xpath("//*[@id='react-burger-menu-btn']")).click();
//
//        WebElement logout = webDriver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));

//        System.out.println(webDriverWait.until(ExpectedConditions.visibilityOf(logout)).getText());

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = webDriver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

//        boolean status = Objects.requireNonNull(webDriverWait.until(ExpectedConditions.visibilityOf(logout))).isDisplayed();
//
//        if(status){
//            logout.click();
//        }else {
//            Assert.assertTrue(true);
//        }
    }


    @AfterMethod
    public void closeBrowser(){
        webDriver.close();
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
