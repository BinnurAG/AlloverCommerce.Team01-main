package team01_AlloverCommerceTestNG.tests.us04;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TestCase08 {

    Pages allpages = new Pages();


    @BeforeTest
    public void beforeMethod(){
        ExtentReportUtils.setUpExtentReport("US04-TC08", "Fatma Binnur Arslanhan");
        //Siteye ulaşılmalı ve edit butonu tıklanabilmeli
        ReusableMethods.signInUS0304();
        allpages.addressesPage().editButonuS.click();
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı ve edit butonu tıklandı");
    }




    @Test
    public void postCodeFail() {

        //Post/Zip Code bilgisi girilebilmeli
        allpages.addressesPage().postcodeS.sendKeys("123456");
        ExtentReportUtils.extentTestInfo("Post/Zip Code bilgisi 6 veya daha fazla rakam olarak girildi");

        //Save Adress butonu tıklanabilir olmalı
        allpages.addressesPage().savebutonS.submit();
        ExtentReportUtils.extentTestInfo("Save Adress butonuna tıklandı");

        ReusableMethods.waitForSecond(2);
        //"Please enter a valid postcode / ZIP." yazısı görüntülenebilmeli
        WaitUtils.waitForVisibility(allpages.addressesPage().postCodeFailS, 3);
        JSUtils.JSblockDsiplay(allpages.addressesPage().postCodeFailS);
        Assert.assertTrue(allpages.addressesPage().postCodeFailS.isDisplayed());
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
