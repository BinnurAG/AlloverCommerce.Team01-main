package team01_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class P6_AccountDetails {

    public P6_AccountDetails() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "a.login.inline-type > span")
    public static WebElement signIn;

    @FindBy(xpath = "//span[text()='Sign Out']")
    public static WebElement signOut;

    @FindBy(xpath = "//input[@type='text']")
    public static WebElement userNameArea;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    public static WebElement passwordArea;

    @FindBy(xpath = "//input[@name='rememberme']")
    public static WebElement rememberMe;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public static WebElement signInButton;

    @FindBy(xpath = "(//input[@type='search'])[1]")
    public static WebElement searchBox;

    @FindBy(xpath = "//div[@class='breadcrumb-container container']")
    public static WebElement searchResults;

    @FindBy(xpath = "//button[@class='btn btn-search']")
    public static WebElement searchIcon;

    @FindBy(xpath = "//button[@name='add-to-cart']")
    public static WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='cart-toggle']")
    public static WebElement cart;

    @FindBy(xpath = "//span[@class='cart-count']")
    public static WebElement cartCount;

    @FindBy(xpath = "//a[@class='button wc-forward']")
    public static WebElement viewCartButton;

    @FindBy(xpath = "//button[@title='Plus']")
    public static WebElement quantityPlusButton;

    @FindBy(xpath = "//button[@title='Minus']")
    public static WebElement quantityMinusButton;

    @FindBy(xpath = "//li[@class='disable']")
    public static WebElement orderCompleteButton;

    @FindBy(css = " span[id='select2-calc_shipping_country-container']")
    public static WebElement countryDropdown;

    @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[2]")
    public static WebElement cityDropdown;

    @FindBy(id = "calc_shipping_city")
    public static WebElement townDropdown;

    @FindBy(css = ".cart-information")
    public static WebElement CartTotal;

    @FindBy(xpath = "//p[@class='woocommerce-shipping-destination']")
    public static WebElement shippingAddress;

    @FindBy(id = "payment_method_bacs")
    public static WebElement wireTransfer;

    @FindBy(id = "payment_method_cod")
    public static WebElement payAtTheDoor;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    public static WebElement proceedToCheckoutButton;

    @FindBy(id = "place_order")
    public static WebElement placeOrderButton;

    @FindBy(xpath = "//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public static WebElement orderReceived;

















}