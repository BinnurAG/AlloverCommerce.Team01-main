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

        allpages.addressesPage().firstNameB.sendKeys(ConfigReader.getProperty("firstNameUs03"));
        allpages.addressesPage().lastNameB.sendKeys(ConfigReader.getProperty("lastNameUS03"));

        allpages.addressesPage().companyB.sendKeys(faker.name().lastName());
        allpages.addressesPage().countryB.click();
        ReusableMethods.waitForSecond(2);
        allpages.addressesPage().countryChoose.sendKeys("France", Keys.ENTER);

        allpages.addressesPage().adress1B.sendKeys(faker.address().fullAddress());
        allpages.addressesPage().adress2B.sendKeys(faker.address().city());
        allpages.addressesPage().postcodeB.sendKeys(faker.address().zipCode());
        allpages.addressesPage().townB.sendKeys(faker.address().city());
        allpages.addressesPage().phoneB.sendKeys(faker.phoneNumber().phoneNumber());



    }

    @AfterTest
    public void afterMethod(){
        //Sayfa kapanmalı
        Driver.closeDriver();
        ExtentReportUtils.extentTestInfo("Sayfa kapandı");
    }

}