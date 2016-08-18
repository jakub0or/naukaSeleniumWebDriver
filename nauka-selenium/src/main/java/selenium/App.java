package selenium;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class App
{
    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @Test
    public  void main( )
    {
        driver.get("http://google.pl");
    }

    @AfterClass
    public static void after(){
        //driver.close();
    }
}
