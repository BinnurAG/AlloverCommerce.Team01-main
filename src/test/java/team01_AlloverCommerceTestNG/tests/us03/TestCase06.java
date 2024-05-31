package team01_AlloverCommerceTestNG.tests.us03;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.pages.P4_MyAccountPage;
import team01_AlloverCommerceTestNG.pages.P5_AddressesPage;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TestCase06 {


    Pages allpages = new Pages();
    Faker faker = new Faker();

    @BeforeTest
    public void beforeMethod(){
        ExtentReportUtils.setUpExtentReport("US03-TC06", "Fatma Binnur Arslanhan");
        //Siteye ulaşılmalı ve ADD butonu tıklanabilmeli
        ReusableMethods.signInUS0304();
        allpages.addressesPage().addButonuB.click();
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı ve ADD butonu tıklandı");
    }



    @Test
    public void saveAddress() {

        if (allpages.addressesPage().firstNameB !=null & allpages.addressesPage().lastNameB !=null &
                allpages.addressesPage().companyB !=null & allpages.addressesPage().countryB !=null &
                allpages.addressesPage().adress1B !=null & allpages.addressesPage().adress2B !=null &
                allpages.addressesPage().postcodeB !=null & allpages.addressesPage().townB !=null &
                allpages.addressesPage().phoneB!=null ) {

            JSUtils.JSMakeValueNull(allpages.addressesPage().firstNameB);
            JSUtils.JSMakeValueNull(allpages.addressesPage().lastNameB);
            JSUtils.JSMakeValueNull(allpages.addressesPage().companyB);
            JSUtils.JSMakeValueNull(allpages.addressesPage().countryB);
            JSUtils.JSMakeValueNull(allpages.addressesPage().adress1B);
            JSUtils.JSMakeValueNull(allpages.addressesPage().adress2B);
            JSUtils.JSMakeValueNull(allpages.addressesPage().postcodeB);
            JSUtils.JSMakeValueNull(allpages.addressesPage().townB);
            JSUtils.JSMakeValueNull(allpages.addressesPage().phoneB);

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
            allpages.addressesPage().phoneB.sendKeys(faker.phoneNumber().cellPhone());

        }else {

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
            allpages.addressesPage().phoneB.sendKeys(faker.phoneNumber().cellPhone());
        }

        Assert.assertTrue(allpages.addressesPage().savebutonB.isEnabled());
        allpages.addressesPage().savebutonB.submit();

        ReusableMethods.waitForSecond(2);

        WaitUtils.waitForVisibility(allpages.addressesPage().addressChanged, 3);
        JSUtils.JSblockDsiplay(allpages.addressesPage().addressChanged);

        Assert.assertTrue(allpages.addressesPage().addressChanged.isDisplayed());

        ReusableMethods.waitForSecond(2);


    }

    @AfterTest
    public void afterMethod(){
        //Sayfa kapanmalı
        Driver.closeDriver();
        ExtentReportUtils.extentTestInfo("Sayfa kapandı");
    }





}