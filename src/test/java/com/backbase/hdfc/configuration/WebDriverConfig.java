package com.backbase.hdfc.configuration;

import com.backbase.hdfc.annotations.LazyConfiguration;
import com.backbase.hdfc.annotations.WebdriverScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;


@LazyConfiguration
public class WebDriverConfig {
    @WebdriverScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    @Primary
    public WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @WebdriverScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    @Primary
    public WebDriver edgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    @WebdriverScopeBean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    @Primary
    public WebDriver chromeDriver() {
        ChromeOptions options = new ChromeOptions();
        // first 2 options for headless mode
        //options.addArguments("--headless");
        //options.addArguments("--disable-gpu");
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }
}
