package com.telran.wikipedia.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
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
}
