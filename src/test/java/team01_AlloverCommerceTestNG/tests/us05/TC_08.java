package team01_AlloverCommerceTestNG.tests.us05;

import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

public class TC_08 {

    Pages pages = new Pages();

    @Test
    public void us05Tc08() {

        //Kullanıcı yeni password ile confirm eşleşmediyse işlem yapılmamalı

        //Web adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));

        //Sign in butonunu tıklanir
        pages.homePage().signInButton.click();

        //Kullanıcı siteye üye olurken girdiği username'i kutucuğa girmeli
        pages.userVendorLoginPage().emailBox.sendKeys("bettybrown@gmail.com");

        //Kullanıcı siteye üye olurken girdiği passwordu kutucuğa girmeli
        pages.userVendorLoginPage().passwordBox.sendKeys("2024deployment!");

        // SIGN IN butonuna tikla
        pages.userVendorLoginPage().signInButton.click();

        //Sayfasinin en altinda bulunan My Account linkine tikla
        ReusableMethods.click(pages.homePage().myAccountButton);

        //Account details butonuna tıkla
        ReusableMethods.click(pages.myAccountPage().accountDetailsButton);

        //Kullanıcı First name Geçerli Bir Veri Girişi Yapar
        pages.accountDetails().detailsFirstNameBox.clear();
        ReusableMethods.waitForSecond(2);
        pages.accountDetails().detailsFirstNameBox.sendKeys("ABetul");

        //Kullanıcı Last name Geçerli Bir Veri Girişi Yapar
        pages.accountDetails().detailsLastNameBox.clear();
        pages.accountDetails().detailsLastNameBox.sendKeys("Tekmen");

        //Kullanıcı "Current password leave blank to leave unchanged" şifresini girer
        ReusableMethods.waitForSecond(2);
        pages.accountDetails().detailsCurrentPasswordBox.sendKeys("2024deployment!");

        //Kullanıcı "New password leave blank to leave unchanged" yeni şifre girer
        pages.accountDetails().detailsNewPasswordBox.sendKeys("2024deployment");

        //Kullanıcı Confirm password şifresini tekrar eksik girer
        pages.accountDetails().detailsConfirmPasswordBox.sendKeys("2024deploymen");

        //Kullanıcı SAVE CHANGES tıklar.
        pages.accountDetails().detailsSaveChangesSubmitBox.submit();

        //"New passwords do not match" yazısını göruldugunu doğrula
        Assert.assertTrue(pages.accountDetails().newPasswordNotMatchAlert.isDisplayed());

    }
}
