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

public class TestCase09 {

    Pages allpages = new Pages();


    @BeforeMethod
    public void beforeMethod(){
        ReusableMethods.signInUS0304();
        allpages.addressesPage().addButonuS.click();
    }




    @Test
    public void phoneFail() {

        allpages.addressesPage().phoneB.sendKeys("aaaAA11");
        allpages.addressesPage().savebutonB.submit();

        ReusableMethods.waitForSecond(2);
        WaitUtils.waitForVisibility(allpages.addressesPage().phoneFailB, 3);
        JSUtils.JSblockDsiplay(allpages.addressesPage().phoneFailB);

        Assert.assertTrue(allpages.addressesPage().phoneFailB.isDisplayed());



    }

    @AfterTest
    public void closeWindow(){
        Driver.closeDriver();
    }





}
