package com.github.jjfhj.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("emulation")
public class EmulationTests extends TestBase {

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
