package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dropdowns {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();




        driver.findElement( By.id( "divpaxinfo" ) ).click();
        Thread.sleep( 1000 );
        for (int i=0; i < 4;i++) {
            driver.findElement( By.id( "hrefIncAdt" ) ).click();
        }

        int a = 1;
        while(a<5)
        {
            driver.findElement( By.id( "hrefIncChd" ) ).click();
            a++;
        }
        driver.findElement( By.id( "btnclosepaxoption" ) );
        //System.out.println(driver.findElement( By.id( "divpaxinfo" ) ).getText());
        Assert.assertEquals(driver.findElement( By.id( "divpaxinfo" ) ).getText(), "5 Adult, 4 Child");



        Select s = new Select( driver.findElement( By.id( "ctl00_mainContent_DropDownListCurrency" ) ) );
        s.selectByVisibleText( "AED" );


        System.out.println(driver.findElement( By.id( "Div1" ) ).getAttribute( "style" ));
        driver.findElement( By.id( "ctl00_mainContent_rbtnl_Trip_1" ) ).click();
        System.out.println(driver.findElement( By.id( "Div1" ) ).getAttribute( "style" ));
        if(driver.findElement( By.id( "Div1" ) ).getAttribute( "style" ).contains( "1" ))
        {
            System.out.println("It's Enabled");
            Assert.assertTrue( true );
        } else {
            Assert.assertTrue( false );
        }
        //System.out.println(driver.findElement( By.name( "ctl00$mainContent$view_date2" ) ).isEnabled());


        Thread.sleep( 2000 );
        driver.findElement( By.id( "ctl00_mainContent_ddl_originStation1_CTXT" )).click();
        driver.findElement( By.xpath( "//a[@value='MAA']" )).click();
        Thread.sleep( 2000 );
        driver.findElement( By.xpath( "(//a[@value='BLR'])[2]" )).click();

        Thread.sleep( 3000 );
        //driver.findElement( By.xpath( "//a[@class='ui-state-default ui-state-highlight ui-state-active']" )).click();
        driver.findElement( By.cssSelector( ".ui-state-default.ui-state-highlight.ui-state-active" )).click();


        //a[@value='MAA']
        //a[@value='BLR']

    }
}
