package day11_Faker_File;

import Utilites.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_Faker extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //facebook görevini fake isimlerle yapalim

        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")).click();
        Thread.sleep(15);

        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement nameBox=driver.findElement(By.xpath("//input[@name='firstname']"));
Faker faker=new Faker();
        Actions actions=new Actions(driver);
        actions.click(nameBox).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB)
                .sendKeys(faker.name().name()).
                sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("10").
                sendKeys(Keys.TAB).
                sendKeys("May").
                sendKeys(Keys.TAB).
                sendKeys("1999").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER)
                .perform();

    }
}
