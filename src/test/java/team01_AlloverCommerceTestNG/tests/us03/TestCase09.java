package team01_AlloverCommerceTestNG.tests.us03;

import org.testng.Assert;
import org.testng.annotations.*;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.pages.P4_MyAccountPage;
import team01_AlloverCommerceTestNG.pages.P5_AddressesPage;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TestCase09 {

    Pages allpages = new Pages();


    @BeforeTest
    public void beforeMethod(){
        ExtentReportUtils.setUpExtentReport("US03-TC09", "Fatma Binnur Arslanhan");
        //Siteye ulaşılmalı ve edit butonu tıklanabilmeli
        ReusableMethods.signInUS0304();
        allpages.addressesPage().editButonB.click();
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı ve edit butonu tıklandı");
    }




    @Test
    public void phoneFail() {

        //Phone bilgisi girilebilmeli
        allpages.addressesPage().phoneB.sendKeys("aaaAA11");
        allpages.addressesPage().savebutonB.submit();
        ExtentReportUtils.extentTestInfo("Phone bilgisi harf olarak girildi");

        ReusableMethods.waitForSecond(2);
        //"PHONE is not a valid phone number." yazısı görüntülenebilmeli
        WaitUtils.waitForVisibility(allpages.addressesPage().phoneFailB, 3);
        JSUtils.JSblockDsiplay(allpages.addressesPage().phoneFailB);
        Assert.assertTrue(allpages.addressesPage().phoneFailB.isDisplayed());
        ExtentReportUtils.extentTestInfo("PHONE is not a valid phone number. yazısı görüntülendi");



    }

    @AfterTest
    public void afterMethod(){
        //Sayfa kapanmalı
        Driver.closeDriver();
        ExtentReportUtils.extentTestInfo("Sayfa kapandı");
        ExtentReportUtils.flush();
    }






}