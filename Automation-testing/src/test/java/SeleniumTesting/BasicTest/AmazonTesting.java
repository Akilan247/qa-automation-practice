package SeleniumTesting.BasicTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AmazonTesting {

    public static void main(String[] args) {

        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://www.amazon.in");

        webDriver.manage().window().maximize();

        System.out.println(webDriver.getTitle());

        WebElement searchBar = webDriver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        searchBar.sendKeys("Samsung Mobiles");

        webDriver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

        List<WebElement> nextPage = webDriver.findElements(By
                        .xpath
                                ("(//a[@class='a-link-normal s-line-clamp-2 s-line-clamp-3-for-col-12 s-link-style a-text-normal'])[1]"));

        System.out.println(nextPage);
        for(int i=0;i < 2;i++){
            nextPage.get(i).click();
        }

        System.out.println(webDriver.getTitle());

//        webDriver.quit();

    }
}
