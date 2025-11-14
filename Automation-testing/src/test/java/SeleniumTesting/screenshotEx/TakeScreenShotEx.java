package SeleniumTesting.screenshotEx;

import SeleniumTesting.ListenersEx.MyListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;

@Listeners(MyListener.class)
public class TakeScreenShotEx {

    WebDriver webDriver;


    @BeforeTest
    public void openBrowser(){
        webDriver = new EdgeDriver();
        webDriver.get("https://demoqa.com/select-menu");
    }

    @Test
    public void takeScreenShot(){

        TakesScreenshot takesScreenshot =(TakesScreenshot) webDriver;
        File sourcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        File targetFile = new File("C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\Automation-testing\\src\\test\\java\\SeleniumTesting\\screenshotEx\\fullPage.png");
        sourcFile.renameTo(targetFile);

    }
}
