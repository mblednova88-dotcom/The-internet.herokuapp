package com.internet.core.pages;

import com.internet.core.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.List;

public class MultipleWindowsPage extends com.internet.core.core.BasePage {

    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Click Here")
    private WebElement clickHereLink;

    public MultipleWindowsPage clickClickHere() {
        clickWithJS(clickHereLink);
        return this;
    }

    public void clickWithJS(WebElement element) {
        super.clickWithJS(element);
    }

    public MultipleWindowsPage switchToNewWindow(int index) {
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
        return this;
    }

    @FindBy(css = "h3")
    private WebElement newWindowHeading;

    public MultipleWindowsPage verifyNewWindowHeading(String expected) {
        Assertions.assertTrue(shouldHaveText(newWindowHeading, expected, 5));
        return this;
    }

    public boolean shouldHaveText(WebElement element,String text,int time){
        return getWait(time).until(ExpectedConditions.textToBePresentInElement(element,text));

    }




}
