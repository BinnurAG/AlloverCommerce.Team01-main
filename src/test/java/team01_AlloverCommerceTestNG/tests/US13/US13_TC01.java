package team01_AlloverCommerceTestNG.tests.US13;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P15_VendorAddressesPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US13_TC01 {
    @Test
    public void test01() {

        //1-Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        P15_VendorAddressesPage p15VendorAddressesPage= new P15_VendorAddressesPage();


        //2-Sign In linkine tikla
        p15VendorAddressesPage.signIn.click();


        //3-Vendor hesabiyla giris yap
        //email girisi
        p15VendorAddressesPage.userName.sendKeys(ConfigReader.getProperty("alloverEmailms"));
        //password girisi
        p15VendorAddressesPage.password.sendKeys(ConfigReader.getProperty("alloverPasswordms"));
        //submit butonuna tiklanir
        p15VendorAddressesPage.submit.click();



        //4-My Account sayfasina git
        p15VendorAddressesPage.signOut.click();
        ReusableMethods.waitForSecond(7);

        //5- Adresesses sekmesine tikla
        p15VendorAddressesPage.billingAdress.click();
        ReusableMethods.waitForSecond(5);


      ReusableMethods.scroll(p15VendorAddressesPage.shippingAddressEdit);
      ReusableMethods.waitForSecond(2);
      p15VendorAddressesPage.shippingAddressEdit.click();

        for (WebElement w:p15VendorAddressesPage.shippingAdressForm) {
            w.sendKeys(Keys.COMMAND,"A");
            w.sendKeys(Keys.DELETE);
        }
        ReusableMethods.ddmIndex(p15VendorAddressesPage.ddmShippingAddressCountry,0);



//
//        p15VendorAddressesPage.shippingFirstName.sendKeys(Keys.COMMAND,"A");
//        p15VendorAddressesPage.shippingFirstName.sendKeys(Keys.DELETE);
//
//
//        p15VendorAddressesPage.shippingLastName.sendKeys(Keys.COMMAND,"A");
//        p15VendorAddressesPage.shippingLastName.sendKeys(Keys.DELETE);
//
//
//
//        p15VendorAddressesPage.shippingCompanyName.sendKeys(Keys.COMMAND,"A");
//        p15VendorAddressesPage.shippingCompanyName.sendKeys(Keys.DELETE);
//
//

//
//
//        p15VendorAddressesPage.shippingStreetName.sendKeys(Keys.COMMAND,"A");
//        p15VendorAddressesPage.shippingStreetName.sendKeys(Keys.DELETE);
//
//
//        p15VendorAddressesPage.shippingZipCodeName.sendKeys(Keys.COMMAND,"A");
//        p15VendorAddressesPage.shippingZipCodeName.sendKeys(Keys.DELETE);
//
//
//        p15VendorAddressesPage.shippingCityName.sendKeys(Keys.COMMAND,"A");
//        p15VendorAddressesPage.shippingCityName.sendKeys(Keys.DELETE);




        ReusableMethods.waitForSecond(4);
        p15VendorAddressesPage.shippingSaveButton.click();

        Assert.assertTrue(p15VendorAddressesPage.billingNameRequiredField.isDisplayed());
        Assert.assertTrue(p15VendorAddressesPage.billingLastNameRequiredField.isDisplayed());
        Assert.assertTrue(p15VendorAddressesPage.billingCountryRequiredField.isDisplayed());
        Assert.assertTrue(p15VendorAddressesPage.billingStreetRequiredField.isDisplayed());
        Assert.assertTrue(p15VendorAddressesPage.billingCityRequiredField.isDisplayed());
        Assert.assertTrue(p15VendorAddressesPage.billingStreetRequiredField.isDisplayed());
        Assert.assertTrue(p15VendorAddressesPage.billingZipCodeRequiredField.isDisplayed());

        Driver.closeDriver();






    }
}
