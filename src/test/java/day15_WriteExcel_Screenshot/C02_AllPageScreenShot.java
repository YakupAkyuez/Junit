package day15_WriteExcel_Screenshot;

import Utilites.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class C02_AllPageScreenShot extends TestBase {
    @Test
    public void testScrenShot() throws IOException {
        //amazona gidip tüm sayfanin fotosunu cekelim.
        driver.get("https://www.amazon.com");

        TakesScreenshot sc= (TakesScreenshot) driver;
        LocalDateTime date=LocalDateTime.now();
        System.out.println(date);
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMDDHHmmss");
        String date2=date.format(dtf);

        File AllPageBild=new File("target/ScreenShot/AllPage"+date2+".jpeg");
        File temp=sc.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,AllPageBild);


    }
}
