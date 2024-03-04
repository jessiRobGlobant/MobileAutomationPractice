package com.globant.screens;

import com.globant.utils.NavBarPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DragScreen extends NavBarPage {

    // Elements
    @AndroidFindBy(uiAutomator = "textContains(\"Drag and Drop\")")
    private WebElement dragHeader;
    @AndroidFindBy(uiAutomator = "descriptionMatches(\"Drag-drop-screen\").childSelector(descriptionStartsWith(\"drop\"))")
    private List<WebElement> dropElements;
    @AndroidFindBy(uiAutomator = "descriptionMatches(\"Drag-drop-screen\").childSelector(descriptionContains(\"drag\"))")
    private List<WebElement> dragElements;
    public DragScreen(AndroidDriver driver) {
        super(driver);
    }

    // Get info
    public String getDragHeader(){
        super.waitTillDisplayed(dragHeader);
        return dragHeader.getText();
    }

    public int getNumOfDropElements(){
        return dropElements.size();
    }

    public int getNumOfDragElements(){
        return dragElements.size();
    }
}
