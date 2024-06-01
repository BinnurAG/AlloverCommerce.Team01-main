package team01_AlloverCommerceTestNG.tests.us04;


import org.testng.Assert;
import org.testng.annotations.*;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TestCase02 {

    Pages allpages = new Pages();

    @BeforeTest
    public void beforeMethod(){
        ExtentReportUtils.setUpExtentReport("US04-TC02", "Fatma Binnur Arslanhan");
        //Siteye ulaşılmalı ve ADD butonu tıklanabilmeli
        ReusableMethods.signInUS0304();
        allpages.addressesPage().addButonuS.click();
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı ve ADD butonu tıklandı");
    }


    @Test
    public void firstLastName() {

        //Firstname ve lastname bilgisi girilebilmeli
        if (allpages.addressesPage().firstNameS !=null & allpages.addressesPage().lastNameS !=null) {
            JSUtils.JSMakeValueNull(allpages.addressesPage().firstNameS);
            JSUtils.JSMakeValueNull(allpages.addressesPage().lastNameS);
            allpages.addressesPage().firstNameS.sendKeys(ConfigReader.getProperty("firstNameUs03"));
            allpages.addressesPage().lastNameS.sendKeys(ConfigReader.getProperty("lastNameUS03"));
        }else {
            allpages.addressesPage().firstNameS.sendKeys(ConfigReader.getProperty("firstNameUs03"));
            allpages.addressesPage().lastNameS.sendKeys(ConfigReader.getProperty("lastNameUS03"));
        }
        ExtentReportUtils.extentTestInfo("Firstname ve lastname bilgisi girildi");


        //Firstname ve lastname bilgisinin girildiği doğrulanabilmeli
        String actualFirstName = allpages.addressesPage().firstNameS.getAttribute("value");
        String actualLastName = allpages.addressesPage().lastNameS.getAttribute("value");

        String expectedFirstName = ConfigReader.getProperty("firstNameUs03");
        String expectedLastName = ConfigReader.getProperty("lastNameUS03");

        Assert.assertEquals(actualFirstName, expectedFirstName, "First name does not match!");
        Assert.assertEquals(actualLastName, expectedLastName, "Last name does not match!");

        ExtentReportUtils.extentTestInfo("Firstname ve lastname bilgisinin girildiği doğrulandı");


    }

    @AfterTest
    public void afterMethod(){
        //Sayfa kapanmalı
        Driver.closeDriver();
        ExtentReportUtils.extentTestInfo("Sayfa kapandı");
        ExtentReportUtils.flush();
    }
}