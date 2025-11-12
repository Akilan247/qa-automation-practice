import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Objects;

public class BsicTest {

    WebDriver webDriver;
    WebDriverWait webDriverWait;
    @BeforeClass
    void openBrowser(){
       webDriver = new EdgeDriver();
       webDriverWait = new WebDriverWait(webDriver,Duration.ofSeconds(10));
       webDriver.get("https://www.saucedemo.com/");
       webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(dataProvider = "dp")
    void login(String username,String pswd){
        webDriver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(username);
        webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pswd);
        webDriver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        WebElement logout = webDriver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]"));
        boolean status = Objects.requireNonNull(webDriverWait.until(ExpectedConditions.visibilityOf(logout))).isDisplayed();

        if(status){
            Objects.requireNonNull(webDriverWait.until(ExpectedConditions.visibilityOf(logout))).click();
            Assert.assertTrue(status);
        }else {
            Assert.fail();
        }
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
