package com.globant.utils;

import com.globant.screens.HomeScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BaseTest {

    // Attributes
    private static final String PROPERTIES_FILE = "src/test/resources/config.properties";
    private static final Properties properties = new Properties();
    public static AndroidDriver driver;
    private static final SoftAssert softAssert = new SoftAssert();
    private static final Logger log = Logger.getLogger(BaseTest.class.getName().getClass());


    @BeforeMethod(alwaysRun = true)
    public void environmentSetup(){
        loadProperties();
        UiAutomator2Options capabilities = new UiAutomator2Options();
        setUpCapabilities(capabilities);
        try{
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    public HomeScreen getHomeScreen(){
        return new HomeScreen(driver);
    }

    private void loadProperties() {
        try {
            FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE);
            properties.load(fileInputStream);
        }
        catch (IOException e) {
            throw new RuntimeException("Error loading the properties file "+PROPERTIES_FILE);
        }
    }

    public static void setUpCapabilities(UiAutomator2Options capabilities){
        capabilities.setPlatformName(getCapability("platformName"));
        capabilities.setDeviceName(getCapability("deviceName"));
        capabilities.setAppPackage(getCapability("appPackage"));
        capabilities.setAppActivity(getCapability("appActivity"));
        capabilities.setAutomationName(getCapability("automationName"));
    }

    public static String getCapability(String variable){
        return properties.getProperty(variable);
    }

    protected SoftAssert getSoftAssert() {
        return softAssert;
    }

    protected void logInfo(String msg){
        log.info(msg);
    }

    @AfterTest()
    public void closeSession(){
        driver.quit();
    }
}
