package day13_Cokies_Webtable;


import Utilites.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_WebTables extends TestBase {
    @Test
    public void dinamikYazici() {
        // onceki class'daki adrese gidip
        // girisYap method'unu kullanarak sayafaya giris yapin
        // input olarak verilen satir sayisi ve sutun sayisi'na sahip
        // cell'deki text'i yazdirin
        int satir=3;
        int sutun=3;
        girisYap();
        WebElement arananCell=
                driver.findElement(By.xpath("//tbody//tr["+3+"]//td["+3+"]"));
        System.out.println(arananCell.getText());
    }
    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
    }
}













