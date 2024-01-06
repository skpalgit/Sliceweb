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

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public String baseURL=ReadConfig.getWebUrl();
    // calling the method from Readconfig class
    ReadConfig readConfig = new ReadConfig();
    public String browser = readConfig.getBrowser();

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
    public void checkStatus(Method m, ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = null;
            screenshotPath = String.valueOf(captureScreenshot(result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + ".jpg"));
            extentTest.addScreenCaptureFromPath(screenshotPath);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.pass(m.getName() + " is passed");
        }

        extentTest.assignCategory(m.getAnnotation(Test.class).groups());

        extentTest.assignCategory(m.getAnnotation(Test.class).testName());


    }

    public static String captureScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("./reports/" + fileName);
        try {
            FileUtils.copyFile(sourceFile, destinationFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Screenshot saved successfully");
        return destinationFile.getAbsolutePath();

    }



@BeforeMethod
    public <context> void launchBrowser(ITestContext context, String browser){
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();

        }
        driver.manage().window().maximize();
    // getCurrentXmlTest method is used to author name via getParameter method

    extentTest = extentReports.createTest(context.getName());
    String author = context.getCurrentXmlTest().getParameter("author");

    // assignAuthor is used to display author name in Extent Report

    extentTest.assignAuthor(author);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    // to quit the browser
    @AfterTest
    public void tearDown(){
    driver.quit();
    }
    // to capture the screenshot
    public static String captureScreenShotBase64() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        String base64 = ts.getScreenshotAs(OutputType.BASE64);
        System.out.println("Screenshot saved successfully using base64");
        return base64;
    }
    public void closeCurrentWindow() {
        driver.close();
    }

    public void elementSendData(WebElement element, String data) {
        element.sendKeys(data);
    }

    public void quitBrowser() {
        driver.quit();
    }

    public WebElement elementById(String idAttributeValue) {
        WebElement element = driver.findElement(By.id(idAttributeValue));
        return element;
    }

    public WebElement elementByName(String nameAtrributeValue) {
        WebElement element = driver.findElement(By.name(nameAtrributeValue));
        return element;
    }

    public WebElement elementByClassName(String classNameAtrributeValue) {
        WebElement element = driver.findElement(By.name(classNameAtrributeValue));
        return element;
    }

    public WebElement elementByXpath(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        return element;
    }

    public String elementText(WebElement element) {
        String text = element.getText();
        return text;
    }

    public void Click(WebElement element) {
        element.click();
    }



}
