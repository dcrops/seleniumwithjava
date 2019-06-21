package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Calendar {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.get( "https://www.path2usa.com/travel-companions" );
        driver.manage().window().maximize();

        By dateField = By.id( "travel_date" );
        By prev = By.xpath( "//div[@class='datepicker-days']//th[@class='prev']" );
        String dayPick   = "23";
        String month = "September";

        driver.findElement( dateField ).click();


        while (!driver.findElement( By.xpath( "//div[@class='datepicker-days']//th[@class='datepicker-switch']" ) ).getText().contains( month ))
        {
            driver.findElement( prev ).click();
        }

        List<WebElement> days = driver.findElements( By.className( "day" ) ); //Grab common attribute (day), put into a list and iterate
        int count = driver.findElements( By.className( "day" ) ).size();

        for (int i = 0; i < count;i++)
        {
            String daytext = driver.findElements( By.className( "day" ) ).get( i ).getText();
            if(daytext.equalsIgnoreCase( dayPick))
            {
                driver.findElements( By.className( "day" ) ).get( i ).click();
                break;
            }
        }




    }
}
