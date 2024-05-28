package team01_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class P15_VendorAddressesPage {
    public P15_VendorAddressesPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h4[.='Addresses']")
    public WebElement addressesTitle;

    @FindBy(xpath = "//a[contains(@href, 'shipping') and contains(text(), 'Add')]")
    public WebElement addButton;

    @FindBy(id = "shipping_first_name")
    public WebElement firstName;

    @FindBy(id = "shipping_last_name")
    public WebElement lastName;

    @FindBy(id = "shipping_company")
    public WebElement companyName;

    @FindBy(id = "shipping_country")
    public WebElement countryDropdown;

    @FindBy(id = "shipping_address_1")
    public WebElement streetName;

    @FindBy(id = "shipping_city")
    public WebElement cityName;

    @FindBy(id = "shipping_state")
    public WebElement stateDropdown;

    @FindBy(id = "shipping_postcode")
    public WebElement zipCodeName;

    @FindBy(css = "button[name = 'save_address']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='woocommerce-notices-wrapper']/div/i")
    public WebElement successMessage;

    @FindBy(xpath = "//li[contains(@class, 'alert-danger') and contains(@data-id, 'shipping_postcode')]")
    public WebElement zipCodeErrorMessage;

    @FindBy(xpath = "//li[contains(@class, 'alert-danger') and contains(@data-id, 'shipping_city')]")
    public WebElement cityErrorMessage;


    public void selectCountry(String countryName) {
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(countryName);

    }


    public void selectState(String stateName) {
        Select select = new Select(stateDropdown);
        select.selectByVisibleText(stateName);
    }

    @FindBy(linkText = "Addresses")
    public WebElement addressesButton;

}
