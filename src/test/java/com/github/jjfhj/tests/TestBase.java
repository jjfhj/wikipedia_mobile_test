package com.github.jjfhj.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.jjfhj.helpers.Attach;
import com.github.jjfhj.pages.GettingStartedPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.github.jjfhj.helpers.Attach.getSessionId;
import static com.github.jjfhj.helpers.RunHelper.deviceHost;
import static com.github.jjfhj.helpers.RunHelper.runHelper;
import static io.qameta.allure.Allure.step;

public class TestBase {

    GettingStartedPage gettingStartedPage = new GettingStartedPage();

    @BeforeAll
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = runHelper().getDriverClass().getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        step("Открыть приложение", () ->
                Selenide.open());
    }

    @AfterEach
    public void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        if (deviceHost.equals("selenoid") || deviceHost.equals("browserstack")) {
            String sessionId = getSessionId();
            Attach.attachVideo(sessionId);
        }

        step("Закрыть приложение", () ->
                Selenide.closeWebDriver());
    }
}
