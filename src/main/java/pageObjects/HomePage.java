package pageObjects;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HomePage extends BaseTest {
    // Constructor to initialize elements using PageFactory
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='complete_bar']")
    private WebElement progressBar;
    @FindBy(xpath = "//h3[normalize-space()='HOME']")
    private WebElement homeTab;
    @FindBy(xpath = "//img[@alt='explore icon']")
    private WebElement investTab;
    @FindBy(xpath = "//img[@alt='passport icon']")
    private WebElement portfolioTab;

    @FindBy(xpath = "//h3[normalize-space()='PERKS OF INVESTMENT']")
    private WebElement perksOfInvestment;
    //@FindBy(how = How.TAG_NAME, using = "a")
    @FindBy(className = "investment_body")
    private List<WebElement> poiIndexList;
    @FindBy(xpath = "//h2[normalize-space()='JUST SLICE THINGS']")
    private  WebElement justSliceText;
    @FindBy(xpath = "(//div[@class='slice_carousal_card'])[1]")
    private List<WebElement> justSliceThings;
    @FindBy(xpath = "//h3[normalize-space()='BLOGS']")
    private WebElement blogsTab;
    @FindBy(xpath = "(//button[normalize-space()='View all'])[1]")
    private WebElement blogsViewAll;
    /*@FindBy(xpath = "//button[normalize-space()='View all']")
    private WebElement blogsViewAll;*/
    @FindBy(xpath = "//button[normalize-space()='Get Started']")
    private WebElement getStarted;
    @FindBy(xpath = "//div[@class='rewards_cards']")
    private List<WebElement> getRewardList;
    @FindBy(xpath = "//h2[normalize-space()='SLICE AMBASSADORS']")
    private WebElement sliceAmbassadors;
    @FindBy(xpath = "(//a[contains(@class,'ambassadors_carousel')])")
    private List<WebElement> ambassadorsList;
    @FindBy(xpath = "//h3[normalize-space()='NEWS']")
    private WebElement newsCarousel;
    @FindBy(xpath = "//a[contains(text(),'FAQ’s')]")
    private WebElement faqsFooter;
    @FindBy(xpath = "(//div[contains(@class,'faqlist')])")
    private List<WebElement> faqLists;
    @FindBy(xpath = "//a[normalize-space()='Privacy Policy']")
    private WebElement privacyPolicy;
    @FindBy(xpath = "//a[normalize-space()='Terms & Conditions']")
    private WebElement termsAndCondition;
    @FindBy(xpath = "//a[@href='https://www.facebook.com/slice.ooo/']")
    private WebElement fbFooter;
    @FindBy(xpath = "//a[@href='https://twitter.com/Slicesuperapp']")
    private WebElement twitterFooter;
    @FindBy(xpath = "//a[@href='https://www.instagram.com/slicesuperapp/']")
    private WebElement instagramFooter;
    @FindBy(xpath = "//ul[@class='socialiconwrap']//li[1]//a[1]")
    private WebElement youtubeFooter;
    @FindBy(xpath = "//a[@href='https://in.pinterest.com/Slicesuperapp/']//img")
    private WebElement pinterestFooter;
    @FindBy(xpath = "//a[@href='https://play.google.com/']//img[@alt='google play store icon']")
    private WebElement playStoreFooter;
    @FindBy(xpath = "//a[@href='https://www.apple.com/in/app-store/']//img[@alt='google play store icon']")
    private WebElement appStoreFooter;
    @FindBy(xpath = "//img[contains(@alt,'website logo')]")
    private WebElement webLogo;

    public void setProgressBar() {
        if (progressBar.isDisplayed()) {
            String barPercentage = progressBar.getText();
            System.out.print(barPercentage);
            extentTest.info("COMPLETE YOUR PROFILE  " + barPercentage);
            System.out.print("COMPLETE YOUR PROFILE " + barPercentage);
            String expectedResult = "Logged-In successfully.";
            if (barPercentage == "100%") {
                System.out.print("User KYC completed");
                extentTest.info("User KYC completed" + barPercentage);

            }

        }
    }

    public void setHomeTab() {
        extentTest.info("Home Tab " + homeTab.getText());
        homeTab.click();
    }


    public void setPerksOfInvestment() {
        extentTest.info("Perk of investment " + perksOfInvestment.getText());
        perksOfInvestment.isEnabled();
        perksOfInvestment.click();
    }

    public void getYourElementList() {
        //Dynamic selection using Random class
        for (WebElement option : poiIndexList){
            String selectPotion = option.getText();
            extentTest.info("PERKS OF INVESTMENT:- " +option.getText());
            System.out.print("PERKS OF INVESTMENT :- " +selectPotion);
           /* if(!poiIndexList.isEmpty())
            {
                for(WebElement ele:poiIndexList)
                    ele.click();
            }*/
        }
        // Getting size of options available
        int size =poiIndexList.size();
        // Generate a random number with in range
        int randomNumber = ThreadLocalRandom.current().nextInt(0,size);
        // Selecting random value
        poiIndexList.get(randomNumber).click();

    }
    public void setJustSliceThings() {
        //Dynamic selection using Random class
        for (WebElement option : justSliceThings){
            String selectPotion = option.getText();
            extentTest.info("JUST SLICE THINGS :- " +option.getText());
            System.out.print("JUST SLICE THINGS :- " +selectPotion);
        }
        // Getting size of options available
        int size =justSliceThings.size();
        // Generate a random number with in range
        int randomNo = ThreadLocalRandom.current().nextInt(0,size);
        // Selecting random value
        justSliceThings.get(randomNo).click();

    }
    public void setBlogs() throws InterruptedException {
        extentTest.info("Check blogs is active " +blogsTab.getText());
        extentTest.info("Check blogs View All button is available " +blogsViewAll);
        blogsViewAll.click();
        extentTest.info("Verify Navigation of View All " +driver.getCurrentUrl());
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        Thread.sleep(2000);
        homeTab.click();
    }
    public void setGetStarted(){
        extentTest.info("Verify Get Started button is active " +getStarted.isEnabled());
        extentTest.info("Verify Get Started button is active " +getStarted.isDisplayed());
        getStarted.click();
        extentTest.info("Verify naviagtion of Get Started button " +driver.getCurrentUrl());
        for(WebElement rewardsList : getRewardList){
            extentTest.info("Rewards Lists "+rewardsList.getText());
        }
        homeTab.click();
    }
    public void setSliceAmbassadors() throws InterruptedException {
        extentTest.info("Verify Slice Ambassador is active " +sliceAmbassadors.isDisplayed());
        for (WebElement webElement : ambassadorsList) {
            extentTest.info("Slice Ambassadors List " + webElement.getText());
            String selectAmbassador= webElement.getText();
            //extentTest.info("Tapping on " + selectAmbassador);
            Thread.sleep(2000);
        }
        int size =ambassadorsList.size();
        int randomNumber = ThreadLocalRandom.current().nextInt(0,size);
        //ambassadorsList.get(randomNumber).click();

    }
    public void setNewsCarousel(){
        //add code here for news
    }
    public void setInvestTab() {
        investTab.click();
        extentTest.info("Invest tab naviagtion" + driver.getCurrentUrl());
    }
    public void setPortfolioTab() throws InterruptedException {
        extentTest.info("Portfolio " + portfolioTab.getText());
        portfolioTab.isEnabled();
        Thread.sleep(2000);
        portfolioTab.click();
    }
    public void setFaqsFooter() throws InterruptedException {
        extentTest.info("Verify FAQ's is available " +faqsFooter.isDisplayed());
        faqsFooter.click();
        for (WebElement faq :faqLists){
            String selectFaq = faq.getText();
            extentTest.info("Faq lists here " +faq.getText());
        }
        Thread.sleep(2000);
        homeTab.click();
    }
    public void setPrivacyPolicy() throws InterruptedException {
        extentTest.info("Verify Privacy and Policy is available " +privacyPolicy.isDisplayed());
        privacyPolicy.click();
        Thread.sleep(2000);
        webLogo.click();
    }
    public void setTermsAndCondition() throws InterruptedException {
        extentTest.info(" Verify TermsAndCondition is available " +termsAndCondition.isDisplayed());
        termsAndCondition.click();
        Thread.sleep(2000);
        webLogo.click();
    }
    public void setFbFooter(){
        extentTest.info("Verify Footer facebook ");
        fbFooter.click();
    }
    public void setTwitterFooter(){
        extentTest.info("Verify Footer Twitter");
        twitterFooter.click();
    }
    public void setInstagramFooter(){
        extentTest.info("Verify Footer Instagram");
        instagramFooter.click();
    }
    public void setYoutubeFooter(){
        youtubeFooter.click();
        extentTest.info("Verify Footer Youtube ");
    }
    public void setPinterestFooter(){
        extentTest.info("Verify Footer Pinterest");
        pinterestFooter.click();
    }
    public void setPlayStoreFooter(){
        playStoreFooter.click();
        extentTest.info("Verify Footer Play Store");
    }
    public void setAppStoreFooter(){
        appStoreFooter.click();
        extentTest.info("Verify Footer App Store ");
    }

}
