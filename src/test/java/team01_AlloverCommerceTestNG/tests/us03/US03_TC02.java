package team01_AlloverCommerceTestNG.tests.us03;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.pages.P4_MyAccountPage;
import team01_AlloverCommerceTestNG.pages.P5_AddressesPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US03_TC02 {

    P1_HomePage homePage = new P1_HomePage();
    P4_MyAccountPage myAccountPage = new P4_MyAccountPage();
    P5_AddressesPage addressesPage = new P5_AddressesPage();
    ReusableMethods reusableMethods = new ReusableMethods();



    @Test
    public void FirstLastName() {

        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        ReusableMethods.waitForSecond(2);
        addressesPage.signIn1.click();

        addressesPage.usernameSignIn.sendKeys(ConfigReader.getProperty("usernameUS03"));
        addressesPage.passwordSignIn.sendKeys(ConfigReader.getProperty("passwordUS03"));

        addressesPage.signIn2.click();

        ReusableMethods.waitForSecond(1);
        addressesPage.signOut.click();

        addressesPage.addressesButton.click();
        Assert.assertTrue(addressesPage.billingAddress.isDisplayed());

        addressesPage.firstNameB.sendKeys(ConfigReader.getProperty("firstNameUs03"));
        addressesPage.lastNameB.sendKeys(ConfigReader.getProperty("lastNameUS03"));



    }


}
