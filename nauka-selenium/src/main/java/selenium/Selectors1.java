package selenium;//Selectors1.java
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Selectors1 {
    private WebDriver  driver;

    @BeforeClass
    public void SetUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver(chromeOptions);
    }
    @Test(description="Zokalizowanie elementów po ID")
    public void IDTest() {
        driver.get("http://allegro.pl");
        WebElement poleWyszukaj = driver.findElement(By.id("main-search-text"));
        By.className("Nazwa klasy");
        By.name("Wartość atrybutu name");
        poleWyszukaj.click();
    }

    @Test(description="Zokalizowanie elementów po Link Text")
    public void LinkTextTest() {
        driver.get("http://allegro.pl");
        WebElement linkElektornika = driver.findElement(By.linkText("Elektronika"));
        linkElektornika.click();
        driver.navigate().back(); //Powrót na stronę główną.
        WebElement linkModaIUroda = driver.findElement(By.partialLinkText("Moda"));
        linkModaIUroda.click();
    }
}
