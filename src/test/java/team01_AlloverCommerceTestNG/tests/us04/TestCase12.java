package team01_AlloverCommerceTestNG.tests.us04;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.JSUtils;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;
import team01_AlloverCommerceTestNG.utilities.WaitUtils;

public class TestCase12 {

    Pages allpages = new Pages();


    @BeforeMethod
    public void beforeMethod(){
        ReusableMethods.signInUS0304();
        allpages.addressesPage().addButonuS.click();
    }




    @Test
    public void companyNameIsAllowedToBeEmpty() {



        //String companyName = allpages.addressesPage().companyB.getAttribute("value");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='';", allpages.addressesPage().townB);


        Assert.assertTrue(allpages.addressesPage().savebutonB.isEnabled());
        allpages.addressesPage().savebutonB.submit();


        ReusableMethods.waitForSecond(2);
        WaitUtils.waitForVisibility(allpages.addressesPage().townFailB, 1);
        JSUtils.JSblockDsiplay(allpages.addressesPage().townFailB);

        Assert.assertTrue(allpages.addressesPage().townFailB.isDisplayed());





    }

    @AfterTest
    public void closeWindow(){
        Driver.closeDriver();
    }


}
