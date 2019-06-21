package Framework_Phase_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Testbase {
    public static WebDriver driver;

    public Testbase() throws FileNotFoundException {
    }

    @Test
    public void init() throws IOException {

        Properties prop = new Properties(  );
        FileInputStream fis = new FileInputStream( "C:\\Source\\seleniumwithjava\\datadriven.properties" );
        prop.load( fis );

        if(prop.getProperty("browser").equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\3579\\Documents\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if(prop.getProperty("browser").equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(prop.getProperty("browser").equals("ie"))
        {
            System.setProperty("webdriver.ie.driver", "C:\\Users\\3579\\Documents\\MicrosoftWebDriver.exe");
            driver = new InternetExplorerDriver();
        } else
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.manage().window().maximize();
        driver.get(prop.getProperty( "url" ) );

        System.out.println(prop.getProperty( "username" ));

    }
}
