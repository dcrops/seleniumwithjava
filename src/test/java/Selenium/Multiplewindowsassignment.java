package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Multiplewindowsassignment {
    public static WebDriver driver;

    public static void main(String[] args) {

        By newWindow = By.xpath( "//a[@href='/windows/new']" );

        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.get( "https://the-internet.herokuapp.com/windows" );
        driver.manage().window().maximize();

        driver.findElement( newWindow ).click();
        System.out.println(driver.getWindowHandles());
        Set<String> wins = driver.getWindowHandles();
        Iterator<String> it = wins.iterator();

        String parent = it.next();
        String child = it.next();

        driver.switchTo().window( child );
        System.out.println(driver.getTitle());
        driver.switchTo().window( parent );
        System.out.println(driver.findElement( By.cssSelector( "[class='example'] h3" )).getText() );


    }
}
