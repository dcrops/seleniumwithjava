package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Tables {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.get( "https://www.cricbuzz.com/live-cricket-scorecard/21632/sco-vs-sl-2nd-odi-sri-lanka-tour-of-scotland-2019" );
        driver.manage().window().maximize();
        int sum = 0;

        WebElement table = driver.findElement( By.xpath( "//div[@id='innings_1']/div[1]" ) ) ;
        int rowcount = table.findElements( By.xpath( "//div[@class='cb-col cb-col-100 cb-scrd-itms']" ) ).size();
        System.out.println(rowcount);
        System.out.println(driver.findElements( By.xpath( "//div[@class='cb-col cb-col-100 cb-scrd-itms']" ) ).size());
        //int count = table.findElements( By.xpath( "//div[@class='cb-col cb-col-100 cb-scrd-itms']/div[3]" ) ).size();
        int score = table.findElements( By.cssSelector("div[id='innings_1'] [class='cb-col cb-col-100 cb-scrd-itms']" ) ).size();
        int count = 0;

        for (int i = 0;i<score-3;i++)
        {
            String value = table.findElements(  By.xpath( "//div[@class='cb-col cb-col-100 cb-scrd-itms']/div[3]" ) ).get( i ).getText();
            int valueinteger = Integer.parseInt( value );
            sum = sum + valueinteger;
            System.out.println("sum = " + sum);
        }
        System.out.println(count);
        String extras = driver.findElement( By.xpath( "//div[text()='Extras']/following-sibling::div" ) ).getText();
        String total = driver.findElement( By.xpath( "//div[text()='Total']/following-sibling::div" ) ).getText();


        int extrasinteger = Integer.parseInt( extras );
        int sum1 = sum + extrasinteger;
        int totalsinteger = Integer.parseInt( total );
        System.out.println(sum1);

        if(sum1 == totalsinteger)
        {
            System.out.println("We have a winner");
        }
        else
        {
            System.out.println("bugger its not matching");
        }


    }
}
