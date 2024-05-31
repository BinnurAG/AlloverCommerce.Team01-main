package team01_AlloverCommerceTestNG.tests.us09;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.FakeMailPage;
import team01_AlloverCommerceTestNG.pages.P14_VendorRegisterPage;
import team01_AlloverCommerceTestNG.pages.P1_HomePage;
import team01_AlloverCommerceTestNG.utilities.*;

public class US_09_TC_17 {
    P14_VendorRegisterPage p14_VendorRegisterPage = new P14_VendorRegisterPage();
    P1_HomePage p1_HomePage = new P1_HomePage();
    Actions actions = new Actions(Driver.getDriver());

    @Test(description = "US09- AC08 Kayıtlı bir e-mail adresi ile kayıt olmaya çalıştığında \"This Email already exists. Please login to the site and apply as vendor.\" mesajını almalı")

    public void test_US_09_TC_12() {

        // Kullanıcı Allover Commerce URL'sine gitmeli
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        String alloverCommerceWebSite = Driver.getDriver().getWindowHandle();
        ExtentReportUtils.extentTestInfo("Web sitesine gidilir");

        // "Sign In" butonuna tıklayın
        p1_HomePage.signInButton.click();

        ExtentReportUtils.extentTestPass("Sign In butonuna basarili bir sekilde tiklandigi test edildi.");
        // "Sign Up" butonuna tıklayın
        p1_HomePage.singUpButton.click();
        // "Become a Vendor" butonuna tıklayın
        ExtentReportUtils.extentTestPass("Sign UP butonuna basarili bir sekilde tiklandigi test edildi.");
        p1_HomePage.becomeAVendorButton.click();
        ExtentReportUtils.extentTestPass("Become a Vendor butonuna basarili bir sekilde tiklandigi test edildi.");
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("fakeEmailUrl"));
        String fakeEmailUrl = Driver.getDriver().getWindowHandle();

        FakeMailPage fakeMailPage = new FakeMailPage();
        String fakeEmail = fakeMailPage.email.getText();
        Driver.getDriver().switchTo().window(alloverCommerceWebSite);
        p14_VendorRegisterPage.registrationEmail.sendKeys(fakeEmail);
        P14_VendorRegisterPage.reSendCodeButton.click();
        ReusableMethods.waitForSecond(3);
        Driver.getDriver().switchTo().window(fakeEmailUrl);
        ReusableMethods.waitForSecond(3);
ExtentReportUtils.extentTestPass("E-Mail alanina veri girisi test edildi");
        String verificationCodeText = fakeMailPage.verificationCodeText.getText();
        System.out.println("verificationCodeText = " + verificationCodeText);
        String verificationCode = verificationCodeText.substring(45).trim();
        System.out.println(verificationCode);
        Driver.getDriver().switchTo().window(alloverCommerceWebSite);
        ReusableMethods.waitForSecond(3);
        p14_VendorRegisterPage.reSendCodeInput.click();
        ExtentReportUtils.extentTestPass("Geçerli Yeniden Gönderme Kodunu Verification Code kutusuna girin");

        // Geçerli Yeniden Gönderme Kodunu "Verification Code" kutusuna girin
        if (verificationCode == null || verificationCode.isEmpty()) {
            throw new IllegalArgumentException("Verification code is null or empty. Please check the configuration.");
        }
        p14_VendorRegisterPage.reSendCodeInput.sendKeys(verificationCode);
        ExtentReportUtils.extentTestPass("Geçerli Yeniden Gönderme Kodunu Verification Code kutusuna girin");
        // Geçerli şifreyi "Password" metin kutusuna girin
        p14_VendorRegisterPage.password.sendKeys(ConfigReader.getProperty("good_password"));
        ExtentReportUtils.extentTestPass("Geçerli şifreyi \"Password\" metin kutusuna girildigi test edildi");
        // Aynı geçerli parolayı "Confirm Password" metin kutusuna girin
        p14_VendorRegisterPage.confirmPassword.sendKeys(ConfigReader.getProperty("good_password"));
        ExtentReportUtils.extentTestPass("Aynı geçerli parolayı \"Confirm Password\" metin kutusuna girildigi test edildi");
        ReusableMethods.waitForSecond(3);
        //Register butonu tıkla
        JSUtils.JSclickWithTimeout(p14_VendorRegisterPage.registerButton);
ExtentReportUtils.extentTestPass("Register butonu tıklandigi test edildi");
        // "This Email already exists. Please log in to the site and apply as vendor." mesajının görünmediğini doğrulayın
        Assert.assertFalse(Driver.getDriver().getPageSource().contains("This Email already exists. Please login to the site and apply as vendor."));
        //ExtentReportUtils.addScreenShotToReport();
        ExtentReportUtils.flush();
    }
}

