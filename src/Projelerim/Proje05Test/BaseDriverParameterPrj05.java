package Projelerim.Proje05Test;

import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParameterPrj05 {

 /*   void loginTest() // Bu metodu 2. dersten aldım.
    {
        driver.get("https://admin-demo.nopcommerce.com/login?");

        WebElement inputEmail=driver.findElement(By.id("input-email"));
        inputEmail.sendKeys("ofyklr@gmail.com");

        WebElement password=driver.findElement(By.id("input-password"));
        password.sendKeys("12345");

        WebElement loginBtn=driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();

        Assert.assertTrue(driver.getTitle().equals("My Account"));
        //Assert.assertEquals(driver.getTitle(),"My Account", "Login olamadı");
        //Assert.assertTrue(driver.getCurrentUrl().contains("account/account"));
    }*/
    public static WebDriver driver; // Static eklentisini Gun05 ParalelTest dersinde kaldırdım.
                                    // Her class ın kendi driver ı olsun.
    public static WebDriverWait wait;

    @BeforeClass
    @Parameters("browserTipi") // Gun05 de ekledik. Browser seçeceğiz.
    public void baslangicIslemler(String browserTipi)
    {
        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        switch (browserTipi.toLowerCase())
        {
            case "firefox" :
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                driver = new FirefoxDriver();
                System.out.println("firefox started");
                break;
            case "safari":
                driver=new SafariDriver();
                System.out.println("safari started");
                break;
            case "edge":
                driver=new EdgeDriver();
                System.out.println("edge started");
                break;
            default:
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                ChromeOptions options = new ChromeOptions(); // Chrome güncellemesinden ötürü OPTIONS nesnesini ekledim.
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
        }
            driver.manage().window().maximize(); // Ekranı max yapıyor.

        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
       // loginTest();
    }

    @AfterClass
    public void bitisIslemleri()
    {
        Tools.Bekle(2);
        driver.quit();
    }
}