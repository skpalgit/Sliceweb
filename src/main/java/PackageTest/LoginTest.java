package PackageTest;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    /*@Test
    public void landingPage(){
        driver.get(baseURL);
        homePage.loginNavigationButton();
        extentTest.info("Clicked on Login button successfully");

    }*/
    @Test
    public void testLogin(){
        driver.get(baseURL);
        homePage.loginNavigationButton();
        extentTest.info("Clicked on Login button successfully");
        extentTest.info("launch Landing Screen");
        driver.getTitle();
        loginPage.enterUserName();
        extentTest.info("Enter UserName");
        loginPage.enterPassword();
        extentTest.info("Entered password");
        loginPage.loginContinueButton();
        extentTest.info("Clicked on Continue button");

    }

}
