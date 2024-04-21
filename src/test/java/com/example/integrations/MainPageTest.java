package com.example.integrations;

import com.example.pages.MainPageObject;
import com.example.utils.BrowserFactory;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class MainPageTest {
    // New instance for each test method.
    static Playwright playwright;
    static Browser browser;

    // New instance for each test method.
    BrowserContext context;
    Page page;
    MainPageObject mainPageObject;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = new BrowserFactory(playwright)
                .getBrowser(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(100));
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        mainPageObject = new MainPageObject(page);
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @Test
    void shouldNavigateToMainPageAndFindElements() {
        mainPageObject.navigate();
        mainPageObject.checkPopularProductSlider();
        mainPageObject.checkNavigationBar();
        mainPageObject.checkSearchBar();
    }
}
