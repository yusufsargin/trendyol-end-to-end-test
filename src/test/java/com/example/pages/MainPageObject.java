package com.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageObject {
    private final Page page;

    public MainPageObject(Page page) {
        this.page = page;
    }

    public void navigate(){
        page.navigate("https://www.trendyol.com");
    }

    public void checkPopularProductSlider(){
        Locator locator = page.locator(".widget-gw-widget .widget-header").first().getByText("Popüler Ürünler");

        assertThat(locator).isVisible();
    }

    public void checkNavigationBar(){
        Locator mainLocator = page.locator("#navigation-wrapper nav ul");

        assertEquals(mainLocator.locator("li.tab-link").count(), 11);
        assertThat(mainLocator.first()).isVisible();
    }

    public void checkSearchBar(){
        Locator locator = page.locator("[data-testid='suggestion']");

        assertTrue(locator.isVisible());
    }
}
