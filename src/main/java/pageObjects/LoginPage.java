package pageObjects;

import base.BaseTest;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[contains(@name,'email')]")
    private WebElement enterUserName;
    @FindBy(xpath = "//*[contains(@name,'password')]")
    private WebElement enterPassword;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginContinueButton;
    public void setEnterUserName(){
        enterUserName.sendKeys("dg@yopmail.com");

    }
    public void setEnterPassword(){
        //driver.findElement(By.xpath("//input[@id=':ru:']")).click();
        enterPassword.sendKeys("Test@123");

    }
    public void setLoginContinueButton(){
        loginContinueButton.click();
       //extentTest.info("Navigate to home page" +driver.getCurrentUrl());

    }
}
