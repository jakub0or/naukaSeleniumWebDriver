package selenium;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsInteractions {

    private WebDriver driver;

    private static String ALLEGRO = "http://www.allegro.pl";
    @BeforeClass
    public void SetUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver(chromeOptions);
    }
    @Test(description="Test klasy Actions")
    public void ActionTest() {
        driver.get(ALLEGRO);

        Actions actions = new Actions(driver);
        WebElement linkElektornika = driver.findElement(By.linkText("Elektronika"));
        actions.moveToElement(linkElektornika).build().perform();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement szukaj = driver.findElement(By.id("main-search-text"));
        actions.moveToElement(szukaj).keyDown(Keys.SHIFT).sendKeys("duże?").keyUp(Keys.SHIFT).sendKeys(" malutkie?").build().perform();
    }
}
