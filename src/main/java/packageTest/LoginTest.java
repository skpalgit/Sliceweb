package packageTest;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {
    LandingPage landingPage = new LandingPage();
    LoginPage loginPage;
    @Test
    public void testLogin() throws InterruptedException {
        driver.get(baseURL);
        extentTest.info("launch Landing Screen");
        landingPage.loginNavigationButton();
        extentTest.info("Clicked Login button ");
        driver.getTitle();
        loginPage= new LoginPage(driver);
        Thread.sleep(2000);
        loginPage.setEnterUserName();
        extentTest.info("Enter UserName");
        loginPage.setEnterPassword();
        extentTest.info("Entered password");
        Thread.sleep(2000);
        loginPage.setLoginContinueButton();
        extentTest.info("Clicked on Continue button");
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String alertMessage = driver.findElement(By.xpath("//div[contains(text(),'Logged-In successfully.')]")).getText();
        String expectedResult ="Logged-In successfully.";
        extentTest.info(alertMessage);
        Assert.assertEquals(alertMessage,expectedResult);
        Thread.sleep(2000);

    }


}
