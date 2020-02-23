package com.telran.wikipedia;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {
    AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();





        cap.setCapability("platformName","Android" );
        cap.setCapability("deviceName", "emu1" );
        cap.setCapability("platformVersion", "8.0");
        cap.setCapability("automationName", "Appium");
        cap.setCapability("appPackage", "org.wikipedia");
        cap.setCapability("appActivity", ".page.PageActivity");
        cap.setCapability("app", "C:/Users/strit/Documents/GitHub/wikipedia/src/test/resources/apk/org.wikipedia.apk");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

    }

    @Test
    public void openApp(){
        System.out.println("App opened");

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
}
