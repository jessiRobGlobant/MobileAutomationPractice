package com.globant.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofMillis;
import static java.util.Collections.singletonList;

public class BaseScreen {

    // Attributes
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    // Constructor
    public BaseScreen(AndroidDriver driver){
        this.driver = driver;
        waitSomeSeconds(5); //My computer is slow
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Getters
    public AndroidDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    // Waits
    protected void waitTillDisplayed(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitTillClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitSomeSeconds(int seconds){
        try{
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Actions
    protected void waitAndClick(WebElement element) {
        waitTillClickable(element);
        element.click();
    }


    public void swipe(int fromX,int fromY,int toX,int toY) {

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,
                "finger");
        Sequence sequence = new Sequence(finger, 1);

        sequence.addAction(finger.createPointerMove(ofMillis(0),
                PointerInput.Origin.viewport(), fromX, fromY));
        sequence.addAction(
                finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        sequence.addAction(new Pause(finger, ofMillis(600)));
        sequence.addAction(finger.createPointerMove(ofMillis(600),
                PointerInput.Origin.viewport(), toX, toY));
        sequence.addAction(
                finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

        driver.perform(singletonList(sequence));
    }

    public void swipeHorizontal(int initialX, int initialY, int finalX) {
        swipe(initialX, initialY, finalX, initialY);
    }

    public void swipeVertical(int cordX, int initialY, int finalY) {
        swipe(cordX, initialY, cordX, finalY);
    }


}
