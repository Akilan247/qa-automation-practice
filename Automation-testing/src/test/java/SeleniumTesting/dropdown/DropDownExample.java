package SeleniumTesting.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class DropDownExample {

    WebDriver webDriver;
    WebDriverWait webDriverWait;

    @BeforeTest
    public void openUrl(){
        webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/select-menu");
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void goTodropDownTest(){

        WebElement webElement = webDriver.findElement(By.xpath("(//ul[@class='menu-list'])[4]//li[@id='item-8']//span"));
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement)).click();

        System.out.println("Selected Menu"+webElement.getText());

        if(webElement.getText().equals("Select Menu")){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }

        webDriver.findElement(By.xpath("(//ul[@class='menu-list'])[4]//li[@id='item-8']")).click();
    }
//(//ul[@class='menu-list'])[4]//li[contains(@id,'item')]//span[text()='Select Menu']
    @Test
    public void selectDropDownTest() throws InterruptedException {

        webDriver.findElement(By.xpath("//div[text()='Select Option']")).click();

        webDriver.findElement(By.xpath("//div[contains(@id,'react-select-') and contains(text(),'Group 1, option 2')]")).click();
//        webDriver.findElement(By.xpath("(//div[@class=' css-1uccc91-singleValue'])[text()='Group 1, option 2']")).click();

        webDriver.findElement(By.xpath("//div[contains(text(),'Select Title')]")).click();
        webDriver.findElement(By.xpath("//div[contains(@id,'react-select-') and starts-with(text(), 'Mr.')]")).click();

        webDriver.findElement(By.id("oldSelectMenu")).click();

        webDriver.findElement(By.xpath("//option[@value='1']")).click();

        Thread.sleep(3000);

        Assert.assertTrue(true);

    }

    @AfterTest
    public void closeBrowser(){
        webDriver.close();
    }
}
