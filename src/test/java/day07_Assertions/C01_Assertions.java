package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
    amazon anasayfaya gidin
    3 farkli test methodu olusturarak asagidaki görevleri yapin
    1-Url'in amazon icerigini test edin
    2-Title'in facebook icermedigini test edin
    3-sol ust kösede amzon logosunun göründügünü test edin
     */

static WebDriver driver;

@BeforeClass
        public static void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://www.amazon.com");
}
@AfterClass
    public static void tearDown() {
    driver.close();
}
@Test
    public void test01() {


    String gesuchtesWort="amazon";
    String actualUtl=driver.getCurrentUrl();
    Assert.assertTrue(actualUtl.contains(gesuchtesWort));

    }
    @Test
    public void test02(){
    String unerwünschtesWort="facebook";
    String actualTitle=driver.getTitle();
    Assert.assertFalse(actualTitle.contains(unerwünschtesWort));
    }
    @Test
    public void test03(){
        WebElement element=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(element.isDisplayed());
    }
}
