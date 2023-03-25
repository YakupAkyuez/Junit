package day08_Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class C01_Alerts {
    static WebDriver driver;

    public C01_Alerts() {
    }

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15L));
    }

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        String expected = "You successfully clicked an alert";
        WebElement sonucYazisi = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = sonucYazisi.getText();
        Assert.assertEquals(expected, actual);
    }
}