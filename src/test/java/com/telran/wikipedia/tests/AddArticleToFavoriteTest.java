package com.telran.wikipedia.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddArticleToFavoriteTest extends TestBase {

  @Test
  public void testAddArticleToFavorite() {
    String wordRequest = "Java";

    app.getArticle().initSearchArticle();
    app.getArticle().typeRequest(wordRequest);
    app.getArticle().openFirstArticle();
    app.getArticle().waitForElementAndTap("//*[@content-desc ='Add this article to a reading list']", 10);
    app.getArticle().tap(By.id("onboarding_button"));
    app.getArticle().waitForElementAndTap("//*[@resource-id = 'org.wikipedia:id/default_list_empty_image']", 10);
    app.getArticle().tap(By.xpath("//*[@resource-id ='org.wikipedia:id/snackbar_action']"));
    Assert.assertTrue(app.getArticle().isResultPresent(wordRequest));

  }

  @Test
  public void deleteArticleFromFavorits() throws InterruptedException {

    app.getArticle().openFavorites();

    if(app.getArticle().isFavoritsListEmpty()){
        app.getArticle().tapReturnButton();
        app.getArticle().tapEploreButton();
        app.getArticle().addArticleToFavorites();
        Thread.sleep(10000);
        app.getArticle().openFavorites();
    }
    app.getArticle().deleteArticle();
    Thread.sleep(10000);






  }




}
