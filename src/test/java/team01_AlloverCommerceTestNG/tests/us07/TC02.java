package team01_AlloverCommerceTestNG.tests.us07;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ExtentReportUtils;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import static org.testng.Assert.assertEquals;
import static team01_AlloverCommerceTestNG.utilities.Driver.closeDriver;
import static team01_AlloverCommerceTestNG.utilities.Driver.getDriver;
import static team01_AlloverCommerceTestNG.utilities.ReusableMethods.*;

public class TC02 {

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

    @Test(description = "US07-AC02 Kullanıcı karşılaştırma listesine en fazla 4 ürün ekleyebilmeli" )
    public void test_MaxFourProductsShouldBeAddedToCompareList() {

        //Siteye git, phone ürününü seç, compare iconuna tıkla ve 4 ürünü listeye ekle
        loginToSite();

        searchProductAndShowAsList("phone");
        click(allPages.comparePage().compareIcon);
        AddNewProduct(3);
        ExtentReportUtils.extentTestInfo("Compare listesine 4 ürün eklendi.");

        //Listeye 1 bilgisayar ürünü ekle
        js.executeScript("arguments[0].remove();", allPages.comparePage().comparePopup);
        searchProductAndShowAsList("bilgisayar");
        click(allPages.comparePage().compareIcon);
        ExtentReportUtils.extentTestInfo("Listeye 1 bilgisayar ürünü eklendi.");

        //5 ürün eklenmeye çalışıldıktan sonra compare listesinin 4 ürün oldugunu test et
        int count = Integer.parseInt(allPages.comparePage().comparingProductCount.getText().replaceAll("\\D+", ""));
        assertEquals(count, 4, "Products count is not 4.");
        click(allPages.comparePage().cleanAllButton);
        ExtentReportUtils.extentTestPass("Compare listesinin hala 4 ürün oldugu doğrulandı");

        js.executeScript("arguments[0].remove();", allPages.comparePage().comparePopup);
        actions.moveToElement(allPages.registerPage().mailOfSite).perform();
        visibleWait(allPages.registerPage().signOut, 15);
        click(allPages.registerPage().signOut);
        visibleWait(allPages.registerPage().logout, 15);
        click(allPages.registerPage().logout);
    }

}