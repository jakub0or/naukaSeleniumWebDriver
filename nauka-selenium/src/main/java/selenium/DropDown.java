package selenium;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
/**
 * Created by Kuba on 30.08.2016.
 */
public class DropDown {

    private WebDriver  driver;

    private static String ONET = "http://www.onet.pl";
    private static String FILMWEB = "http://www.filmweb.pl/rankings/film/world";

    @BeforeClass
    public void SetUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver(chromeOptions);
    }

    @Test(description="Filmweb")
    public void FilmwebTest() {
        driver.get(FILMWEB);
        Select dropdown = new Select(driver.findElement(By.name("country")));
        WebElement button = driver.findElement(By.xpath("//*[@value=\"Filtruj\"]"));
        //Trzy różne sposby na osiągniecie tej samej zaznaczonej wartości
        //dropdown.selectByIndex(2);
        //dropdown.selectByValue("135");
        dropdown.selectByVisibleText("Albania");
        button.click();
    }

    @Test(description="Onet")
        public void OnetTest() {
            driver.get(ONET);
            String miasto = "Zamość"; //Lublin
            WebElement rozwin = driver.findElement(By.className("selectedCityWrapper"));
            rozwin.click();
            Boolean isPresent = driver.findElements(By.linkText(miasto)).size() > 0;
            if(isPresent) {
                WebElement widoczneMiasto = driver.findElement(By.linkText(miasto));
                widoczneMiasto.click();
            } else {
                driver.findElement(By.className("citySearchField")).sendKeys(miasto);
                driver.findElement(By.xpath("//*"));//*[@id="mainPageBody"]/div[3]/div[1]/article/div[3]/div/div/form/div/div/div[1]/strong
                String XpathString = "//div[@class=\"citySearchSuggest\"]/div[contains(., \""+miasto+"\")]";
                driver.findElement(By.xpath(XpathString)).click();
                driver.findElement(By.className("citySearchSubmit")).click();
            }
    }
}
