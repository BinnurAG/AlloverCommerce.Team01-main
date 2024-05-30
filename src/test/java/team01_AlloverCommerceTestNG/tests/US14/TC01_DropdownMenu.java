package team01_AlloverCommerceTestNG.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TC01_DropdownMenu {  // Simple Product, Variable Product, Grouped Product, External - Affiliate Product seçenekleri olmalı (PASS)


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

        //Simple product menuye kadar scroll yap.
        ReusableMethods.scroll(allPages.vendorProductManagerPage().dropdownSimpleProduct);

        // Add Product sayfasına geldiğini doğrula.
        WebElement actualResultText = allPages.vendorStoreManagerPage().addProductVerify;
        softAssert.assertTrue(actualResultText.isDisplayed());

    }

    @Test(description = "US14 - TC01 / Simple Product, Variable Product, Grouped Product, External - Affiliate Product seçenekleri olmalı")
    public void test01() throws InterruptedException {

        //Simple Product dropdown menüsünün görünür olduğunu doğrula.
        allPages.vendorProductManagerPage().dropdownSimpleProduct.isDisplayed();

        //Simple Product dropdown menusune tikla.
        allPages.vendorProductManagerPage().dropdownSimpleProduct.click();
        Thread.sleep(3);

        //Menüde; Simple Product, Variable Product, Grouped Product ve External/Affiliate Product seçeneklerinin olduğunu doğrula.
        ReusableMethods.ddmIndex(allPages.vendorProductManagerPage().dropdownSimpleProduct, 0);
        ReusableMethods.ddmIndex(allPages.vendorProductManagerPage().dropdownSimpleProduct, 1);
        ReusableMethods.ddmIndex(allPages.vendorProductManagerPage().dropdownSimpleProduct, 2);
        ReusableMethods.ddmIndex(allPages.vendorProductManagerPage().dropdownSimpleProduct, 3);

    }

    @AfterMethod
    public void tearDown() {
        Driver.getDriver().close();
    }

}
