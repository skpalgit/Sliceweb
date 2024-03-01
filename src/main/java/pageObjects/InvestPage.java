package pageObjects;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;

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
    @FindBy(xpath = "//div[@class='right_col']//button[1]")
    private WebElement investBtn;
    @FindBy(css = "div[class='checkout_invest_wrapper'] h2")
    private WebElement investmentAmount;
    @FindBy(css = "div[class='d_flex'] p")
    private WebElement investAmount;
    public void setCheckSlicesRemaining(){
        //check the remaining slice in live property
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
    /*public void setPrimaryInvestVale(){
        extentTest.info("invest value " + primaryInvestVale.getText());
        String investValeText = primaryInvestVale.getText();

        // Using a regular expression to remove non-numeric characters except the decimal point
        String numericValueString = investValeText.replaceAll("[^\\d.]", "");

        try {
            // Parse the string to double and then convert to int
            double totalInvestDouble = Double.parseDouble(numericValueString);
            float totalInvest = (float) Math.abs(totalInvestDouble);
            //float totalInvest = (int) totalInvestDouble;
            //default slice for the user
            extentTest.info("Total invest value " + totalInvest);
        } catch (NumberFormatException e) {
            extentTest.log(Status.valueOf("Failed to parse invest value: " + numericValueString), e);
        }
    }*/
    public float setPrimaryInvestValue( ) {
        String investText = investAmount.getText();
        // Assuming investText is something like "AED 1234.56"
        String numericValueString = investText.replaceAll("[^\\d.]", "");
        float investmentAmountValue = 0.00f;
        try {
            investmentAmountValue = Float.parseFloat(numericValueString);
            extentTest.info("Investment Amount value: " + investmentAmountValue);
        } catch (NumberFormatException e) {
            extentTest.log(Status.valueOf("Failed to parse investment amount value: " + numericValueString), e);
        }
        return investmentAmountValue;
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
        //acceptTnc.click();


    }

    public void setAcceptTnc() {
        acceptTnc.click();
    }

    public void scrollInvestTnC(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("document.querySelector(\".MuiDialogContent-root.accept_terms_body.css-1ty026z\").scrollTop=12000");
        setPrimaryInvestValue();
    }
    public void setInvestBtn(){
        /*JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");*/
        investBtn.click();
        extentTest.info("get navigation " +driver.getCurrentUrl());
    }
    public void setInvestmentAmount(float f) {
        // Get the text from the WebElement
        String investText = investmentAmount.getText();
        extentTest.info("Print investText: " + investText);

        // Remove non-numeric characters, except the decimal point and digits.
        String numericValueStr = investText.replaceAll("[^\\d.]", "");
        extentTest.info("Numeric part of investText: " + numericValueStr);

        // Parse the cleaned string as a float.
        float matchValue = Float.parseFloat(numericValueStr);
        extentTest.info("Parsed numeric value: " + matchValue);

        // Define a small threshold for comparing floating-point numbers to handle precision issues.
        final float EPSILON = 0.001f;
        if (Math.abs(matchValue - f) < EPSILON) {
            extentTest.info("Match found with value: " + matchValue);
        } else {
            extentTest.info("No match. Parsed value: " + matchValue + ", Expected: " + f);
        }
    }

}
