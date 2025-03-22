package com.backbase.hdfc.pages;

import com.backbase.hdfc.annotations.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
@Slf4j
public class LoginPage extends Base{

    @FindBy(xpath = "(//input[@name='username'])[1]")
    private WebElement loginCustomerId;
    @FindBy(xpath = "(//input[@name='password'])[1]")
    private WebElement loginPassword;
    @FindBy(xpath = "(//input[@name='login'])[1]")
    private WebElement loginButton;
    @FindBy(xpath = "(//span[@class='forgot-password'])[1]")
    private WebElement forgotPasswordLink;
    @FindBy(xpath = "(//a[@href='/support'])[1]")
    private WebElement getCustomerIdLink;
    @FindBy(xpath = "//*[@id='otp-header']")
    private WebElement otpModalHeader;
    @FindBy(xpath = "//*[@id='otpValue']")
    private WebElement enterOTPTextBox;
    @FindBy(xpath = "//*[@id='bb-modal-body']/div[2]/div[1]/div/button[1]")
    private WebElement submitOTPButton;
    @FindBy(xpath = "//*[@id='kc-page-title']/div[2]")
    private WebElement portalTitle;

    public void goTo(){
        this.driver.get(applicationConfig.getPortalURL());
    }

    public void login(String userType){
        loginCustomerId.sendKeys(applicationConfig.getUserCredentials(userType).getUserName());
        loginPassword.sendKeys(applicationConfig.getUserCredentials(userType).getPassword());
        loginButton.click();
    }

    public void enterOtp(){
        waitElement(enterOTPTextBox);
        enterOTPTextBox.sendKeys("123456");
        submitOTPButton.click();
    }

    public void openPortal(){
        goTo();
        waitElement(portalTitle);
        Assert.assertTrue("Unable to load portal",isLoaded());
    }

    @Override
    public boolean isLoaded() {
        return portalTitle.getText().trim().equalsIgnoreCase("Welcome to NetBanking");
    }
}
