package com.globant.screens;

import com.globant.utils.BaseScreen;
import com.globant.utils.NavBarPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SwipeScreen extends NavBarPage {

    // Elements
    @AndroidFindBy(uiAutomator = "textContains(\"Swipe horizontal\")")
    private WebElement swipeHeader;
    @AndroidFindBy(uiAutomator = "descriptionMatches(\"Carousel\").childSelector(index(0))" +
            ".childSelector(index(0)).childSelector(className(\"android.view.ViewGroup\"))")
    private List<WebElement> carouselElements;
    @AndroidFindBy(uiAutomator = "textContains(\"You found me\")")
    private WebElement swipeUpTxt;

    // Cords for swipe actions on carousel
    private int leftCordX;
    private int cordY;
    private int rightCordX;

    // Cords for swipe Up action
    private int iniCordY;
    private int finCordY;

    // Constructor
    public SwipeScreen(AndroidDriver driver) {
        super(driver);
        getCords();
    }

    // Get info
    public String getSwipeHeader(){
        super.waitTillDisplayed(swipeHeader);
        return swipeHeader.getText();
    }

    public int getNumOfCards(){
        return carouselElements.size();
    }

    private void getCords(){
        WebElement card = carouselElements.get(0);
        Point point = card.getLocation();
        leftCordX = point.getX() + 30;
        cordY = point.getY() + 100;
        rightCordX = point.getX() + 300;
        iniCordY = cordY - 200;
        finCordY = iniCordY - 800;
    }

    public boolean isFirstCardVisible(){
        return checkVisibilityCard(0);
    }

    public boolean isLastCardVisible(){
        return checkVisibilityCard(5);
    }

    public boolean isPenultimateCardVisible(){
        return checkVisibilityCard(4);
    }

    private boolean checkVisibilityCard(int cardNum){
        List<WebElement> allTextViews = driver.findElements(
                AppiumBy.androidUIAutomator(
                        String.format("resourceIdMatches(\"__CAROUSEL_ITEM_%d_READY__\").childSelector(descriptionMatches(\"card\"))",cardNum)));
        System.out.println(allTextViews.size());
        return (!allTextViews.isEmpty());
    }

    public String getSwipeUpText(){
        return swipeUpTxt.getText();
    }

    // Actions
    public void swipeLeft(){
        super.swipeHorizontal(rightCordX, cordY, leftCordX);
    }

    public void swipeRight(){
        super.swipeHorizontal(leftCordX, cordY, rightCordX);
    }

    public void swipeToLast(){
        int numOfCards = 6;
        for (byte i = 1; i< numOfCards; i++){
            swipeLeft();
        }
    }

    public void swipeUp(){
        super.swipeVertical(rightCordX, iniCordY, finCordY);
        super.swipeVertical(rightCordX, iniCordY+600, finCordY);
        super.swipeVertical(rightCordX, iniCordY, finCordY);
    }

}
