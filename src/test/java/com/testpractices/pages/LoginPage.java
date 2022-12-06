package com.testpractices.pages;

import org.openqa.selenium.By;

import static com.testpractices.drivers.DriverManagers.getDriver;

public class LoginPage {
    public String loginBoxTitle(){
        return getDriver().findElement(By.cssSelector("div:nth-child(2) > div > div > h2")).getText();
    }
}
