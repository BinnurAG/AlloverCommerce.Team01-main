package team01_AlloverCommerceTestNG.tests.us03;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCase10 {

    Pages allpages = new Pages();
    Faker faker = new Faker();

    @BeforeTest
    public void beforeMethod(){
        ExtentReportUtils.setUpExtentReport("US03-TC10", "Fatma Binnur Arslanhan");
        //Siteye ulaşılmalı
        ReusableMethods.signInUS0304();
        ExtentReportUtils.extentTestInfo("Siteye ulaşıldı");
    }




    @Test
    public void addressTableIsDisplayed() {

        //Addres table görüntülenebilmeli
        List<String> linkTexts = allpages.addressesPage().getLinkTexts(allpages.addressesPage().addressTable);
        allpages.addressesPage().editButonB.click();
        ExtentReportUtils.extentTestInfo("//Addres table görüntülenebilmeli");

        //Street adress değiştirilebilmeli
        JSUtils.JSMakeValueNull(allpages.addressesPage().adress1B);
        allpages.addressesPage().adress1B.sendKeys(faker.address().fullAddress());
        allpages.addressesPage().savebutonB.submit();
        ExtentReportUtils.extentTestInfo("Street adress değiştirildi");


        //Street Adress'in güncellendiği doğrulanabilmeli
        List<String> expectedTexts = allpages.addressesPage().getLinkTexts(allpages.addressesPage().addressTable);
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