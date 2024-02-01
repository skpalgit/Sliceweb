package pageObjects;

import base.BaseTest;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseTest {
    public void enterUserName(){
        driver.findElement(By.xpath("//*[contains(@name,'email')]")).sendKeys("dg@yopmail.com");

    }
    public void enterPassword(){
        //driver.findElement(By.xpath("//input[@id=':ru:']")).click();
        driver.findElement(By.xpath("//*[contains(@name,'password')]")).sendKeys("Test@123");

    }
    public void loginContinueButton(){
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.getCurrentUrl();

    }
}
