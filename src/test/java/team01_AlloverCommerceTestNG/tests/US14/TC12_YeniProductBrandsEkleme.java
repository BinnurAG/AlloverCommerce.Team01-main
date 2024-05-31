package team01_AlloverCommerceTestNG.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TC12_YeniProductBrandsEkleme {

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

        // Add Product sayfasına geldiğini doğrula.
        WebElement actualResultText = allPages.vendorStoreManagerPage().addProductVerify;
        softAssert.assertTrue(actualResultText.isDisplayed());
    }

    @Test
    public void test01() {

        //Add new Product brands linkine tıkla.
        ReusableMethods.scroll(allPages.vendorProductManagerPage().addNewProducts);
        WaitUtils.waitFor(1);
        allPages.vendorProductManagerPage().addNewProducts.click();
        WaitUtils.waitFor(1);

        //Product brands name alanına geçerli bir data gir.
        allPages.vendorProductManagerPage().ProductBox.sendKeys("bbb");
        WaitUtils.waitFor(1);

        //Yeni marka eklendiğini doğrula.
        softAssert.assertTrue(allPages.vendorProductManagerPage().verifyAddProduct.isDisplayed());

    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}