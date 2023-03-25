package day13_Cokies_Webtable;

import Utilites.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class C02_Webtables extends TestBase {
    @Test
    public void WebTable() {

        //● login( ) metodun oluşturun ve oturum açın.
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com");
        //            ○ Username : manager
        //            ○ Password : Manager1!
        loginMethod();

        //● table( ) metodu oluşturun
        //            ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> column = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Column number :" + column.size());
        WebElement allBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(allBody.getText());
        //            ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        //● printRows( ) metodu oluşturun //tr
        List<WebElement> rows = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Lines Num: " + rows);
        //            ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        System.out.println("Rows :" + rows.size());
        //            ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each : rows
        ) {
            System.out.println(each.getText());
        }
        //            ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> cellList = driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each : cellList
        ) {
            System.out.println(each.getText());
        }
        //E maildeki tüm elementleri konsolda yazdırın.
        List<WebElement> emailrows = driver.findElements(By.xpath("//tbody//td[3]"));
        for (WebElement each : emailrows
        ) {
            System.out.println(each.getText());
        }
        List<WebElement> headers = driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailrowsNum=0;
        for (int i = 0; i <headers.size() ; i++) {
          if ( headers.get(i).getText().equals("Email")){

            emailrowsNum=i;
        }
    }
        List<WebElement>emaiColumn=driver.findElements(By.xpath("//tbody//td["+(emailrowsNum+1)+"]"));
        for (WebElement each:emaiColumn
             ) {
            System.out.println(each.getText());
        }
}

    private void loginMethod() {
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
