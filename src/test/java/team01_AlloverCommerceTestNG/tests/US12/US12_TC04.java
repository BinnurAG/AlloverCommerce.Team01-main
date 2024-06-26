package team01_AlloverCommerceTestNG.tests.US12;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P15_VendorAddressesPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US12_TC04 {
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

        p15VendorAddressesPage.userName.sendKeys(ConfigReader.getProperty("alloverEmails"));
        //password girisi
        p15VendorAddressesPage.password.sendKeys(ConfigReader.getProperty("alloverPasswords"));

        //submit butonuna tiklanir
        p15VendorAddressesPage.submit.click();



        //4-My Account sayfasina git
        p15VendorAddressesPage.signOut.click();


        //5- Adresesses sekmesine tikla
        p15VendorAddressesPage.billingAdress.click();
        ReusableMethods.scroll(p15VendorAddressesPage.billingAdress);
        ReusableMethods.waitForSecond(7); //pop up hata verdigi icin bekletiyoruz

        //6-Billing AdressEdit kismindaki Add sekmesini tikla
        p15VendorAddressesPage.billingAddressEdit.click();
        // ReusableMethods.scroll(p15VendorAddressesPage.billingEmailAdresBox);



        p15VendorAddressesPage.billingFirstNameBox.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.billingFirstNameBox.sendKeys(Keys.DELETE);


        p15VendorAddressesPage.billingLastNameBox.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.billingLastNameBox.sendKeys(Keys.DELETE);



        p15VendorAddressesPage.billingCompanyNameBox.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.billingCompanyNameBox.sendKeys(Keys.DELETE);


        ReusableMethods.ddmIndex(p15VendorAddressesPage.ddmBillingAddressCountry,0);


        p15VendorAddressesPage.billingStreetAddressNameBox.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.billingStreetAddressNameBox.sendKeys(Keys.DELETE);


        p15VendorAddressesPage.billingStreetAddress2NameBox.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.billingStreetAddress2NameBox.sendKeys(Keys.DELETE);


        p15VendorAddressesPage.billingStreetAddressNameBox.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.billingStreetAddressNameBox.sendKeys(Keys.DELETE);


        p15VendorAddressesPage.billingZipCodeBox.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.billingZipCodeBox.sendKeys(Keys.DELETE);


        p15VendorAddressesPage.billingCityNameBox.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.billingCityNameBox.sendKeys(Keys.DELETE);


        ReusableMethods.scroll(p15VendorAddressesPage.billingPhoneNumberBox);


        p15VendorAddressesPage.billingPhoneNumberBox.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.billingPhoneNumberBox.sendKeys(Keys.DELETE);
        p15VendorAddressesPage.billingSaveAddress.submit();


        Assert.assertTrue(p15VendorAddressesPage.billingNameRequiredField.isDisplayed());
        Assert.assertTrue(p15VendorAddressesPage.billingLastNameRequiredField.isDisplayed());
        Assert.assertTrue(p15VendorAddressesPage.billingCountryRequiredField.isDisplayed());
        Assert.assertTrue(p15VendorAddressesPage.billingStreetRequiredField.isDisplayed());
        Assert.assertTrue(p15VendorAddressesPage.billingCityRequiredField.isDisplayed());
        Assert.assertTrue(p15VendorAddressesPage.billingStreetRequiredField.isDisplayed());
        Assert.assertTrue(p15VendorAddressesPage.billingZipCodeRequiredField.isDisplayed());
        Assert.assertTrue(p15VendorAddressesPage.billingPhoneRequiredField.isDisplayed());

        Driver.closeDriver();

    }
}
