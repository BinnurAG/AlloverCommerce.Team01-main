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

        //Post/Zip Code bilgisi girilebilmeli
        allpages.addressesPage().postcodeB.sendKeys("aaaAA11");
        ExtentReportUtils.extentTestInfo("Post/Zip Code bilgisi harf olarak girildi");

        //Save Adress butonu tıklanabilir olmalı
        allpages.addressesPage().savebutonB.submit();
        ExtentReportUtils.extentTestInfo("Save Adress butonuna tıklandı");

        ReusableMethods.waitForSecond(2);
        //"Please enter a valid postcode / ZIP." yazısı görüntülenebilmeli
        WaitUtils.waitForVisibility(allpages.addressesPage().postCodeFailB, 3);
        JSUtils.JSblockDsiplay(allpages.addressesPage().postCodeFailB);
        Assert.assertTrue(allpages.addressesPage().postCodeFailB.isDisplayed());
        ExtentReportUtils.extentTestInfo("Please enter a valid postcode / ZIP. yazısı görüntülendi");



    }

    @AfterTest
    public void afterMethod(){
        //Sayfa kapanmalı
        Driver.closeDriver();
        ExtentReportUtils.extentTestInfo("Sayfa kapandı");
        ExtentReportUtils.flush();
    }



}