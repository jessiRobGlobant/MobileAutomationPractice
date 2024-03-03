package com.globant.tests;

import com.globant.screens.HomeScreen;
import com.globant.screens.WebviewScreen;
import com.globant.utils.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuBarTest extends BaseTest {

    // @BeforeMethod
    public void goToHome(){
        HomeScreen homeScreen = super.getHomeScreen();
        homeScreen.goHome();
    }

    @Test
    public void navigateThorughMenuBar(){

        HomeScreen homeScreen = super.getHomeScreen();
        WebviewScreen webviewScreen = homeScreen.goWebview();
    }
}
