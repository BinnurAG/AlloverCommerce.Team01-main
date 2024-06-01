
package team01_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team01_AlloverCommerceTestNG.utilities.Driver;

import java.util.List;

public class P18_VendorProductManagerPage {

    public P18_VendorProductManagerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

     @FindBy(id = "product_type")
     public WebElement dropdownSimpleProduct;

    @FindBy(id = "is_virtual")

    public WebElement virtualCheckBox;
    @FindBy(id = "is_downloadable")
    public WebElement downloadableCheckBox;

    @FindBy(id = "regular_price")
    public WebElement priceBox;

    @FindBy(id = "sale_price")
    public WebElement salePriceBox;

    @FindBy(id = "pro_title")
    public WebElement productTitleBox;

    @FindBy(xpath = "//*[@value='232']")
    public WebElement categoryBooks_Music_Film;

    @FindBy(id = "featured_img_display")
    public WebElement uploadPhoto;

    @FindBy(xpath = "//option[@value='external']")
    public WebElement dropdownExternalProduct;

    @FindBy(xpath = "//option[@value='grouped']")
    public WebElement dropdownGroupedProduct;

    @FindBy(xpath = "//option[@value='variable']")
    public WebElement dropdownVariableProduct;

    @FindBy(id ="__wp-uploader-id-1")
    public WebElement selectFiles;
    @FindBy(id = "__wp-uploader-id-4")
    public WebElement selectFiles2;

    @FindBy(xpath = "//button[text()='Select']")
    public WebElement selectButton;

    @FindBy(xpath = "//div[@class='media-frame-content']//li[contains(@class, 'attachment')]//img")
    public WebElement addedImage;

    @FindBy (id= "pro_title")
    public WebElement productTitle;

    public  WebElement shortDescription;

    @FindBy(xpath = "(//*[@id='menu-item-browse'])[1]")
    public WebElement menuLibraryButton;

    @FindBy(xpath = "//img[@src='https://allovercommerce.com/wp-content/uploads/2024/05/logo-1-300x237.png']")
    public WebElement logoImage;

    @FindBy(id = "gallery_img_gimage_0_display")
    public WebElement addGalleryPhotoButton;

    @FindBy(xpath = "(//*[@id='menu-item-browse'])[2]")
    public WebElement menuGalleryLibraryButton;

    @FindBy(xpath = "//li[@role='checkbox']")
    public List<WebElement> logoGalleryImage;

    @FindBy(xpath = "(//button[.='Add to Gallery'])[2]")
    public WebElement addToGalleryPhotoButton;

    @FindBy(id = "featured_img_display")
    public WebElement addPhotoButton;

    @FindBy(id= "wcfm_products_simple_submit_button")
    public WebElement submitButton;

    @FindBy(xpath = "//span[contains(text(),'Products')]")
    public WebElement menuProduct;

    @FindBy(className= "wcfm_product_title" )
    public List<WebElement> addedProducts;

    @FindBy(xpath = "//*[@class='wcfm_menu_items wcfm_menu_wcfm-coupons']")
    public WebElement coupons;

    @FindBy(xpath = "//*[@id='add_new_coupon_dashboard']")
    public WebElement addNewCoupon;

    @FindBy(xpath = "//input[@id='title']")
    public WebElement codeBox;

    @FindBy(xpath = "//*[@id='description']")
    public  WebElement descriptionBox;

    @FindBy(xpath = "(//select)[1]")
    public  WebElement discountType;

    @FindBy(xpath = "//*[@id='coupon_amount']")
    public  WebElement couponAmountBox;

    @FindBy(xpath = "//*[@id=\"menu-item-upload\"][2]")
    public WebElement uploadFilesButton;

    @FindBy(className = "load-more-count")
    public WebElement filesVerify;


    @FindBy(id = "tinymce")
    public WebElement description;

    @FindBy(xpath = "//ul[@id = 'product_cats_checklist']")
    public WebElement productCategories;

    @FindBy(xpath = "//input[@value=\"1283\"]")
    public WebElement categoriesBox;

    @FindBy(xpath = "//*[.='+Add new category']")
    public WebElement newCategoriesButton;

    @FindBy(id = "wcfm_new_cat")
    public WebElement CategoriesBox;

    @FindBy(xpath = "//button[@type='button' and @data-taxonomy='product_cat']")
    public WebElement addNewCategories;

    @FindBy(xpath = "//input[@value ='1085']")
    public WebElement addProductBrands;

    @FindBy(xpath = "//*[.='+Add new Product brands']")
    public WebElement addNewProducts;

    @FindBy(id = "wcfm_new_product_brand")
    public WebElement ProductBox;

    @FindBy(xpath = "//li[@*='1509']")
    public WebElement verifyAddProduct;

    @FindBy(xpath = "//button[@class='button upload-dismiss-errors'][1]")
    public WebElement dismissError;

    @FindBy(xpath = "(//button[@class='media-modal-close'])[6]")
    public WebElement closeButton;

    @FindBy(className = "wcfm-message wcfm-error")
    public WebElement titleErrorMessage;
}
