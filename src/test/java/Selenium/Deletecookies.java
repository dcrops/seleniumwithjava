package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Deletecookies {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
        driver.manage().deleteCookieNamed( "sessionKey" );
        driver.get( "http://qaclickacademy.com/practice.php" );

    }
}
