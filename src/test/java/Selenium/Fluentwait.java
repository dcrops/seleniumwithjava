package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class Fluentwait {
    public static WebDriver driver;

    public static void main(String[] args) {

        By linkSelect = By.cssSelector( "[id='start'] button" );

        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );

        driver = new ChromeDriver();
        driver.get( "https://the-internet.herokuapp.com/dynamic_loading/1" );
        driver.manage().window().maximize();
        driver.findElement(linkSelect).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>( driver ).withTimeout( Duration.ofSeconds(30) )
                .pollingEvery( Duration.ofSeconds( 3 ) ).ignoring( NoSuchElementException.class );


        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                if ( driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed())
                {
                    return driver.findElement(By.cssSelector("[id='finish'] h4"));
                } else {
                    return null;
                }
            }
        });
        System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());



    }
}
