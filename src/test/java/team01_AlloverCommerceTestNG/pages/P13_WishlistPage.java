package team01_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class P13_WishlistPage {
    public P13_WishlistPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[.='Wishlist']")
    public WebElement wishlistTitle;

    @FindBy(xpath = "//div[@class='yith-wcwl-add-button']")
    public WebElement addWishList;

    @FindBy(xpath = "//i[@class='w-icon-heart']")
    public WebElement wishListIcon;

    @FindBy(xpath = "//h2[@class='page-title']")
    public WebElement wishListScreen;

    @FindBy(xpath = "//button[@title='Quick View']")
    public WebElement quickViewButton;

    @FindBy(xpath = "//button[@title='Close (Esc)']")
    public WebElement quickViewCloseButton;

    @FindBy(xpath = "//a[@class='btn btn-dark btn-rounded btn-sm add_to_cart alt']")
    public WebElement addCartButtonInWishList;

    @FindBy(xpath = "//a[@class='btn btn-success btn-md']")
    public WebElement viewCartButton;









}