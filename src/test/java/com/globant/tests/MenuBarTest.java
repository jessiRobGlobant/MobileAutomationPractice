package com.globant.tests;

import com.globant.screens.*;
import com.globant.utils.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuBarTest extends BaseTest {

    private HomeScreen homeScreen;

    @BeforeMethod
    public void goToHome(){
        homeScreen = super.getHomeScreen();
        homeScreen.goHome();
        homeScreen.waitSomeSeconds(5);
    }

    @Test
    public void navigateThorughMenuBar(){
        WebviewScreen webviewScreen = homeScreen.goWebview();
        assertWebviewScreen(webviewScreen);
        LoginScreen loginScreen = homeScreen.goLogin();
        assertLoginScreen(loginScreen);
        FormsScreen formsScreen = loginScreen.goForms();
        assertFormsScreen(formsScreen);
        SwipeScreen swipeScreen = formsScreen.goSwipe();
        assertSwipeScreen(swipeScreen);
        DragScreen dragScreen = swipeScreen.goDrag();
        assertDragScreen(dragScreen);
        homeScreen = dragScreen.goHome();
        assertHomeScreen(homeScreen);
        super.getSoftAssert().assertAll();
    }

    private void assertWebviewScreen(WebviewScreen webviewScreen){
        super.getSoftAssert().assertTrue(
                webviewScreen.isWebdriverDisplayed(),
                "Webdriver is displayed");
    }

    private void assertLoginScreen(LoginScreen loginScreen){
        super.getSoftAssert().assertEquals(
                loginScreen.getLogginHeader(),
                "Login / Sign up Form");
        super.getSoftAssert().assertTrue(
                loginScreen.isLoginBtnClickable(),
                "Login Button is clickable");
    }

    private void assertFormsScreen(FormsScreen formsScreen){
        super.getSoftAssert().assertEquals(
                formsScreen.getFormsHeader(),
                "Form components");
        super.getSoftAssert().assertTrue(
                formsScreen.isActiveBtnClickable(),
                "Active Button is clickable");
        super.getSoftAssert().assertFalse(
                formsScreen.isInactiveBtnClickable(),
                "Inactive Button is not clickable");
    }

    private void assertSwipeScreen(SwipeScreen swipeScreen){
        super.getSoftAssert().assertEquals(
                swipeScreen.getSwipeHeader(),
                "Swipe horizontal");
        boolean greater = swipeScreen.getNumOfCards() >= 1;
        super.getSoftAssert().assertTrue(
                greater,
                "More than 0 cards in carousel");
    }

    private void assertDragScreen(DragScreen dragScreen){
        super.getSoftAssert().assertEquals(
                dragScreen.getDragHeader(),
                "Drag and Drop");
        super.getSoftAssert().assertEquals(
                dragScreen.getNumOfDropElements(),
                dragScreen.getNumOfDragElements());
    }

    private void assertHomeScreen(HomeScreen homeScreen){
        super.getSoftAssert().assertTrue(
                homeScreen.isLogoDisplayed(),
                "Logo is displayed");
        super.getSoftAssert().assertEquals(
                homeScreen.getDescriptionText(),
                "Demo app for the appium-boilerplate");
    }


}
