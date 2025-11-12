package SeleniumTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://www.globalsqa.com/demo-site/draganddrop/");

        webDriver.switchTo().frame(0);

        WebElement source = webDriver.findElement(By.xpath("//ul[@id='gallery']/li[3]"));

        WebElement target = webDriver.findElement(By.id("trash"));

        Actions action = new Actions(webDriver);

        Action act = action.dragAndDrop(source,target).build();

        act.perform();

        Thread.sleep(3000);

        WebElement source1  = webDriver.findElement(By.xpath("//div[@id='trash']/ul/li"));

        WebElement target1 = webDriver.findElement(By.xpath("//ul[@id='gallery']"));

        action.dragAndDrop(source1,target1).perform();

        Thread.sleep(2000);
        webDriver.quit();

    }
}
