package com.backbase.hdfc.stepdefinitions;

import com.backbase.hdfc.annotations.LazyAutowired;
import com.backbase.hdfc.pages.HomePage;
import com.backbase.hdfc.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HdfcLoginStepDefs {
    @LazyAutowired
    private LoginPage loginPage;

    @LazyAutowired
    private HomePage homePage;

    @Given("open Hdfc netbanking portal")
    public void open_hdfc_netbanking_portal() {
        loginPage.openPortal();
    }

    @Given("enter the credentials of customer {string}")
    public void enter_the_credentials_of_customer(String string) {
        loginPage.login(string);
    }

    @Given("enter the otp and click submit")
    public void enter_the_otp_and_click_submit() {
        loginPage.enterOtp();
    }

    @Then("validate that Login to Hdfc netbanking portal is Successful and user redirect to Dashboard successfully")
    public void validate_that_login_to_hdfc_netbanking_portal_is_successful_and_user_redirect_to_dashboard_successfully() {
        homePage.isLoaded();
    }
}
