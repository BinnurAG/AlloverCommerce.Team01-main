package team01_AlloverCommerceTestNG.tests.us03;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCase10 {

    Pages allpages = new Pages();
    Faker faker = new Faker();

    @BeforeMethod
    public void beforeMethod(){
        ReusableMethods.signInUS0304();

    }




    @Test
    public void addressTableIsDisplayed() {

        List<String> linkTexts = allpages.addressesPage().getLinkTexts();
        allpages.addressesPage().editButonB.click();

        JSUtils.JSMakeValueNull(allpages.addressesPage().adress1B);
        allpages.addressesPage().adress1B.sendKeys(faker.address().fullAddress());
        allpages.addressesPage().savebutonB.submit();


        List<String> expectedTexts = allpages.addressesPage().getLinkTexts();

        Assert.assertNotEquals(linkTexts, expectedTexts);


    }

    @AfterTest
    public void closeWindow(){
        Driver.closeDriver();
    }




}