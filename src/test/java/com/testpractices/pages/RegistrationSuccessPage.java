package com.testpractices.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.testpractices.drivers.DriverManagers.getDriver;
import static org.testng.AssertJUnit.assertEquals;

public class RegistrationSuccessPage {

    public MyAccountPage continueToMyAccount () {
        continueBtn ().click ();
        return new MyAccountPage ();
    }

    public RegistrationSuccessPage verifySuccessfulRegistration () {
        assertEquals (getDriver ().findElement (By.tagName ("h1"))
                .getText (), "Your Account Has Been Created!");
        return this;
    }

    private WebElement continueBtn () {
        return getDriver ().findElement (By.cssSelector (".buttons > a.btn-primary"));
    }
}
