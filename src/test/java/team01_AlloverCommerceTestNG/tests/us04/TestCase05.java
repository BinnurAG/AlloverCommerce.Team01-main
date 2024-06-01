package team01_AlloverCommerceTestNG.tests.us04;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TestCase05 {


    Pages allpages = new Pages();
    Faker faker = new Faker();

    @BeforeTest
    public void beforeMethod(){
        ExtentReportUtils.setUpExtentReport("US04-TC05", "Fatma Binnur Arslanhan");
        //Siteye ulaşılmalı ve ADD butonu tıklanabilmeli
        ReusableMethods.signInUS0304();
        allpages.addressesPage().addButonuS.click();
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı ve ADD butonu tıklandı");
    }




    @Test
    public void addressChangedVerify() {




        //Elementler boş değilse içindeki veri silinir
        if (allpages.addressesPage().firstNameS !=null & allpages.addressesPage().lastNameS !=null &
                allpages.addressesPage().companyS !=null & allpages.addressesPage().countryS !=null &
                allpages.addressesPage().adress1S !=null & allpages.addressesPage().adress2S !=null &
                allpages.addressesPage().postcodeS !=null & allpages.addressesPage().townS !=null ) {

            JSUtils.JSMakeValueNull(allpages.addressesPage().firstNameS);
            JSUtils.JSMakeValueNull(allpages.addressesPage().lastNameS);
            JSUtils.JSMakeValueNull(allpages.addressesPage().companyS);
            JSUtils.JSMakeValueNull(allpages.addressesPage().countryS);
            JSUtils.JSMakeValueNull(allpages.addressesPage().adress1S);
            JSUtils.JSMakeValueNull(allpages.addressesPage().adress2S);
            JSUtils.JSMakeValueNull(allpages.addressesPage().postcodeS);
            JSUtils.JSMakeValueNull(allpages.addressesPage().townS);


            //Firstname, lastname ve Company name bilgisi girilebilmeli
            allpages.addressesPage().firstNameS.sendKeys(ConfigReader.getProperty("firstNameUs03"));
            allpages.addressesPage().lastNameS.sendKeys(ConfigReader.getProperty("lastNameUS03"));
            allpages.addressesPage().companyS.sendKeys(faker.name().lastName());

            //Country dropdown'ı tıklanabilmeli ve France seçilebilmeli
            allpages.addressesPage().countryS.click();
            ReusableMethods.waitForSecond(2);
            allpages.addressesPage().countryChooseS.sendKeys("France", Keys.ENTER);

            //Address, address2, ZipCode, Town/City bilgileri girilebilmeli
            allpages.addressesPage().adress1S.sendKeys(faker.address().fullAddress());
            allpages.addressesPage().adress2S.sendKeys(faker.address().city());
            allpages.addressesPage().postcodeS.sendKeys(faker.address().zipCode());
            allpages.addressesPage().townS.sendKeys(faker.address().city());


        }else {

            //Firstname, lastname ve Company name bilgisi girilebilmeli
            allpages.addressesPage().firstNameS.sendKeys(ConfigReader.getProperty("firstNameUs03"));
            allpages.addressesPage().lastNameS.sendKeys(ConfigReader.getProperty("lastNameUS03"));
            allpages.addressesPage().companyS.sendKeys(faker.name().lastName());

            //Country dropdown'ı tıklanabilmeli ve France seçilebilmeli
            allpages.addressesPage().countryS.click();
            ReusableMethods.waitForSecond(2);
            allpages.addressesPage().countryChooseS.sendKeys("France", Keys.ENTER);

            //Address, address2, ZipCode, Town/City bilgileri girilebilmeli
            allpages.addressesPage().adress1S.sendKeys(faker.address().fullAddress());
            allpages.addressesPage().adress2S.sendKeys(faker.address().city());
            allpages.addressesPage().postcodeS.sendKeys(faker.address().zipCode());
            allpages.addressesPage().townS.sendKeys(faker.address().city());

        }
        ExtentReportUtils.extentTestInfo("Firstname, lastname ve Company name bilgisi girildi");
        ExtentReportUtils.extentTestInfo("Country dropdown'ı tıklanabilmeli ve France seçildi");
        ExtentReportUtils.extentTestInfo("Address, address2, ZipCode, Town/City bilgileri girildi");



        ReusableMethods.waitForSecond(2);

        //Save butonuna tıklanabilmeli
        Assert.assertTrue(allpages.addressesPage().savebutonS.isEnabled());
        allpages.addressesPage().savebutonS.submit();
        ExtentReportUtils.extentTestInfo("Save butonuna tıklandı");

        ReusableMethods.waitForSecond(2);

        //"Address changed successfully." metni görüntülenmeli
        WaitUtils.waitForVisibility(allpages.addressesPage().addressChanged, 3);
        JSUtils.JSblockDsiplay(allpages.addressesPage().addressChanged);
        Assert.assertTrue(allpages.addressesPage().addressChanged.isDisplayed());

        ExtentReportUtils.extentTestInfo("Address changed successfully. metni görüntülendi");




    }

    @AfterTest
    public void afterMethod(){
        //Sayfa kapanmalı
        Driver.closeDriver();
        ExtentReportUtils.extentTestInfo("Sayfa kapandı");
        ExtentReportUtils.flush();
    }





}
