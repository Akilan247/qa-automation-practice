package SeleniumTesting.BasicTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LoginTest {

    public void openApp(){
        System.out.println("enter the prijmting logintest");
    }


    public static void main(String[] args) throws InterruptedException, IOException {

        FileInputStream file = new FileInputStream("C:\\Users\\aximsoft\\IdeaProjects\\" +
                "dragAndDrop-Test\\src\\main\\resources\\" +
                "data.properties");

        Properties properties = new Properties();

        properties.load(file);

        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        login(username,password);

        System.out.println(username +" " +password);

    }

    public static void login(String username,String password) throws InterruptedException {

        WebDriver webDriver = new EdgeDriver();

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        webDriver.get("https://www.saucedemo.com/");

        webDriver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);

        webDriver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

//        Thread.sleep(2000);

        webDriver.findElement(By.xpath("//input[@type='submit']")).click();

        System.out.println(webDriver.getTitle());

        webDriver.findElement(By.xpath("//a[@id='item_4_title_link']")).click();

        webDriver.findElement(By.xpath("//button[@id='add-to-cart']")).click();

        webDriver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();

//        Alert
        webDriver.quit();
    }
}
