package com.globant.tests;

import com.globant.screens.HomeScreen;
import com.globant.screens.LoginScreen;
import com.globant.screens.SignUpScreen;
import com.globant.screens.SuccessfulScreen;
import com.globant.utils.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

public class SignUpTest extends BaseTest {

    private LoginScreen loginScreen;
    private final Faker faker = new Faker();
    private final String email = faker.internet().emailAddress();
    private final String password = faker.internet().password();

    @BeforeMethod
    public void prepareTest(){
        HomeScreen homeScreen = super.getHomeScreen();
        homeScreen.waitSomeSeconds(5);
        loginScreen = homeScreen.goLogin();
    }

    @Test
    public void signUpTest(){
        SignUpScreen signUpScreen = loginScreen.goSignUp();
        enterData(this.email, this.password, signUpScreen);
        SuccessfulScreen successfulScreen = signUpScreen.presssignUpBtn();
        assertSignUpAlert(successfulScreen);
    }

    private void enterData(String email, String password, SignUpScreen signUpScreen){
        signUpScreen.enterEmail(email);
        super.logInfo("User email: "+ email);
        signUpScreen.enterPassword(password);
        super.logInfo("User password: "+ password);
        signUpScreen.enterPassword2(password);
    }

    public void assertSignUpAlert(SuccessfulScreen successfulScreen){
        super.getSoftAssert().assertEquals(
                successfulScreen.getTittle(),
                "Signed Up!");
        super.getSoftAssert().assertEquals(
                successfulScreen.getMessage(),
                "You successfully signed up!");
    }

}
