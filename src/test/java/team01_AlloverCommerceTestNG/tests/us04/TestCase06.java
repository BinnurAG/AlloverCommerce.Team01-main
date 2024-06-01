package team01_AlloverCommerceTestNG.tests.us04;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ExtentReportUtils;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TestCase06 {

    Pages allpages = new Pages();


    @BeforeTest
    public void beforeMethod(){
        ExtentReportUtils.setUpExtentReport("US04-TC06", "Fatma Binnur Arslanhan");
        //Siteye ulaşılmalı tıklanabilmeli
        ReusableMethods.signInUS0304();
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı tıklandı");
    }



    @Test
    public void editAddressButton() {

        //Edit Your Billing Adress butonu tıklanabilir olmalı
        allpages.addressesPage().editButonuS.click();
        Assert.assertTrue(allpages.addressesPage().addressPageS.isDisplayed());
        ExtentReportUtils.extentTestInfo("Edit Your Billing Adress butonu tıklandı");
        ExtentReportUtils.extentTestInfo("Address sayfası görüntülendi");

    }



    @AfterTest
    public void afterMethod(){
        //Sayfa kapanmalı
        Driver.closeDriver();
        ExtentReportUtils.extentTestInfo("Sayfa kapandı");
        ExtentReportUtils.flush();
    }

}
