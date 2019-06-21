package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxExercise {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );

        driver = new ChromeDriver();
        driver.get( "http://qaclickacademy.com/practice.php" );
        driver.manage().window().maximize();

        By Checkbox1 = By.id( "checkBoxOption1" );

        driver.findElement( Checkbox1 ).click();
        Assert.assertTrue(driver.findElement( Checkbox1 ).isSelected() );
        Thread.sleep( 2000  );
        driver.findElement( Checkbox1 ).click();
        Assert.assertFalse(driver.findElement( Checkbox1 ).isSelected() );

        System.out.println(driver.findElements( By.xpath("//input[@type='checkbox']") ).size());

    }
}
