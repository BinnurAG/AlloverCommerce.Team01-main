package team01_AlloverCommerceTestNG.tests.us03;

import org.testng.Assert;
import org.testng.annotations.*;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.pages.P4_MyAccountPage;
import team01_AlloverCommerceTestNG.pages.P5_AddressesPage;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TestCase08 {

    Pages allpages = new Pages();


    @BeforeTest
    public void beforeMethod(){
        ExtentReportUtils.setUpExtentReport("US03-TC08", "Fatma Binnur Arslanhan");
        //Siteye ulaşılmalı ve ADD butonu tıklanabilmeli
        ReusableMethods.signInUS0304();
        allpages.addressesPage().addButonuB.click();
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı ve ADD butonu tıklandı");
    }




    @Test
    public void postCodeFail() {

        allpages.addressesPage().postcodeB.sendKeys("aaaAA11");
        allpages.addressesPage().savebutonB.submit();

        ReusableMethods.waitForSecond(2);
        WaitUtils.waitForVisibility(allpages.addressesPage().postCodeFailB, 3);
        JSUtils.JSblockDsiplay(allpages.addressesPage().postCodeFailB);

        Assert.assertTrue(allpages.addressesPage().postCodeFailB.isDisplayed());



    }

    @AfterTest
    public void afterMethod(){
        //Sayfa kapanmalı
        Driver.closeDriver();
        ExtentReportUtils.extentTestInfo("Sayfa kapandı");
    }



}