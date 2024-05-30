package team01_AlloverCommerceTestNG.tests.us03;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.pages.P4_MyAccountPage;
import team01_AlloverCommerceTestNG.pages.P5_AddressesPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.JSUtils;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TestCase02 {

        Pages allpages = new Pages();

    @BeforeMethod
    public void beforeMethod(){
        ReusableMethods.signInUS0304();
        allpages.addressesPage().addButonuB.click();
    }


    @Test
    public void firstLastName() {

        if (allpages.addressesPage().firstNameB !=null & allpages.addressesPage().lastNameB !=null) {
            JSUtils.JSMakeValueNull(allpages.addressesPage().firstNameB);
            JSUtils.JSMakeValueNull(allpages.addressesPage().lastNameB);
            allpages.addressesPage().firstNameB.sendKeys(ConfigReader.getProperty("firstNameUs03"));
            allpages.addressesPage().lastNameB.sendKeys(ConfigReader.getProperty("lastNameUS03"));
        }else {
            allpages.addressesPage().firstNameB.sendKeys(ConfigReader.getProperty("firstNameUs03"));
            allpages.addressesPage().lastNameB.sendKeys(ConfigReader.getProperty("lastNameUS03"));
        }

        String actualFirstName = allpages.addressesPage().firstNameB.getAttribute("value");
        String actualLastName = allpages.addressesPage().lastNameB.getAttribute("value");


        String expectedFirstName = ConfigReader.getProperty("firstNameUs03");
        String expectedLastName = ConfigReader.getProperty("lastNameUS03");


        Assert.assertEquals(actualFirstName, expectedFirstName, "First name does not match!");
        Assert.assertEquals(actualLastName, expectedLastName, "Last name does not match!");




    }

    @AfterMethod
    public void afterMethod(){
        Driver.closeDriver();
    }

}
