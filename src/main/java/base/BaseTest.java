package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    @BeforeSuite
    public void initiateExtentReports() {
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("AllTests.html");
        extentReports.attachReporter(sparkReporter_all);

        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.name"));
    }
    @AfterSuite
    public void generateExtentReports() throws IOException {
        extentReports.flush();
        try {
            Desktop.getDesktop().browse(new File("AllTests.html").toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // This method is used to generate the Extent Report
    @AfterMethod
public <result> void checkStatus(Method m,  ITestResult result){
        if(result.getStatus())==ITestResult.FAILURE {
            String screenshotPath=null;
            screenshotPath =captureScreenShot(result.getTestContext().getName()+ ""+result.getMethod().getMethodName()+".jpeg");
            extentTest.
        }
    }

    private String captureScreenShot(String s) {

    }

    @Parameters("browser")
    public void beforeMethod(String browser){

    }
    @AfterMethod
    @AfterTest
}
