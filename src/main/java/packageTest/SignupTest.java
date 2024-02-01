package packageTest;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.SignupPage;

public class SignupTest extends BaseTest {
    LandingPage landingPage = new LandingPage();
    SignupPage signupPage;

    @Test
    public void testSignup() throws InterruptedException {
        driver.get(baseURL);
        landingPage.signupNaviagtionButton();
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
        Thread.sleep(3000);
        signupPage.setAcceptButton();
        Thread.sleep(2000);
        signupPage.setCreateaccountBtn();
        extentTest.info("We have sent a verification link to your email account");
        Thread.sleep(2000);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        /*String alertMessage = driver.findElement(By.xpath("//div[contains(text(),'We have sent a verification link to your email account')]')]")).getText();
        String expectedResult ="We have sent a verification link to your email account";
        extentTest.info(alertMessage);
        Assert.assertEquals(alertMessage,expectedResult);*/
    }
}
