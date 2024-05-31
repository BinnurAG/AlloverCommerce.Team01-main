package team01_AlloverCommerceTestNG.tests.us07;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import team01_AlloverCommerceTestNG.pages.P12_ComparePage;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ExtentReportUtils;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.*;
import static team01_AlloverCommerceTestNG.utilities.Driver.closeDriver;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;
import static team01_AlloverCommerceTestNG.utilities.ReusableMethods.*;

public class TC01 {

    Pages allPages = new Pages();
    Actions actions = new Actions(getDriver());
    JavascriptExecutor js = (JavascriptExecutor) getDriver();

    @BeforeMethod
    public void beforeMethod() {
        ExtentReportUtils.setUpExtentReport("Hikmet Capraz", "Compare Test");
        loginToSite();
    }
    @AfterMethod
    public void afterMethod() {
        closeDriver();
    }

    @Test(description = "US07-AC01 Kullanıcı karşılaştırmak için ürün seçebilmeli" )
    public void test_AddTwoProductsToCompareList() {

        //Siteye git, "Bilgisayar" ürününü arattır ve sonuçları liste olarak getir.
        searchProductAndShowAsList("Bilgisayar");
        ExtentReportUtils.extentTestInfo("Siteye git, Bilgisayar ürününü arattır ve sonuçları liste olarak getir.");
        visibleWait(allPages.comparePage().compareIcon, 10);

        //2 ürünü karşılaştırma listesine ekle
        click(allPages.comparePage().compareIcon);
        AddNewProduct(1);
        ExtentReportUtils.extentTestInfo("2 ürünü karıştırma listesine ekle.");

        // Compare listesinde 2 ürün var mü kontrol et;
        int count = Integer.parseInt(allPages.comparePage().comparingProductCount.getText().replaceAll("\\D+", ""));
        assertEquals(count, 2, "Products count is not 2.");
        ExtentReportUtils.extentTestPass("Compare listesinde 2 ürün olduğu doğrulandı.");
        ExtentReportUtils.addScreenShotToReport();

        js.executeScript("arguments[0].remove();", allPages.comparePage().comparePopup);
        actions.moveToElement(allPages.registerPage().mailOfSite).perform();
        visibleWait(allPages.registerPage().signOut, 15);
        click(allPages.registerPage().signOut);
        visibleWait(allPages.registerPage().logout, 15);
        click(allPages.registerPage().logout);

    }


}

