package com.globant.screens;

import com.globant.utils.BaseScreen;
import com.globant.utils.NavBarPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SuccessfulScreen extends BaseScreen {

    // Elements
    @AndroidFindBy(id = "android:id/alertTitle")
    private WebElement alertTittle;
    @AndroidFindBy(id = "android:id/message")
    private WebElement alertTxt;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement okLink;

    // Constructor
    public SuccessfulScreen(AndroidDriver driver) {
        super(driver);
    }

    // Get info
    public String getTittle(){
        super.waitTillDisplayed(alertTittle);
        return alertTittle.getText();
    }
    public String getMessage(){
        super.waitTillDisplayed(alertTxt);
        return alertTxt.getText();
    }

    // Press elements
    public LoginScreen pressOKLogin(){
        super.waitAndClick(okLink);
        return new LoginScreen(super.getDriver());
    }

    public SignUpScreen pressOKSignUp(){
        super.waitAndClick(okLink);
        return new SignUpScreen(super.getDriver());
    }

}
