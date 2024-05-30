package team01_AlloverCommerceTestNG.tests.us03;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.pages.P4_MyAccountPage;
import team01_AlloverCommerceTestNG.pages.P5_AddressesPage;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.*;

public class TestCase08 {

    Pages allpages = new Pages();


    @BeforeMethod
    public void beforeMethod(){
        ReusableMethods.signInUS0304();
    }




    @Test
    public void editAddressButton() {

        allpages.addressesPage().postcodeB.sendKeys("aaaAA11");
        allpages.addressesPage().savebutonB.submit();

        ReusableMethods.waitForSecond(2);
        WaitUtils.waitForVisibility(allpages.addressesPage().postCodeFailB, 3);
        JSUtils.JSblockDsiplay(allpages.addressesPage().postCodeFailB);

        Assert.assertTrue(allpages.addressesPage().postCodeFailB.isDisplayed());






    }

    @AfterTest
    public void closeWindow(){
        Driver.closeDriver();
    }



}