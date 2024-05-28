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

public class US03_TC04 {

    P1_HomePage homePage = new P1_HomePage();
    P4_MyAccountPage myAccountPage = new P4_MyAccountPage();
    P5_AddressesPage adressesPage = new P5_AddressesPage();
     ReusableMethods reusableMethods = new ReusableMethods();


    @BeforeTest
    public void signIn(){

    }

    @AfterTest
    public void closeWindow(){
        Driver.closeDriver();
    }


    @Test
    public void FirstLastName() {

        adressesPage.addButonuB.click();
        Assert.assertTrue(adressesPage.billingAddress.isDisplayed());

        adressesPage.firstNameB.sendKeys(ConfigReader.getProperty("firstNameUs03"));
        adressesPage.lastNameB.sendKeys(ConfigReader.getProperty("lastNameUS03"));



    }


}