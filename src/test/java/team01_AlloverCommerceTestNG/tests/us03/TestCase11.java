package team01_AlloverCommerceTestNG.tests.us03;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.pages.P4_MyAccountPage;
import team01_AlloverCommerceTestNG.pages.P5_AddressesPage;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TestCase11 {

        Pages allpages = new Pages();

    @BeforeTest
    public void beforeMethod(){
        ExtentReportUtils.setUpExtentReport("US03-TC11", "Fatma Binnur Arslanhan");
        //Siteye ulaşılmalı ve edit butonu tıklanabilmeli
        ReusableMethods.signInUS0304();
        allpages.addressesPage().editButonB.click();
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı ve edit butonu tıklandı");
    }




    @Test
    public void companyNameIsAllowedToBeEmpty() {



        //Company name bilgisi silinebilmeli
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='';", allpages.addressesPage().companyB);
        ExtentReportUtils.extentTestInfo("Company name bilgisi silindi");

        //Save Adress butonu tıklanabilir olmalı
        allpages.addressesPage().savebutonB.submit();
        ExtentReportUtils.extentTestInfo("Save Adress butonu tıklandı");

        //Address changed successfully. yazısı görünmeli
        WaitUtils.waitForVisibility(allpages.addressesPage().addressChanged, 3);
        JSUtils.JSblockDsiplay(allpages.addressesPage().addressChanged);

        Assert.assertTrue(allpages.addressesPage().addressChanged.isDisplayed());
        ExtentReportUtils.extentTestInfo("Address changed successfully. yazısı göründü");


    }

    @AfterTest
    public void afterMethod(){
        //Sayfa kapanmalı
        Driver.closeDriver();
        ExtentReportUtils.extentTestInfo("Sayfa kapandı");
        ExtentReportUtils.flush();
    }



}