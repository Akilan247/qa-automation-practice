package SeleniumTesting.ListenersEx;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter extentSparkReporter;
    public ExtentReports extentReports;
    public ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {

        File file = new File("C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\Automation-testing\\src\\test\\Reports" +
                "myRepo.html");

        extentSparkReporter = new ExtentSparkReporter(file);

        extentSparkReporter.config().setDocumentTitle("Automation Report");
        extentSparkReporter.config().setReportName("Testing Practice");
        extentSparkReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        extentReports.setSystemInfo("Computer Name","LocalHost");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.PASS,"Test case PASSED is : "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.FAIL,"Test case FAILED is : "+result.getName());

        try {
            BasicTest testClass = (BasicTest)result.getInstance();
            WebDriver driver = (testClass).webDriver;
            TakesScreenshot ts = (TakesScreenshot) driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);

            String screenshotPath ="C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\A" +
                    "utomation-testing\\src\\test\\java\\SeleniumTesting\\ListenersEx"+ result.getName()+".png";

            File destFile = new File(screenshotPath);

            srcFile.renameTo(destFile);

            driver.navigate().refresh();

            System.out.println("Screenshot saved at: " + screenshotPath);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.log(Status.SKIP,"Test case SKIPPED is : "+result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}
