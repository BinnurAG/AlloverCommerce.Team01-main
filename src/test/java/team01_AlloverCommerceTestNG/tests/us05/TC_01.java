package team01_AlloverCommerceTestNG.tests.us05;

import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import java.util.Arrays;
import java.util.List;


public class TC_01 {

    Pages pages = new Pages();

    @Test
    public void us05Tc01() {

        //Kullanıcı Account Details (Hesap Detaylarını) görebilmeli

        //Web adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));

        //Sign in butonunu tıklanir
        pages.homePage().signInButton.click();

        //Kullanıcı siteye üye olurken girdiği username'i kutucuğa girmeli
        pages.userVendorLoginPage().emailBox.sendKeys("britton.jamesson@floodouts.com");

        //Kullanıcı siteye üye olurken girdiği passwordu kutucuğa girmeli
        pages.userVendorLoginPage().passwordBox.sendKeys("yvtve8V$9");

        // SIGN IN butonuna tikla
        pages.userVendorLoginPage().signInButton.click();

        //Sayfasinin en altinda bulunan My Account linkine tikla
        ReusableMethods.click(pages.homePage().myAccountButton);

        //Account details butonuna tıkla
        ReusableMethods.click(pages.myAccountPage().accountDetailsButton);

        //Hesap Detayları( First name, Last name, Display name, Email address ve Biography) alanlarını görüntülendiği doğrulanmali
        //Account Details basliginin goruntulendigini dogrula
        Assert.assertTrue(pages.accountDetails().myAccountTitle.isDisplayed());

        //First name basliginin goruntulendigini dogrula
        Assert.assertTrue(pages.accountDetails().firstNameTitle.isDisplayed());

        //Last name basliginin goruntulendigini dogrula
        Assert.assertTrue(pages.accountDetails().lastNameTitle.isDisplayed());

        //Display name basliginin goruntulendigini dogrula
        Assert.assertTrue(pages.accountDetails().displayNameTitle.isDisplayed());

        //Email adress name basliginin goruntulendigini dogrula
        Assert.assertTrue(pages.accountDetails().emailTitle.isDisplayed());

        //Biography basliginin goruntulendigini dogrula
        Assert.assertTrue(pages.accountDetails().biographyTitle.isDisplayed());
        Driver.closeDriver();

    }
}