package team01_AlloverCommerceTestNG.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

//Bu datalar ornek icin eklenmistir
    /*
@DataProvider(name = "positiveTestData")
    public static Object[][] provideBoundaryValueTestData() {
        return new Object[][]{
                {"18"},    // Alt sınır
                {"18.0"},
                {"30"},  // Geçerli yaş
                {"50."}, //noktadan sonra bos
                {"20.7"},
                {"38.99"},
                {"100.00"},
                {"+76"},
                {"087"},
                {"100"},   // Üst sınır
                {"18.12345678901234567890123456789012345678901234567890"}, // 50 karakterden uzun sayı
        };
    }

    @DataProvider(name = "negativeTestData")
    public static Object[][] provideNegativeTestData() {
        return new Object[][]{
                {"17"},   // Alt sınırın altı
                {"17.99"},
                {"100.01"},
                {"0"},
                {"101"},  // Üst sınırın üstü
                {" "},      // Tek bir boşluk karakteri
                {"  "}    // İki boşluk karakteri
        };
    }

    @DataProvider(name = "invalidTestData")
    public static Object[][] provideInvalidTestData() {
        return new Object[][]{
                {"ali"},   // invalidTestData
                {"%"},
                {"-18"},
                {"22,5"},
                {"yirmi"},
                {"5.0.0"},  // Birden fazla nokta içeren sayı
                {"3/2"},    // Geçersiz karakter içeren sayı
                {"$10"},    // Para birimi sembolü içeren sayı
                {"100/2"},    // Kesir içeren sayı
                {"123abc"}, // Sayı ve harf içeren kombinasyon
                {"def456"}

        };
    }

    @DataProvider(name = "emptyTestData")
    public static Object[][] provideEmptyTestData() {
        return new Object[][]{
                {""} , // Boş giriş
        };
    }

*/
    // US 16 : Price ve Sale Price icin

    @DataProvider(name = "positiveTestDataForUs16")
    public static Object[][] providePositiveTestData() {
        return new Object[][]{
                {"0"},
                {"35"},
                {"37.0"},
                {"50."}, //noktadan sonra bos
                {"20.7"},
                {"38.99"},
                {"100.00"},
                {"000087"},
                {".0000000"},
                {".87657687776654545445"}, //.dan sonraki ucuncu basamagi yuvarliyor
                {"18.12345678901234567890123456789012345678901234567890"}, // 50 karakterden uzun sayı
        };
    }

    @DataProvider(name = "negativeTestDataForUs16")
    public static Object[][] provideNegativeTestData() {
        return new Object[][]{
                {"xqz"},
                {"#$%"},
                {""},
                {" "},      // Tek bir boşluk karakteri
                {"  "},   // İki boşluk karakteri
                {"+76"},
                {"-50"},
                {"25.78."}
        };
    }


    @DataProvider(name = "invalidTestData")
    public static Object[][] provideInvalidTestData() {
        return new Object[][]{
                {"0"}, //Value must be greater than or equla to 0.1
                {"2.34"} //Please enter a valid value.The two nearest valid values are 2.3 and 2.4
                //  mesaji geliyor fakat yinede datayi kabul ediyor
        };

    }
    //fiyat 0 kabul etmemeli
    //fiyat ondalik sayinin ikinci basamaginda 0 haricinde sayi kabul etmmeli
    //fiyat bosluk kabul etmemeli
//fiyat 0 kabul etmemeli
    //fiyat 0 iken sales fiyat kabul etmemeli

    //https://allovercommerce.com/wp-content/uploads/2024/05/book_image-16-scaled.jpg
    //https://allovercommerce.com/wp-content/uploads/woocommerce_uploads/2024/05/logo-a3ca53.png  hata veriyor

}


