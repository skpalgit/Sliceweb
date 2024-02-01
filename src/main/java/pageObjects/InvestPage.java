package pageObjects;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvestPage extends BaseTest {
    public InvestPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "(//div[@class='overlay_blur live-overlay'])")
    private WebElement lockedProperty;
    @FindBy(xpath = "(//div[@class='status_btn'])")
    private WebElement propertyStatus;
    @FindBy(xpath = "//div[@class='slices_remaining']/p")
    private WebElement checkSlicesRemaining;
    public void setCheckSlicesRemaining(){
        String getValue = checkSlicesRemaining.getText();
        extentTest.info("get value " +getValue);
        String[] sliceParts = getValue.split(" ");
        String remainingSlices = sliceParts[2];
        String[] sliceCounts = remainingSlices.split("/");
        // Gets the last part, which should be total slice of property
        //String sliceTotal =sliceParts[sliceParts.length-1];
        String sliceLeft = sliceCounts[0];
        extentTest.info("Slice left " +sliceLeft);


    }
}
