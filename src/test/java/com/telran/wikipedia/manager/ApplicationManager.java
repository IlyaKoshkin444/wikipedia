package com.telran.wikipedia.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    AppiumDriver driver;
    ArticleHelper article;

    public void init() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "emu1");
        cap.setCapability("platformVersion", "8.0");
        cap.setCapability("automationName", "Appium");
        cap.setCapability("appPackage", "org.wikipedia");
        cap.setCapability("appActivity", ".main.MainActivity");
        cap.setCapability("app", "C:/Users/Elena/Dropbox/Tel-ran/Mobile/apk/org.wikipedia.apk");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        article = new ArticleHelper(driver);




    }

    public ArticleHelper getArticle() {
        return article;
    }

    public void skipWelcomePage(){
        driver.findElement(By.id("fragment_onboarding_skip_button")).click();
    }

    public void stop() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}

