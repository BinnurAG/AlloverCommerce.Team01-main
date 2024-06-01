package team01_AlloverCommerceTestNG.tests.us04;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;


public class TestCase01 {

    Pages allPages = new Pages();
    ExtentReportsListener extentReportsListener = new ExtentReportsListener();
    @BeforeTest
    public void beforeTest(){
        ExtentReportUtils.setUpExtentReport("US04-TC01", "Fatma Binnur Arslanhan");
    }


    @Test(description = "US04")
    public void ADDbutonu() {

        //Site anasyfası açılmalı
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ExtentReportUtils.extentTestInfo("Site anasyfası açıldı");

        //Sign in sayfası açılmalı
        ReusableMethods.waitForSecond(2);
        allPages.addressesPage().signIn1.click();
        ExtentReportUtils.extentTestInfo("Sign in sayfası açıldı");

        //Username ve password girilebilmeli
        allPages.addressesPage().usernameSignIn.sendKeys(ConfigReader.getProperty("usernameUS03"));
        allPages.addressesPage().passwordSignIn.sendKeys(ConfigReader.getProperty("passwordUS03"));
        ExtentReportUtils.extentTestInfo("Username ve password girildi");

        //Sign In butonu tıklanır olmalı
        allPages.addressesPage().signIn2.click();
        ExtentReportUtils.extentTestInfo("Sign In butonu tıklandı");

        //Sign Out butonu tıklanır olmalı
        ReusableMethods.waitForSecond(1);
        allPages.addressesPage().signOut.click();
        ExtentReportUtils.extentTestInfo("Sign Out butonu tıklandı");

        //Addresses sayfası açılmalı
        allPages.addressesPage().addressesButton.click();
        ExtentReportUtils.extentTestInfo("Addresses sayfası açıldı");

        //ADD butonu tıklanabilir olmalıdır
        Assert.assertTrue(allPages.addressesPage().shippingAddress.isDisplayed());
        allPages.addressesPage().addButonuS.click();
        ExtentReportUtils.extentTestInfo("ADD butonu tıklandı");

        //Adresses sayfası kapanıp Shipping Adress sayfası açılmış olmalıdır
        Assert.assertTrue(allPages.addressesPage().addressPageS.isDisplayed());
        ExtentReportUtils.extentTestInfo("Adresses sayfası kapanıp Shipping Adress sayfası açıldı");



    }

    @AfterTest
    public void afterMethod(){
        //Sayfa kapanmalı
        Driver.closeDriver();
        ExtentReportUtils.extentTestInfo("Sayfa kapandı");
        ExtentReportUtils.flush();
    }




}
