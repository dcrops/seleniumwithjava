package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Autodropdownassignment {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.get( "http://qaclickacademy.com/practice.php" );
        driver.manage().window().maximize();

        By from = By.id("autocomplete");

        String destination = "United Kingdom";
        int count = 0;

        driver.findElement( from ).sendKeys( "UNI");
        Thread.sleep( 1000 );
        driver.findElement( from ).sendKeys( Keys.ARROW_DOWN );

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String script = "return document.getElementById(\"autocomplete\").value;";
        String text = (String) js.executeScript( script );
        System.out.println(text);

        while(!text.equalsIgnoreCase( destination ))
        {
            count++;
            Thread.sleep( 1000 );
            driver.findElement( from ).sendKeys( Keys.ARROW_DOWN );
            text = (String) js.executeScript( script );
            System.out.println(text);
            if(count>10)
            {
                break;
            }
            if (count>10)
            {
                System.out.println("Element is Not Found");
            }
            else
            {
                System.out.println("Element is Found");
            }
        }




    }
}
