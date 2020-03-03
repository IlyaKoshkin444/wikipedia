package com.telran.wikipedia.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddArticleToFavoriteTest extends TestBase {

    @Test
    public void testAddArticleToFavorite(){
        String wordRequest = "Java";
        app.skipWelcomePage();
        app.getArticle().initSearchArticle();
        app.getArticle().typeRequest(wordRequest);
        app.getArticle().waitForElementAndTap("//*[@resource-id = 'org.wikipedia:id/page_list_item_title']", 3000);
        app.getArticle().waitForElementAndTap("//*[@content-desc ='Add this article to a reading list']", 5000);
        app.getArticle().tap(By.id("onboarding_button"));
        app.getArticle().waitForElementAndTap("//*[@resource-id = 'org.wikipedia:id/default_list_empty_image']", 3000);
        app.getArticle().tap(By.xpath("//*[@resource-id ='org.wikipedia:id/snackbar_action']"));
        Assert.assertTrue(app.getArticle().isResultPresent(wordRequest));

    }
}
