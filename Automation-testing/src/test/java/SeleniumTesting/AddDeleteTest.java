package SeleniumTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AddDeleteTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        WebElement webElement = webDriver.findElement(By.xpath("//button[.='Add Element']"));
        Actions actions = new Actions(webDriver);
        for(int i=0;i < 3;i++){
            Thread.sleep(2000);
            webElement.click();
        }

        List<WebElement> webElementList = webDriver.findElements(By.id("elements"));
//        Thread.sleep(3000);

        for(int i =1; i <= webElementList.size();i++){
            webDriver.findElement(By.xpath("//div[@id='elements']/button[3]"));
        }
    }
}
