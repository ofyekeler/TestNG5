package Projelerim.Proje04;

import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Proje04 extends BaseDriverPrj04 {

//  Test Case 1: Registrations Test
//➢ https://demo.nopcommerce.com/register?returnUrl=%2F Sitesine gidiniz
//➢ Register butonuna tıklayınız
//➢ First Name ve Last Name giriniz
//➢ Doğum tarihi kısımlarını select ile seciniz
//➢ Email giriniz
//➢ Password ve password confirm giriniz
//➢ Register butonuna tıklayınız
//➢ Başarılı bir şekilde kaydolduğunuzu doğrulayınız.
    
    @Test(priority = 1)
    @Parameters({"eMail", "pass"})
    void Registrations_Test(String eMail, String pass){
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        WebElement firstName = driver.findElement(By.cssSelector("[id='FirstName']"));
        firstName.sendKeys("NameGrup5");

        WebElement lastName = driver.findElement(By.cssSelector("[id='LastName']"));
        lastName.sendKeys("LastGrup5");

        WebElement day = driver.findElement(By.cssSelector("[name='DateOfBirthDay']"));
        Select daymenu = new Select(day);
        daymenu.selectByVisibleText("1");

        WebElement month = driver.findElement(By.cssSelector("[name='DateOfBirthMonth']"));
        Select monthmenu = new Select(month);
        monthmenu.selectByIndex(2);

        WebElement year = driver.findElement(By.cssSelector("[name='DateOfBirthYear']"));
        Select yearmenu = new Select(year);
        yearmenu.selectByVisibleText("1990");

        WebElement email = driver.findElement(By.cssSelector("[id='Email']"));
        email.sendKeys(eMail);

        WebElement password = driver.findElement(By.cssSelector("[id='Password']"));
        password.sendKeys(pass);

        WebElement confirmPassword = driver.findElement(By.cssSelector("[id='ConfirmPassword']"));
        confirmPassword.sendKeys(pass);

        WebElement register = driver.findElement(By.cssSelector("[id='register-button']"));
        register.click();

        wait.until(ExpectedConditions.urlContains("registerresult"));

        WebElement msg = driver.findElement(By.xpath("//*[text()='Your registration completed']"));
        Assert.assertTrue(msg.getText().contains("completed"));
    }

//   Test Case 2: Login Test
//➢ Login butonuna tıklayınız
//➢ Kaydolduğunuz Email ve password giriniz
//➢ LOG IN butonunna tıklayınız
//➢ Başarılı bir şekilde login olduğunuzu doğrulayınız.
    @Test(priority = 2)
    @Parameters({"eMail", "pass"})
    void Login_Test(String eMail, String pass) {
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        WebElement login = driver.findElement(By.cssSelector("[class='ico-login']"));
        login.click();

        WebElement email = driver.findElement(By.cssSelector("[id='Email']"));
        email.sendKeys(eMail);

        WebElement password = driver.findElement(By.cssSelector("[id='Password']"));
        password.sendKeys(pass);

        WebElement loginBtn = driver.findElement(By.cssSelector("[class='button-1 login-button']"));
        loginBtn.click();

        WebElement logOut = driver.findElement(By.cssSelector("[class='ico-logout']"));
        Assert.assertTrue(logOut.getText().contains("Log out"));

        logOut.click();
    }

//   Test Case 3: Data Provider Login
//➢ Login butonuna tıklayınız
//➢ Geçerli ve geçersiz Email ve password’u Data Provider metodundan aliniz
//➢ LOG IN butonunna tıklayınız
//➢ başarılı bir şekilde login olup olmadığınızı doğrulayınız.
    @Test(dataProvider = "datas")
    void Data_Provider_Login(String eMail, String passWord) {
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        WebElement login = driver.findElement(By.cssSelector("[class='ico-login']"));
        login.click();

        WebElement email = driver.findElement(By.cssSelector("[id='Email']"));
        email.sendKeys(eMail);

        WebElement password = driver.findElement(By.cssSelector("[id='Password']"));
        password.sendKeys(passWord);

        WebElement loginBtn = driver.findElement(By.cssSelector("[class='button-1 login-button']"));
        loginBtn.click();

        WebElement logOut = driver.findElement(By.cssSelector("[class='ico-logout']"));
        SoftAssert _softAssert = new SoftAssert();
        _softAssert.assertTrue(logOut.getText().contains("Log out"));
        _softAssert.assertAll();
    }

    @DataProvider
    public Object[][] datas() {
        Object[][] user = {
                {"agaghsh@gmail.com", "grup05"},         // MAİL YANLIŞ
                {"grup05@gmail.com", "grup"},      // PASSWORD YANLIŞ
                {"grup05@gmail.com", "grup05"}};     // DOĞRU

        return user;
    }

//    Test Case 4: Tab Menu Test
//➢ Tab menudeki ürünlerin isimlerini liste atiniz
//➢ Tab menu listesini locate ediniz
//➢ Locate ettiginiz listenin elemanlarinin tab menudeki ürünleri içerdiğini doğrulayınız.

    @Test(priority = 3)
    void Tab_Menu_Test() {
        driver.get("https://demo.nopcommerce.com/");

        List<WebElement> tabMenuList = driver.findElements(By.xpath("//*[@class='top-menu notmobile']/li/a"));

        ArrayList<String> TabUrunler = new ArrayList<>(Arrays.asList("Computers", "Electronics", "Apparel", "Digital downloads", "Books", "Jewelry", "Gift Cards"));

        for (WebElement t : tabMenuList) {

            System.out.println("t.getText() = " + t.getText());
            Assert.assertTrue(TabUrunler.contains(t.getText()));
        }
    }

//   Test Case 5: Order Gifts Test
//➢ Tab menuden gifts’e tıklayınız
//➢ Physical giftlerden birini random olarak seciniz
//➢ Açılan sayfada recipient name, sender name ve message bölümlerini doldurunuz
//➢ Ad To Cart’a tıklayınız
//➢ Urunun sepete eklendiğini doğrulayınız

    @Test(dependsOnMethods = {"Login_Test"})
    @Parameters({"yName","mess","recName"})
    void Order_Gifts_Test(String yName, String mess,String recName) {
        WebElement giftCard = driver.findElement(By.xpath("//*[@class='top-menu notmobile']/li[7]/a"));
        Tools.Bekle(3);
        giftCard.click();

        List<WebElement> giftCardList = driver.findElements(By.cssSelector("[class='product-title']>a"));

        WebElement randomGiftL = giftCardList.get((int) (Math.random() * giftCardList.size()));
        randomGiftL.click();

        WebElement recipientsName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='recipient-name']")));
        recipientsName.sendKeys(recName);

        WebElement yourName = driver.findElement(By.cssSelector("[class='sender-name']"));
        yourName.sendKeys(yName);

        WebElement message = driver.findElement(By.cssSelector("[class='message']"));
        message.sendKeys(mess);

        WebElement addToCard = driver.findElement(By.cssSelector("[class='button-1 add-to-cart-button']"));
        addToCard.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='content']")));
        WebElement mesg = driver.findElement(By.xpath("//*[@class='content']"));
        System.out.println(mesg.getText());
        Assert.assertTrue(mesg.getText().contains("The product has been added"));
    }

