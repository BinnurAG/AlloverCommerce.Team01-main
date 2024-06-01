package team01_AlloverCommerceTestNG.tests.us04;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TestCase10 {

    Pages allpages = new Pages();

    @BeforeTest
    public void beforeMethod(){
        ExtentReportUtils.setUpExtentReport("US04-TC10", "Fatma Binnur Arslanhan");
        //Siteye ulaşılmalı ve edit butonu tıklanabilmeli
        ReusableMethods.signInUS0304();
        allpages.addressesPage().editButonuS.click();
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı ve edit butonu tıklandı");
    }




    @Test
    public void companyNameIsAllowedToBeEmpty() {



        //Company name bilgisi silinebilmeli
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='';", allpages.addressesPage().companyS);
        ExtentReportUtils.extentTestInfo("Company name bilgisi silindi");

        //Save Adress butonu tıklanabilir olmalı
        allpages.addressesPage().savebutonS.submit();
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
