package pageObjects;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class SignupPage extends BaseTest {

    // Constructor to initialize elements using PageFactory
    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(@name,'firstName')]")
    private WebElement firstNameInput ;
    //WebElement firstnameinput = driver.findElement(By.id("//input[@name='firstName']"));
    @FindBy(xpath = "//*[contains(@name,'lastName')]")
    private WebElement lastNameInput ;
    @FindBy(xpath = "//*[contains(@name,'email')]")
    private WebElement emailInput ;
    @FindBy(xpath = "//*[contains(@name,'password')]")
    private WebElement passwordInput ;
    @FindBy(xpath = "//*[contains(@name,'tnc')]")
    private WebElement tncCheckbox ;
    @FindBy(xpath = "//button[normalize-space()='Accept']")
    private WebElement acceptButton;
    @FindBy(xpath = "//button[normalize-space()='CREATE ACCOUNT']")
    private WebElement createAccountBtn;
    @FindBy(xpath = "//h1[normalize-space()='Verify your email']")
    private WebElement verifyUrEmail;
   /* @FindBy(xpath = "//button[@class='btn secondary uppercase']")
    public WebElement acceptTnC;
    @FindBy(xpath = "document.querySelector(\".MuiDialogContent-root.accept_terms_body.css-1ty026z\").scrollTop=12000")
    public WebElement tncPage;*/
   @FindBy(xpath = "//img[@alt='google icon']")
   private WebElement googleSignupLogin;
    @FindBy(xpath = "//img[@alt='facebook icon']")
    private WebElement fbSignupLogin;



    public void enterFirstName() {
        String firstName = generateRandomString(5);
        firstNameInput.sendKeys(firstName);
        extentTest.info("random test "+firstName);
        String val = firstNameInput.getAttribute("value");
        extentTest.info("Entered First Name: " + val);
        extentTest.info("Entered First Name Length: " + val.length());
    }
    public void lastFirstName() {
        String lastName = generateRandomString(5);
        lastNameInput.sendKeys(lastName);
        extentTest.info("random test "+lastName);
        String val = lastNameInput.getAttribute("value");
        extentTest.info("Entered Last Name: " + val);
        extentTest.info("Entered Last Name Length: " + val.length());
    }
    public void setEmailInput(){
        String randomemail = generateRandomEmail(5);
        emailInput.sendKeys(randomemail);
        extentTest.info("generateRandomEmail " +randomemail);

    }
    public void setPasswordInput(){
        String randompassword = generateRandomPassword(8);
        passwordInput.sendKeys(randompassword);
        extentTest.info("generateRandomPassword  " +randompassword);

    }
    public void setTncCheckbox(){

        tncCheckbox.click();
    }
    public void setAcceptTnC(){
        scrollPageToEnd();
       // acceptTnC.click();
    }
    public void setAcceptButton(){

        acceptButton.click();
    }
    public void setCreateaccountBtn(){

        createAccountBtn.click();
    }
    public void setGoogleSignupLogin(){
        googleSignupLogin.click();
    }
    public void setFbSignupLogin(){
        fbSignupLogin.click();
    }




    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }
    public String generateRandomEmail(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }

        // String domain = "example.com";
        String domain = "yopmail.com";
        return sb.toString() + "@" + domain;
    }
    public String generateRandomPassword(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }
        String addchar= "@";
        return sb.toString()+addchar;
    }
    // Function to scroll to the end of the page using JavaScript
    private void scrollPageToEnd() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Execute JavaScript to scroll to the end of the page
        //jsExecutor.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", tncPage);
        jsExecutor.executeScript("document.querySelector(\".MuiDialogContent-root.accept_terms_body.css-1ty026z\").scrollTop=12000");


        //jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }





}
