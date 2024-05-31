package team01_AlloverCommerceTestNG.tests.US15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TC01_VendorOlarakAdvancedMenuleriGorebilmeli {

    Pages allPages = new Pages();
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setUp() {

        // Web sitesine git.
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));

        // Kayıtlı vendor bilgileriyle giriş yap.
        allPages.homePage().signInButton.click();
        ReusableMethods.userVendorlogin("nrumeysa.ksck@gmail.com", "123456789Rr");

        // My account butonuna tıkla.
        allPages.homePage().signOutButton.click();

        // Storage Manager linkine tıkla.
        allPages.vendorStoreManagerPage().storeManagerLink.click();

        // Mouse ile Products butonu üzerinde bekle.
        ActionsUtils.hoverOver(allPages.vendorStoreManagerPage().productsMenu);
        WaitUtils.waitForVisibility(By.linkText("Add New"), 3);

        // Add New butonuna tıkla.
        allPages.vendorStoreManagerPage().addNew2.click();

        ReusableMethods.scroll(allPages.vendorProductManagerPage().uploadPhoto);

        // Add Product sayfasına geldiğini doğrula.
        WebElement actualResultText = allPages.vendorStoreManagerPage().addProductVerify;
        softAssert.assertTrue(actualResultText.isDisplayed());
        WaitUtils.waitFor(1);

    }

    @Test
    public void test01() {
        //Tüm menülerin (Inventory, Shipping, Attributes, Linked, Seo, Advanced) görünür olup olmadığını kontrol et.
        softAssert.assertTrue(allPages.vendorProductManagerPage().inventory.isDisplayed());
        softAssert.assertTrue(allPages.vendorProductManagerPage().shipping.isDisplayed());
        softAssert.assertTrue(allPages.vendorProductManagerPage().attributes.isDisplayed());
        softAssert.assertTrue(allPages.vendorProductManagerPage().linked.isDisplayed());
        softAssert.assertTrue(allPages.vendorProductManagerPage().seo.isDisplayed());
        softAssert.assertTrue(allPages.vendorProductManagerPage().advanced.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
