package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Synchronisation {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.get( "https://www.trivago.com.au" );
        driver.manage().window().maximize();
        //Thread.sleep( 3000 );
        //driver.findElement( By.name( "sQuery" ) ).click();
        driver.findElement( By.xpath( "//input[@name='sQuery']" ) ).sendKeys( "nyc" );
        driver.findElement( By.xpath( "//input[@name='sQuery']" ) ).sendKeys( Keys.TAB );
        driver.findElement( By.xpath( "//input[@name='sQuery']" ) ).sendKeys( Keys.TAB );
        driver.findElement( By.xpath( "//button[@key='searchButton']" ) ).click();

        WebDriverWait ew = new WebDriverWait(driver, 20);
        ew.until( ExpectedConditions.visibilityOfElementLocated( By.xpath( "//button[@key='searchButton']"  ) ));



    }
}
