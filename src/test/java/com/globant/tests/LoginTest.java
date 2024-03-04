package com.globant.tests;

import com.globant.screens.SuccessfulScreen;
import com.globant.utils.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin(){

    }

    public void assertLoginMsg(SuccessfulScreen successfulLoginScreen){
        super.getSoftAssert().assertEquals(
                successfulLoginScreen.getMessage(),
                "You are logged in!");
    }
}
