package health.trayt.automation.pages;

import health.trayt.automation.annotations.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
@Slf4j
public class LoginPage extends Base{

    @FindBy(xpath = "(//input[@name='email'])[1]")
    private WebElement loginEmail;
    @FindBy(xpath = "(//input[@name='password'])[1]")
    private WebElement loginPassword;
    @FindBy(xpath = "(//button[@type='submit'])[1]")
    private WebElement loginButton;
    @FindBy(xpath = "(//a[@href='/reset-password'])[1]")
    private WebElement forgotPasswordLink;
    @FindBy(xpath = "(//a[@href='/support'])[1]")
    private WebElement getSupportLink;
    @FindBy(xpath = "(//h1[contains(@class,'Login_title')])[1]")
    private WebElement portalTitle;

    public void goTo(){
        this.driver.get(applicationConfig.getPortalURL());
    }

    public void login(String userType){
        loginEmail.sendKeys(applicationConfig.getUserCredentials(userType).getUserName());
        loginPassword.sendKeys(applicationConfig.getUserCredentials(userType).getPassword());
        loginButton.click();
    }

    public void openPortal(){
        goTo();
        Assert.assertTrue("Unable to load portal",isLoaded());
    }

    @Override
    public boolean isLoaded() {
        return portalTitle.getText().trim().equalsIgnoreCase("Clinician Portal");
    }
}
