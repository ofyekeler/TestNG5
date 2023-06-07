package Projelerim.Proje05;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Proje05_ListElements extends BaseDriverParameterPrj05{

    public Proje05_ListElements() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="Email")
    WebElement userName;

    @FindBy(xpath="//input[@id='Password']")
    WebElement password;

    @FindBy(xpath="//button[@class='button-1 login-button']")
    WebElement logBtn;

    @FindBy(xpath="//*[text()='Logout']")
    WebElement logOut;

    @FindBy(xpath="//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li")
    List<WebElement> leftList;

    @FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li[@class='nav-item has-treeview menu-is-opening menu-open']")
    WebElement openList;

    @FindBy(xpath = "//li[@class='nav-item has-treeview menu-is-opening menu-open']//li")
    List<WebElement> openListPar;

    @FindBy(xpath="(//[@class='nav-item has-treeview'])[4]")
    public WebElement customersInMenu;

    @FindBy(xpath="//[@class='nav-item has-treeview menu-is-opening menu-open']//p[text()=' Customers']")
    public WebElement customers;
}