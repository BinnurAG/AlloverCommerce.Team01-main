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

public class TC05 {

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
    @Test
    public void test_DeleteAllProductsWithCleanAllButton() {

        //Siteye git, phone ürününü seç, compare iconuna tıkla ve 4 ürünü listeye ekle
        loginToSite();
        searchProductAndShowAsList("phone");
        click(allPages.comparePage().compareIcon);
        AddNewProduct(3);
        ExtentReportUtils.extentTestInfo("4 ürün eklendi");

        //Compare popup'ında bulunan clean all butonuna tıkla
        click(allPages.comparePage().cleanAllButton);
        int count = Integer.parseInt(allPages.comparePage().comparingProductCount.getText().replaceAll("\\D+", ""));
        assertEquals(count, 0, "Products count is not 0.");
        ExtentReportUtils.extentTestPass("Compare popup'ındaki Clean All butonu ile tüm ürünler silindi");

        js.executeScript("arguments[0].remove();", allPages.comparePage().comparePopup);
        actions.moveToElement(allPages.registerPage().mailOfSite).perform();
        visibleWait(allPages.registerPage().signOut, 15);
        click(allPages.registerPage().signOut);
        visibleWait(allPages.registerPage().logout, 15);
        click(allPages.registerPage().logout);
    }

}