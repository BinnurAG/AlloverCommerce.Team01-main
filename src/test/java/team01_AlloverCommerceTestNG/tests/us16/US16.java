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

public class US16 {

    Pages allPages = new Pages();

    @BeforeMethod
    public void setUp() {
        // Web sitesine git
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("alloverCommerceUrl"));;

        // Kayitli vendor bilgileriyle giris yap
        allPages.homePage().signInButton.click();
        ReusableMethods.userVendorlogin("britton.jamesson@floodouts.com", "yvtve8V$");

        // Sign out a tiklayarak My account sayfasina gir
        allPages.homePage().signOutButton.click();
        //Sol taraftaki listeden Store Manager i tikla
        allPages.myAccountPage().storeManagerButton.click();
        // My Store kisminda Products i tikla
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
        //Virtual ve Downloadable checkbox larini sec
        WebElement virtualCheckBox  = allPages.vendorProductManagerPage().virtualCheckBox;
        ReusableMethods.scroll(virtualCheckBox);
        if(!virtualCheckBox.isSelected()){
            virtualCheckBox.click();
        }

        WebElement downloadableCheckBox = allPages.vendorProductManagerPage().downloadableCheckBox;
        if(!downloadableCheckBox.isSelected()){
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

        allPages.vendorProductManagerPage().salePriceBox.clear();
        //Price ve Sale Price bilgilerini girebildigini onayla
        String actualPrice= allPages.vendorProductManagerPage().priceBox.getText();// bos geliyo
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String script = "return arguments[0].value;";
        String actualPriceValue = (String) js.executeScript(script, allPages.vendorProductManagerPage().priceBox);
        Assert.assertEquals(actualPriceValue, "45");
        String actualSalePriceValue = (String) js.executeScript(script, allPages.vendorProductManagerPage().salePriceBox);
        Assert.assertEquals(actualSalePriceValue, "37");

    }
    @Test
    public void test04() {
        //Product Title kisminda urun basliginin yazilabildigini dogrula
        allPages.vendorProductManagerPage().productTitleBox.sendKeys("Your Soul is a river");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String script = "return arguments[0].value;";
        String actualProductTitle = (String) js.executeScript(script, allPages.vendorProductManagerPage().productTitleBox);
        System.out.println(actualProductTitle);
        Assert.assertEquals(actualProductTitle,"Your soul is a river" );

    }
    @Test
    public void test05() {
        //Categories kismindan istedigin bir secenegi sec
        //Categories kismindan secim yapilabildigini dogrula
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollToElement(allPages.vendorProductManagerPage().categoryEducation).perform();

        WebElement categoryEducation = allPages.vendorProductManagerPage().categoryEducation;
        categoryEducation.click();
        Assert.assertTrue(categoryEducation.isSelected());
    }

    @Test
    public void test06() {
        // Dropdown dan Simple Product sec
        ReusableMethods.ddmVisibleText(allPages.vendorProductManagerPage().dropdownSimpleProduct, "Simple Product");
        // Virtual ve Downloadabe sec
        ReusableMethods.waitForSecond(2);
        ReusableMethods.scroll(allPages.vendorProductManagerPage().downloadableCheckBox);
        allPages.vendorProductManagerPage().virtualCheckBox.click();
        allPages.vendorProductManagerPage().downloadableCheckBox.click();

        //Product Title gir
        allPages.vendorProductManagerPage().productTitleBox.sendKeys("Your soul is a river");
        //Price ve Sale Price bilgilerini gir
        allPages.vendorProductManagerPage().priceBox.sendKeys("35");
        allPages.vendorProductManagerPage().salePriceBox.sendKeys("27");

        //Kategori sec
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollToElement(allPages.vendorProductManagerPage().categoryEducation).perform();
        allPages.vendorProductManagerPage().categoryEducation.click();
        //Resim ekle
        allPages.vendorProductManagerPage().uploadPhoto.click();

        // Galeri image ekle
        // Downloadable menusunde name kismini gir
        //Downloadable menusunde file kismina dokumani upload et
        //Submit butonuna bas
        // Soldaki menulerden Product i tikla
        //  Product kisminda urunun adini gorerek eklendigini onayla
    }


    @Test (dataProvider = "negativeDataForUS16")
    public void test07(String negativeDataForUS16){
        // Price bilgisini gir
        WebElement pricebox = allPages.vendorProductManagerPage().priceBox;
        pricebox.sendKeys(negativeDataForUS16);
        // Sale Price bilgisini gir
        WebElement salePriceBox = allPages.vendorProductManagerPage().salePriceBox;
        salePriceBox.sendKeys(negativeDataForUS16);
        //  Price kismina invalid bilgiler girilemedigini dogrula	abc, #@$,  space,
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String script = "return arguments[0].value;";
        String actualPriceValue = (String) js.executeScript(script, allPages.vendorProductManagerPage().priceBox);
        Assert.assertTrue(actualPriceValue.isEmpty());
        // Sale Price kismina invalid bilgiler girilemedigini dogrula	abc, #@$,  space,
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
        Assert.assertTrue(Integer.parseInt(actualPriceValue)>Integer.parseInt(actualSalePriceValue));

    }

    @DataProvider(name = "negativeDataForUS16")
    private static Object[][] provideInvalidTestData() {
        return new Object[][] {
                { "xqz" },
                { "$@%"},
                {" "}
        };
    }
    @AfterMethod
    public void tearDown() {
        //    Driver.getDriver().close();
    }
}

