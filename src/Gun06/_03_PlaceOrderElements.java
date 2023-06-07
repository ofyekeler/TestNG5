package Gun06;

import Utlity.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _03_PlaceOrderElements {

    // Bu sayfa bir anlamla locator kütüphanesi gibidir.

    // Bu sayfadaki bütün elemanların driverlar bağlantısı gerekiyor
    // bunun için aşağıdaki consructor eklendi ve için PageFatory ile
    // driver üzerinden bu (this) sayfadaki bütün elemnalar ilişkilendirildi.
    // Böylece Sayfada dan nesne türetildiği zaman değil, kullanıldığı
    // anda elemanların bulunması aktif oluyor.Bu yöntemle bütün sayfalarda
    // aynı isimde elemanlar var ise buradaki tanımlama hepsi için geçerli hale
    // gelmiş oluyor. Bu yapıya Page Object Model (POM) adı veriliyor.
    public _03_PlaceOrderElements() { // Constructor ekledik.
       PageFactory.initElements(BaseDriver.driver, this); // Burada ki element ler ne zaman kullanılacaksa,
                                                                // driver ile ilişkilendir ve başlat.
       // driver.findElement ı hepsi için yap
    }

    @FindBy(name = "search")  // @FindBy diyerek "sen aslında locator" sun dedim.
    public WebElement searchBox;

    @FindBy(css = "[class='btn btn-default btn-lg']")
    public WebElement searchButton;

    @FindBy(xpath = "//span[text()='Add to Cart']")
    public WebElement addToChart;

    @FindBy(linkText = "Shopping Cart")
    public WebElement shoppingChart;

    @FindBy(linkText = "Checkout")
    public WebElement checkOut;

    @FindBy(id = "button-payment-address")
    public WebElement continue1;

    @FindBy(id = "button-shipping-address")
    public WebElement continue2;

    @FindBy(id = "button-shipping-method")
    public WebElement continue3;

    @FindBy(name = "agree")
    public WebElement agree;

    @FindBy(id = "button-payment-method")
    public WebElement continue4;

    @FindBy(id = "button-confirm")
    public WebElement confirm;

    @FindBy(css = "[id='content']>h1")
    public WebElement msg;

}


