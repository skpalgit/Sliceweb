package packageTest;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.time.Duration;

public class HomeTest extends BaseTest {
    LandingPage landingPage = new LandingPage();
    HomePage homePage;
    LoginTest loginTest = new LoginTest();
    @Test
    public void setHomePage() throws InterruptedException {
        driver.get(baseURL);
        landingPage.loginNavigationButton();
        extentTest.info("Launching landing screen");
        Thread.sleep(2000);
        loginTest.testLogin();
        homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        homePage.setProgressBar();
        Thread.sleep(2000);
        homePage.setHomeTab();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        extentTest.info("Naviagtion " + driver.getCurrentUrl());
        System.out.print("Navigation " +driver.getCurrentUrl());
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
        homePage.setInvestTab();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        extentTest.info("Naviagtion " + driver.getCurrentUrl());
        System.out.print("Navigation " +driver.getCurrentUrl());
        Thread.sleep(2000);
        homePage.setPortfolioTab();
        Thread.sleep(2000);


        //Created new footertest class for this code
       /* homePage.setFaqsFooter();
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
        homePage.setAppStoreFooter();*/



    }

}
