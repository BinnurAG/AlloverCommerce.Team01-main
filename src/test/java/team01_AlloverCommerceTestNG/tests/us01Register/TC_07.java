package team01_AlloverCommerceTestNG.tests.us01Register;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import team01_AlloverCommerceTestNG.pages.P2_RegisterPage;

public class TC_07 {

    P2_RegisterPage p2_registerPage = new P2_RegisterPage();
    Faker faker = new Faker();

    @Test
    public void emptyUsernameTest() {
// Siteye müşteri olarak kayıt olurken username alanı boş bırakıldığında kayıt işlemi gerçekleşmemeli
//        Web sitesine git
//        Register linkine tıkla
//        Username alanını boş bırak
//        Your Email address alanına bir veri gir
//        Password alanına 8 karakterli bir veri gir
//        I agree to the privacy policy kontrol kutusunu seç
//        SIGN UP butonuna tıkla
//        Kayıt işleminin gerçekleşmediğini doğrula
    }
}
