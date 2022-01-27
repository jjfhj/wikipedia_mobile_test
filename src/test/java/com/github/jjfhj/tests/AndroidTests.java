package com.github.jjfhj.tests;

import com.github.jjfhj.pages.GettingStartedPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tags({@Tag("emulation"), @Tag("real"), @Tag("selenoid")})
public class AndroidTests extends TestBase {

    GettingStartedPage gettingStartedPage = new GettingStartedPage();

    @Test
    @DisplayName("Проверка первых четырех экранов Getting Started")
    void checkingTheFirstFourScreensOfGettingStarted() {
        step("Проверить отображение заголовка с текстом 'The Free Encyclopedia …in over 300 languages' " +
                "на первом экране", () -> {
            gettingStartedPage.titleDisplayOnFirstScreen();
        });
        step("Нажать на кнопку 'Далее' на первом экране", () -> {
            gettingStartedPage.clickNextOnTheFirstScreen();
        });
        step("Проверить отображение заголовка с текстом 'New ways to explore' на втором экране", () -> {
            gettingStartedPage.titleDisplayOnSecondScreen();
        });
        step("Нажать на кнопку 'Далее' на втором экране", () -> {
            gettingStartedPage.clickNextOnTheSecondScreen();
        });
        step("Проверить отображение заголовка с текстом 'Reading lists with sync' на третьем экране", () -> {
            gettingStartedPage.titleDisplayOnThirdScreen();
        });
        step("Нажать на кнопку 'Далее' на третьем экране", () -> {
            gettingStartedPage.clickNextOnTheThirdScreen();
        });
        step("Проверить отображение заголовка с текстом 'Send anonymous data' на четвертом экране", () -> {
            gettingStartedPage.titleDisplayOnFourthScreen();
        });
        step("Нажать на кнопку 'Готово' на четвертом экране", () -> {
            gettingStartedPage.clickOnTheButtonReadyOnTheFourthScreen();
        });
    }
}
