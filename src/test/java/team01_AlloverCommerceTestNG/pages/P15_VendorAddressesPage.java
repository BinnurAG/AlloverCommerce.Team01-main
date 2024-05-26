package team01_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class P15_VendorAddressesPage {
    public P15_VendorAddressesPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h4[.='Addresses']")
    public WebElement addressesTitle;
}
