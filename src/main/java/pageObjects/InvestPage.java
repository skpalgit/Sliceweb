package pageObjects;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

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
    @FindBy(xpath = "//div[@class='card_body']")
    private WebElement liveCard;
    @FindBy(xpath = "//button[@class='btn primary']")
    private WebElement primaryInvestBtn;
    @FindBy(xpath = "//div[@class='counter_wrapper space_between']//p[1]")
    private WebElement primaryInvestVale;
    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    private WebElement investTnC;
    @FindBy(xpath = "//button[normalize-space()='Accept']")
    private WebElement acceptTnc;
    public void setCheckSlicesRemaining(){
        String getValue = checkSlicesRemaining.getText();
        extentTest.info("get value " +getValue);
        String[] sliceParts = getValue.split(" ");
        String remainingSlices = sliceParts[2];
        String[] sliceCounts = remainingSlices.split("/");
        // Gets the last part, which should be total slice of property
        //String sliceTotal =sliceParts[sliceParts.length-1];
        int sliceLeft = Integer.parseInt(sliceCounts[0]);
        extentTest.info("Slice left " +sliceLeft);
        if (sliceLeft>0){
            liveCard.click();
            extentTest.info("Clicked on Live Property");

        }



    }
    public void setPrimaryInvestVale(){
        extentTest.info("invest value " + primaryInvestVale.getText());
        String investValeText = primaryInvestVale.getText();

        // Using a regular expression to remove non-numeric characters except the decimal point
        String numericValueString = investValeText.replaceAll("[^\\d.]", "");

        try {
            // Parse the string to double and then convert to int
            double totalInvestDouble = Double.parseDouble(numericValueString);
            float totalInvest = (float) Math.abs(totalInvestDouble);
            //float totalInvest = (int) totalInvestDouble;
            extentTest.info("Total invest value " + totalInvest);
        } catch (NumberFormatException e) {
            extentTest.log(Status.valueOf("Failed to parse invest value: " + numericValueString), e);
        }
    }
    public void setPrimaryInvestBtn(){
        String getBtn = String.valueOf(primaryInvestBtn.isEnabled());
        extentTest.info("Check invest button is enabled");
        if(getBtn == String.valueOf(true)){
            primaryInvestBtn.click();

        }
    }
    public void setInvestTnC(){
        investTnC.click();
        scrollInvestTnC();
        acceptTnc.click();


    }
    public void scrollInvestTnC(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }
}
