package team01_AlloverCommerceTestNG.tests.us04;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.annotations.*;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ExtentReportUtils;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TestCase03 {


    Pages allpages = new Pages();
    Faker faker = new Faker();


    @BeforeTest
    public void beforeMethod(){
        ExtentReportUtils.setUpExtentReport("US04-TC03", "Fatma Binnur Arslanhan");
        //Siteye ulaşılmalı ve ADD butonu tıklanabilmeli
        ReusableMethods.signInUS0304();
        allpages.addressesPage().addButonuS.click();
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı ve ADD butonu tıklandı");
    }



    @Test
    public void countryToPhoneFilling() {

        //Firstname ve lastname bilgisi girilebilmeli
        allpages.addressesPage().firstNameS.sendKeys(ConfigReader.getProperty("firstNameUs03"));
        allpages.addressesPage().lastNameS.sendKeys(ConfigReader.getProperty("lastNameUS03"));
        ExtentReportUtils.extentTestInfo("Firstname ve lastname bilgisi girildi");

        //Company name girilebilmeli
        allpages.addressesPage().companyS.sendKeys(faker.name().lastName());
        ExtentReportUtils.extentTestInfo("Company name girildi");

        //Country dropdown'ı tıklanabilmeli ve France seçilebilmeli
        allpages.addressesPage().countryS.click();
        ReusableMethods.waitForSecond(2);
        allpages.addressesPage().countryChooseS.sendKeys("France", Keys.ENTER);
        ExtentReportUtils.extentTestInfo("Country dropdown'ı tıklandı ve France seçildi");

        //Address, address2, ZipCode, Town/City bilgileri girilebilmeli
        allpages.addressesPage().adress1S.sendKeys(faker.address().fullAddress());
        allpages.addressesPage().adress2S.sendKeys(faker.address().city());
        allpages.addressesPage().townS.sendKeys(faker.address().city());
        allpages.addressesPage().postcodeS.sendKeys(faker.address().zipCode());

        ExtentReportUtils.extentTestInfo("Address, address2, ZipCode, Town/City bilgileri girildi");
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
