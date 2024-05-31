package team01_AlloverCommerceTestNG.tests.us04;

import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;



public class TestCase01 {

    Pages allPages = new Pages();


    @Test
    public void ADDbutonuS() {

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
        Assert.assertTrue(allPages.addressesPage().shippingAddress.isDisplayed());
        allPages.addressesPage().addButonuS.click();
        Assert.assertTrue(allPages.addressesPage().addressPageS.isDisplayed());



    }




}
