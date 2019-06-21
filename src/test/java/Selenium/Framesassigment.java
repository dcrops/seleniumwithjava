package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Framesassigment {
    public static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.get( "https://the-internet.herokuapp.com/nested_frames" );
        driver.manage().window().maximize();
        System.out.println(driver.findElements( By.tagName( "frame" ) ).size());
        driver.switchTo().frame( driver.findElement( By.name( "frame-top" ) ) );
        driver.switchTo().frame( driver.findElement( By.name( "frame-middle" ) ) );
        System.out.println(driver.findElement( By.xpath( "//div[@id='content']" ) ).getText());

        driver.switchTo().defaultContent();

    }
}
