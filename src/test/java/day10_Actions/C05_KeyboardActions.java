package day10_Actions;

import Utilites.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C05_KeyboardActions extends TestBase {
    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));

        //once arama kutusuna click yapip harf harf Nutella yazisini yazdiralim sonrada enter
        Actions actions=new Actions(driver);
        actions.click(searchBox).
        keyDown(Keys.SHIFT).
        sendKeys("n").keyUp(Keys.SHIFT).
                sendKeys("u").
                sendKeys("t").
                sendKeys("e").
                sendKeys("l").
                sendKeys("l").
                sendKeys("a").
                sendKeys(Keys.ENTER).perform();
    }
}
