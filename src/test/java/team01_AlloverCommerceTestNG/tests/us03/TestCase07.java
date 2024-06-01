package team01_AlloverCommerceTestNG.tests.us03;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.*;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.pages.P4_MyAccountPage;
import team01_AlloverCommerceTestNG.pages.P5_AddressesPage;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ExtentReportUtils;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TestCase07 {

    Pages allpages = new Pages();


    @BeforeTest
    public void beforeMethod(){
        ExtentReportUtils.setUpExtentReport("US03-TC07", "Fatma Binnur Arslanhan");
        //Siteye ulaşılmalı
        ReusableMethods.signInUS0304();
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı");
    }



    @Test
    public void editAddressButton() {

        //Edit Your Billing Adress butonu tıklanabilir olmalı
        allpages.addressesPage().editButonB.click();
        Assert.assertTrue(allpages.addressesPage().addressPageB.isDisplayed());
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