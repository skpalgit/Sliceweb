package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ReadConfig;
import io.percy.selenium.Percy;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    // Configuration and browser setup
    ReadConfig readConfig = new ReadConfig();
    public String browser = readConfig.getBrowser();
    public String baseURL = readConfig.getWebUrl();

    // Initialize ExtentReports before the test suite starts
    @BeforeSuite
    public void initiateExtentReports() {
        extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("AllTests.html");
        extentReports.attachReporter(sparkReporter_all);
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
    }

    // Generate and open the Extent Report after all tests are completed
    @AfterSuite
    public void generateExtentReport() {
        try {
            extentReports.flush();
            Desktop.getDesktop().browse(new File("AllTests.html").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // After each test method, check the test's status and take necessary actions
    @AfterMethod
    public void checkStatus(Method m, ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = captureScreenshot(result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + ".jpg");
            extentTest.addScreenCaptureFromPath(screenshotPath);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.pass(m.getName() + " is passed");
        }
        extentTest.assignCategory(m.getAnnotation(Test.class).groups());
        extentTest.assignCategory(m.getAnnotation(Test.class).testName());
    }

    // Capture screenshot and save to reports directory
    public static String captureScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("./reports/" + fileName);
        try {
            FileUtils.copyFile(sourceFile, destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot saved successfully");
        return destinationFile.getAbsolutePath();
    }

    // Launch the browser specified in the configuration before each test method
    @BeforeMethod
    public void launchBrowser(ITestContext context) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
        extentTest = extentReports.createTest(context.getName());
        String author = context.getCurrentXmlTest().getParameter("author");
        // The following line is commented out but it's used to assign author name in the report
        // extentTest.assignAuthor(author);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    // Quit the browser after each test method
    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    // Capture screenshot in base64 format
    public static String captureScreenShotBase64() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        String base64 = ts.getScreenshotAs(OutputType.BASE64);
        System.out.println("Screenshot saved successfully using base64");
        return base64;
    }

    // Utility methods for interacting with web elements and navigating the browser
    public void closeCurrentWindow() { driver.close(); }
    public void elementSendData(WebElement element, String data) { element.sendKeys(data); }
    public void quitBrowser() { driver.quit(); }
    public WebElement elementById(String idAttributeValue) { return driver.findElement(By.id(idAttributeValue)); }
    public WebElement elementByName(String nameAttributeValue) { return driver.findElement(By.name(nameAttributeValue)); }
    public WebElement elementByClassName(String classNameAttributeValue) { return driver.findElement(By.className(classNameAttributeValue)); }
    public WebElement elementByXpath(String xpath) { return driver.findElement(By.xpath(xpath)); }
    public String elementText(WebElement element) { return element.getText(); }
    public void Click(WebElement element) { element.click(); }
    public void refresh() { driver.navigate().refresh(); }
    public void backward() { driver.navigate().back(); }
    public void forward() { driver.navigate().forward(); }
}
