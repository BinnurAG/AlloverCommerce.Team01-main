
package team01_AlloverCommerceTestNG.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class P16_VendorStoreManagerPage {

    public P16_VendorStoreManagerPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement productsMenu;

    @FindBy(xpath = "//h2[.='Store Manager']")
    public WebElement storeManagerTitle;

    @FindBy(linkText = "Store Manager")
    public WebElement storeManagerLink;

    @FindBy(linkText = "Add New")
    public WebElement addNew2;

    @FindBy(xpath = "//h2[.='Add Product']")
    public WebElement addProductVerify;



}
