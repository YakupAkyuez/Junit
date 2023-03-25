package day08_Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class C02_Alerts {
    static WebDriver driver;

    public C02_Alerts() {
    }

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15L));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() {
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        String expected = "You successfully clicked an alert";
        WebElement sonucYazisi = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = sonucYazisi.getText();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void tes02() {
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String unexpected = "successfuly";
        WebElement finallyWorth = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = finallyWorth.getText();
        Assert.assertFalse(actual.contains(unexpected));
    }

    @Test
    public void tes03() {
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Yakup Akyüz");
        driver.switchTo().alert().accept();
        String istenen = "Yakup Akyüz";
        WebElement finallyWorth = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = finallyWorth.getText();
        Assert.assertTrue(actual.contains(istenen));
    }
}


