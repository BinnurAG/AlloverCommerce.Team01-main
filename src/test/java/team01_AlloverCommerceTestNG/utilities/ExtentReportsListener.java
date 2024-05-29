package team01_AlloverCommerceTestNG.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import team01_AlloverCommerceTestNG.utilities.Driver;
import team01_AlloverCommerceTestNG.utilities.ExtentReportUtils;



public class ExtentReportsListener implements ITestListener {

    /**
     * onstart==> Tum testlerden once tek bir kez cagrilir
     * Böylece icine yazdigimiz kodlar sayesinde test başladığında raporlama baslatilir.
     * @param context TestNG context nesnesi
     */
    @Override
    public void onStart(ITestContext context) {

        ExtentReportUtils.setUpExtentReport(context.getCurrentXmlTest().getName(), context.getCurrentXmlTest().getName());

    }

    /**
     * onTestStart==> her bir @Test methodundan once bir kez cagrilir
     * Böylece Test methoduna başlandığında, testName ve description verileri alınarak rapora eklenir.
     * @param result Test sonucu nesnesi
     */
    @Override
    public void onTestStart(ITestResult result) {

        // Metod ismini kullanarak test aciklamasina baslik olarak ekliyoruz
        String testName = result.getMethod().getMethodName();

        //Test methodlarinin parantez icined description parametresiyle yazmis oldugumuz aciklamalari
        // dynamic olarak rapora ne testi oldugunu yansitabiliriz
        // mesela test caselerdeki test objective buraya yazilabilir
        String description = result.getMethod().getDescription(); // Metod açıklamasını kullanarak description alıyoruz

        ExtentReportUtils.createExtentTest(description,testName );
    }

    /**
     * onTestSuccess==> sadece pass olan testlerden sonra bir kez cagrilir
     * Test başarılı olduğunda, başarılı mesajı eklenir.
     * @param result Test sonucu nesnesi
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        /*
        Bu kod, Extent Reports ile bir testin başarıyla tamamlandığını belirten bir mesajı raporlamak için kullanılır.
        Mesaj, HTML biçimlendirmesi ile yeşil ve kalın bir şekilde görüntülenir ve sonuna bir yeşil onay işareti eklenir.
        Bu, test raporunda görsel olarak belirgin bir başarı işareti sağlar.
         */
        String passIsareti = "&#9989";
        ExtentReportUtils.extentTestPass("<span style='color:green; font-weight:bold'>Test başarıyla tamamlandı. </span>" + passIsareti);
        ExtentReportUtils.extentTestPass(result.getName());
    }

    /**
     * onTestFailure==> sadece fail olan testlerden sonra bir kez cagrilir
     * Test başarısız olduğunda, ekran görüntüsü alınır ve raporlama oluşturulur.
     * @param result Test sonucu nesnesi
     */
    @Override
    public void onTestFailure(ITestResult result) {
        /*
        Bu kod, Extent Reports ile bir testin başarısız olduğunu belirten bir mesajı raporlamak için kullanılır.
        Mesaj, HTML biçimlendirmesi ile kırmızı ve kalın bir şekilde görüntülenir ve sonuna bir kırmızı çarpı işareti eklenir.
        Bu, test raporunda görsel olarak belirgin bir başarısızlık işareti sağlar.
         */
        // Fail mesajı ekleme
        String failIsareti = "&#10060";
        ExtentReportUtils.extentTestFail("<span style='color:red; font-weight:bold'>Test başarısız oldu! </span>" + failIsareti);
        ExtentReportUtils.extentTestFail(result.getName());
        // Raporlama
        try {
            ExtentReportUtils.addScreenShotToReport();
        } catch (Exception e) {
            ExtentReportUtils.extentTestInfo("Rapora ekran görüntüsü eklenirken hata meydana geldi");
        } finally {
            Driver.closeDriver();
        }
    }

    /**
     * onfinish==> Tum testlerden sonra tek bir kez cagrilir
     * Böylece tüm testler bittiğinde raporlama kapatılır.
     * @param context TestNG context nesnesi
     */
    @Override
    public void onFinish(ITestContext context) {
        ExtentReportUtils.flush();
    }
}
