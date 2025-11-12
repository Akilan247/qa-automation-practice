package SeleniumTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        Thread.sleep(4000);
        webDriver.navigate().to("https://www.youtube.com");
        webDriver.navigate().refresh();
        webDriver.quit();
    }
}
