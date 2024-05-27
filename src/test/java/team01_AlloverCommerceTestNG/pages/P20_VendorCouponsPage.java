package team01_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class P20_VendorCouponsPage {

    public P20_VendorCouponsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Store Manager")
    public static WebElement storeManager;

    @FindBy(xpath = "(//span[@class='text'])[6]")
    public static WebElement couponButton;

    @FindBy(xpath = "(//span[@class='text'])[18]")
    public static WebElement addNewCouponButton;

    @FindBy(xpath = "//input[@id='title']")
    public static WebElement codeBox;

    @FindBy(xpath = "//textarea[@id='description']")
    public static WebElement descriptionMessage;

    @FindBy(xpath = "//select[@id='discount_type']")
    public static WebElement discountType;

    @FindBy(id = "coupon_amount")
    public static WebElement couponAmount;

    @FindBy(xpath = "//input[@id='expiry_date']")
    public static WebElement expiryDate;

    @FindBy(xpath = "//*[@id='free_shipping']")
    public static WebElement allowFreeShipping;

    @FindBy(xpath = "//*[@id='show_on_store']")
    public static WebElement showOnStore;

    @FindBy(id ="wcfm_coupon_manager_submit_button")
    public static WebElement couponSubmitButton;

    @FindBy(xpath= "//*[@class='wcfm-message wcfm-success']")
    public static WebElement submitVerify;

    @FindBy (xpath = "(//*[@class='wcfm_dashboard_item_title'])[1]")
    public static WebElement couponCode;



<<<<<<< HEAD
=======

>>>>>>> 7049fd31175ad4311accb19107f01bf490969150

}
