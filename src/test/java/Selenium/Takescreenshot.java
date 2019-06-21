package Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Takescreenshot {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, IOException {


        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.manage().window().maximize();
        driver.get( "http://qaclickacademy.com/practice.php" );



        File src = ((TakesScreenshot)driver).getScreenshotAs( OutputType.FILE );
        FileUtils.copyFile( src,new File("C:\\Users\\3579\\Documents\\Screenshots\\screenshot.png")) ;

    }
}
