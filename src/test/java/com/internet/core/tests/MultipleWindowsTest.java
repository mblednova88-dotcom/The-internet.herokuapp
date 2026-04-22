package com.internet.core.tests;

import com.internet.core.core.TestBase;
import com.internet.core.pages.MultipleWindowsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class MultipleWindowsTest extends TestBase {

    private MultipleWindowsPage windowsPage;

    @BeforeEach
    public void openPage() {
        driver.get("https://the-internet.herokuapp.com/windows");
        windowsPage = new MultipleWindowsPage(driver);
    }

    @Test

    public void testNewWindowHeading() {
        windowsPage
                .clickClickHere()
                .switchToNewWindow(1)
                .verifyNewWindowHeading("New Window");
    }
}
