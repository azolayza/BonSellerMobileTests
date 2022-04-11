package com.azovcevae.drivers;

import com.azovcevae.config.BrowserstackConfig;
import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class BrowserstackMobileDriver implements WebDriverProvider {
    public static BrowserstackConfig browserstack =
            ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.appium_version", "1.22.0");
        mutableCapabilities.setCapability("browserstack.user", browserstack.user());
        mutableCapabilities.setCapability("browserstack.key", browserstack.key());
        mutableCapabilities.setCapability("app", browserstack.app());
        mutableCapabilities.setCapability("device", "Samsung Galaxy S10e");
        mutableCapabilities.setCapability("os_version", "9.0");
        mutableCapabilities.setCapability("project", "BonSeller Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-bs");
        mutableCapabilities.setCapability("name", "bonseller_test");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }
}
