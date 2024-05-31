package team01_AlloverCommerceTestNG.tests.us03;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class TestCase11 {

        Pages allpages = new Pages();

    @BeforeMethod
    public void beforeMethod(){
        ReusableMethods.signInUS0304();
        allpages.addressesPage().addButonuB.click();
    }




    @Test
    public void companyNameIsAllowedToBeEmpty() {



        //String companyName = allpages.addressesPage().companyB.getAttribute("value");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='';", allpages.addressesPage().companyB);


        allpages.addressesPage().savebutonB.submit();

        WaitUtils.waitForVisibility(allpages.addressesPage().addressChanged, 3);
        JSUtils.JSblockDsiplay(allpages.addressesPage().addressChanged);

        Assert.assertTrue(allpages.addressesPage().addressChanged.isDisplayed());


    }

     @AfterTest
    public void closeWindow(){
        Driver.closeDriver();
    }


}