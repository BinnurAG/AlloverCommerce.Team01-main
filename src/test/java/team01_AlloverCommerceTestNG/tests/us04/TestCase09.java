package team01_AlloverCommerceTestNG.tests.us04;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ExtentReportUtils;
import team01_AlloverCommerceTestNG.utilities.JSUtils;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import java.util.List;

public class TestCase09 {

    Pages allpages = new Pages();
    Faker faker = new Faker();

    @BeforeTest
    public void beforeMethod(){
        ExtentReportUtils.setUpExtentReport("US04-TC09", "Fatma Binnur Arslanhan");
        //Siteye ulaşılmalı
        ReusableMethods.signInUS0304();
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı");
    }




    @Test
    public void addressTableIsDisplayed() {

        //Addres table görüntülenebilmeli
        List<String> linkTexts = allpages.addressesPage().getLinkTexts(allpages.addressesPage().addressTableS);
        allpages.addressesPage().editButonuS.click();
        ExtentReportUtils.extentTestInfo("//Addres table görüntülenebilmeli");

        //Street adress değiştirilebilmeli
        JSUtils.JSMakeValueNull(allpages.addressesPage().adress1S);
        allpages.addressesPage().adress1S.sendKeys(faker.address().fullAddress());
        allpages.addressesPage().savebutonS.submit();
        ExtentReportUtils.extentTestInfo("Street adress değiştirildi");


        //Street Adress'in güncellendiği doğrulanabilmeli
        List<String> expectedTexts = allpages.addressesPage().getLinkTexts(allpages.addressesPage().addressTableS);
        Assert.assertNotEquals(linkTexts, expectedTexts);
        ExtentReportUtils.extentTestInfo("Street Adress'in güncellendiği doğrulandı");


    }

    @AfterTest
    public void afterMethod(){
        //Sayfa kapanmalı
        Driver.closeDriver();
        ExtentReportUtils.extentTestInfo("Sayfa kapandı");
        ExtentReportUtils.flush();
    }


}
