package com.github.jjfhj.tests;

import com.github.jjfhj.pages.GettingStartedPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("selenoid")
public class SelenoidTests extends TestBase {

    GettingStartedPage gettingStartedPage = new GettingStartedPage();

    @Test
    @DisplayName("Проверка первых четырех экранов Getting Started")
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
