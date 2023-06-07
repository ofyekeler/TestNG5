package Projelerim.Proje05Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Proje_05_RightNaw {

    public Proje_05_RightNaw(WebDriver driver) {
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

    @FindBy(xpath = "(//div[@class='k-multiselect-wrap k-floatwrap'])[1]")
    public WebElement newsLetter;

    @FindBy(xpath = "//*[@id='SelectedNewsletterSubscriptionStoreIds_listbox']/li[@tabindex='-1' and @aria-selected='false']")
    public List<WebElement> newsLetteritems;  //bu locator ile alttındaki liste açılıyor

    @FindBy(xpath = "//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover']")
    public WebElement customerRole;

    @FindBy(xpath = "//*[@id='SelectedCustomerRoleIds_listbox']/li[@tabindex='-1' and @aria-selected='false']")
    public List<WebElement> customerRoleitems;  //bu locator ile alttındaki liste açılıyor

    @FindBy(xpath = "//select[@id='VendorId']")
    public WebElement managerOfVonder;

    @FindBy(xpath = "//textarea[@id='AdminComment']")
    public WebElement adminComment;

    @FindBy(xpath = "//button[@name='save']")
    public WebElement saveBtn;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
    public WebElement verification;

    @FindBy(xpath = "//*[@id='SearchEmail']")
    public WebElement srchEmail;

    @FindBy(xpath = "//*[@id='SearchFirstName']")
    public WebElement srchFirstName;

    @FindBy(xpath = "//*[@id='SearchLastName']")
    public WebElement srchLastName;

    @FindBy(xpath = "//*[@id='search-customers']")
    public WebElement srchcbutton;

    @FindBy(xpath = "//a[@class='btn btn-default']")
    public WebElement editbutton;

    @FindBy(xpath = "(//tr[@class='odd']/td)[2]")
    public WebElement checkCustomer;

    @FindBy(xpath = "//*[@name='save']")
    public WebElement editsavebutton;

    @FindBy(xpath = "//span[@id='customer-delete']")
    public WebElement deletebutton;

    @FindBy(xpath = "//button[@class='btn btn-danger float-right']")
    public WebElement seconddeletebutton;

    @FindBy(xpath = "//*[@class='float-left']")
    public WebElement resultpage;

    @FindBy(xpath = "//ul[@id='SelectedCustomerRoleIds_taglist']//span[@aria-label='delete']")
    public WebElement deleteCustomerRole;
}