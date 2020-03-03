package com.telran.wikipedia.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchArticleTest extends TestBase {
    @Test
    public void testSearchArticle() throws InterruptedException {
        String wordRequest = "Coronavirus";
        app.getArticle().initSearchArticle();
        app.getArticle().typeRequest(wordRequest);
        app.getArticle().waitForElement("//*[contains(@text,'" + wordRequest + "')]", 3000);
        Assert.assertTrue(app.getArticle().isResultPresent(wordRequest));
        app.getArticle().swipeArticlesUp();
    }
}
