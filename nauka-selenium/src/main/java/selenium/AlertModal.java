package selenium;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertModal {

    private WebDriver driver;

    private static String ALERT = "http://www.javascripter.net/faq/alert.htm";
    private static String MODAL = "http://www.w3schools.com/bootstrap/bootstrap_modal.asp";

    @BeforeClass
    public void SetUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver(chromeOptions);
    }
    @Test(description="Obsługa okna alert")
public void AlertTest() {
        driver.get(ALERT);
        driver.findElement(By.xpath("//*/input[@value=\"Try it now\"]")).click(); //uruchamiamy alert

        System.out.printf("Tekst z alertu: "+driver.switchTo().alert().getText()); //pobieramy tekst

        try {
            TimeUnit.SECONDS.sleep(5); //opóźnienie
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().alert().accept(); //akceptujemy alert
    }

    @Test(description="Obsługa okna modal")
    public void ModalTest() {
        driver.get(MODAL);
        driver.findElement(By.xpath("//*[@id=\"main\"]/button")).click(); //uruchamiamy modal

        try {
            TimeUnit.SECONDS.sleep(5); //opóźnienie
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"myModal\"]//*/button")).click();
    }
}
