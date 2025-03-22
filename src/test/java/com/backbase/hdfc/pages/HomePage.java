package com.backbase.hdfc.pages;

import com.backbase.hdfc.annotations.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Page
public class HomePage extends Base{

    @FindBy(xpath = "(//span[@class='bb-dashboard--tab-title'])[1]")
    private WebElement homepageHeader;

    @Override
    public boolean isLoaded() {
        waitElement(homepageHeader);
        return homepageHeader.getText().trim().contains("Accounts");
    }
}
