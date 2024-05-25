package team01_AlloverCommerceTestNG.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P2_RegisterPage;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class US01_Register_SignUp {

    P2_RegisterPage p2_registerPage = new P2_RegisterPage();

    Faker faker = new Faker();

    @Test
    public void testTC01() {
//  Siteye müşteri olarak geçerli verilerle kayıt olunabilmeli(Register)
//        1	Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
//        2	Register linkine tıkla
       p2_registerPage.register.click();
//        3	Username alanına bir veri gir
//        4	Your Email address alanına bir veri gir
        p2_registerPage.userName.sendKeys(faker.name().username(), Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB);
//        5	Password alanına bir veri gir(12345678)
        p2_registerPage.password.sendKeys("08*24Luc");
        //       6	I agree to the privacy policy kontrol kutusunu seç
        p2_registerPage.privacyPolicy.click();
//        7	SIGN UP butonuna tıkla
        p2_registerPage.submitButton.click();
//        8	Anasayfanın açıldığını ve Sign Out linkinin göründüğünü doğrula
        Assert.assertTrue(p2_registerPage.signOut.isDisplayed());
        //Driver.closeDriver();
    }
    @Test
    public void testTC02() { //FAIL EKRAN GORUNTUSU ALMALISIN
//  Siteye müşteri olarak kayıt olurken
//  username alanına küçük harf,büyük harf,rakam ve özel karakterler girilebilmeli
//        1	Web sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
//        2	Register linkine tıkla
        p2_registerPage.register.click();
//        3	Username alanına bir veri gir(TimotHi*08)
        p2_registerPage.userName.sendKeys("TimotHi*08");
//        4	Your Email address alanına bir veri gir
        p2_registerPage.emailAddress.sendKeys(faker.internet().emailAddress());
//        5	Password alanına bir veri gir(08*24Luc)
        p2_registerPage.password.sendKeys("08*24Luc");
//        6	I agree to the privacy policy kontrol kutusunu seç
        p2_registerPage.privacyPolicy.click();
//        7	SIGN UP butonuna tıkla
        p2_registerPage.submitButton.click();
//        8	Anasayfanın açıldığını ve Sign Out linkinin göründüğünü doğrula
        Assert.assertFalse(p2_registerPage.resultMessage.getText().contains("Sign Out"));
        //Driver.closeDriver();
    }

}
