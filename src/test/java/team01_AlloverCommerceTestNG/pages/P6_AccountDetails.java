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






}
