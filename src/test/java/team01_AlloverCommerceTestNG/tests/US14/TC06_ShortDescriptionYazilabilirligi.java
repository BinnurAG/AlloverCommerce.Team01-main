package team01_AlloverCommerceTestNG.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.P18_VendorProductManagerPage;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TC06_ShortDescriptionYazilabilirligi {

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
        // "Short Description" alanına veri gir.
        Driver.getDriver().switchTo().frame(0);
        allPages.vendorProductManagerPage().shortDescription.sendKeys("kolye");

        //Girilen verinin göründüğünü doğrula.
        softAssert.assertEquals(allPages.vendorProductManagerPage().shortDescription.getText(), "kolye");
    }

   @AfterMethod
   public void tearDown() {
        Driver.closeDriver();
   }

}


