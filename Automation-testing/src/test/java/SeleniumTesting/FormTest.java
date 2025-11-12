package SeleniumTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://www.globalsqa.com/samplepagetest/");
        Thread.sleep(5000);

        webDriver.findElement(By
                        .xpath("//input[@class='wpcf7-form-control wpcf7-file']"))
                        .sendKeys("C:\\Users\\aximsoft\\Downloads\\im1.png");

        webDriver.findElement(By.xpath("//input[contains(@class,'name')]")).sendKeys("Akilan");

        webDriver.findElement(By.xpath("//input[contains(@class,'email')]")).sendKeys("example@gmail.com ");



    }
}
