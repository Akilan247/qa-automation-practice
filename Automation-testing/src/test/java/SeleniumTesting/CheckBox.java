package SeleniumTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckBox {

    public static void main(String[] args) {
        WebDriver webDriver = new ChromeDriver();

        int toggleIndex = 1;
        webDriver.get("https://demoqa.com/checkbox");

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        WebElement check = webDriver.findElement(By.xpath("(//button[@title='Toggle'])[1]"));

        webDriverWait.until(ExpectedConditions.elementToBeClickable(check)).click();

        WebElement check1 = webDriver.findElement(By.xpath("(//button[@title='Toggle'])[2]"));

        webDriverWait.until(ExpectedConditions.elementToBeClickable(check1)).click();

        WebElement notes = webDriver.findElement(By.xpath("//label[@for='tree-node-notes']"));

        notes.click();

//        webDriverWait.until(ExpectedConditions.elementToBeClickable(notes)).click();
    }
}
