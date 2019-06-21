package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Multiplewindows {
    public static WebDriver driver;

    public static void main(String[] args) {

        By terms = By.xpath( "//a[contains(@href,'https://accounts.google.com/TOS?loc=AU&hl=en')]" );

        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.get( "https://accounts.google.com/ServiceLogin/signinchooser?elo=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin" );
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.findElement( terms ).click();

        System.out.println(driver.getWindowHandles());
        Set<String> ids=driver.getWindowHandles();

        Iterator<String> it = ids.iterator();

        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child );
        System.out.println(driver.getTitle());
        driver.switchTo().window( parent );
        System.out.println(driver.getTitle());
    }
}
