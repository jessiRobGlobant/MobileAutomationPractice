package com.globant.screens;

import com.globant.utils.NavBarPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends NavBarPage {

    // Elements
    @AndroidFindBy(uiAutomator = "descriptionMatches(\"Home-screen\").childSelector(index(0))")
    private WebElement logoImage;

    @AndroidFindBy(uiAutomator = "descriptionMatches(\"Home-screen\").childSelector(textContains(\"appium-boilerplate\"))")
    private WebElement descriptionTxt;

    // Constructor
    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    // Methods
    public boolean isLogoDisplayed(){
        super.waitTillDisplayed(logoImage);
        return logoImage.isDisplayed();
    }

    public String getDescriptionText(){
        super.waitTillDisplayed(descriptionTxt);
        return descriptionTxt.getText();
    }

}
