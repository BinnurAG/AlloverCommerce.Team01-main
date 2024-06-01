package team01_AlloverCommerceTestNG.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TC05_FotografEklemeNegatifSenaryo2 { //Ürün fotoğrafı uygun formatta değilse, fotoğraf sayfaya eklenmemeli

    Pages allPages = new Pages();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test01() {

        allPages.vendorProductManagerPage().setUp();
        //Açılan sayfanın sağ üst köşesindeki boş resim ikonuna tıkla.
        allPages.vendorProductManagerPage().uploadPhoto.click();
        WaitUtils.waitForPageToLoad(10);

        //Select files butonuna tıkla.
        allPages.vendorProductManagerPage().selectFiles.click();

        //Açılan dosyadan uygun formatta olmayan(boyutu 2mbden fazla) bir dosya seç ve aç butonuna tıkla.
        String yuksekBoyut = System.getProperty("user.home")+"\\Downloads\\rum.jpg";
        ReusableMethods.uploadFilePath(yuksekBoyut);

        //"Exceeds the maximum upload size for this site" mesajının görüldüğünü doğrula.
        softAssert.assertTrue(allPages.vendorProductManagerPage().dismissError.isDisplayed());

        allPages.vendorProductManagerPage().tearDown();
    }

}
