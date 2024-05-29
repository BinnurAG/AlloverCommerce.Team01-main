package team01_AlloverCommerceTestNG.tests.us03;

import org.testng.Assert;
import org.testng.annotations.Test;

import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TestCase01 {

    Pages allPages = new Pages();


    @Test
    public void ADDbutonu() {

        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        ReusableMethods.waitForSecond(2);
        allPages.addressesPage().signIn1.click();
        allPages.addressesPage().usernameSignIn.sendKeys(ConfigReader.getProperty("usernameUS03"));
        allPages.addressesPage().passwordSignIn.sendKeys(ConfigReader.getProperty("passwordUS03"));

        allPages.addressesPage().signIn2.click();

        ReusableMethods.waitForSecond(1);
        allPages.addressesPage().signOut.click();

        allPages.addressesPage().addressesButton.click();
        //Assert.assertTrue(addressesPage.billingAddress.isDisplayed());
        Assert.assertTrue(allPages.addressesPage().billingAddress.isDisplayed());

        allPages.addressesPage().addButonuB.click();
        Assert.assertTrue(allPages.addressesPage().addressPageB.isDisplayed());



    }




}
