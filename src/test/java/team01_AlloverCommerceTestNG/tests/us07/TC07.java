package team01_AlloverCommerceTestNG.tests.us07;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.ExtentReportUtils;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.assertTrue;
import static team01_AlloverCommerceTestNG.utilities.Driver.closeDriver;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;
import static team01_AlloverCommerceTestNG.utilities.ReusableMethods.*;

public class TC07 {

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

    @Test(description = "US07-AC05 Kullanıcı karşılaştırma ekranından ürün silebilmeli")
    public void test_DeleteFromTheCompareScreen() {

        //Siteye git, phone ürününü seç, compare iconuna tıkla ve 4 ürünü listeye ekle
        loginToSite();
        searchProductAndShowAsList("phone");
        click(allPages.comparePage().compareIcon);
        AddNewProduct(3);
        ExtentReportUtils.extentTestInfo("4 ürün eklendi");

        //Start compare butonuna tıkla ve karşılaştırma ekranını aç
        click(allPages.comparePage().startCompareButton);
        visibleWait(allPages.comparePage().compareField, 5);
        ExtentReportUtils.extentTestInfo("Karıştırma ekranı açıldı");

        //Karıştırma ekranında 4 ürünü de teker teker sil
        deleteProductFromCompareScreen(4);
        visibleWait(allPages.comparePage().noProductsAddedToCompareList, 5);
        assertTrue(allPages.comparePage().noProductsAddedToCompareList.isDisplayed());
        ExtentReportUtils.extentTestPass("Karşılaştırılan 4 ürün silindi");

        actions.moveToElement(allPages.registerPage().mailOfSite).perform();
        visibleWait(allPages.accountDetails().signOut, 15);
        click(allPages.accountDetails().signOut);
        visibleWait(allPages.registerPage().logout, 15);
        click(allPages.registerPage().logout);
    }

 }