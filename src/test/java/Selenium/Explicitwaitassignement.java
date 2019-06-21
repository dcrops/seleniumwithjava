package Selenium;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicitwaitassignement {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        By linkSelect = By.xpath( "//a[@href='javascript: void(0);loadAjax();']" );
        By results = By.id( "results" );

        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\3579\\Documents\\chromedriver.exe" );

        driver = new ChromeDriver();
        driver.get( "http://www.itgeared.com/demo/1506-ajax-loading.html" );
        driver.manage().window().maximize();
        driver.findElement( linkSelect ).click();

        WebDriverWait ew = new WebDriverWait( driver, 10 );
        System.out.println(ew.until( ExpectedConditions.visibilityOfElementLocated( results ) ).getText());
    }
}
