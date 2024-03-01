package packageTest;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.time.Duration;

public class HomeTest extends BaseTest {
    // Initialize page objects
    LandingPage landingPage = new LandingPage();
    HomePage homePage;
    LoginTest loginTest = new LoginTest();

    @Test
    public void setHomePage() throws InterruptedException {
        // Navigate to the base URL
        driver.get(baseURL);

        // Navigate to the login page
        landingPage.loginNavigationButton();

        // Log information about launching the landing screen
        extentTest.info("Launching landing screen");

        // Wait for 2 seconds
        Thread.sleep(2000);

        // Perform login action
        loginTest.testLogin();

        // Initialize HomePage with driver
        homePage = new HomePage(driver);

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Interact with the progress bar on the home page
        homePage.setProgressBar();

        // Wait for 2 seconds
        Thread.sleep(2000);

        // Navigate to the Home tab
        homePage.setHomeTab();

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Log and print the current URL after navigation
        extentTest.info("Navigation " + driver.getCurrentUrl());
        System.out.print("Navigation " +driver.getCurrentUrl());

        // Various interactions with the home page
        homePage.setPerksOfInvestment();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        homePage.getYourElementList();
        Thread.sleep(2000);
        homePage.setJustSliceThings();
        Thread.sleep(2000);
        homePage.setBlogs();
        Thread.sleep(2000);
        homePage.setGetStarted();
        Thread.sleep(2000);
        homePage.setSliceAmbassadors();
        Thread.sleep(2000);

        // Navigate to the Invest tab
        homePage.setInvestTab();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Log and print the current URL after navigation to the Invest tab
        extentTest.info("Navigation " + driver.getCurrentUrl());
        System.out.print("Navigation " +driver.getCurrentUrl());

        // Wait for 2 seconds
        Thread.sleep(2000);

        // Navigate to the Portfolio tab
        homePage.setPortfolioTab();
        Thread.sleep(2000);

        // The following code is for interacting with various elements in the footer
        // It has been commented out and moved to a separate FooterTest class for better organization
        /*
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
        */
    }
}
