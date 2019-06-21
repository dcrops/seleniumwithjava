package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Scope {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.get( "http://qaclickacademy.com/practice.php" );
        driver.manage().window().maximize();

        System.out.println(driver.findElements( By.tagName( "a" ) ).size()); //Prints number of tags on page

        WebElement footer = driver.findElement( By.id( "gf-BIG" ) );
        System.out.println(footer.findElements( By.tagName( "a" ) ).size()); //Prints number of tags in footer

        WebElement footerCol1 = driver.findElement( By.xpath( "//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul" ) );
        System.out.println(footerCol1.findElements( By.tagName( "a" ) ).size()); //Prints number of tags in first column of footer

        for (int i = 1; i < footerCol1.findElements( By.tagName( "a" ) ).size();i++)
        {
            String clickTabs = Keys.chord( Keys.CONTROL, Keys.ENTER );
            footerCol1.findElements( By.tagName( "a" ) ).get( i ) .sendKeys( clickTabs ); //Selects all tags in first column of footer
            Thread.sleep( 5000L );
        }
        Set<String> abc=driver.getWindowHandles(); //Selects each open window and prints out its Title
        Iterator<String> it = abc.iterator();
        while (it.hasNext())
        {
            driver.switchTo().window( it.next());
            System.out.println(driver.getTitle());
        }
    }

    }
