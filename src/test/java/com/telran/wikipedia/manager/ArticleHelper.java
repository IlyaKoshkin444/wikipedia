package com.telran.wikipedia.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ArticleHelper extends HelperBase {
    public ArticleHelper(AppiumDriver driver) {
        super(driver);
    }

    public void initSearchArticle() {
        tap(By.id("search_container"));

    }

    public void typeRequest(String wordRequest) {
        type(By.id("search_src_text"), wordRequest);
    }

    public boolean isResultPresent(String wordRequest) {

        String xpath = "//*[contains(@text,'" + wordRequest + "')]";
        return isElementPresent(By.xpath(xpath));
    }

    public void swipeArticlesUp() {
        driver.hideKeyboard();
        swipeUp();
    }
    public void openFirstArticle() {
        waitForElementAndTap("//*[@resource-id = 'org.wikipedia:id/page_list_item_title']", 10);
    }

    public void openFavorites() {
        //click on flag
        waitForElementAndTap("//*[@content-desc='My lists']", 10);
        //enter to saved list
        waitForElementAndTap("//*[@resource-id='org.wikipedia:id/reading_list_list']", 10);
    }

    public boolean isFavoritsListEmpty(){
        return isElementPresent(By.xpath("//*[@resource-id='org.wikipedia:id/reading_list_empty_text']"));
    }

    public void tapReturnButton() {
        tap(By.xpath("//*[@content-desc='Navigate up']"));
    }

    public void addArticleToFavorites() {
        String wordRequest = "Java";
        initSearchArticle();
        typeRequest(wordRequest);
        openFirstArticle();
        waitForElementAndTap("//*[@content-desc ='Add this article to a reading list']", 10);
        tap(By.id("onboarding_button"));
        waitForElementAndTap("//*[@resource-id = 'org.wikipedia:id/default_list_empty_image']", 10);
        tap(By.xpath("//*[@resource-id ='org.wikipedia:id/snackbar_action']"));

    }

    public void tapEploreButton() {
        tap(By.xpath("//*[@content-desc='Explore']"));
    }

    public void deleteArticle() {
       swipeElementToLeft(By.
               xpath("//*[@resource-id='org.wikipedia:id/page_list_item_image']/.."));
    }

    public void swipeElementToLeft(By locator) {
        TouchAction action = new TouchAction(driver);

        WebElement element = driver.findElement(locator);
        int leftX = element.getLocation().getX();
        int rightX = leftX+ element.getSize().getWidth();

        int upperY = element.getLocation().getY();
        int lowerY = upperY + element.getSize().getHeight();

        int middleY = (upperY +lowerY)/2;

        action.longPress(PointOption.point(rightX, middleY))
                .moveTo(PointOption.point(leftX, middleY))
                .release()
                .perform();

    }
}
