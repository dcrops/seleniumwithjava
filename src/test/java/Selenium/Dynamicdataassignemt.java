package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class Dynamicdataassignemt {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        By selectCheckbox = By.id( "checkBoxOption3" );
        By dropdown = By.id( "dropdown-class-example" );
        By name = By.id( "name" );
        By alert = By.id( "alertbtn" );
        String checkPick;


        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.get( "http://qaclickacademy.com/practice.php" );
        driver.manage().window().maximize();

        driver.findElement( selectCheckbox ).click();
        checkPick = (driver.findElement(selectCheckbox).getAttribute( "value" ));
        System.out.println(checkPick);
        driver.findElement( dropdown ).click();
        WebElement dd = driver.findElement( By.xpath( "//select[@id='dropdown-class-example']" ) );
        //System.out.println(dd.findElements( By.tagName( "option" ) ).size());

        for (int i=0;i<dd.findElements( By.tagName( "option" ) ).size();i++)
        {
            String text = driver.findElements( By.xpath( "//select[@id='dropdown-class-example']/option" ) ).get( i ).getText().toLowerCase();
            if (checkPick.equals( text ))
            {
               driver.findElements( By.xpath( "//select[@id='dropdown-class-example']/option" ) ).get( i ).click();
            }
        }
        driver.findElement( name ).sendKeys( checkPick );
        driver.findElement( alert ).click();
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        System.out.println(alertText);
        if (alertText.contains( checkPick ))
        {
            System.out.println("I am verifying that " + checkPick + " appears in the Alert");
        } else {
            System.out.println(checkPick + "is not included in the alert");
        }
    }
}
