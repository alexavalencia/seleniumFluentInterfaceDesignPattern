package com.testpractices.utilities;

import org.openqa.selenium.WebElement;

public class Helper {

    public static void enterText (WebElement element, String text) {
        element.click ();
        element.clear ();
        element.sendKeys (text);
    }
}
