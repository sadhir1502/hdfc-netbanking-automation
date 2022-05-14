package health.trayt.automation.stepdefinitions;

import health.trayt.automation.annotations.LazyAutowired;
import health.trayt.automation.pages.HomePage;
import health.trayt.automation.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class LoginDemoStepDefs {
    @LazyAutowired
    private LoginPage loginPage;
    @LazyAutowired
    private HomePage homePage;

    @Given("^User opens clinical portal$")
    public void userOpensClinicalPortal() {
        loginPage.openPortal();
    }

    @Then("^User validate that Login is Successful$")
    public void userValidateThatLoginIsSuccessful() {
        homePage.isLoaded();
    }

    @And("^Sign into portal as \"([^\"]*)\"$")
    public void signIntoPortalAs(String arg0){
        loginPage.login(arg0);
    }
}
