package day15_WriteExcel_Screenshot;

import Utilites.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C04_JSExecutor extends TestBase {
    @Test
    public void JavaScriptExecutor() {

        //amazona gidelim asagidaki "Sign in" butonu görününceye kadar scroll yapalim ve butona tiklayalim

        driver.get("https://www.amazon.com");

        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement signButton=driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));
        js.executeScript("arguments[0].scrollIntoView(true);",signButton);
        js.executeScript("arguments[0].click();",signButton);
    }
}
