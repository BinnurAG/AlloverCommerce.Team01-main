package team01_AlloverCommerceTestNG.tests.US14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TC04_FotografEklemeNegatifSenaryo {

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

        //Açılan dosyadan uygun formatta olmayan bir dosya seç ve aç butonuna tıkla.
        String yanlisDosyaFormati = System.getProperty("user.home")+"\\Downloads\\adminTestData.xlsx";
        ReusableMethods.uploadFilePath(yanlisDosyaFormati);

        WaitUtils.waitForClickablility(allPages.vendorProductManagerPage().selectButton, 8);

        //Acilan dosyayinin eklenemedigini dogrula.
        WebElement actualResult = allPages.vendorProductManagerPage().selectButton;
        softAssert.assertTrue(!actualResult.isEnabled());
        ReusableMethods.screenShotOfWebElement(allPages.vendorProductManagerPage().selectButton);

        allPages.vendorProductManagerPage().tearDown();
    }
}
