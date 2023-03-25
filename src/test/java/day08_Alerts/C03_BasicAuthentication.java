package day08_Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_BasicAuthentication {
    static WebDriver driver;

    public C03_BasicAuthentication() {
    }

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15L));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
