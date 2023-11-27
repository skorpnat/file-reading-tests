package tests;

import org.junit.jupiter.api.AfterEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @AfterEach
    void clearAll() {
        closeWebDriver();
    }
}
