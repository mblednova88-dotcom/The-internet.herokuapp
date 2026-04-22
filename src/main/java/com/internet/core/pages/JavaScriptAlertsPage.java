package com.internet.core.pages;


import com.internet.core.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertsPage extends com.internet.core.core.BasePage {

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(css = "button[onclick='jsAlert()']")
    private WebElement jsAlertButton;

    public JavaScriptAlertsPage clickJsAlertButton() {
        clickWithJS(jsAlertButton);
        return this;
    }



    public JavaScriptAlertsPage acceptAlert() {
        driver.switchTo().alert().accept();
        return this;
    }



    @FindBy(css = "button[onclick='jsConfirm()']")
    private WebElement jsConfirmButton;

    public JavaScriptAlertsPage clickJsConfirmButton() {
        clickWithJS(jsConfirmButton);
        return this;
    }

    public JavaScriptAlertsPage acceptConfirm() {
        driver.switchTo().alert().accept();
        return this;
    }

    public JavaScriptAlertsPage dismissConfirm() {
        driver.switchTo().alert().dismiss();
        return this;
    }



    @FindBy(css = "button[onclick='jsPrompt()']")
    private WebElement jsPromptButton;

    public JavaScriptAlertsPage clickJsPromptButton() {
        clickWithJS(jsPromptButton);
        return this;
    }

    public JavaScriptAlertsPage sendTextToPrompt(String text) {
        if (text != null) {
            driver.switchTo().alert().sendKeys(text);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    public JavaScriptAlertsPage dismissPrompt() {
        driver.switchTo().alert().dismiss();
        return this;
    }



    @FindBy(id = "result")
    private WebElement resultText;

    public JavaScriptAlertsPage verifyResult(String expected) {
        Assertions.assertTrue(shouldHaveText(resultText, expected, 5));
        return this;
    }
}