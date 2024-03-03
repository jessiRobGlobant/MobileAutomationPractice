package com.globant.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {

    // Attributes
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    // Constructor
    public BaseScreen(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Getters
    public AndroidDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    // Waits
    protected void waitTillDisplayed(WebElement element){
        // getWait().until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitTillClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitAndClick(WebElement element) {
        waitTillClickable(element);
        element.click();
    }


}
