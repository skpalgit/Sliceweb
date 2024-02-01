package packageTest;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.InvestPage;
import pageObjects.LandingPage;

import java.time.Duration;

public class InvestTest extends BaseTest {
    InvestPage investPage;
    LandingPage landingPage =new LandingPage();
    LoginTest loginTest =new LoginTest();
    @Test
    public void InvestTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        loginTest.testLogin();
        homePage.setInvestTab();
        Thread.sleep(2000);
        investPage = new InvestPage(driver);
        investPage.setCheckSlicesRemaining();
        extentTest.info("check......." +driver.getCurrentUrl());
        investPage.setPrimaryInvestVale();
        investPage.setPrimaryInvestBtn();
        extentTest.info("Naviagtion to invest " +driver.getCurrentUrl());
        Thread.sleep(2000);
        investPage.setInvestTnC();
        Thread.sleep(20000000);


    }
}
