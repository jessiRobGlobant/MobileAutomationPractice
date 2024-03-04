package com.globant.tests;

import com.globant.screens.SuccessfulLoginScreen;
import com.globant.utils.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin(){

    }

    public void assertLoginMsg(SuccessfulLoginScreen successfulLoginScreen){
        super.getSoftAssert().assertEquals(
                successfulLoginScreen.getMessage(),
                "You are logged in!");
    }
}
