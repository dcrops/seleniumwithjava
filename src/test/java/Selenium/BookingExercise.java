package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BookingExercise {
    public static WebDriver driver;



    public static void main(String[] args) throws InterruptedException {

        By adults = By.id( "Adults" );
        By children = By.id( "Childrens" );
        By departDate = By.id( "DepartDate" );
        By today = By.cssSelector( ".ui-state-default.ui-state-highlight.ui-state-active " );
        By options = By.id( "MoreOptionsLink" );
        By prefAirline = By.id( "AirlineAutocomplete" );
        By search = By.id( "SearchBtn" );
        By error = By.id( "homeErrorMessage" );

        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );

        driver = new ChromeDriver();
        driver.get( "https://www.cleartrip.com/" );
        driver.manage().window().maximize();

        Select s = new Select( driver.findElement( adults ) ) ;
        s.selectByValue( "3" );
        Select s1 = new Select( driver.findElement( children ) ) ;
        s1.selectByValue( "2" );

        driver.findElement( departDate ).click();
        driver.findElement( today ).click();
        driver.findElement( options ).click();
        driver.findElement( prefAirline ).sendKeys( "Indigo" );
        driver.findElement( search ).click();
        System.out.println(driver.findElement( error ).getText());


    }
}
