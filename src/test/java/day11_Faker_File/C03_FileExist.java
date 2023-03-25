package day11_Faker_File;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void Test() {
        System.out.println(System.getProperty("user.dir"));
        String dokWay=System.getProperty("user.home")+"/Desktop//text.rtf";
        System.out.println(dokWay);
        System.out.println(Files.exists(Paths.get(dokWay)));
    }
}
