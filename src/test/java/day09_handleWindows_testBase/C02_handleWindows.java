package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();

    }

    @Test
    public void test01() {
        //amazon ansayfaya gidelim
        driver.get("https://www.amazon.com");
        String firstPageValue=driver.getWindowHandle();
        //urlin amazon icerdigini test edelim
        String aactula="amazon";
        String expected=driver.getCurrentUrl();
        Assert.assertTrue(expected.contains(aactula));
        //yeni bir pencere acip bestbuy an sayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.bestbuy.com");
        //title in best buy icerdigini test edelim
        String title="Best Buy";
        String secondPageValue=driver.getWindowHandle();
        String actual=driver.getTitle();
        Assert.assertTrue(actual.contains(title));
        //ilk sayfaya gidelim java aratalim
        driver.switchTo().window(firstPageValue);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);


        //arama sonuclarinin java icerdigini test edelim
        String sonuc=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
        String worth="Java";
        Assert.assertTrue(sonuc.contains(worth));
        //yeniden bestbuy in acik oldugu sayfaya gidelim

        driver.switchTo().window(secondPageValue);
        //logo isDisplayed?
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed());




    }
}