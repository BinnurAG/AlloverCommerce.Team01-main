package team01_AlloverCommerceTestNG.tests.us04;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TestCase04 {


    Pages allpages = new Pages();
    Faker faker = new Faker();

    @BeforeMethod
    public void beforeMethod(){
        ReusableMethods.signInUS0304();
        allpages.addressesPage().addButonuS.click();
    }




    @Test
    public void emailIsDisplayed() {

        String value = allpages.addressesPage().emailB.getAttribute("value");
        Assert.assertNotEquals(value, null);



    }

    @AfterMethod
    public void closeWindow(){
        Driver.closeDriver();
    }
}
