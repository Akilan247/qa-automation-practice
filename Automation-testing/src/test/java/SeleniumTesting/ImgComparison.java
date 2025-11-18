package SeleniumTesting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class ImgComparison {

    WebDriver webDrive;

    @BeforeTest
    public void openBrowser(){
        webDrive = new ChromeDriver();
        webDrive.manage().window().maximize();
    }

    @Test
    public void TestImage(){
        WebElement img1 = webDrive.findElement(By.xpath("//img[@loading='lazy' and contains(@alt,'snowy forest')]"));
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDrive;
        File imgExpected = img1.getScreenshotAs(OutputType.FILE);
    }
}
