package com.azovcevae.tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@Tag("selenide")
public class LoginTests extends TestBase{

        @Test
        void successLogin() {
                $(AppiumBy.id("com.bonpass.seller.v2.dev:id/login_phone_number_edit_text")).setValue("9009005050");
                $(AppiumBy.id("com.bonpass.seller.v2.dev:id/login_password_edit_text")).setValue("2508").pressEnter();
            //step("Click Submit button", () -> $(AppiumBy.id("android.widget.Button")).click());
                $(AppiumBy.id("com.bonpass.seller.v2.dev:id/toolbarTitle")).shouldHave(text("Потапова Полина"));
        }
}
