package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Tablesassignment {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, IOException {


        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.manage().window().maximize();
        driver.get( "http://qaclickacademy.com/practice.php" );

        WebElement table = driver.findElement( By.id( "product" ) );
        int rows = table.findElements( By.xpath( "//table[@id='product']/tbody/tr" ) ).size();
        int cols = table.findElements( By.xpath( "//table[@id='product']/tbody/tr/th" ) ).size();
        System.out.println(rows );
        System.out.println(cols );

        String instructor = table.findElement( By.xpath( "//table[@id='product']/tbody/tr[3]/td" ) ).getText();
        String course = table.findElement( By.xpath( "//table[@id='product']/tbody/tr[3]/td/following-sibling::td" ) ).getText();
        String price = table.findElement( By.xpath( "//table[@id='product']/tbody/tr[3]/td/following-sibling::td/following-sibling::td" ) ).getText();

        System.out.println(instructor);
        System.out.println(course);
        System.out.println(price);

    }
}
