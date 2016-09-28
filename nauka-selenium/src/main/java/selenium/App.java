package selenium;
//App.java
import io.github.bonigarcia.wdm.ChromeDriverManager;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.annotations.Test;
public class App {
    @Test(description="Pierwszy test!")
    public void openSite() {
        ChromeDriverManager.getInstance().setup(); //inicjalizacja drivera przegladarki Chrome. Korzystamy z biblioteki webdriver manager
        WebDriver  driver = new ChromeDriver(); //utworzenie obiektu drivera
        driver.get("http://www.google.pl");
    }
}