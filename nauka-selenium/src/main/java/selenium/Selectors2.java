package selenium;//Selectors1.java
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Selectors2 {
    private WebDriver  driver;

    @BeforeClass
    public void SetUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver(chromeOptions);
    }
    @Test(description="Zokalizowanie elementów po XPath i css")
    public void XPathCSSTest() {
        driver.get("http://allegro.pl");
        WebElement przyciskKoszykXpath = driver.findElement(By.xpath("//*[@id=\"cart-status-header\"]/a/span[2]/span"));
        przyciskKoszykXpath.click();
        driver.navigate().back();
        WebElement przyciskKoszykCSS = driver.findElement(By.cssSelector("#cart-status-header > a > span.count > span"));
    }
}
