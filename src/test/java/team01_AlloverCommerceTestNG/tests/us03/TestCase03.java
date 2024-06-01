package team01_AlloverCommerceTestNG.tests.us03;

import com.github.javafaker.Country;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TestCase03 {


    Pages allpages = new Pages();
    Faker faker = new Faker();


    @BeforeTest
    public void beforeMethod(){
        ExtentReportUtils.setUpExtentReport("US03-TC03", "Fatma Binnur Arslanhan");
        //Siteye ulaşılmalı ve ADD butonu tıklanabilmeli
        ReusableMethods.signInUS0304();
        allpages.addressesPage().addButonuB.click();
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı ve ADD butonu tıklandı");
    }



    @Test
    public void countryToPhoneFilling() {

        //Firstname ve lastname bilgisi girilebilmeli
        allpages.addressesPage().firstNameB.sendKeys(ConfigReader.getProperty("firstNameUs03"));
        allpages.addressesPage().lastNameB.sendKeys(ConfigReader.getProperty("lastNameUS03"));
        ExtentReportUtils.extentTestInfo("Firstname ve lastname bilgisi girildi");

        //Company name girilebilmeli
        allpages.addressesPage().companyB.sendKeys(faker.name().lastName());
        ExtentReportUtils.extentTestInfo("Company name girildi");

        //Country dropdown'ı tıklanabilmeli ve France seçilebilmeli
        allpages.addressesPage().countryB.click();
        ReusableMethods.waitForSecond(2);
        allpages.addressesPage().countryChoose.sendKeys("France", Keys.ENTER);
        ExtentReportUtils.extentTestInfo("Country dropdown'ı tıklandı ve France seçildi");

        //Address, address2, ZipCode, Town/City ve Phone Number bilgileri girilebilmeli
        allpages.addressesPage().adress1B.sendKeys(faker.address().fullAddress());
        allpages.addressesPage().adress2B.sendKeys(faker.address().city());
        allpages.addressesPage().postcodeB.sendKeys(faker.address().zipCode());
        allpages.addressesPage().townB.sendKeys(faker.address().city());
        allpages.addressesPage().phoneB.sendKeys(faker.phoneNumber().phoneNumber());
        ExtentReportUtils.extentTestInfo("Address, address2, ZipCode, Town/City ve Phone Number bilgileri girildi");
        ExtentReportUtils.addScreenShotToReport();



    }

    @AfterTest
    public void afterMethod(){
        //Sayfa kapanmalı
        Driver.closeDriver();
        ExtentReportUtils.extentTestInfo("Sayfa kapandı");
        ExtentReportUtils.flush();
    }

}