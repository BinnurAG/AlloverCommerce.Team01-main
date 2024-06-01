package team01_AlloverCommerceTestNG.tests.us04;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TestCase11 {

    Pages allpages = new Pages();


    @BeforeTest
    public void beforeMethod(){
        ExtentReportUtils.setUpExtentReport("US04-TC11", "Fatma Binnur Arslanhan");
        //Siteye ulaşılmalı ve edit butonu tıklanabilmeli
        ReusableMethods.signInUS0304();
        allpages.addressesPage().editButonuS.click();
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı ve edit butonu tıklandı");
    }




    @Test
    public void TownIsNotAllowedToBeEmpty() {



        //Town/City bilgisi silinebilmeli
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='';", allpages.addressesPage().townS);
        ExtentReportUtils.extentTestInfo("Town/City bilgisi silindi");


        //Save Adress butonu tıklanabilir olmalı
        Assert.assertTrue(allpages.addressesPage().savebutonS.isEnabled());
        allpages.addressesPage().savebutonS.submit();
        ExtentReportUtils.extentTestInfo("Save Adress butonu tıklandı");

        //"Town / City is a required field." uyarısını alınmalı
        ReusableMethods.waitForSecond(2);
        WaitUtils.waitForVisibility(allpages.addressesPage().townFailS, 1);
        JSUtils.JSblockDsiplay(allpages.addressesPage().townFailS);

        Assert.assertTrue(allpages.addressesPage().townFailS.isDisplayed());
        ExtentReportUtils.extentTestInfo("Town / City is a required field. uyarısını alındı");





    }

    @AfterTest
    public void afterMethod(){
        //Sayfa kapanmalı
        Driver.closeDriver();
        ExtentReportUtils.extentTestInfo("Sayfa kapandı");
        ExtentReportUtils.flush();
    }

}
