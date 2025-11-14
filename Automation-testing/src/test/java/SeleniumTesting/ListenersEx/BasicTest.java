package SeleniumTesting.ListenersEx;

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

import java.time.Duration;
import java.util.Objects;

public class BasicTest {

    WebDriver webDriver;
    WebDriverWait webDriverWait;
    @BeforeTest
    @Parameters({"browser"})
    void openBrowser(String ch){
       switch (ch){
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
        webDriver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(username);
        webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pswd);
        webDriver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        webDriver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();

        WebElement logout = webDriver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));

        System.out.println(webDriverWait.until(ExpectedConditions.visibilityOf(logout)).getText());

        boolean status = Objects.requireNonNull(webDriverWait.until(ExpectedConditions.visibilityOf(logout))).isDisplayed();

        if(status){
            logout.click();
            Assert.assertTrue(status);
        }else {
            Assert.fail();
        }
    }

    @AfterTest
    public void closeBrowser(){
        webDriver.quit();
    }


    @DataProvider(name="dp")
    Object[][] loginData(){
        Object[][] data = {
                {"standard_user","secret_sauce"},
                {"locked_out_user","secret_sauce"},
                {"problem_user","secret_sauce"},
                {"performance_glitch_user","secret_sauce"},
                {"standard_user","secret_sauce"},
                {"standard_user","secret_sauce"}
        };
        return data;
    }
}
