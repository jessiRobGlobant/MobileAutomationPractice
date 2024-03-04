package com.globant.utils;

import com.globant.screens.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public abstract class NavBarPage extends BaseScreen{

    // Elements
    @AndroidFindBy(uiAutomator = "descriptionMatches(\"Home\")")
    private WebElement homeNavBar;

    @AndroidFindBy(uiAutomator = "descriptionMatches(\"Webview\")")
    private WebElement webviewNavBar;

    @AndroidFindBy(uiAutomator = "descriptionMatches(\"Login\")")
    private WebElement loginNavBar;

    @AndroidFindBy(accessibility = "Forms")
    private WebElement formsNavBar;

    @AndroidFindBy(accessibility = "Swipe")
    private WebElement swipeNavBar;

    @AndroidFindBy(accessibility = "Drag")
    private WebElement dragNavBar;

    // Constructor
    public NavBarPage(AndroidDriver driver) {
        super(driver);
    }

    public HomeScreen goHome(){
        super.waitAndClick(homeNavBar);
        return new HomeScreen(this.driver);
    }

    public WebviewScreen goWebview(){
        super.waitAndClick(webviewNavBar);
        return new WebviewScreen(this.driver);
    }

    public LoginScreen goLogin(){
        super.waitAndClick(loginNavBar);
        return new LoginScreen(this.driver);
    }

    public FormsScreen goForms(){
        super.waitAndClick(formsNavBar);
        return new FormsScreen(this.driver);
    }

    public SwipeScreen goSwipe(){
        super.waitAndClick(swipeNavBar);
        return new SwipeScreen(this.driver);
    }

    public DragScreen goDrag(){
        super.waitAndClick(dragNavBar);
        return new DragScreen(this.driver);
    }
}
