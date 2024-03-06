package com.globant.tests;

import com.globant.screens.HomeScreen;
import com.globant.screens.SwipeScreen;
import com.globant.utils.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwipeTest extends BaseTest {

    private SwipeScreen swipeScreen;

    @BeforeMethod
    public void prepareTest(){
        HomeScreen homeScreen = super.getHomeScreen();
        swipeScreen = homeScreen.goSwipe();
    }

    @Test
    public void swipeTest(){
        swipeScreen.swipeLeft();
        super.getSoftAssert().assertFalse(swipeScreen.isFirstCardVisible());
        swipeScreen.swipeToLast();
        super.getSoftAssert().assertTrue(swipeScreen.isLastCardVisible());
        super.getSoftAssert().assertFalse(swipeScreen.isPenultimateCardVisible());
        swipeScreen.swipeUp();
        super.getSoftAssert().assertEquals(swipeScreen.getSwipeUpText(), "You found me!!!");
        super.getSoftAssert().assertAll();
    }

    }
