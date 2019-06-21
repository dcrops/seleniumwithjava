package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
    public static WebDriver driver;

    public static void main(String[] args) {


            System.setProperty("webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe");

            driver = new ChromeDriver();
            driver.get("https://www.ptv.vic.gov.au/");
            driver.manage().window().maximize();

            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            //System.out.println(driver.getPageSource());

            driver.get( "http://yahoo.com" );
            System.out.println(driver.getTitle());
            driver.navigate().back();
            System.out.println(driver.getTitle());
            driver.navigate().forward();
            System.out.println(driver.getTitle());
            driver.close();
    }
}
