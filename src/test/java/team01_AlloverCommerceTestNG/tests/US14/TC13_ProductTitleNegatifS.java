package team01_AlloverCommerceTestNG.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TC13_ProductTitleNegatifS { //Product title alanı boş bırakılıp sumbit butonuna basıldığında "Product successfully published" mesajı alınmamalı

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
        WaitUtils.waitFor(1);
        ReusableMethods.scroll(allPages.vendorProductManagerPage().uploadPhoto);
        WaitUtils.waitFor(1);
    }

    @Test
    public void test01() {

        //Açılan sayfanın sağ üst köşesindeki boş resim ikonuna tıkla.
        allPages.vendorProductManagerPage().uploadPhoto.click();
        WaitUtils.waitForPageToLoad(10);

        //Select files butonuna tıkla.
        allPages.vendorProductManagerPage().selectFiles.click();

        //Açılan dosyadan uygun formatta olan ürün fotoğrafını seç ve aç butonuna tıkla.
        String fotografDosyasiUpload = System.getProperty("user.home") + "\\Downloads\\Photo.jpg";
        ReusableMethods.uploadFilePath(fotografDosyasiUpload);

        WaitUtils.waitForClickablility(allPages.vendorProductManagerPage().selectButton, 8);

        //Media Library alanına gelen fotoğrafı, sağ alt köşedeki select butonuna basarak ekle.
        allPages.vendorProductManagerPage().selectButton.click();

        //Açılan sayfanın sağ üst köşesindeki kucuk boş resim ikonuna tıkla.
        allPages.vendorProductManagerPage().addGalleryPhotoButton.click();
        ReusableMethods.waitForSecond(2);

        //Select files butonuna tıkla.
        allPages.vendorProductManagerPage().selectFiles.click();

        //Açılan dosyadan uygun formatta olan ürün fotoğrafını seç ve aç butonuna tıkla.
        String fotografDosyasi2 = System.getProperty("user.home") + "\\Downloads\\Photo.jpg";
        ReusableMethods.uploadFilePath(fotografDosyasi2);

        ReusableMethods.waitForSecond(5);

        WaitUtils.waitForClickablility(allPages.vendorProductManagerPage().addToGalleryPhotoButton, 8);

        allPages.vendorProductManagerPage().closeButton.click();

        //Categories başlığı altında bulunan seçeneklerden ürün ile ilişkili olanları seç.
        ReusableMethods.scroll(allPages.vendorProductManagerPage().productCategories);
        ReusableMethods.waitForSecond(4);
        ReusableMethods.click(allPages.vendorProductManagerPage().categoriesBox);

        //Submit butonuna tıkla.
        ReusableMethods.scroll(allPages.vendorProductManagerPage().submitButton);
        ReusableMethods.waitForSecond(3);
        allPages.vendorProductManagerPage().submitButton.click();
        ReusableMethods.waitForSecond(2);
        softAssert.assertTrue(allPages.vendorProductManagerPage().titleErrorMessage.isDisplayed());

    }
}
