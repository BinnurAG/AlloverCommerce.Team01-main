package team01_AlloverCommerceTestNG.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

import java.awt.datatransfer.StringSelection;

public class TC02_UrunFotografiEkleme { //Ürün fotoğrafı eklenebilmeli (öne çıkan ürün fotoğrafı) PASS

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

    @Test
    public void test01() {
        //Açılan sayfanın sağ üst köşesindeki boş resim ikonuna tıkla.
        allPages.vendorProductManagerPage().uploadPhoto.click();
    }

    @Test
    public void test02() {
        //Upload fıles butonuna tıkla.
        allPages.vendorProductManagerPage().uploadFilesButton.click();
    }

    @Test
    public void test03() {
        //Select files butonuna tıkla.
        allPages.vendorProductManagerPage().selectFiles.click();
    }

    @Test
    public void test04() {
        //Açılan dosyadan uygun formatta olan ürün fotoğrafını seç ve aç butonuna tıkla.

    }

    @Test
    public void test05() {
        //Media Library alanına gelen fotoğrafı, sağ alt köşedeki select butonuna basarak ekle.
        allPages.vendorProductManagerPage().selectButton.click();
    }

    @Test
    public void test06() {
        //Ürün fotoğrafı eklendiğini doğrula.
        allPages.vendorProductManagerPage().filesVerify.isDisplayed();
    }

}