package team01_AlloverCommerceTestNG.tests.us03;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.*;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.pages.P4_MyAccountPage;
import team01_AlloverCommerceTestNG.pages.P5_AddressesPage;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TestCase12 {

    Pages allpages = new Pages();


    @BeforeTest
    public void beforeMethod(){
        ExtentReportUtils.setUpExtentReport("US03-TC12", "Fatma Binnur Arslanhan");
        //Siteye ulaşılmalı ve ADD butonu tıklanabilmeli
        ReusableMethods.signInUS0304();
        allpages.addressesPage().addButonuB.click();
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı ve ADD butonu tıklandı");
    }




    @Test
    public void companyNameIsAllowedToBeEmpty() {



        //String companyName = allpages.addressesPage().companyB.getAttribute("value");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='';", allpages.addressesPage().townB);


        Assert.assertTrue(allpages.addressesPage().savebutonB.isEnabled());
        allpages.addressesPage().savebutonB.submit();


        ReusableMethods.waitForSecond(2);
        WaitUtils.waitForVisibility(allpages.addressesPage().townFailB, 1);
        JSUtils.JSblockDsiplay(allpages.addressesPage().townFailB);

        Assert.assertTrue(allpages.addressesPage().townFailB.isDisplayed());





    }

    @AfterTest
    public void afterMethod(){
        //Sayfa kapanmalı
        Driver.closeDriver();
        ExtentReportUtils.extentTestInfo("Sayfa kapandı");
    }



}