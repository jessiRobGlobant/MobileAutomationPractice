package com.globant.screens;

import com.globant.utils.NavBarPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class FormsScreen extends NavBarPage {

    // Elements
    @AndroidFindBy(uiAutomator = "textContains(\"Form components\")")
    private WebElement formsHeader;

    @AndroidFindBy(accessibility = "button-Active")
    private WebElement activeBtn;

    @AndroidFindBy(accessibility = "button-Inactive")
    private WebElement inactiveBtn;

    // Constructor
    public FormsScreen(AndroidDriver driver) {
        super(driver);
    }

    // Get info
    public String getFormsHeader(){
        super.waitTillDisplayed(formsHeader);
        return formsHeader.getText();
    }
    public boolean isActiveBtnClickable(){
        super.waitTillClickable(activeBtn);
        String value = activeBtn.getAttribute("clickable");
        return Boolean.parseBoolean(value);
    }

    public boolean isInactiveBtnClickable(){
        super.waitTillDisplayed(inactiveBtn);
        String value = inactiveBtn.getAttribute("clickable");
        return Boolean.getBoolean(value);
    }
}
