package team01_AlloverCommerceTestNG.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

import javax.swing.text.Utilities;
import java.awt.datatransfer.StringSelection;

public class TC02_UrunFotografiEkleme { //Ürün fotoğrafı eklenebilmeli (öne çıkan ürün fotoğrafı) PASS

    Pages allPages = new Pages();

    @Test
    public void test01() {

        allPages.vendorProductManagerPage().setUp();

        //Açılan sayfanın sağ üst köşesindeki boş resim ikonuna tıkla.
        ReusableMethods.scroll(allPages.vendorProductManagerPage().uploadPhoto);
        allPages.vendorProductManagerPage().uploadPhoto.click();
        WaitUtils.waitForPageToLoad(10);

        //Select files butonuna tıkla.
        allPages.vendorProductManagerPage().selectFiles.click();

        //Açılan dosyadan uygun formatta olan ürün fotoğrafını seç ve aç butonuna tıkla.
        String fotografDosyasiUpload = System.getProperty("user.home")+"\\Downloads\\Photo.jpg";
        ReusableMethods.uploadFilePath(fotografDosyasiUpload);

        WaitUtils.waitForClickablility(allPages.vendorProductManagerPage().selectButton, 8);

        //Media Library alanına gelen fotoğrafı, sağ alt köşedeki select butonuna basarak ekle.
        allPages.vendorProductManagerPage().selectButton.click();

        WaitUtils.waitForClickablility(allPages.vendorProductManagerPage().uploadPhoto, 10);

        //Ürün fotoğrafı eklendiğini doğrula.
        allPages.vendorProductManagerPage().uploadPhoto.click();
        allPages.vendorProductManagerPage().filesVerify.isDisplayed();

        allPages.vendorProductManagerPage().tearDown();
    }

}



