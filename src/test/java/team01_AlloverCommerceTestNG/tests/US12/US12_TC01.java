package team01_AlloverCommerceTestNG.tests.US12;

import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P15_VendorAddressesPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class US12_TC01 {
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

            //6-Billing Adress kismindaki Add sekmesini tikla

            p15VendorAddressesPage.billingAddressEdit.click();
           // ReusableMethods.scroll(p15VendorAddressesPage.billingEmailAdresBox);



            //7-Mail adresini otomatik geldigini dogrula
            Assert.assertEquals( p15VendorAddressesPage.billingEmailAdresBox.getAttribute("value"),"eshawn.kolden@floodouts.com");
            Driver.closeDriver();
        }
    }






