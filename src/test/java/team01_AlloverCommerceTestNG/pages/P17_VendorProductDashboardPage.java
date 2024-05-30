
package team01_AlloverCommerceTestNG.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class P17_VendorProductDashboardPage {

    public P17_VendorProductDashboardPage() { PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//*[.='Add New']")
    public WebElement addNewButton;

    @FindBy(xpath = "(//*[@type='search'])[1]")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@name='add-to-cart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "(//i)[6]")
    public WebElement cart;

    @FindBy(xpath = "//a[@class='button checkout wc-forward']")
    public WebElement checkout;
    @FindBy(xpath = "//a[@class='button wc-forward']")
    public WebElement viewCart;

    @FindBy(xpath = "//*[.='Product']")
    public WebElement product;
    @FindBy(id = "order_review_heading")
    public WebElement yourorder;

    @FindBy(xpath = "//input[@id='billing_first_name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='billing_last_name']")
    public WebElement lastName;

    @FindBy(id = "billing_address_1")
    public WebElement street;

    @FindBy(xpath = "//span[@title='Germany']")
    public WebElement country;

    @FindBy(xpath = "//input[@value='60603']")
    public WebElement postcodeZip;

    @FindBy(xpath = "//input[@value='Frankfurt']")
    public WebElement townCity;

    @FindBy(xpath = "//span[@id='select2-billing_state-container']")
    public WebElement State;

    @FindBy(xpath = "//input[@value='123456']")
    public WebElement phone;

    @FindBy(xpath = "//input[@value='nike.crew@floodouts.com']")
    public WebElement email;

    @FindBy(xpath = "(//bdi)[4]")
    public WebElement subtotal;
    @FindBy(xpath = "//tr[@class='order-total']")
    public WebElement totalprice;
    @FindBy(xpath = "(//input)[22]")
    public WebElement wireTransfer;
    @FindBy(id = "payment_method_cod")
    public WebElement payAtTheDoor;

    @FindBy(xpath = "//*[text()='Thank you. Your order has been received.']")
    public WebElement Verifymessage;

    @FindBy(xpath = "//button[@id='place_order']")
    public WebElement placeOrder;


    @FindBy(xpath = "//a[contains(text(),'My Account')]")
    public WebElement myAccount;


}
