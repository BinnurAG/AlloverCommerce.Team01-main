
package team01_AlloverCommerceTestNG.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.utilities.*;

import java.util.List;

public class P18_VendorProductManagerPage {

    Pages allPages = new Pages();
    public P18_VendorProductManagerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    SoftAssert softAssert = new SoftAssert();
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

    @FindBy(id ="__wp-uploader-id-1")
    public WebElement selectFiles;

    @FindBy(xpath = "//button[text()='Select']")
    public WebElement selectButton;

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

    @FindBy(id = "wcfm_products_manage_form_inventory_head")
    public WebElement inventory;
    @FindBy(id = "wcfm_products_manage_form_shipping_head")
    public WebElement shipping;
    @FindBy(id = "wcfm_products_manage_form_attribute_head")
    public WebElement attributes;
    @FindBy(id = "wcfm_products_manage_form_linked_head")
    public WebElement linked;
    @FindBy(id = "wcfm_products_manage_form_yoast_head")
    public WebElement seo;
    @FindBy(id = "wcfm_products_manage_form_advanced_head")
    public WebElement advanced;
    @FindBy(xpath = "//input[@id='sku']")
    public WebElement skuBox;
    @FindBy(id = "manage_stock")
    public WebElement manageStockButton;
    @FindBy(id = "stock_qty")
    public WebElement stockQtyBox;
    @FindBy(id = "backorders")
    public WebElement backOrdersDdm;
    @FindBy(id = "stock_status")
    public WebElement stockStatusDdm;
    @FindBy(xpath = "(//option[@value='instock'])[1]")
    public WebElement inStockDdmSelect;
    @FindBy(id = "sold_individually")
    public WebElement soldIndividually;
    @FindBy(id = "weight")
    public WebElement weightBox;
    @FindBy(id = "length")
    public WebElement lengthBox;
    @FindBy(id = "width")
    public WebElement widthBox;
    @FindBy(id = "width")
    public WebElement heightBox;
    @FindBy(id = "shipping_class")
    public WebElement shippingClass;
    @FindBy(id = "_wcfmmp_processing_time")
    public WebElement processingTime;
    @FindBy(xpath = "//select/option[@value='1']")
    public WebElement getProcessingTime;





    @BeforeMethod
    public void setUp(){
        ReusableMethods.userVendorlogin(ConfigReader.getProperty("vendorEmail"),ConfigReader.getProperty("vendorPassword"));

        allPages.homePage().signOutButton.click();
        allPages.vendorStoreManagerPage().storeManagerLink.click();
        allPages.vendorStoreManagerPage().productsMenu.click();
        ActionsUtils.hoverOver(allPages.vendorStoreManagerPage().productsMenu);
        WaitUtils.waitForVisibility(By.linkText("Add New"), 3);
        allPages.vendorStoreManagerPage().addNew2.click();
        WebElement actualResultText = allPages.vendorStoreManagerPage().addProductVerify;
        softAssert.assertTrue(actualResultText.isDisplayed());
        WaitUtils.waitFor(1);
    }

    @AfterMethod
    public void tearDown() {

        Driver.closeDriver();
    }
}
