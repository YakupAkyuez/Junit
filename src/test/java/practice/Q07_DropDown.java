package practice;

import Utilites.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class Q07_DropDown extends TestBase {
    // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/


    //-->Task3 printout DropDown Elements' number
    //-->Task4 choose dropdown elements and printout dropdown elements' name  until choise 6


    @Test
    public void test01() {
        //-->Task1 Find Dropdown on Multi Selection
      driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        //-->Task2 Find  all Dropdown Elements on page
        WebElement MultiSelection=driver.findElement(By.xpath("(//span[@class='comboTreeArrowBtnImg'])[1]"));
       // WebElement MSOptionSelect=driver.findElement(By.xpath(("(//span[@class='comboTreeArrowBtnImg'])[2]")));
        //WebElement SingleSelection=driver.findElement(By.xpath(("(//span[@class='comboTreeArrowBtnImg'])[3]")));
        MultiSelection.click();
       // Select select1=new Select(MSOptionSelect);
        //Select select2=new Select(SingleSelection);



    }
}