//    Test Case 6: Order Computer Test
//➢ Tab menudeki Computers üzerine gidiniz
//➢ Drop down dan Desktops’a tıklayınız
//➢ Açılan sayfadan Build your own computer’i seciniz
//➢ Random bir RAM seciniz
//➢ Random bir HDD seciniz
//➢ AD TO CART’a tıklayınız
//➢ Urunun başarılı bir şekilde sepete eklendiğini doğrulayınız

    @Test(dependsOnMethods = {"Login_Test"})
    void Order_Computer_Test() {
        Actions actions = new Actions(driver);
        WebElement computers = driver.findElement(By.xpath("(//a[@href='/computers'])[1] "));
        actions.moveToElement(computers).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='/desktops'])[1]")));
        WebElement desktop = driver.findElement(By.xpath("(//a[@href='/desktops'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(desktop)).click();

        WebElement buildComp = driver.findElement(By.xpath("//*[text()='Build your own computer']"));
        buildComp.click();

        WebElement ram = driver.findElement(By.xpath("//*[@id='product_attribute_2']"));
        Select ramMenu = new Select(ram);
        wait.until(ExpectedConditions.elementToBeClickable(ram));

        ramMenu.selectByIndex((int) (Math.random() * (ramMenu.getOptions().size() - 1) + 1));

        List<WebElement> hdds = driver.findElements(By.cssSelector("[id^='product_attribute_3']"));
        hdds.get((int) (Math.random() * hdds.size())).click();

        WebElement addToCart = driver.findElement(By.xpath("//*[@id='add-to-cart-button-1']"));
        addToCart.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='content']")));
        WebElement mesg = driver.findElement(By.xpath("//*[@class='content']"));
        Assert.assertTrue(mesg.getText().contains("The product has been added"));
    }

//   Test Case 7: Parametreli Search Test
//➢ Search’e xml den aldiginiz “Adobe Photoshop CS4” giriniz
//➢ Search butonuna tıklayınızh
//➢ Açılan sayfadaki urun baslığının bu text’I içerdiğini doğrulayınız

    @Test(dependsOnMethods = {"Login_Test"})
    @Parameters("searchWord")
    void ParameterSearchTest(String searchW) {
        WebElement search = driver.findElement(By.xpath("//*[@id='small-searchterms']"));
        search.sendKeys(searchW);
        WebElement searchBtn = driver.findElement(By.xpath("//*[@class='button-1 search-box-button']"));
        searchBtn.click();

        WebElement cs4Text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Adobe Photoshop CS4']")));
        Assert.assertEquals(searchW, cs4Text.getText());
    }
}