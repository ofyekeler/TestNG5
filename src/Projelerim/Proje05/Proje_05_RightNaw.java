package Projelerim.Proje05;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Proje_05_RightNaw extends BaseDriverParameterPrj05 {

    public Proje_05_RightNaw() {
        PageFactory.initElements(driver, this);
    }

    //customers a bastıktan sonra doldurulacak formun locatorları

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement addNew;

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement AddNewPassword;

    @FindBy(xpath = "//input[@id='FirstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='LastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='Gender_Male']")
    public WebElement GendereMale; //click

    @FindBy(xpath = "//input[@id='Gender_Female']")
    public WebElement GenderFemale; //click

    @FindBy(xpath = "//input[@id='DateOfBirth']")
    public WebElement dateOfBirth;

    @FindBy(xpath = "//input[@id='Company']")
    public WebElement Company;

    @FindBy(xpath = "//input[@id='IsTaxExempt']")
    public WebElement IsTaxExempt;

   // @FindBy(xpath = "//select[@id='SelectedNewsletterSubscriptionStoreIds']")
    @FindBy(xpath = "(//div[@class='k-multiselect-wrap k-floatwrap'])[1]")
    public WebElement newsLetter;

   // @FindBy(xpath = "//li[@tabindex='-1' and @aria-selected='true']")
    @FindBy(xpath = "//*[@id='SelectedNewsletterSubscriptionStoreIds_listbox']/li[@tabindex='-1' and @aria-selected='false']")
    public List<WebElement> newsLetteritems;  //bu locator ile alttındaki liste açılıyor

//    @FindBy(xpath = "(//select[@id='SelectedNewsletterSubscriptionStoreIds']/option)[2]")
//    public WebElement newsLetterOptTestStore; // News Letter ın "Test store 2" option ı

    @FindBy(xpath = "//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover']")
    public WebElement customerRole;

   // @FindBy(xpath = "//li[@tabindex='-1' and @aria-selected='false']")
    @FindBy(xpath = "//*[@id='SelectedCustomerRoleIds_listbox']/li[@tabindex='-1' and @aria-selected='false']")
    public List<WebElement> customerRoleitems;  //bu locator ile alttındaki liste açılıyor

//    @FindBy(xpath = "//input[@class='k-input']")
//    public WebElement customerRole;  //seyda nın yazdıgı locator

//    @FindBy(xpath = "//select[@id='SelectedCustomerRoleIds']/option[text()='Vendors']")
//    public WebElement customerRoleVendors; // Customer Role un "Vendors" option ı

    @FindBy(xpath = "//select[@id='VendorId']")
    public WebElement managerOfVonder;

    @FindBy(xpath = "(//select[@id='VendorId']/option)[2]")
    public WebElement managerOfVonderOpt2; // manager of Vendor ın "Vendor 1" option ı

    @FindBy(xpath = "//textarea[@id='AdminComment']")
    public WebElement adminComment;

    @FindBy(xpath = "//button[@name='save']")
    public WebElement saveBtn;


}
