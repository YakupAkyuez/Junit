package day10_Actions;

import Utilites.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Set;

public class C03_Actions extends TestBase {
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions=new Actions(driver);
        WebElement cizgiliAlan=driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlan).perform();
        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        driver.switchTo().alert().accept();
        String firstPageHandle= driver.getWindowHandle();
        WebElement elementalSelenium=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        elementalSelenium.click();
        Set<String>handleSet=driver.getWindowHandles();
        String seconPage="";
        System.out.println(handleSet);
        for (String each:handleSet
             )
        if (!each.equals(firstPageHandle))

        {
            seconPage=each;
        }
        driver.switchTo().window(seconPage);
        WebElement yaziElementi=driver.findElement(By.tagName("h1"));
        String expectedIkinciYazi="Elemental Selenium";
        String actualIkinciYazi=yaziElementi.getText();
        Assert.assertEquals(expectedIkinciYazi,actualIkinciYazi);
    }

}
