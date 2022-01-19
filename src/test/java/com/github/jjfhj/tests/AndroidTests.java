package com.github.jjfhj.tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidTests extends TestBase {

    @Test
    @DisplayName("Отображение результатов поиска")
    void displayingSearchResultsTest() {
        step("Нажать на поле поиска", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        });
        step("Ввести значение 'BrowserStack' в поле и выполнить поиск", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Проверить отображение результатов поиска", () -> {
            $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    @DisplayName("Открытие страницы из результатов поиска")
    void openingPageFromSearchResultsTest() {
        step("Нажать на поле поиска", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        });
        step("Ввести значение 'Moon' в поле и выполнить поиск", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Moon");
        });
        step("Нажать на результат поиска с заголовком 'Moon'", () -> {
            $$(byClassName("android.widget.TextView")).find(text("Moon")).click();
        });
        step("Проверить отображение подзаголовка 'Earth's natural satellite' на открывшейся странице", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/view_page_subtitle_text")).shouldHave(text("Earth's natural satellite"));
        });
    }
}
