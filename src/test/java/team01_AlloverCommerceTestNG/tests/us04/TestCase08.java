package team01_AlloverCommerceTestNG.tests.us04;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.JSUtils;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;
import team01_AlloverCommerceTestNG.utilities.WaitUtils;

public class TestCase08 {

    Pages allpages = new Pages();


    @BeforeMethod
    public void beforeMethod(){
        ReusableMethods.signInUS0304();
        allpages.addressesPage().addButonuS.click();
    }




    @Test
    public void postCodeFail() {

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
