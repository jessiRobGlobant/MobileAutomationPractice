package com.globant.tests;

import com.github.javafaker.Faker;
import com.globant.screens.HomeScreen;
import com.globant.screens.LoginScreen;
import com.globant.screens.SignUpScreen;
import com.globant.screens.SuccessfulScreen;
import com.globant.utils.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    // Attributes
    private LoginScreen loginScreen;
    private final Faker faker = new Faker();
    private final String email = faker.internet().emailAddress();
    private final String password = faker.internet().password();

    @BeforeMethod
    public void prepareTest(){
        HomeScreen homeScreen = super.getHomeScreen();
        homeScreen.waitSomeSeconds(5);
        loginScreen = homeScreen.goLogin();
        createUser();
    }

    @Test
    public void testLogin(){
        loginScreen.enterEmail(this.email);
        loginScreen.enterPassword(this.password);
        SuccessfulScreen successfulScreen = loginScreen.pressLoginBtn();
        assertLoginAlert(successfulScreen);
    }

    public void assertLoginAlert(SuccessfulScreen successfulScreen){
        super.getSoftAssert().assertEquals(
                successfulScreen.getTittle(),
                "Success");
        super.getSoftAssert().assertEquals(
                successfulScreen.getMessage(),
                "You are logged in!");
    }
    private void createUser(){
        SignUpScreen signUpScreen = loginScreen.goSignUp();
        enterData(this.email, this.password, signUpScreen);
        SuccessfulScreen successfulScreen = signUpScreen.pressSignUpBtn();
        signUpScreen = successfulScreen.pressOKSignUp();
        loginScreen = signUpScreen.goLogin();
    }

    private void enterData(String email, String password, SignUpScreen signUpScreen){
        signUpScreen.enterEmail(email);
        super.logInfo("User email: "+ email);
        signUpScreen.enterPassword(password);
        super.logInfo("User password: "+ password);
        signUpScreen.enterPassword2(password);
    }
}
