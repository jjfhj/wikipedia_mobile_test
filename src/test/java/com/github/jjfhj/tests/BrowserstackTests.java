package com.github.jjfhj.tests;

import com.github.jjfhj.annotations.JiraIssue;
import com.github.jjfhj.annotations.JiraIssues;
import com.github.jjfhj.annotations.Layer;
import com.github.jjfhj.annotations.Microservice;
import io.appium.java_client.MobileBy;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Layer("ui")
@Owner("kgordienko")
@Tag("browserstack")
@JiraIssues({@JiraIssue("HOMEWORK-329")})
@Link(name = "Wikipedia", url = "https://play.google.com/store/apps/details?id=org.wikipedia&hl=ru&gl=US")
@DisplayName("Тестирование мобильного приложения Wikipedia")
public class BrowserstackTests extends TestBase {

    @Test
    @DisplayName("Отображение результатов поиска")
    @Tags({@Tag("Blocker"), @Tag("High")})
    @Microservice("Search Results")
    @Owner("user")
    @Feature("Поиск")
    @Story("Страница результатов поиска")
    @Severity(SeverityLevel.BLOCKER)
    void displayingSearchResultsTest() {
        step("Нажать на поле поиска", () ->
                $(MobileBy.AccessibilityId("Search Wikipedia")).click());
        step("Ввести значение 'BrowserStack' в поле и выполнить поиск", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack"));
        step("Проверить отображение результатов поиска", () ->
                $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Открытие страницы из результатов поиска")
    @Tags({@Tag("Blocker"), @Tag("High")})
    @Microservice("Search Results")
    @Feature("Поиск")
    @Story("Страница результатов поиска")
    @Severity(SeverityLevel.BLOCKER)
    void openingPageFromSearchResultsTest() {
        step("Нажать на поле поиска", () ->
                $(MobileBy.AccessibilityId("Search Wikipedia")).click());
        step("Ввести значение 'Moon' в поле и выполнить поиск", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Moon"));
        step("Нажать на результат поиска с заголовком 'Moon'", () ->
                $$(byClassName("android.widget.TextView")).find(text("Moon")).click());
        step("Проверить отображение подзаголовка 'Earth's natural satellite' на открывшейся странице", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/view_page_subtitle_text")).shouldHave(text("Earth's natural satellite")));
    }
}
