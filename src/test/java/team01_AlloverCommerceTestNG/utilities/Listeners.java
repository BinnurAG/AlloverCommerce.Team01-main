package team01_AlloverCommerceTestNG.utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Listeners implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onstart==> Tum testlerden once tek bir kez cagrilir"+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onfinish==> Tum testlerden sonra tek bir kez cagrilir"+context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart==> her bir @Test methodundan once bir kez cagrilir" + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess==> sadece pass olan testlerden sonra bir kez cagrilir" + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure==> sadece fail olan testlerden sonra bir kez cagrilir" + result.getName());
        ReusableMethods.screenShot(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped==> sadece atlanan testlerden sonra bir kez cagrilir" + result.getName());
    }

    /*
    Bu methodun amaci sadece bir test basarisiz oldugu zaman o testi yeniden kac defa calistiracağımızi belirlemektir
    maxRetryCount = 1; ==>ek olarak calisma sayisidir
    Bu ornekte fail olan test normal bir kere calistiktan sonra bir kere daha bu methodun calismasini saglayacak
    buraya kac yazarsak o kadar tekrar calisir
     */
    private static int retryCount = 0;
    private static final int maxRetryCount = 1;
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

    /*
    Bu method bir test methoduna bir RetryAnalyzer eklemek icin kullanilir
    Listeners classindaki retry methodunu yani yukarida yazmis oldugumuz methodu RetryAnalyzer olarak ayarlar
    Bu sayede test fail oldugu zaman Listeners clasimizdaki bu retry methodu cagrilir ve yukaridaki tekar calistirma uygulanmis olacak
     */

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        annotation.setRetryAnalyzer(Listeners.class);
    }

}
