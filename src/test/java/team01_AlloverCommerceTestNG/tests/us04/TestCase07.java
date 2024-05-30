package team01_AlloverCommerceTestNG.tests.us04;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TestCase07 {

    Pages allpages = new Pages();


    @BeforeMethod
    public void beforeMethod(){
        ReusableMethods.signInUS0304();

    }




    @Test
    public void editAddressButton() {

        allpages.addressesPage().editButonB.click();
        Assert.assertTrue(allpages.addressesPage().addressPageB.isDisplayed());

    }

    @AfterTest
    public void closeWindow(){
        Driver.closeDriver();
    }

}
