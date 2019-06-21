package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Recaptcha {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.get( "https://patrickhlauke.github.io/recaptcha/" );
        driver.manage().window().maximize();
        int number = findFrameNumber(driver, By.id( "recaptcha-anchor" ) );
        driver.switchTo().frame( number );
        driver.findElement( By.id( "recaptcha-anchor" ) ).click();
        driver.switchTo().defaultContent();
        System.out.println("Switched to Page");

        //int number1 = findFrameNumber(driver, By.xpath( "//*[@id='recaptcha-verify-button]" ) );
        int number1 = findFrameNumber(driver, By.xpath( "//button[@id='recaptcha-verify-button']" ) );

        driver.switchTo().frame( number1 );
        driver.findElement( By.xpath( "//button[@id='recaptcha-verify-button']"  ) ).click();


    }

    public static int findFrameNumber(WebDriver driver, By by) {

        int i;
        int frameCount = driver.findElements( By.tagName( "iframe" ) ).size();
        System.out.println("Frame count is " + frameCount);
        for (i = 0;i<frameCount;i++)
        {
            System.out.println("I is " + i);
            System.out.println("By is " + by);

            driver.switchTo().frame( i );
            System.out.println("We are now in frame " + i);
            int count = driver.findElements(by).size();
            System.out.println("Count = " + count);
            if (count > 0)
            {
                driver.findElement( by ).click();
                break;
            }
            else
            {
                System.out.println("Continue Looping");
            }
        }
        driver.switchTo().defaultContent();
        System.out.println("Switched to Page");
        System.out.println("I = " + i);
        return i;
    }
}
