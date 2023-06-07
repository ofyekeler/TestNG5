package Gun02;

import Utlity.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class _01_Enable_False {

    @Test // public, jUnit de ki gibi zorunlu değil.
    void test1(){
        System.out.println("test 1");
    }

    @Test(enabled = false) // ...dediğimde bu kısmı test e dahil etmez.
                            // sanki çift slash yapmışız gibi.
    void test2(){
        System.out.println("test 2");
    }

    @Test
    void test3(){
        System.out.println("test 3");
    }

    public static WebDriver driver;

    @BeforeClass
    void baslangicIslemler()
    {
        System.out.println("başlangıç işlemleri yapılıyor");
        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize(); // Ekranı max yapıyor.
        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);
    }

    @AfterClass
    void bitisIslemleri()
    {
        System.out.println("bitiş işlemleri yapılıyor");
        Tools.Bekle(1);
        driver.quit();
    }
/*
başlangıç işlemleri yapılıyor
test 1
test 3
bitiş işlemleri yapılıyor
*/
}
