package Gun07;

import Gun06._03_PlaceOrderElements;
import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _02_WishListPOM extends BaseDriver {
    // Place Order Model'in kısaltması
    @Test
    @Parameters("searchText")
    void addToWishList(String text){

        _03_PlaceOrderElements poe=new _03_PlaceOrderElements();

        poe.searchBox.sendKeys(text);
        poe.searchButton.click();

        _02_WishListElements wle=new _02_WishListElements();

        int randomSecim= Tools.RandomGenerator(wle.searhResult.size());

        String wishItemText=wle.searhResult.get(randomSecim).getText();

        wle.wishBtnList.get(randomSecim).click();

        wle.btnWishProducts.click();

        Tools.listContainsString(wle.wishTableNames, wishItemText);
    }
}
