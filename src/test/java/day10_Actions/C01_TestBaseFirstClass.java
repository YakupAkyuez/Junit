package day10_Actions;

import Utilites.TestBase;
import org.junit.Test;

public class C01_TestBaseFirstClass extends TestBase {

    @Test
    public void  test01(){
        driver.get("https://www.amazon.com");
    }
}
