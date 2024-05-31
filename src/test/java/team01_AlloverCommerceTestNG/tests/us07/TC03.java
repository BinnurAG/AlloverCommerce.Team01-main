package team01_AlloverCommerceTestNG.tests.us07;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.ExtentReportUtils;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.*;
import static team01_AlloverCommerceTestNG.utilities.Driver.closeDriver;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;
import static team01_AlloverCommerceTestNG.utilities.ReusableMethods.*;

public class TC03 {

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

    @Test(description = "US07-AC03 Kullanıcı karşılaştırma listesinden ürün silip yeni ürün ekleyebilmeli")

    public void test03_AllProductsShouldBeDeletedFromTheComparisonListAndAddNewOnes() {

        //Siteye git, Bilgisayar ürününü seç, compare iconuna tıkla ve 4 ürünü listeye ekle
        loginToSite();
        searchProductAndShowAsList("Bilgisayar");
        click(allPages.comparePage().compareIcon);
        AddNewProduct(3);

        //Compare popup'ındaki ürünleri teker teker sil ve 2 yeni ürün ekle
        deleteProduct(3);
        actions.clickAndHold(allPages.comparePage().scrollBarInComparePopup).moveByOffset(100, 0).perform();
        deleteProduct(1);

        AddNewProduct(2);

        //Son  olarak compare listesinin 2 ürün oldugunu test et
        int count = Integer.parseInt(allPages.comparePage().comparingProductCount.getText().replaceAll("\\D+", ""));
        assertEquals(count, 2, "Products count is not 2.");
        ExtentReportUtils.extentTestPass("Compare listesinin 2 ürün oldugu doğrulandı");

        js.executeScript("arguments[0].remove();", allPages.comparePage().comparePopup);
        actions.moveToElement(allPages.registerPage().mailOfSite).perform();
        visibleWait(allPages.registerPage().signOut, 15);
        click(allPages.registerPage().signOut);
        visibleWait(allPages.registerPage().logout, 15);
        click(allPages.registerPage().logout);
    }


}