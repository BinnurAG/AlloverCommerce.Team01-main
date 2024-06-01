package team01_AlloverCommerceTestNG.tests.us03;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.pages.P4_MyAccountPage;
import team01_AlloverCommerceTestNG.pages.P5_AddressesPage;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TestCase05 {

    Pages allpages = new Pages();
    Faker faker = new Faker();

    @BeforeTest
    public void beforeMethod(){
        ExtentReportUtils.setUpExtentReport("US03-TC05", "Fatma Binnur Arslanhan");
        //Siteye ulaşılmalı ve ADD butonu tıklanabilmeli
        ReusableMethods.signInUS0304();
        allpages.addressesPage().addButonuB.click();
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı ve ADD butonu tıklandı");
    }




    @Test
    public void saveAddress() {




        //Elementler boş değilse içindeki veri silinir
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

            //Firstname, lastname ve Company name bilgisi girilebilmeli
            allpages.addressesPage().firstNameB.sendKeys(ConfigReader.getProperty("firstNameUs03"));
            allpages.addressesPage().lastNameB.sendKeys(ConfigReader.getProperty("lastNameUS03"));
            allpages.addressesPage().companyB.sendKeys(faker.name().lastName());

            //Country dropdown'ı tıklanabilmeli ve France seçilebilmeli
            allpages.addressesPage().countryB.click();
            ReusableMethods.waitForSecond(2);
            allpages.addressesPage().countryChoose.sendKeys("France", Keys.ENTER);

            //Address, address2, ZipCode, Town/City ve Phone Number bilgileri girilebilmeli
            allpages.addressesPage().adress1B.sendKeys(faker.address().fullAddress());
            allpages.addressesPage().adress2B.sendKeys(faker.address().city());
            allpages.addressesPage().postcodeB.sendKeys(faker.address().zipCode());
            allpages.addressesPage().townB.sendKeys(faker.address().city());
            allpages.addressesPage().phoneB.sendKeys(faker.phoneNumber().cellPhone());

        }else {

            //Firstname, lastname ve Company name bilgisi girilebilmeli
            allpages.addressesPage().firstNameB.sendKeys(ConfigReader.getProperty("firstNameUs03"));
            allpages.addressesPage().lastNameB.sendKeys(ConfigReader.getProperty("lastNameUS03"));
            allpages.addressesPage().companyB.sendKeys(faker.name().lastName());

            //Country dropdown'ı tıklanabilmeli ve France seçilebilmeli
            allpages.addressesPage().countryB.click();
            ReusableMethods.waitForSecond(2);
            allpages.addressesPage().countryChoose.sendKeys("France", Keys.ENTER);

            //Address, address2, ZipCode, Town/City ve Phone Number bilgileri girilebilmeli
            allpages.addressesPage().adress1B.sendKeys(faker.address().fullAddress());
            allpages.addressesPage().adress2B.sendKeys(faker.address().city());
            allpages.addressesPage().postcodeB.sendKeys(faker.address().zipCode());
            allpages.addressesPage().townB.sendKeys(faker.address().city());
            allpages.addressesPage().phoneB.sendKeys(faker.phoneNumber().cellPhone());
        }
        ExtentReportUtils.extentTestInfo("Firstname, lastname ve Company name bilgisi girildi");
        ExtentReportUtils.extentTestInfo("Country dropdown'ı tıklanabilmeli ve France seçildi");
        ExtentReportUtils.extentTestInfo("Address, address2, ZipCode, Town/City ve Phone Number bilgileri girildi");



        ReusableMethods.waitForSecond(2);

        //Save butonuna tıklanabilmeli
        Assert.assertTrue(allpages.addressesPage().savebutonB.isEnabled());
        allpages.addressesPage().savebutonB.submit();
        ExtentReportUtils.extentTestInfo("Save butonuna tıklandı");




    }

    @AfterTest
    public void afterMethod(){
        //Sayfa kapanmalı
        Driver.closeDriver();
        ExtentReportUtils.extentTestInfo("Sayfa kapandı");
        ExtentReportUtils.flush();
    }




}