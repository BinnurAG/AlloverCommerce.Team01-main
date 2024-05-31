package team01_AlloverCommerceTestNG.tests.us04;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TestCase03 {


    Pages allpages = new Pages();
    Faker faker = new Faker();


    @BeforeMethod
    public void beforeMethod(){
        ReusableMethods.signInUS0304();
        allpages.addressesPage().addButonuS.click();
    }



    @Test
    public void countryToPhoneFilling() {

        allpages.addressesPage().firstNameB.sendKeys(ConfigReader.getProperty("firstNameUs03"));
        allpages.addressesPage().lastNameB.sendKeys(ConfigReader.getProperty("lastNameUS03"));

        allpages.addressesPage().companyB.sendKeys(faker.name().lastName());
        allpages.addressesPage().countryB.click();
        ReusableMethods.waitForSecond(2);
        allpages.addressesPage().countryChoose.sendKeys("France", Keys.ENTER);

        allpages.addressesPage().adress1B.sendKeys(faker.address().fullAddress());
        allpages.addressesPage().adress2B.sendKeys(faker.address().city());
        allpages.addressesPage().postcodeB.sendKeys(faker.address().zipCode());
        allpages.addressesPage().townB.sendKeys(faker.address().city());
        allpages.addressesPage().phoneB.sendKeys(faker.phoneNumber().phoneNumber());



    }

    @AfterMethod
    public void afterMethod(){
        Driver.closeDriver();
    }

}