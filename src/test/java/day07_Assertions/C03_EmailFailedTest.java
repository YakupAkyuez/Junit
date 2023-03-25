package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_EmailFailedTest {

    /*
    Bir Class olusturalim YanlisEmailTesti
http://automationpractice.com/index.php sayfasina gidelim
Sign in butonuna basalim
Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim

     */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationpractice.com/index.php");
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }
    @Test
    public void test(){
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        String istenmeyen="yakupmail.com";
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(istenmeyen+Keys.ENTER);
        String element = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol")).getText();
        String istenen="Invalid email address";
        Assert.assertTrue(element.contains(istenen));



    }

}
