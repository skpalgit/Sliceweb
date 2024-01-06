package pageObjects;

import base.BaseTest;
import org.openqa.selenium.By;

public class HomePage extends BaseTest {
public void loginNavigationButton(){
    driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div[2]/div/div[2]/a[1]"));

}
}
