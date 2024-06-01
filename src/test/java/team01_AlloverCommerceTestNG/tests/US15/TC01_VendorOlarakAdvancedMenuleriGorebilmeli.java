package team01_AlloverCommerceTestNG.tests.US15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.P18_VendorProductManagerPage;
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
    }

    @Test
    public void test01() {

        //Tüm menülerin (Inventory, Shipping, Attributes, Linked, Seo, Advanced) görünür olup olmadığını kontrol et.

        ReusableMethods.scroll(allPages.vendorProductManagerPage().inventory);
        ReusableMethods.waitForSecond(3);
        softAssert.assertTrue(allPages.vendorProductManagerPage().inventory.isDisplayed());
        softAssert.assertTrue(allPages.vendorProductManagerPage().shipping.isDisplayed());
        softAssert.assertTrue(allPages.vendorProductManagerPage().attributes.isDisplayed());
        softAssert.assertTrue(allPages.vendorProductManagerPage().linked.isDisplayed());
        softAssert.assertTrue(allPages.vendorProductManagerPage().seo.isDisplayed());
        softAssert.assertTrue(allPages.vendorProductManagerPage().advanced.isDisplayed());
    }


}
