package com.globant.screens;

import com.globant.utils.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SuccessfulLoginScreen extends BaseScreen {

    // Elements
    @AndroidFindBy(accessibility = "android:id/message")
    private WebElement alertTxt;

    @AndroidFindBy(accessibility = "android:id/button1")
    private WebElement okLink;

    // Constructor
    public SuccessfulLoginScreen(AndroidDriver driver) {
        super(driver);
    }

    // Methods
    public String getMessage(){
        super.waitTillDisplayed(alertTxt);
        return alertTxt.getText();
    }

    public HomeScreen pressOK(){
        super.waitAndClick(okLink);
        return new HomeScreen(super.getDriver());
    }
}
