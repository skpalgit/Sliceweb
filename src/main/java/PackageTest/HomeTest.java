package PackageTest;

import base.BaseTest;
import pageObjects.HomePage;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
    HomePage homePage =new HomePage();
    @Test
    public void testLoginHomePage(){
        driver.get(baseURL);
        homePage.loginNavigationButton();
    }



}

