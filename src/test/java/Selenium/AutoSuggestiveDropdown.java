package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='fromCity']")).click();

        WebElement source = driver.findElement(By.xpath("//input[@placeholder='From']"));

        Thread.sleep(1000);
        source.click();
        Thread.sleep(1000);
        source.sendKeys("MUM");
        Thread.sleep(1000);
        source.sendKeys(Keys.ARROW_DOWN);
        source.sendKeys(Keys.ENTER);
        source = driver.findElement(By.xpath("//input[@placeholder='To']"));
        Thread.sleep(1000);
        source.click();
        Thread.sleep(1000);
        source.sendKeys("DEL");
        Thread.sleep(1000);

        for(int i=1;i<6;i++)
        {
            source.sendKeys(Keys.ARROW_DOWN);
        }
        source.sendKeys(Keys.ENTER);

    }
}
