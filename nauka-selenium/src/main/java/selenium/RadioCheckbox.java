package selenium;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class RadioCheckbox {

    private WebDriver driver;

    private static String PIZZAPORTAL = "https://pizzaportal.pl/lublin/restauracje/nadbystrzycka/38";

    @BeforeClass
    public void SetUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver(chromeOptions);
    }

    @Test(description="Checkbox")
    public void CheckboxButtonTest() {
        driver.get(PIZZAPORTAL);
        waitForLoad(driver);
        driver.findElement(By.xpath("//*/div[@class=\"filter-picker\"]/label[1]")).click(); //Pizza
        driver.findElement(By.xpath("//*/div[@class=\"filter-picker\"]/label[4]")).click(); //Burgery
    }

    @Test(description="Radio")
    public void RadioButtonTest() {
        driver.get(PIZZAPORTAL);
        String xPath = "//*/div[@class=\"sorting-option\"]"; //Xpath określający pola radio
        waitForLoad(driver);
        int count = driver.findElements(By.xpath(xPath)).size();
        System.out.printf("Liczba pól radio: "+count);
        for (int i = 0; i < count; i++) {
            System.out.printf(i+": "+driver.findElements(By.xpath(xPath)).get(i).isSelected());
            driver.findElements(By.xpath(xPath)).get(i).click();

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void waitForLoad(WebDriver driver) {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
}
