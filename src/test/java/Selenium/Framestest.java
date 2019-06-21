package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Framestest {
    public static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.get( "https://jqueryui.com/droppable/" );
        driver.manage().window().maximize();
        driver.switchTo().frame( driver.findElement( By.className( "demo-frame" ) ) );
        //driver.switchTo().frame( 0 );

        Actions a = new Actions(driver);
        WebElement source = driver.findElement( By.id( "draggable" ) );
        WebElement target = driver.findElement( By.id( "droppable" ) );
        a.dragAndDrop( source, target ).perform();

        driver.switchTo().defaultContent();
        System.out.println(driver.findElement( By.xpath( "//p[@class='desc']" ) ).getText());


    }
}
