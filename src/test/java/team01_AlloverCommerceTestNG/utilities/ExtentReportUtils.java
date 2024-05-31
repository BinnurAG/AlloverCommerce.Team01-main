
package team01_AlloverCommerceTestNG.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Bu sınıf ExtentReports kullanarak test raporları oluşturmak için yardımcı metodlar içerir.
 */
public class ExtentReportUtils {
    private static ExtentReports extentReports;
    private static ExtentHtmlReporter extentHtmlReporter;
    private static ExtentTest extentTest;

    /**
     * ExtentReports nesnesini ve HTML raporlama nesnesini kurar.
     *
     * @param "My Extend Report" Oluşturulacak raporun adı
     */
    public static void setUpExtentReport(String qaNAme, String testName) {
        if (extentReports == null) { // ExtentReports nesnesi oluşturulmamış ise
            // Bu objecti raporları oluşturmak ve yönetmek için kullanacağız
            extentReports = new ExtentReports();

            // Öncelikle oluşturmak istediğimiz HTML raporu projemizde nerede saklamak istiyorsak bir dosya yolu oluşturmalıyız
            String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
            String path = "target/extentReport/" + date + " htmlReport.html";
            extentHtmlReporter = new ExtentHtmlReporter(path);

            // ExtentsReports'a HTML raporlayıcı ekler, ve bu raporun HTML formatında oluşturulmasını sağlar
            extentReports.attachReporter(extentHtmlReporter);

            // HTML raporun belge başlığını ayarlar
            extentHtmlReporter.config().setDocumentTitle("Allover Commerce Test Raporu");

            // Raporda gösterilecek olan genel başlığı ayarlar
            extentHtmlReporter.config().setReportName("My Extend Report");

            // Bu HTML raporunda görmek isteyebileceğimiz diğer bilgileri aşağıdaki şekilde ekleyebiliriz
            extentReports.setSystemInfo("Environment", "QA");
            extentReports.setSystemInfo("Browser", "Chrome");
            extentReports.setSystemInfo("Test Automation Engineer",qaNAme);

             extentTest = extentReports.createTest(testName,"Test Steps");
        }
    }

    /**
     * Yeni bir test için ExtentTest nesnesi oluşturur.
     *
     * @param testName Yeni bir test adı oluşturur
     * @param description Açıklamasını ekler
     */
    public static void createExtentTest(String testName, String description) {
        extentTest = extentReports.createTest(testName, "<span style='color:green; font-weight:bold'> " + description + " </span>");
    }

    /**
     * Test başarılı olduğunda çalışacak metod.
     *
     * @param message Başarılı test mesajı
     */
    public static void extentTestPass(String message) {
        if (extentTest != null) {
            extentTest.pass(message);
        }
    }

    /**
     * Test başarısız olduğunda çalışacak metod.
     *
     * @param message Başarısız test mesajı
     */
    public static void extentTestFail(String message) {
        if (extentTest != null) {
            extentTest.fail(message);
        }
    }

    /**
     * Test hakkında bilgi ekler.
     *
     * @param message Test bilgi mesajı
     */
    public static void extentTestInfo(String message) {
        if (extentTest != null) {
            extentTest.info(message);
        }
    }

    /**
     * Bu metod ile rapora ekran görüntüsü eklenir.
     */
    public static void addScreenShotToReport() {
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "src/test/java/team01_AlloverCommerceTestNG/reports/screenShotsReport" + date + ".png";
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        try {
            Files.write(Paths.get(path), ts.getScreenshotAs(OutputType.BYTES));
            extentTest.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\" + path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Bir web elementin görüntüsünü alıp rapora ekler.
     *
     * @param webElement Görüntüsü alınmak istenen WebElement
     */
    public static void addScreenShotOfWebElementToReport(WebElement webElement) {
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "src/test/java/team01_AlloverCommerceTestNG/reports/webElementSSReport" + date + ".png";
        try {
            Files.write(Paths.get(path), webElement.getScreenshotAs(OutputType.BYTES));
            extentTest.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\" + path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Raporlama işlemlerini sonlandırır ve raporu kaydeder.
     */
    public static void flush() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}