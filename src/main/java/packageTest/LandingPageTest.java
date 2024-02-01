package packageTest;

import base.BaseTest;
import pageObjects.LandingPage;
import org.testng.annotations.Test;

import java.time.Duration;

public class LandingPageTest extends BaseTest {
    LandingPage landingPage =new LandingPage();
    @Test
    public void testLoginHomePage(){
        driver.get(baseURL);
        landingPage.loginNavigationButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        extentTest.info("Tap on Login button successfully");
    }
    @Test
    public void testSignupHomePage(){
        driver.get(baseURL);
        landingPage.signupNaviagtionButton();
        extentTest.info("Tap on Signup button successfully");

    }



}

