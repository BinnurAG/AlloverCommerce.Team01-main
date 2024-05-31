package team01_AlloverCommerceTestNG.tests.us07;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.ExtentReportUtils;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static team01_AlloverCommerceTestNG.utilities.Driver.closeDriver;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;
import static team01_AlloverCommerceTestNG.utilities.ReusableMethods.*;

public class TC04 {

    Pages allPages = new Pages();
    Actions actions = new Actions(getDriver());
    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    @BeforeMethod
    public void beforeMethod() {
        ExtentReportUtils.setUpExtentReport("Hikmet Capraz", "Compare Test");
    }

    @AfterMethod
    public void afterMethod() {
        closeDriver();
    }
    @Test(description = "US07-AC03 Kullanıcı karşlaştırma listesinden ürün silip yeni ürün ekleyebilmeli")
    public void test_DeleteSomeOrAllProductsAndAddNewOnes() {

        //Siteye git, Bilgisayar ürününü seç, compare iconuna tıkla ve 4 ürünü listeye ekle
        loginToSite();
        searchProductAndShowAsList("phone");
        click(allPages.comparePage().compareIcon);
        AddNewProduct(3);

        //Compare popup'ındaki ürünlerin tamamını teker teker sil
        deleteProduct(3);
        actions.clickAndHold(allPages.comparePage().scrollBarInComparePopup).moveByOffset(100, 0).perform();
        deleteProduct(1);


        //Yeni bir ürün ekle
        js.executeScript("arguments[0].remove();", allPages.comparePage().comparePopup);
        click(allPages.comparePage().compareIcon);

        //Son  olarak compare listesinin 1 ürün oldugunu test et
        int count = Integer.parseInt(allPages.comparePage().comparingProductCount.getText().replaceAll("\\D+", ""));
        assertEquals(count, 1, "Products count is not 1.");

        js.executeScript("arguments[0].remove();", allPages.comparePage().comparePopup);
        actions.moveToElement(allPages.registerPage().mailOfSite).perform();
        visibleWait(allPages.registerPage().signOut, 15);
        click(allPages.registerPage().signOut);
        visibleWait(allPages.registerPage().logout, 15);
        click(allPages.registerPage().logout);
    }


}