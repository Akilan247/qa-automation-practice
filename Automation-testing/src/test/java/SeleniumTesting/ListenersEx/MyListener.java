package SeleniumTesting.ListenersEx;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class MyListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("On Test Start....");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {

        BasicTest testClass = (BasicTest)result.getInstance();

        WebDriver driver = (testClass).webDriver;

            TakesScreenshot ts = (TakesScreenshot) driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);

            String screenshotPath = "C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\Automation-testing\\src\\" +
                    "test\\java\\SeleniumTesting\\ListenersEx\\"+ result.getName()+".png";

            File destFile = new File(screenshotPath);

            srcFile.renameTo(destFile);

            driver.navigate().refresh();

            System.out.println("Screenshot saved at: " + screenshotPath);

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
