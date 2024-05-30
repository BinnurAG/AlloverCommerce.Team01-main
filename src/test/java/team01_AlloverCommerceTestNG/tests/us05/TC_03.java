package team01_AlloverCommerceTestNG.tests.us05;

import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC_03 {       // TC-03

    Pages pages = new Pages();

    @Test
    public void us05Tc03() {

        //Kullanıcı Account Details (Hesap Detaylarını) First Name Doldurmadan Ekleme Yapamamalı

        //Web adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));

        //Sign in butonunu tıklanir
        pages.homePage().signInButton.click();

        //Kullanıcı siteye üye olurken girdiği username'i kutucuğa girmeli
        pages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        //Kullanıcı siteye üye olurken girdiği passwordu kutucuğa girmeli
        pages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$");

        // SIGN IN butonuna tikla
        pages.userVendorLoginPage().signInButton.click();

        //Sayfasinin en altinda bulunan My Account linkine tikla
        ReusableMethods.click(pages.homePage().myAccountButton);

        //Account details butonuna tıkla
        ReusableMethods.click(pages.myAccountPage().accountDetailsButton);

        //Kullanıcı First name Veri girişi yapmaz
        pages.accountDetails().detailsFirstNameBox.clear();
        ReusableMethods.waitForSecond(2);

        //Kullanıcı Last name Geçerli Bir Veri Girişi Yapar
        pages.accountDetails().detailsLastNameBox.clear();
        pages.accountDetails().detailsLastNameBox.sendKeys("Eksi");

        //Kullanıcı SAVE CHANGES tıklar.
        pages.accountDetails().detailsSaveChangesSubmitBox.submit();

        //FIRST NAME is a required field. Yazısını Görmeli.
        Assert.assertTrue(pages.accountDetails().zorunluAlanYazisiFirstName.isDisplayed());
        Driver.closeDriver();

    }
}