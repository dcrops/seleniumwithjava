package Selenium;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static java.util.stream.IntStream.rangeClosed;

public class Planit {
    public static WebDriver driver;

    //These are the locators for the Homepage
    By first_name = By.name( "firstname" );
    By surname = By.name( "lastname" );
    By mobile_email = By.name( "reg_email__" );
    By confirm = By.name( "reg_email_confirmation__" );
    By password = By.name( "reg_passwd__");
    By day = By.id( "day" );
    By month = By.id( "month" );
    By year = By.id( "year" );
    By female = By.xpath( "//input[@value='1']" );
    By male = By.xpath( "//input[@value='2']" );
    By sign_up = By.name( "websubmit" );


    // This is the sectin where I randomize my data

    String emailString = RandomStringUtils.randomAlphanumeric(8);
    String email = emailString+"@gmail.com";
    String passwordValue = RandomStringUtils.randomAlphanumeric(10);
    String dayValue = RandomStringUtils.randomNumeric(28);
    String [] firstNames = {"Jason", "Michael", "Freddy", "Harley"};
    String [] lastNames = {"Voorhees", "Myers", "Kruger", "Quinn"};
    String [] genders = {"Male", "Female"};
    String [] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    Random r=new Random();
    int randomFirstName = r.nextInt( firstNames.length );
    int randomLastName = r.nextInt( lastNames.length );
    int randomMonth=r.nextInt(months.length);
    int[] range = rangeClosed(1905, 2000).toArray();
    int randomYear=r.nextInt(range.length);
    int randomGender = r.nextInt( genders.length );


    //These are all my test methods

    public void init() //This method provides the chrome driver, goes to the webpage and maximizes it

    {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.get( "https://www.facebook.com/" );
        driver.manage().window().maximize();
    }

    public void namesPopluate() //This method populates the first and last name fields with the random names
    {
        driver.findElement( first_name ).sendKeys( firstNames[randomFirstName].toLowerCase() );
        driver.findElement( surname ).sendKeys( lastNames[randomLastName].toLowerCase() );
    }

    public void emailPopulate() //This method populates the email and email confirmation fields with a random email address
    {
        driver.findElement( mobile_email ).sendKeys( email.toLowerCase() );
        driver.findElement( confirm ).sendKeys( email.toLowerCase());
    }

    public void passwordPopulate() //This method populates the password field with a random password
    {
        driver.findElement( password ).sendKeys( passwordValue );
    }

    public void dobPopulate() //This method populates the DOB fields with a random DOB
    {
        driver.findElement( day ).sendKeys( dayValue );
        driver.findElement( month ).sendKeys( months[randomMonth] );
        Select yearPick = new Select( driver.findElement( year ));
        yearPick.selectByIndex( randomYear );
    }

    public void genderPopulate() //This method populates the gender selection with a random gender
    {
        if (randomGender == 0) {
            driver.findElement( male ).click();
        } else if (randomGender == 1) {
            driver.findElement( female ).click();
        }
    }

    public void signup() //This method presses the signup button
    {
        driver.findElement( sign_up ).click();
    }

    public void facebookSignup() //This method has all the above methods in it in the correct order. This method is called in the PlanitActions Class
    {
        init();
        namesPopluate();
        emailPopulate();
        passwordPopulate();
        dobPopulate();
        genderPopulate();
        signup();
    }
}
