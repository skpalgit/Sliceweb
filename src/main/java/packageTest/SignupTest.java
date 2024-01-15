package packageTest;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignupPage;

import java.time.Duration;

public class SignupTest extends BaseTest {
    HomePage homePage = new HomePage();
    SignupPage signupPage;

    @Test
    public void testSignup() throws InterruptedException {
        driver.get(baseURL);
        homePage.signupNaviagtionButton();
        extentTest.info("Launching landing screen");
        Thread.sleep(2000);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        signupPage = new SignupPage(driver);  // Initialize SignupPage with the WebDriver
        signupPage.enterFirstName();
        extentTest.info("Enter first name");
        Thread.sleep(1000);
        signupPage.lastFirstName();
        extentTest.info("Enter first name");
        Thread.sleep(2000);
        signupPage.setEmailInput();
        extentTest.info("Enter email");
        Thread.sleep(1000);
        signupPage.setPasswordInput();
        extentTest.info("Enter Password");
        Thread.sleep(1000);
        signupPage.setTncCheckbox();
        extentTest.info("Click Checkbox");
        Thread.sleep(2000);
        signupPage.setAcceptTnC();
        extentTest.info("AcceptTnC");
        Thread.sleep(1000);
        signupPage.setContimueButton();
        Thread.sleep(20000);
    }
}
