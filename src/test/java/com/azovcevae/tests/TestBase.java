package com.azovcevae.tests;

import com.azovcevae.drivers.BrowserstackMobileDriver;
import com.azovcevae.drivers.EmulatorDriver;
import com.azovcevae.helpers.Attach;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.azovcevae.helpers.Attach.getSessionId;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestBase {
    private static final String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        //Configuration.browser = getDeviceDriver(deviceHost);
        //Configuration.browser = BrowserstackMobileDriver.class.getName();
        Configuration.browser = EmulatorDriver.class.getName();
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    /*@AfterEach
    public void afterEach() {
        //String sessionId = getSessionId();

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        closeWebDriver();
        //Attach.video(sessionId);
    }*/
}
