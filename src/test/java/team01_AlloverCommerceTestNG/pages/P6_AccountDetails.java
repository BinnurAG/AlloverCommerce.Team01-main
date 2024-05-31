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

    @FindBy(xpath = "//p[@class='alert alert-light alert-info woocommerce-info']")
    public static WebElement invalidSearch;

    @FindBy(xpath = "//button[@value='54320']")
    public static WebElement addToCart;

    @FindBy(xpath = "//h4[@class='cart-title']")
    public static WebElement shoppingCartList;

    @FindBy(xpath = "//i[@class='fas fa-times']")
    public static WebElement removeProduct;

    @FindBy(xpath = "//a[@class='button checkout wc-forward']")
    public static WebElement checkout;

    @FindBy(xpath = "//a[@class='btn btn-dark btn-link btn-icon-right btn-close']")
    public static WebElement closeButton;

    @FindBy (xpath = "//button[@title='Plus']")
    public static WebElement plus;

    @FindBy(xpath = "//button[@title='Minus']")
    public static WebElement minus;

    @FindBy(xpath = "//a[@class='showcoupon']")
    public static WebElement enterYourCode;

    @FindBy(id = "coupon_code")
    public static WebElement couponCode;

    @FindBy(xpath = "//*[@name='apply_coupon']")
    public static WebElement applyCouponButton;

    @FindBy(xpath = "//div[@role='alert']")
    public static WebElement couponAlertMessage;

    @FindBy(xpath = "//button[@name='clear_cart']")
    public static WebElement clearCart;

    @FindBy(xpath = "//input[@id='billing_first_name']")
    public static WebElement firstName;

    @FindBy(xpath = "//input[@id='billing_last_name']")
    public static WebElement lastName;

    @FindBy(xpath = "//select[@id='billing_country']")
    public static WebElement countryRegion1;

    @FindBy(xpath = "//input[@id='billing_address_1']")
    public static WebElement streetAddress;

    @FindBy(xpath = "//input[@id='billing_city']")
    public static WebElement city;

    @FindBy(xpath = "//input[@id='billing_postcode']")
    public static WebElement zipCode;

    @FindBy(xpath = "//select[@id='billing_state']")
    public static WebElement state;

    @FindBy(xpath = "//input[@id='billing_phone']")
    public static WebElement phone;

    @FindBy(xpath = "//h4[normalize-space()='Payment Methods']")
    public static WebElement paymentMethods;

    @FindBy(xpath = "//tr[@class='cart-subtotal']//bdi[1]")
    public static WebElement subTotal;

    @FindBy(xpath = "//button[@id='place_order']")
    public static WebElement placeOrder;

    @FindBy(xpath = "//input[@id='billing_email']")
    public static WebElement emailAddress;

    @FindBy(xpath = "//*[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public static WebElement orderMessage;






















}
