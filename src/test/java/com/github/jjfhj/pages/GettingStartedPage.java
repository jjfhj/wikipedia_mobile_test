package com.github.jjfhj.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class GettingStartedPage {

    // Locators & Elements
    private final String FIRST_SCREEN_TEXT_TITLE = "The Free Encyclopedia …in over 300 languages";
    private final String SECOND_SCREEN_TEXT_TITLE = "New ways to explore";
    private final String THIRD_SCREEN_TEXT_TITLE = "Reading lists with sync";
    private final String FOURTH_SCREEN_TEXT_TITLE = "Send anonymous data";
    private final SelenideElement
            firstScreen = $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")),
            nextButtonOnTheFirstScreen = $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            secondScreen = $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")),
            nextButtonOnTheSecondScreen = $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            thirdScreen = $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")),
            nextButtonOnTheThirdScreen = $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            fourthScreen = $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")),
            buttonReadyOnTheFourthScreen = $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button"));

    // Actions
    @Step("Проверить отображение заголовка с текстом 'The Free Encyclopedia …in over 300 languages' на первом экране")
    public GettingStartedPage titleDisplayOnFirstScreen() {
        firstScreen.shouldHave(text(FIRST_SCREEN_TEXT_TITLE));

        return this;
    }

    @Step("Нажать на кнопку 'Далее' на первом экране")
    public GettingStartedPage clickNextOnTheFirstScreen() {
        nextButtonOnTheFirstScreen.click();

        return this;
    }

    @Step("Проверить отображение заголовка с текстом 'New ways to explore' на втором экране")
    public GettingStartedPage titleDisplayOnSecondScreen() {
        secondScreen.shouldHave(text(SECOND_SCREEN_TEXT_TITLE));

        return this;
    }

    @Step("Нажать на кнопку 'Далее' на втором экране")
    public GettingStartedPage clickNextOnTheSecondScreen() {
        nextButtonOnTheSecondScreen.click();

        return this;
    }

    @Step("Проверить отображение заголовка с текстом 'Reading lists with sync' на третьем экране")
    public GettingStartedPage titleDisplayOnThirdScreen() {
        thirdScreen.shouldHave(text(THIRD_SCREEN_TEXT_TITLE));

        return this;
    }

    @Step("Нажать на кнопку 'Далее' на третьем экране")
    public GettingStartedPage clickNextOnTheThirdScreen() {
        nextButtonOnTheThirdScreen.click();

        return this;
    }

    @Step("Проверить отображение заголовка с текстом 'Send anonymous data' на четвертом экране")
    public GettingStartedPage titleDisplayOnFourthScreen() {
        fourthScreen.shouldHave(text(FOURTH_SCREEN_TEXT_TITLE));

        return this;
    }

    @Step("Нажать на кнопку 'Готово' на четвертом экране")
    public GettingStartedPage clickOnTheButtonReadyOnTheFourthScreen() {
        buttonReadyOnTheFourthScreen.click();

        return this;
    }
}
