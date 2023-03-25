package day10_Actions;

import Utilites.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C04_MouseActions extends TestBase {
    //Yeni bir class olusturalim: MouseActions2


    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement dragMe=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragMe,dropHere).perform();
       String sonuc= driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
       String actual="Dropped!";
        Assert.assertEquals(actual,sonuc);

    }

}
