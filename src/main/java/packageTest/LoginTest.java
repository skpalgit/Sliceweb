package packageTest;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    @Test
    public void testLogin() throws InterruptedException {
        driver.get(baseURL);
        extentTest.info("launch Landing Screen");
        homePage.loginNavigationButton();
        extentTest.info("Clicked Login button ");
        driver.getTitle();
        loginPage.enterUserName();
        extentTest.info("Enter UserName");
        loginPage.enterPassword();
        extentTest.info("Entered password");
        Thread.sleep(2000);
        loginPage.loginContinueButton();
        extentTest.info("Clicked on Continue button");
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String alertMessage = driver.findElement(By.xpath("//div[contains(text(),'Logged-In successfully.')]")).getText();
        String expectedResult ="Logged-In successfully.";
        extentTest.info(alertMessage);
        Assert.assertEquals(alertMessage,expectedResult);

    }


}
