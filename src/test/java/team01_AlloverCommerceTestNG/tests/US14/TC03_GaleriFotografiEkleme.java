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

    @Test
    public void test01() {

        allPages.vendorProductManagerPage().setUp();

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

        allPages.vendorProductManagerPage().tearDown();
    }

}