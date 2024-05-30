package team01_AlloverCommerceTestNG.tests.us16;

import jdk.jfr.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import team01_AlloverCommerceTestNG.pages.Pages;
import team01_AlloverCommerceTestNG.utilities.ConfigReader;
import team01_AlloverCommerceTestNG.utilities.DataProviderUtils;
import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ReusableMethods;

import java.util.List;
import java.util.Random;

public class US16 {

    Pages allPages = new Pages();

    @BeforeMethod
    public void setUp() {
        // Web sitesine git
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("alloverCommerceUrl"));

        // Kayitli vendor bilgileriyle giris yap
        allPages.homePage().signInButton.click();
        ReusableMethods.userVendorlogin("britton.jamesson@floodouts.com", "yvtve8V$");

        // Sign out'a tiklayarak My account sayfasina git
        allPages.homePage().signOutButton.click();

        //Sol taraftaki listeden Store Manager'i tikla
        allPages.myAccountPage().storeManagerButton.click();

        // My Store kisminin altindaki Products'i tikla
        ReusableMethods.scroll(allPages.vendorStoreManagerPage().productsMenu);
        ReusableMethods.waitForSecond(2);
        allPages.vendorStoreManagerPage().productsMenu.click();

        // Gelen sayfanin sag tarafindaki Add New butonunu tikla
        allPages.vendorProductDashboardPage().addNewButton.click();
    }

    @Test
    public void test01() {
        // Add Product sayfasindaki ilk dropdown menusunde Simple Product seceneginin default olarak gorundugunu dogrula
        Select select = new Select(allPages.vendorProductManagerPage().dropdownSimpleProduct);
        String actualDefaultOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDefaultOption, "Simple Product");
    }

    @Test
    public void test02() {
        //Virtual ve Downloadable checkbox'larini sec
        WebElement virtualCheckBox = allPages.vendorProductManagerPage().virtualCheckBox;
        ReusableMethods.scroll(virtualCheckBox);
        if (!virtualCheckBox.isSelected()) {
            virtualCheckBox.click();
        }

        WebElement downloadableCheckBox = allPages.vendorProductManagerPage().downloadableCheckBox;
        if (!downloadableCheckBox.isSelected()) {
            downloadableCheckBox.click();
        }

        // Virtual ve Downloadable checkbox larinin secilebildigini dogrula
        Assert.assertTrue(virtualCheckBox.isSelected());
        Assert.assertTrue(downloadableCheckBox.isSelected());
    }

    @Test
    public void test03() {
        //Price bilgisini gir
        ReusableMethods.scroll(allPages.vendorProductManagerPage().priceBox);
        allPages.vendorProductManagerPage().priceBox.sendKeys("45");

        //Sale Price bilgisini gir
        allPages.vendorProductManagerPage().salePriceBox.sendKeys("37");

        //Price ve Sale Price bilgilerini girebildigini dogrula
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String script = "return arguments[0].value;";

        String actualPriceValue = (String) js.executeScript(script, allPages.vendorProductManagerPage().priceBox);
        Assert.assertEquals(actualPriceValue, "120.8");

        String actualSalePriceValue = (String) js.executeScript(script, allPages.vendorProductManagerPage().salePriceBox);
        Assert.assertEquals(actualSalePriceValue, "95.4");
    }

    @Test
    public void test04() {
        //Product Title kisminda urun basliginin yazilabildigini dogrula
        allPages.vendorProductManagerPage().productTitleBox.sendKeys("Techpro Automation Testing");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String script = "return arguments[0].value;";
        String actualProductTitle = (String) js.executeScript(script, allPages.vendorProductManagerPage().productTitleBox);
        Assert.assertEquals(actualProductTitle, "Techpro Automation Testing");
    }

    @Test
    public void test05() {
        //Categories kismindan ekleyecegin urune ait bir kategori sec
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollToElement(allPages.vendorProductManagerPage().categoryBooks_Music_Film).perform();

        WebElement categoryBooks_Music_Film = allPages.vendorProductManagerPage().categoryBooks_Music_Film;
        categoryBooks_Music_Film.click();

        //Categories kismindan secim yapilabildigini dogrula
        Assert.assertTrue(categoryBooks_Music_Film.isSelected());
    }

    @Test
    public void test06() {
        // Dropdown'dan Simple Product sec
        ReusableMethods.ddmVisibleText(allPages.vendorProductManagerPage().dropdownSimpleProduct, "Simple Product");

        // Virtual ve Downloadable checkboxlarini sec
        ReusableMethods.waitForSecond(2);
        ReusableMethods.scroll(allPages.vendorProductManagerPage().downloadableCheckBox);

        allPages.vendorProductManagerPage().virtualCheckBox.click();
        allPages.vendorProductManagerPage().downloadableCheckBox.click();

        //Product Title gir
        allPages.vendorProductManagerPage().productTitleBox.sendKeys("Your soul is a river");

        //Price ve Sale Price bilgilerini gir
        allPages.vendorProductManagerPage().priceBox.sendKeys("35");
        allPages.vendorProductManagerPage().salePriceBox.sendKeys("27");

        //Kategori seceneklerinden bir kategori sec
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollToElement(allPages.vendorProductManagerPage().categoryBooks_Music_Film).perform();
        allPages.vendorProductManagerPage().categoryBooks_Music_Film.click();

        //Resim(featured image) kismini uzerine (sag ust kose) tikla
      //  allPages.vendorProductManagerPage().uploadPhoto.click();
      //  allPages.vendorProductManagerPage().selectFiles.click();
        allPages.vendorProductManagerPage().addPhotoButton.click();
        ReusableMethods.waitForSecond(2);
        allPages.vendorProductManagerPage().menuLibraryButton.click();
        ReusableMethods.waitForSecond(4);
        ReusableMethods.click(allPages.vendorProductManagerPage().logoImage);
        allPages.vendorProductManagerPage().selectButton.click();

        // Galeri image ekle
        allPages.vendorProductManagerPage().addGalleryPhotoButton.click();
        ReusableMethods.waitForSecond(2);
        allPages.vendorProductManagerPage().menuGalleryLibraryButton.click();
        ReusableMethods.waitForSecond(4);
        ReusableMethods.click(allPages.vendorProductManagerPage().logoGalleryImage.get(allPages.vendorProductManagerPage().logoGalleryImage.size()-1));
        ReusableMethods.waitForSecond(2);
        allPages.vendorProductManagerPage().addToGalleryPhotoButton.click();

        //Submit butonuna bas
        ReusableMethods.scroll( allPages.vendorProductManagerPage().submitButton);
        ReusableMethods.waitForSecond(2);
        allPages.vendorProductManagerPage().submitButton.click();

        // Soldaki menulerden Product i tikla
        ReusableMethods.waitForSecond(4);
        ReusableMethods.scroll( allPages.vendorProductManagerPage().menuProduct);
        allPages.vendorProductManagerPage().menuProduct.click();

        //  Product kisminda urunun adini gorerek eklendigini onayla
        List<WebElement> products = allPages.vendorProductManagerPage().addedProducts;
        for (WebElement product: products) {
       //     Assert.assertEquals("Techpro QA Education " + randomNumber, product.getText());

        }

    }

    @Test(dataProvider = "negativeTestDataForUs16",dataProviderClass = DataProviderUtils.class)
    public void test07(String negativeDataForUS16) {
        // Price bilgisini gir
        WebElement pricebox = allPages.vendorProductManagerPage().priceBox;
        pricebox.sendKeys(negativeDataForUS16);

        // Sale Price bilgisini gir
        WebElement salePriceBox = allPages.vendorProductManagerPage().salePriceBox;
        salePriceBox.sendKeys(negativeDataForUS16);

        //  Price kismina invalid bilgiler girilemedigini dogrula	0, xqz, %#$,  space,
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String script = "return arguments[0].value;";
        String actualPriceValue = (String) js.executeScript(script, allPages.vendorProductManagerPage().priceBox);
        Assert.assertTrue(actualPriceValue.isEmpty());

        // Sale Price kismina invalid bilgiler girilemedigini dogrula	xqz, %#$,  space,
        String actualSalePriceValue = (String) js.executeScript(script, allPages.vendorProductManagerPage().salePriceBox);
        Assert.assertTrue(actualSalePriceValue.isEmpty());
    }

    @Test
    public void test08() {
        // Price bilgisini gir
        WebElement pricebox = allPages.vendorProductManagerPage().priceBox;
        pricebox.sendKeys("50");

        //Sale Price bilgisini gir
        WebElement salePriceBox = allPages.vendorProductManagerPage().salePriceBox;
        salePriceBox.sendKeys("100");

        //Price in Sale Price tan daha kucuk olamayacagini dogrula
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String script = "return arguments[0].value;";
        String actualPriceValue = (String) js.executeScript(script, allPages.vendorProductManagerPage().priceBox);
        String actualSalePriceValue = (String) js.executeScript(script, allPages.vendorProductManagerPage().salePriceBox);
        Assert.assertTrue(Integer.parseInt(actualPriceValue) > Integer.parseInt(actualSalePriceValue));

    }

    @AfterMethod
    public void tearDown() {
        //    Driver.getDriver().close();
    }

}

