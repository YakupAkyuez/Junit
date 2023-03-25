package day10_Actions;

import Utilites.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class C02_Actions extends TestBase {
    @Test
    public void test01(){
        //amazon anasayfaya gidip
        //account menuden create a liste tikla
        Actions actons=new Actions(driver);
        driver.get("https://www.amazon.com");
        WebElement element= driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        actons.moveToElement(element).perform();
      driver.findElement(By.xpath("(//span[@class='nav-text'])[2]")).click();
    }
}
