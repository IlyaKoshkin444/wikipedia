package com.telran.wikipedia.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    AppiumDriver driver;
    WebDriverWait wait;

    public HelperBase(AppiumDriver driver) {
        this.driver = driver;
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void waitForElementAndTap(String locator, int timeOut){
        wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        tap(By.xpath(locator));
    }

    public void waitForElement(String locator, int timeOut){
        wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void tap(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            tap(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size() > 0;
    }

    public void hideKeyBoard(){
        driver.hideKeyboard();
    }

    public void swipeUp(){
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width/2;
        int startY = (int) (size.height * 0.8);
        int stopY = (int) (size.height * 0.2);

        action.longPress(PointOption.point(x, startY)).moveTo(PointOption.point(x, stopY)).release().perform();
    }

    public void swipeToTheLeft(String xpath){


        Dimension size = driver.manage().window().getSize();

        int x = (int) (size.width * 0.20);
        int y = (int) (size.width * 0.80);

        TouchAction action = new TouchAction(driver);


        WebElement elment   = (WebElement) driver.findElement(By.xpath(xpath));
        action.longPress(PointOption.point((Point) elment)).moveTo(PointOption.point(x, 580)).release().perform();

    }
}
