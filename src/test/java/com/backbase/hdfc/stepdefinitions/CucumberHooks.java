package com.backbase.hdfc.stepdefinitions;

import com.backbase.hdfc.annotations.LazyAutowired;
import com.backbase.hdfc.utilities.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

public class CucumberHooks {

    @LazyAutowired
    private ApplicationContext applicationContext;
    @LazyAutowired
    private ScreenshotUtil screenshotUtil;
    @AfterStep
    public void afterStep(Scenario scenario){
        if(!scenario.isFailed()){
            scenario.attach(this.screenshotUtil.getScreenshot(), "image/png", scenario.getName());
        }
    }

    @After
    @Step("close browser after executing scenario")
    public void afterScenario(){
        this.applicationContext.getBean(WebDriver.class).quit();
    }

}
