package team01_AlloverCommerceTestNG.tests.us03;

import org.testng.Assert;
import org.testng.annotations.Test;

import team01_AlloverCommerceTestNG.pages.P5_AddressesPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC01 {

    P5_AddressesPage addressesPage = new P5_AddressesPage();


    @Test
    public void ADDbutonu() {

        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        ReusableMethods.waitForSecond(2);
        addressesPage.signIn1.click();

        addressesPage.firstNameB.sendKeys(ConfigReader.getProperty("usernameUS03"));
        addressesPage.passwordSignIn.sendKeys(ConfigReader.getProperty("passwordUS03"));

        addressesPage.signIn2.click();

        ReusableMethods.waitForSecond(1);
        addressesPage.signOut.click();

        addressesPage.addressesButton.click();
        //Assert.assertTrue(addressesPage.billingAddress.isDisplayed());
        Assert.assertTrue(addressesPage.billingAddress.isDisplayed());

    }




}
