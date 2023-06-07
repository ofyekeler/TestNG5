package Projelerim.Proje05;

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

public class Proje05 extends BaseDriverParameterPrj05{
    /*
Test Case 1: Login Test
https://admin-demo.nopcommerce.com/login? sitesine gidiniz.
Geçerli Username,password giriniz.
Login butonuna tıklayınız.
Login olduğunuzu doğrulayınız.
    */

    @Test
    void loginTest(){

        driver.get("https://admin-demo.nopcommerce.com/login?");

        Proje05_ListElements lgn = new Proje05_ListElements();

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

    @Test (dependsOnMethods = {"loginTest"})
    void checkLeftNawMenu(){

        Proje05_ListElements lgn = new Proje05_ListElements();

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

    @Test(dependsOnMethods = {"loginTest"})
    void createcustomer() {

        Proje05_ListElements lftNav = new Proje05_ListElements();
        Proje_05_RightNaw rghtNav = new Proje_05_RightNaw();

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

        // Aşşağıda ilk başta web elementi selecte çevirip denedim olmadı.
        // sonra optionların locatorlarını bularak denemeye çalıştım yine olmadı
        // burayı düzeltirsiniz
        // en son save den sonra Assert eklenecek, kayıt yaptıramadığım için assert e gelemedim

        rghtNav.newsLetter.click();
        rghtNav.newsLetteritems.get(0).click();

        rghtNav.customerRole.click();
        rghtNav.customerRoleitems.get(3).click();
//          Select newsL = new Select(rghtNav.newsLetter);
//         newsL.selectByIndex(1);
//        wait.until(ExpectedConditions.visibilityOf(rghtNav.newsLetterOptTestStore)).click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(rghtNav.customerRole)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(rghtNav.customerRoleVendors)).click();
//        Select cusRole = new Select(rghtNav.customerRole);
//        cusRole.selectByVisibleText("Vendors");

        wait.until(ExpectedConditions.elementToBeClickable(rghtNav.managerOfVonder)).click();
        Select mangRole = new Select(rghtNav.managerOfVonder);
        mangRole.selectByVisibleText("Vendor 1");
        wait.until(ExpectedConditions.elementToBeClickable(rghtNav.managerOfVonderOpt2)).click();

        rghtNav.adminComment.sendKeys("Hello my World.");
        rghtNav.saveBtn.click();
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


/*
Test Case 5: Delete Customer
➢ Customers’a tıklatınız.
➢ Acilan sayfada search kismina yukarida olusturdugunuz Customer’in email,firstname
ve lastName leri giriniz.
➢ Search butonuna tıklatınız.
➢ Delete butonuna tıklatınız.
➢ Başarılı bir şekilde Customer sildiğinizi doğrulayanız.
*/


/*
Test Case 6: Search Test
➢ Search kısmına “Shipments” textini gönderiniz.
➢ Arama sonucuna tıklayınız.
➢ Shipments’e gittiğini doğrulayınız
*/
}
