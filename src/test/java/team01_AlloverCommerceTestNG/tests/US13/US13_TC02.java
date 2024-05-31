package team01_AlloverCommerceTestNG.tests.US13;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P15_VendorAddressesPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US13_TC02 {
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


        p15VendorAddressesPage.shippingFirstName.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.shippingFirstName.sendKeys("mihajlo");


        p15VendorAddressesPage.shippingLastName.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.shippingLastName.sendKeys("buxton");

        ReusableMethods.ddmVisibleText(p15VendorAddressesPage.ddmShippingAddressCountry,"Norway");


        p15VendorAddressesPage.shippingCompanyName.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.shippingCompanyName.sendKeys("buxton");


        p15VendorAddressesPage.shippingStreetName.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.shippingStreetName.sendKeys("Paulines");


        p15VendorAddressesPage.shippingZipCodeName.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.shippingZipCodeName.sendKeys("3244");


        p15VendorAddressesPage.shippingCityName.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.shippingCityName.sendKeys("Sandefjord");


        ReusableMethods.scroll(p15VendorAddressesPage.shippingSaveButton);
        ReusableMethods.waitForSecond(4);
        p15VendorAddressesPage.shippingSaveButton.click();

        Assert.assertTrue(p15VendorAddressesPage.billingAddresSuccessfullText.isDisplayed());

        Driver.closeDriver();
    }
}
