package team01_AlloverCommerceTestNG.tests.us01;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P2_RegisterPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ExtentReportUtils;

public class TC_02 {

    P2_RegisterPage p2_registerPage = new P2_RegisterPage();
    Faker faker = new Faker();

    @Test(description = "US01 - TC02 The user should be able to register to the site with special characters")
    public void specialCharacterTest() { //FAIL EKRAN GORUNTUSU ALMALISIN
//  Siteye müşteri olarak kayıt olurken
//  username alanına küçük harf,büyük harf,rakam ve özel karakterler girilebilmeli
//        1	Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
//        2	Register linkine tıkla
        p2_registerPage.register.click();
//        3	Username alanına bir veri gir
        p2_registerPage.userName.sendKeys(ConfigReader.getProperty("privateUserName"));
//        4	Your Email address alanına bir veri gir
        ExtentReportUtils.extentTestInfo("Your Email address alanına bir veri gir");
        p2_registerPage.emailAddress.sendKeys(faker.internet().emailAddress());
//        5	Password alanına bir veri gir
        p2_registerPage.password.sendKeys(ConfigReader.getProperty("registeredPassword"));
//        6	I agree to the privacy policy kontrol kutusunu seç
        p2_registerPage.privacyPolicy.click();
//        7	SIGN UP butonuna tıkla
        p2_registerPage.submitButton.click();
//      ReusableMethods.screenShot("SignOut");
//        8	Anasayfanın açıldığını ve Sign Out linkinin göründüğünü doğrula
        ExtentReportUtils.extentTestFail("Test basarisiz oldu");
        Assert.assertTrue(p2_registerPage.signOut.isEnabled());

        Driver.closeDriver();
    }

}