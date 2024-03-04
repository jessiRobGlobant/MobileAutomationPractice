package com.globant.screens;

import com.globant.utils.NavBarPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebviewScreen extends NavBarPage {

    // Elements
    @AndroidFindBy(uiAutomator = "textContains(\"WebdriverIO · Next-gen browser\")")
    private WebElement webdriverIOElement;

    public WebviewScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean isWebdriverDisplayed(){
        super.waitTillDisplayed(webdriverIOElement);
        return webdriverIOElement.isDisplayed();
    }
}
