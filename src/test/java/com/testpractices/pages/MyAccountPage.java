package com.testpractices.pages;

import org.openqa.selenium.By;

import static com.testpractices.drivers.DriverManagers.getDriver;
import static org.testng.AssertJUnit.assertEquals;

public class MyAccountPage {
    public MyAccountPage verifyPageHeader () {
        assertEquals (getDriver ().findElement (By.tagName ("h2"))
                .getText (), "My Account");
        return this;
    }
}
