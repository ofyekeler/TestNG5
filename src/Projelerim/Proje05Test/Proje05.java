package Projelerim.Proje05Test;

/*
Techno Study Testing Project 5

1. POM kullanınız.
2. Paralel testler koşturunuz (Chrome,Firefox).
3. Test Case’lerinizi xml file dan çalistiriniz.
4. Url: https://admin-demo.nopcommerce.com/login?
5. username: admin@yourstore.com, password: admin
*/

import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Proje05 extends BaseDriverParameterPrj05 {
    /*
Test Case 1: Login Test
https://admin-demo.nopcommerce.com/login? sitesine gidiniz.
Geçerli Username,password giriniz.
Login butonuna tıklayınız.
Login olduğunuzu doğrulayınız.
    */

    @Test (priority = 1)
    void loginTest() {

        driver.get("https://admin-demo.nopcommerce.com/login?");

        Proje05_ListElements lgn = new Proje05_ListElements(driver);

        lgn.userName.clear();
        lgn.userName.sendKeys("admin@yourstore.com");
        Tools.Bekle(2);
        lgn.password.clear();
        lgn.password.sendKeys("admin");
        lgn.logBtn.click();

        Assert.assertTrue(lgn.logOut.getText().contains("Logout"));
    }
    /*
Test Case 2: Check LeftNaw Menu
Dashboar'dun altındaki menülere tek tek tıklatın.
Menülerin açılıp açılmadığını doğrulayın.
Açılan menünün altındaki elemanların olduğunu doğrulayın.
    */

    @Test(priority = 2,dependsOnMethods = {"loginTest"})
    void checkLeftNawMenu() {

        Proje05_ListElements lgn = new Proje05_ListElements(driver);

        for (int i = 1; i < lgn.leftList.size(); i++) {
            lgn.leftList.get(i).click();
            wait.until(ExpectedConditions.visibilityOf(lgn.openList));
            Assert.assertTrue(lgn.openList.isDisplayed());
            Assert.assertFalse(lgn.openListPar.isEmpty());
        }
    }

    /*
    Test Case 3: Create Customer
    Customers menusunun altındaki Customers’a tıklatınız.
    Açılan sayfada Add new Butonuna tıklatınız.
    Açılan formu doldurunuz ve save butonuna tıklatınız.
    Başarılı bir şekilde Customer oluşturduğunuzu doğrulayınız.
    */
    @Test(priority = 3,dependsOnMethods = {"loginTest"})
    void createcustomer() {

        Proje05_ListElements lftNav = new Proje05_ListElements(driver);
        Proje_05_RightNaw rghtNav = new Proje_05_RightNaw(driver);

        lftNav.customersInMenu.click();
        wait.until(ExpectedConditions.visibilityOf(lftNav.customers));
        lftNav.customers.click();
        wait.until(ExpectedConditions.elementToBeClickable(rghtNav.addNew));
        rghtNav.addNew.click();
        rghtNav.email.sendKeys("grup5@gmail.com");
        rghtNav.AddNewPassword.sendKeys("123456");
        rghtNav.firstName.sendKeys("Grup5");
        rghtNav.lastName.sendKeys("Techno");
        rghtNav.GenderFemale.click();
        rghtNav.dateOfBirth.sendKeys("10.10.1990");
        rghtNav.Company.sendKeys("TechnoStudy");
        rghtNav.IsTaxExempt.click();

        rghtNav.newsLetter.click();
        wait.until(ExpectedConditions.elementToBeClickable(rghtNav.newsLetteritems.get(0)));
        rghtNav.newsLetteritems.get(0).click();

        wait.until(ExpectedConditions.elementToBeClickable(rghtNav.customerRole));
        if(rghtNav.deleteCustomerRole.isEnabled()){
            rghtNav.deleteCustomerRole.click();}
        wait.until(ExpectedConditions.elementToBeClickable(rghtNav.customerRole)).click();

        rghtNav.customerRoleitems.get(3).click();

        wait.until(ExpectedConditions.elementToBeClickable(rghtNav.managerOfVonder)).click();
        Select mangRole = new Select(rghtNav.managerOfVonder);
        mangRole.selectByVisibleText("Vendor 1");

        rghtNav.adminComment.sendKeys("Hello my World.");
        rghtNav.saveBtn.click();
        wait.until(ExpectedConditions.visibilityOf(rghtNav.verification));
        Assert.assertTrue(rghtNav.verification.getText().contains("added successfully"));
    }

/*
Test Case 4: Edit Customer
➢ Customers’a tıklatınız.
➢ Acilan sayfada search kısmına yukarıda oluşturduğunuz Customer’in email,firstname
ve lastName’leri giriniz.
➢ Search butonuna tıklatınız.
➢ Oluşturmuş olduğunuz kaydın geldiğini doğrulayınız.
➢ Edit butonuna tıklatınız.
➢ Herhangi bir bilgiyi değiştirip save butonuna tıklatınız.
➢ Başarılı bir şekilde update olduğunu doğrulayınız.
*/

    @Test(priority = 4,dependsOnMethods = {"loginTest"})
    void  EditCustomer(){

        Proje05_ListElements lftNav = new Proje05_ListElements(driver);
        Proje_05_RightNaw rghtNav = new Proje_05_RightNaw(driver);

        rghtNav.srchEmail.sendKeys("grup5@gmail.com");
        rghtNav.srchFirstName.sendKeys("Grup5");
        rghtNav.srchLastName.sendKeys("Techno");
        rghtNav.srchcbutton.click();

        Assert.assertEquals("grup5@gmail.com",rghtNav.checkCustomer.getText());

        rghtNav.editbutton.click();
        rghtNav.firstName.clear();
        rghtNav.firstName.sendKeys("Grup55");
        rghtNav.editsavebutton.click();
        wait.until(ExpectedConditions.visibilityOf(rghtNav.verification));
        Assert.assertTrue(rghtNav.verification.getText().contains("updated successfully"));

    }

/*
Test Case 5: Delete Customer
➢ Customers’a tıklatınız.
➢ Acilan sayfada search kismina yukarida olusturdugunuz Customer’in email,firstname
ve lastName leri giriniz.
➢ Search butonuna tıklatınız.
➢ Delete butonuna tıklatınız.
➢ Başarılı bir şekilde Customer sildiğinizi doğrulayanız.
*/

    @Test(priority = 5,dependsOnMethods = {"loginTest"})
    void  DeleteCustomer() {

        Proje05_ListElements lftNav = new Proje05_ListElements(driver);
        Proje_05_RightNaw rghtNav = new Proje_05_RightNaw(driver);

        rghtNav.srchEmail.sendKeys("grup5@gmail.com");
        rghtNav.srchFirstName.sendKeys("Grup55");
        rghtNav.srchLastName.sendKeys("Techno");
        rghtNav.srchcbutton.click();
        rghtNav.editbutton.click();
        wait.until(ExpectedConditions.elementToBeClickable(rghtNav.deletebutton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(rghtNav.seconddeletebutton)).click();
        wait.until(ExpectedConditions.visibilityOf(rghtNav.verification));
        Assert.assertTrue(rghtNav.verification.getText().contains("deleted successfully"));
    }
/*
Test Case 6: Search Test
➢ Search kısmına “Shipments” textini gönderiniz.
➢ Arama sonucuna tıklayınız.
➢ Shipments’e gittiğini doğrulayınız
*/

    @Test(priority = 6,dependsOnMethods = {"loginTest"})
    void  SearchTest() {

        Proje05_ListElements lftNav = new Proje05_ListElements(driver);
        Proje_05_RightNaw rghtNav = new Proje_05_RightNaw(driver);

        lftNav.searchbox.sendKeys("Shipments");
        lftNav.searchresult.click();
        wait.until(ExpectedConditions.visibilityOf(rghtNav.resultpage));
        Assert.assertTrue(rghtNav.resultpage.getText().equalsIgnoreCase("Shipments"));
    }
}