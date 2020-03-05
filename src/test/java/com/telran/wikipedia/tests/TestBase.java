package com.telran.wikipedia.tests;

import com.telran.wikipedia.manager.ApplicationManager;
import com.telran.wikipedia.utils.Listener;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Arrays;

@Listeners(Listener.class)

public class TestBase {

    public static ApplicationManager app = new ApplicationManager();

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startTestLog(Method m, Object[] parameter){
        logger.info("Start test " + m.getName()
                + " with parameters " + Arrays.asList(parameter));
    }

    @AfterMethod
    public void stopTestLog(Method m){
        logger.info("Stop test " + m.getName());
    }



    @BeforeSuite
    public void setUp() throws MalformedURLException {
        app.init();
        if(app.getArticle()
                .isElementPresent(By.id("fragment_onboarding_skip_button"))){
            app.skipWelcomePage();
        }

    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        app.stop();

    }

}
