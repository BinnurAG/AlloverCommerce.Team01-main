
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



    @FindBy(xpath = "//*[.='Register']")
    public WebElement registerButtonEntry;

    @FindBy(xpath = "//*[@class='register_as_vendor']")
    public WebElement signUpAsVendor;


    @FindBy(xpath = "//*[@id='user_email']")
    public WebElement emailBecomeVendor;

    @FindBy(xpath = "//*[@id='passoword']")
    public WebElement passwordBecomeVendor;



    @FindBy(xpath = "//*[@id='confirm_pwd']")
    public WebElement confirmPasswordBecomeVendor;



    //mustafameric
    @FindBy(xpath = "//*[@id='wcfm_membership_register_button']")
    public WebElement submitBecomeVendor;


    @FindBy(xpath = "//*[@class='login inline-type']")
    public WebElement signIn;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement userName;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@name='login']")
    public WebElement submit;


    @FindBy(xpath = "//*[.='Sign Out']")
    public WebElement signOut;


    @FindBy(xpath = "(//*[.='Addresses'])[1]")
    public WebElement billingAdress;


    @FindBy(xpath = "(//a[text()='Add'])[1]")
    public WebElement billingAdressAdd;
    @FindBy(xpath = "(//a[.='Edit Your Billing Address'])[1]")
    public WebElement billingAddressEdit;

    @FindBy(xpath = "//*[.='Logout']")
    public WebElement logOut;



    @FindBy(xpath = "//input[@id='billing_email']")
    public WebElement billingEmailAdresBox;

    @FindBy(xpath = "//select[@id='billing_country']")
    public WebElement ddmBillingAddressCountry;


    @FindBy(xpath = "//input[@id='billing_first_name']")
    public WebElement billingFirstNameBox;

    @FindBy(xpath = "//input[@id='billing_last_name']")
    public WebElement billingLastNameBox;

    @FindBy(xpath = "//input[@id='billing_company']")
    public WebElement billingCompanyNameBox;

    @FindBy(xpath = "//input[@id='billing_address_1']")
    public WebElement billingStreetAddressNameBox;

    @FindBy(xpath = "//input[@id='billing_address_2']")
    public WebElement billingStreetAddress2NameBox;

    @FindBy(xpath = "//input[@id='billing_city']")
    public WebElement billingCityNameBox;

    @FindBy(xpath = "//input[@id='billing_postcode']")
    public WebElement billingZipCodeBox;

    @FindBy(xpath = "//input[@id='billing_phone_field']")
    public WebElement billingPhoneNumberBox;



    //mustafameric













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
