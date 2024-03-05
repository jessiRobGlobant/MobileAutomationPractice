package com.globant.screens;

import com.globant.utils.NavBarPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SignUpScreen extends NavBarPage {

    // Elements
    @AndroidFindBy(accessibility = "button-login-container")
    private WebElement loginBtn;
    @AndroidFindBy(accessibility = "input-email")
    private WebElement inputEmail;
    @AndroidFindBy(accessibility = "input-password")
    private WebElement inputPassword;
    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement inputRepeatPassword;
    @AndroidFindBy(accessibility = "button-SIGN UP")
    private WebElement signUpBtn;

    // Constructor
    public SignUpScreen(AndroidDriver driver) {
        super(driver);
    }

    // Enter data
    public void enterEmail (String email){
        //super.waitAndClick(inputEmail);
        inputEmail.sendKeys(email);
    }

    public void enterPassword (String password){
        //super.waitAndClick(inputPassword);
        inputPassword.sendKeys(password);
    }

    public void enterPassword2 (String password){
        //super.waitAndClick(inputPassword);
        inputRepeatPassword.sendKeys(password);
    }

    // Press Elements
    public SuccessfulScreen pressSignUpBtn(){
        super.waitAndClick(signUpBtn);
        return new SuccessfulScreen(super.getDriver());
    }

    public LoginScreen goLogin(){
        super.waitAndClick(loginBtn);
        return new LoginScreen(super.getDriver());
    }
}
