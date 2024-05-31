
package team01_AlloverCommerceTestNG.tests.us03;


import org.testng.Assert;
import org.testng.annotations.*;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.pages.P4_MyAccountPage;
import team01_AlloverCommerceTestNG.pages.P5_AddressesPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TestCase02 {

    Pages allpages = new Pages();

    @BeforeTest
    public void beforeMethod(){
        ExtentReportUtils.setUpExtentReport("US03-TC02", "Fatma Binnur Arslanhan");
        //Siteye ulaşılmalı ve ADD butonu tıklanabilmeli
        ReusableMethods.signInUS0304();
        allpages.addressesPage().addButonuB.click();
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı ve ADD butonu tıklandı");
    }


    @Test
    public void firstLastName() {

        //Firstname ve lastname bilgisi girilebilmeli
        if (allpages.addressesPage().firstNameB !=null & allpages.addressesPage().lastNameB !=null) {
            JSUtils.JSMakeValueNull(allpages.addressesPage().firstNameB);
            JSUtils.JSMakeValueNull(allpages.addressesPage().lastNameB);
            allpages.addressesPage().firstNameB.sendKeys(ConfigReader.getProperty("firstNameUs03"));
            allpages.addressesPage().lastNameB.sendKeys(ConfigReader.getProperty("lastNameUS03"));
        }else {
            allpages.addressesPage().firstNameB.sendKeys(ConfigReader.getProperty("firstNameUs03"));
            allpages.addressesPage().lastNameB.sendKeys(ConfigReader.getProperty("lastNameUS03"));
        }
        ExtentReportUtils.extentTestInfo("Firstname ve lastname bilgisi girildi");

        String actualFirstName = allpages.addressesPage().firstNameB.getAttribute("value");
        String actualLastName = allpages.addressesPage().lastNameB.getAttribute("value");


        String expectedFirstName = ConfigReader.getProperty("firstNameUs03");
        String expectedLastName = ConfigReader.getProperty("lastNameUS03");


        Assert.assertEquals(actualFirstName, expectedFirstName, "First name does not match!");
        Assert.assertEquals(actualLastName, expectedLastName, "Last name does not match!");



    }

    @AfterMethod
    public void afterMethod(){
        //Sayfa kapanmalı
        Driver.closeDriver();
        ExtentReportUtils.extentTestInfo("Sayfa kapandı");
    }


}
