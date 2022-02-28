package com.github.jjfhj.tests;

import com.github.jjfhj.annotations.JiraIssue;
import com.github.jjfhj.annotations.JiraIssues;
import com.github.jjfhj.annotations.Layer;
import com.github.jjfhj.annotations.Microservice;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Layer("ui")
@Owner("kgordienko")
@Tag("emulation")
@JiraIssues({@JiraIssue("HOMEWORK-329")})
@Link(name = "Wikipedia", url = "https://play.google.com/store/apps/details?id=org.wikipedia&hl=ru&gl=US")
@DisplayName("Тестирование мобильного приложения Wikipedia")
public class EmulationTests extends TestBase {

    @Test
    @DisplayName("Проверка первых четырех экранов Getting Started")
    @Tags({@Tag("Critical"), @Tag("Highest")})
    @Microservice("Getting Started")
    @Feature("Начало работы")
    @Story("Экраны начала работы")
    @Severity(SeverityLevel.BLOCKER)
    void checkingTheFirstFourScreensOfGettingStarted() {
        // First Screen
        gettingStartedPage.titleDisplayOnFirstScreen()
                .clickNextOnTheFirstScreen();
        // Second Screen
        gettingStartedPage.titleDisplayOnSecondScreen()
                .clickNextOnTheSecondScreen();
        // Third Screen
        gettingStartedPage.titleDisplayOnThirdScreen()
                .clickNextOnTheThirdScreen();
        // Fourth Screen
        gettingStartedPage.titleDisplayOnFourthScreen()
                .clickOnTheButtonReadyOnTheFourthScreen();
        // Search Field
        gettingStartedPage.displaySearchField();
    }
}
