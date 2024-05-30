package team01_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class P12_ComparePage {

    public P12_ComparePage() {
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

    @FindBy(xpath = "//a[@class='w-icon-list btn-showtype']")
    public static WebElement showResultsAsListIcon;

    @FindBy(xpath = "//div[@class='compare-popup show']")
    public static WebElement comparePopup;

    @FindBy(xpath = "//div[@class='compare-heading']/p")
    public static WebElement comparingProductCount;

    @FindBy(xpath = "//a[@class='compare btn-product-icon']")
    public static WebElement compareIcon;

    @FindBy(xpath = "//a[@href='https://allovercommerce.com/urun/blue-ski-boots/']/figure/img")
    public static WebElement BlueSkiBoots;

    @FindBy(xpath = "//a[@class='btn-remove remove_from_compare fas fa-times']")
    public static WebElement productDeleteIcon;

    @FindBy(xpath = "//div[@class='slider-scrollbar-drag']")
    public static WebElement scrollBarInComparePopup;

    @FindBy(xpath = "//a[text()='Start Compare !']")
    public static WebElement startCompareButton;

    @FindBy(xpath = " //div[@class='compare-col compare-field']")
    public static WebElement compareField;

    @FindBy(xpath = "//a[text()='Clean All']")
    public static WebElement cleanAllButton;

    @FindBy(xpath = "//i[@class='w-icon-times-solid']")
    public static WebElement productDeleteIconInCompareScreen;

    @FindBy(xpath = "//h2[text()='No products added to the compare']")
    public static WebElement noProductsAddedToCompareList;






















}