package team01_AlloverCommerceTestNG.tests.us04;


import org.testng.Assert;
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
        allpages.addressesPage().addButonuS.click();
    }


    @Test
    public void firstLastName() {

        if (allpages.addressesPage().firstNameS !=null & allpages.addressesPage().lastNameS !=null) {
            JSUtils.JSMakeValueNull(allpages.addressesPage().firstNameS);
            JSUtils.JSMakeValueNull(allpages.addressesPage().lastNameS);
            allpages.addressesPage().firstNameS.sendKeys(ConfigReader.getProperty("firstNameUs03"));
            allpages.addressesPage().lastNameS.sendKeys(ConfigReader.getProperty("lastNameUS03"));
        }else {
            allpages.addressesPage().firstNameS.sendKeys(ConfigReader.getProperty("firstNameUs03"));
            allpages.addressesPage().lastNameS.sendKeys(ConfigReader.getProperty("lastNameUS03"));
        }

        String actualFirstName = allpages.addressesPage().firstNameS.getAttribute("value");
        String actualLastName = allpages.addressesPage().lastNameS.getAttribute("value");


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