package com.globant.screens;

import com.globant.utils.BaseScreen;
import com.globant.utils.NavBarPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SwipeScreen extends NavBarPage {

    // Elements
    @AndroidFindBy(uiAutomator = "textContains(\"Swipe horizontal\")")
    private WebElement swipeHeader;
    @AndroidFindBy(uiAutomator = "descriptionMatches(\"Carousel\").childSelector(index(0))" +
            ".childSelector(index(0)).childSelector(className(\"android.view.ViewGroup\"))")
    private List<WebElement> carouselElements;

    // Constructor
    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    // Get info
    public String getSwipeHeader(){
        super.waitTillDisplayed(swipeHeader);
        return swipeHeader.getText();
    }

    public int getNumOfCards(){
        return carouselElements.size();
    }
}
