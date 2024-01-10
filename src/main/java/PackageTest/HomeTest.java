package PackageTest;

import base.BaseTest;
import pageObjects.HomePage;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeTest extends BaseTest {
    HomePage homePage =new HomePage();
    @Test
    public void testLoginHomePage(){
        driver.get(baseURL);
        homePage.loginNavigationButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        extentTest.info("Tap on Login button successfully");
    }
    @Test
    public void testSignupHomePage(){
        driver.get(baseURL);
        homePage.signupNaviagtionButton();
        extentTest.info("Tap on Signup button successfully");

    }



}

