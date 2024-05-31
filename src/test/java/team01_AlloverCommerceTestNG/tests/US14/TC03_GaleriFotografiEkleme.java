package team01_AlloverCommerceTestNG.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TC03_GaleriFotografiEkleme {
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

        //Açılan sayfanın sağ üst köşesindeki kucuk boş resim ikonuna tıkla.
        allPages.vendorProductManagerPage().addGalleryPhotoButton.click();
        ReusableMethods.waitForSecond(2);

        //Select files butonuna tıkla.
        allPages.vendorProductManagerPage().selectFiles.click();

        //Açılan dosyadan uygun formatta olan ürün fotoğrafını seç ve aç butonuna tıkla.
        String fotografDosyasiUpload = System.getProperty("user.home") + "\\Downloads\\Photo.jpg";
        ReusableMethods.uploadFilePath(fotografDosyasiUpload);

        ReusableMethods.waitForSecond(5);

        WaitUtils.waitForClickablility(allPages.vendorProductManagerPage().addToGalleryPhotoButton, 8);

        //Ürün fotoğrafı eklendiğini doğrula.
        allPages.vendorProductManagerPage().filesVerify.isDisplayed();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}