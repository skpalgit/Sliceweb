package packageTest;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.SignupPage;

public class GoogleSignupLogin extends BaseTest {
    SignupPage signupPage;
    LandingPage landingPage = new LandingPage();

    @Test
    public void setSignupPage() throws InterruptedException {
        driver.get(baseURL);
        landingPage.signupNaviagtionButton();
        // Initialize the SignupPage object before running the tests
        signupPage = new SignupPage(driver);
        signupPage.setGoogleSignupLogin();
        Thread.sleep(8000);
        extentTest.info("Google popup opened");

    }

}
