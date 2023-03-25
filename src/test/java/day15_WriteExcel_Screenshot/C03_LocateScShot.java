package day15_WriteExcel_Screenshot;

import Utilites.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class C03_LocateScShot extends TestBase {


    @Test
    public void name() throws IOException {
    driver.get("https://wwww.amazon.com");
    WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
    searchBox.sendKeys("Nutella"+ Keys.ENTER);
    WebElement sonucYazi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

    File sonucSC=new File("target/ScreenShot/sonucYaziSCS.jpeg");
    File temp=sonucYazi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,sonucSC);


}
}
