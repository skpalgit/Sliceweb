package pageObjects;

import base.BaseTest;
import io.percy.selenium.Percy;
import org.openqa.selenium.By;

public class LandingPage extends BaseTest {
    public void loginNavigationButton(){
    Percy percy = new Percy(driver);
    driver.findElement(By.xpath("//a[normalize-space()='LOGIN']")).click();
    //percy.snapshot("home page");



}
    public void signupNaviagtionButton(){
        driver.findElement(By.xpath("//a[normalize-space()='SIGNUP']")).click();

    }
}
