package SeleniumTesting.ListenersEx;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public static WebDriver getWebDriver(){
        return webDriverThreadLocal.get();
    }

    public static void setWebDriver(WebDriver webDriver){
        webDriverThreadLocal.set(webDriver);
    }

    public static void removeWebDriver(){
        webDriverThreadLocal.remove();
    }
}
