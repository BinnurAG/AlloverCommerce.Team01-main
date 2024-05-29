package team01_AlloverCommerceTestNG.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P15_VendorAddressesPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US12_TC01 {
    @Test
    public void test01() {


            //Web sitesine git
            Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
            P15_VendorAddressesPage p15VendorAddressesPage= new P15_VendorAddressesPage();
            //Sign In linkine tikla
            p15VendorAddressesPage.signIn.click();
            //Vendor hesabiyla giris yap

            //vendor olarak email girisi
            p15VendorAddressesPage.userName.sendKeys(ConfigReader.getProperty("alloverEmail"));
            //vendor olarak password girisi
            p15VendorAddressesPage.password.sendKeys(ConfigReader.getProperty("alloverPassword"));
            //submit butonuna tiklanir
            p15VendorAddressesPage.submit.click();

            //My Account sayfasina git
            p15VendorAddressesPage.signOut.click();
            p15VendorAddressesPage.billingAdress.click();
            ReusableMethods.scroll(p15VendorAddressesPage.billingAdress);
            ReusableMethods.waitForSecond(7);
            p15VendorAddressesPage.billingAddressEdit.click();
            ReusableMethods.ddmVisibleText(p15VendorAddressesPage.ddmBillingAddressCountry,"Select a country / region…");

            Assert.assertEquals( p15VendorAddressesPage.billingEmailAdresBox.getAttribute("value"),"eshawn.kolden@floodouts.com");
        }
    }






