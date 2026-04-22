package com.internet.core.tests;

import com.internet.core.core.TestBase;
import com.internet.core.pages.JavaScriptAlertsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class JavaScriptAlertsTest extends TestBase {

    private JavaScriptAlertsPage alertsPage;

    @BeforeEach
    public void openPage() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        alertsPage = new JavaScriptAlertsPage(driver);
    }

    @Test

    public void testJsAlertAccept() {
        alertsPage
                .clickJsAlertButton()
                .acceptAlert()
                .verifyResult("You successfully clicked an alert");
    }

    @Test

    public void testJsConfirmAccept() {
        alertsPage
                .clickJsConfirmButton()
                .acceptConfirm()
                .verifyResult("You clicked: Ok");
    }

    @Test

    public void testJsConfirmDismiss() {
        alertsPage
                .clickJsConfirmButton()
                .dismissConfirm()
                .verifyResult("You clicked: Cancel");
    }

    @Test

    public void testJsPromptWithText() {
        alertsPage
                .clickJsPromptButton()
                .sendTextToPrompt("Hello Selenium")
                .verifyResult("You entered: Hello Selenium");
    }

    @Test

    public void testJsPromptDismiss() {
        alertsPage
                .clickJsPromptButton()
                .dismissPrompt()
                .verifyResult("You entered: null");
    }
}