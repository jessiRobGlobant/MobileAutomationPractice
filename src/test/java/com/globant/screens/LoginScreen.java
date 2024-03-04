package com.globant.screens;

import com.globant.utils.NavBarPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends NavBarPage {

    // Elements
    @AndroidFindBy(uiAutomator = "textContains(\"Login / Sign up\")")
    private WebElement loginHeader;
    @AndroidFindBy(accessibility = "button-sign-up-container")
    private WebElement signUpBtn;
    @AndroidFindBy(accessibility = "input-email")
    private WebElement inputEmail;
    @AndroidFindBy(accessibility = "input-password")
    private WebElement inputPassword;
    @AndroidFindBy(accessibility = "button-LOGIN")
    private WebElement loginBtn;



    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    // Get info
    public String getLogginHeader(){
        super.waitTillDisplayed(loginHeader);
        return loginHeader.getText();
    }

    public boolean isLoginBtnClickable(){
        super.waitTillClickable(loginBtn);
        String value = loginBtn.getAttribute("clickable");
        return Boolean.parseBoolean(value);
    }

    // Enter data
    public void enterEmail (String email){
        super.waitAndClick(inputEmail);
        inputEmail.sendKeys(email);
    }

    public void enterPassword (String password){
        super.waitAndClick(inputPassword);
        inputPassword.sendKeys(password);
    }

    // Press Elements
    public void pressLoginBtn(){
        super.waitAndClick(loginBtn);
    }

    public SignUpScreen goSignUp(){
        super.waitAndClick(signUpBtn);
        return new SignUpScreen(super.driver);
    }
}
