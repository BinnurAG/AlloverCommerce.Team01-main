package team01_AlloverCommerceTestNG.tests.US12;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P15_VendorAddressesPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US12_TC02 {

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


        //5- Adresesses sekmesine tikla
        p15VendorAddressesPage.billingAdress.click();
        ReusableMethods.scroll(p15VendorAddressesPage.billingAdress);
        ReusableMethods.waitForSecond(7); //pop up hata verdigi icin bekletiyoruz

        //6-Billing AdressEdit kismindaki Add sekmesini tikla
        p15VendorAddressesPage.billingAddressEdit.click();
        // ReusableMethods.scroll(p15VendorAddressesPage.billingEmailAdresBox);



        p15VendorAddressesPage.billingFirstNameBox.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.billingFirstNameBox.sendKeys("Zeid");


        p15VendorAddressesPage.billingLastNameBox.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.billingLastNameBox.sendKeys("Duoat");



        p15VendorAddressesPage.billingCompanyNameBox.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.billingCompanyNameBox.sendKeys("Migros");


        ReusableMethods.ddmVisibleText(p15VendorAddressesPage.ddmBillingAddressCountry,"Norway");


        p15VendorAddressesPage.billingStreetAddressNameBox.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.billingStreetAddressNameBox.sendKeys("Doet straat");


        p15VendorAddressesPage.billingStreetAddress2NameBox.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.billingStreetAddress2NameBox.sendKeys("27 dallas");


        p15VendorAddressesPage.billingStreetAddressNameBox.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.billingStreetAddressNameBox.sendKeys("Doet straat 21");


        p15VendorAddressesPage.billingZipCodeBox.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.billingZipCodeBox.sendKeys("4410PG");


        p15VendorAddressesPage.billingCityNameBox.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.billingCityNameBox.sendKeys("Norway");


        ReusableMethods.scroll(p15VendorAddressesPage.billingPhoneNumberBox);


        p15VendorAddressesPage.billingPhoneNumberBox.sendKeys(Keys.COMMAND,"A");
        p15VendorAddressesPage.billingPhoneNumberBox.sendKeys("+905467845637");


        p15VendorAddressesPage.billingSaveAddress.submit();
        Assert.assertTrue(p15VendorAddressesPage.billingAddresSuccessfullText.isDisplayed());
        Driver.closeDriver();






    }
}