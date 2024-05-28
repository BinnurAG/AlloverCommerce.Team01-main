package team01_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class P5_AddressesPage {


    public P5_AddressesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "login inline-type")
    public WebElement signIn1;

    @FindBy(id = "username")
    public WebElement usernameSignIn;

    @FindBy(id = "password")
    public WebElement passwordSignIn;

    @FindBy(css = "button[name='login']")
    public WebElement signIn2;

    @FindBy(xpath = "//a[span='Sign Out']")
    public WebElement signOut;

    @FindBy(xpath = "//header[h3='Billing address']")
    public WebElement billingAddress;



    //Billing Address Sayfası
    @FindBy(xpath = "//a[@href='https://allovercommerce.com/my-account-2/edit-address/billing/']")
    public WebElement addButonuB;

    @FindBy(className = "woocommerce-address-fields")
    public WebElement addressPageB;

    @FindBy(id = "billing_first_name")
    public WebElement firstNameB;

    @FindBy(id = "billing_last_name")
    public WebElement lastNameB;

    @FindBy(id = "billing_company")
    public WebElement companyB;

    @FindBy(id = "billing_country")
    public WebElement countryB;

    @FindBy(id = "billing_address_1")
    public WebElement adress1B;

    @FindBy(id = "billing_address_2")
    public WebElement adress2B;

    @FindBy(id = "billing_town")
    public WebElement townB;

    @FindBy(id = "billing_state")
    public WebElement stateB;

    @FindBy(id = "billing_postcode")
    public WebElement postcodeB;

    @FindBy(id = "billing_phone")
    public WebElement phoneB;

    @FindBy(id = "billing_email")
    public WebElement emailB;

    @FindBy(name = "save_address")
    public WebElement savebutonB;

    //Shipping Address Sayfası

    @FindBy(xpath = "//a[@href='https://allovercommerce.com/my-account-2/edit-address/shipping/']")
    public WebElement addButonu;

    @FindBy(className = "woocommerce-address-fields")
    public WebElement addressPageS;

    @FindBy(id = "shipping_first_name")
    public WebElement firstNameS;

    @FindBy(id = "shipping_last_name")
    public WebElement lastNameS;

    @FindBy(id = "shipping_company")
    public WebElement companyS;

    @FindBy(id = "shipping_country")
    public WebElement countryS;

    @FindBy(id = "shipping_address_1")
    public WebElement adress1S;

    @FindBy(id = "shipping_address_2")
    public WebElement adress2S;

    @FindBy(id = "shipping_town")
    public WebElement townS;

    @FindBy(id = "shipping_state")
    public WebElement stateS;

    @FindBy(id = "shipping_postcode")
    public WebElement postcodeS;

    @FindBy(id = "shipping_phone")
    public WebElement phoneS;

    @FindBy(id = "shipping_email")
    public WebElement emailS;

    @FindBy(name = "save_address")
    public WebElement savebutonS;

}
