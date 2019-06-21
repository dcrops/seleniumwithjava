package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Autodropdown2 {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.get( "https://ksrtc.in/oprs-web/guest/home.do?h=1" );
        driver.manage().window().maximize();

        By from = By.id( "fromPlaceName" );
        String destination = "BENGALURU INTERNATION AIRPORT";
        int count = 0;


        driver.findElement( from ).sendKeys( "BEN" );
        Thread.sleep( 2000 );
        driver.findElement( from).sendKeys(Keys.ARROW_DOWN);
        System.out.println(driver.findElement(from ).getText());

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String script = "return document.getElementById(\"fromPlaceName\").value;";
        String text = (String) js.executeScript( script );
        System.out.println(text);


        while (!text.equalsIgnoreCase( destination ))
        {
            count++;
            driver.findElement( from ).sendKeys(Keys.ARROW_DOWN);
            Thread.sleep( 1000 );
            text = (String) js.executeScript( script );
            System.out.println(text);

            if (count>10)
            {
                break;
            }
        }
        if (count>10)
        {
            System.out.println("Element Not Found");
        }
        else
        {
            System.out.println("Element Found");
        }



    }
}
