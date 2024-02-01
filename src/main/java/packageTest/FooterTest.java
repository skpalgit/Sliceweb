package packageTest;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LandingPage;

import java.time.Duration;

public class FooterTest extends BaseTest {
    HomePage homePage;
    LandingPage landingPage =new LandingPage();
    LoginTest loginTest =new LoginTest();
    @Test
    public void TestFooter() throws InterruptedException {
        homePage = new HomePage(driver);
        driver.get(baseURL);
        landingPage.loginNavigationButton();
        extentTest.info("Launching landing screen");
        Thread.sleep(2000);
        loginTest.testLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        homePage.setFaqsFooter();
        Thread.sleep(2000);
        homePage.setPrivacyPolicy();
        Thread.sleep(2000);
        homePage.setTermsAndCondition();
        Thread.sleep(2000);
        homePage.setFbFooter();
        homePage.setInstagramFooter();
        homePage.setPinterestFooter();
        homePage.setTwitterFooter();
        homePage.setYoutubeFooter();
        homePage.setPlayStoreFooter();
        homePage.setAppStoreFooter();
    }
}
