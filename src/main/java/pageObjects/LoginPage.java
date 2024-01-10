package pageObjects;

import base.BaseTest;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {
    public void enterUserName(){
        driver.findElement(By.xpath("//*[contains(@name,'email')]")).sendKeys("sandeep.pal@appinventive.com");

    }
    public void enterPassword(){
        //driver.findElement(By.xpath("//input[@id=':ru:']")).click();
        driver.findElement(By.xpath("//*[contains(@name,'password')]")).sendKeys("Test@123");

    }
    public void loginContinueButton(){
        driver.findElement(By.xpath("//button[@type='submit']"));
    }
}
