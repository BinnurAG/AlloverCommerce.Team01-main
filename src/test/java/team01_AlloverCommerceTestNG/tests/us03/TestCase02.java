package team01_AlloverCommerceTestNG.tests.us03;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.pages.P4_MyAccountPage;
import team01_AlloverCommerceTestNG.pages.P5_AddressesPage;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ExtentReportUtils;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TestCase02 {

        Pages allpages = new Pages();

    @BeforeMethod
    public void beforeMethod(){
        ReusableMethods.signInUS0304();
    }


    @Test
    public void firstLastName() {

        allpages.addressesPage().firstNameB.sendKeys(ConfigReader.getProperty("firstNameUs03"));
        allpages.addressesPage().lastNameB.sendKeys(ConfigReader.getProperty("lastNameUS03"));

        ExtentReportUtils.addScreenShotToReport();

    }

    @AfterMethod
    public void afterMethod(){
        Driver.closeDriver();
    }

}