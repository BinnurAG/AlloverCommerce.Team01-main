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

public class TC06 {

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

    @Test(description = "US07-AC04 Kullanıcı 2 ürün karşılaştırabilmeli")
    public void test_TwoProductsShouldBeCompared() {

        //Siteye git, Bilgisayar ürününü seç, compare iconuna tıkla ve 2 ürünü listeye ekle
        loginToSite();
        searchProductAndShowAsList("Bilgisayar");
        click(allPages.comparePage().compareIcon);
        AddNewProduct(1);
        ExtentReportUtils.extentTestInfo("2 ürün eklendi");

        //Start compare butonuna tıkla ve 2 ürünü karşılaştır.
        click(allPages.comparePage().startCompareButton);
        visibleWait(allPages.comparePage().compareField, 5);
        assertTrue(allPages.comparePage().compareField.isDisplayed(), "Karşılastırma ekranı açılmadı.");
        ExtentReportUtils.extentTestPass("2 ürün karıştırıldı");

        actions.moveToElement(allPages.registerPage().mailOfSite).perform();
        visibleWait(allPages.registerPage().signOut, 15);
        click(allPages.registerPage().signOut);
        visibleWait(allPages.registerPage().logout, 15);
        click(allPages.registerPage().logout);
    }


}