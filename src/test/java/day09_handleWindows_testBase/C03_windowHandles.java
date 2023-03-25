package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_windowHandles {
    //● Tests package’inda yeni bir class olusturun: WindowHandle2
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
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
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement worthElement= driver.findElement(By.xpath("//h3"));
        String ecpected="Opening a new window";
        String firstPage=driver.getWindowHandle();
        String actual=worthElement.getText();
        Assert.assertEquals(ecpected,actual);
        String expectedTitle="The Internet";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        driver.findElement(By.linkText("Click Here")).click();
        Set<String>windowHandles =driver.getWindowHandles();
        String secondPage="";
        for (String each:windowHandles
             )
        if (!each.equals(firstPage))

        {
            each=secondPage;
        }


        String expectedSecondTitle="New Window";
        String actualSecond= driver.getTitle();
        Assert.assertEquals(actualSecond,expectedSecondTitle);
        driver.switchTo().window(secondPage);
        String actualthird= driver.getTitle();
        String expectedThird="The Internet";
        Assert.assertEquals(actualthird,expectedThird);
    }
}