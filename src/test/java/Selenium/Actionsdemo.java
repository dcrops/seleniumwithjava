package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Actionsdemo {
    public static WebDriver driver;

    public static void main(String[] args) {

        By accountList = By.id( "nav-link-accountList" );
        By search = By.id( "twotabsearchtextbox" );

        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.get( "https://www.amazon.com/" );
        driver.manage().window().maximize();

        Actions a = new Actions(driver);
        WebElement move1 = driver.findElement( search );
        WebElement move2 = driver.findElement( accountList );

        a.moveToElement(move1).click().keyDown( Keys.SHIFT ).sendKeys( "Hello" ).doubleClick().perform();
        a.moveToElement( move2 ).contextClick().perform();

    }
}
