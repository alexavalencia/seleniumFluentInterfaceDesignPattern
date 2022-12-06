package com.testpractices.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.testpractices.drivers.DriverManagers.getDriver;

public class HomePage {

    public static HomePage homePage(){
        return new HomePage();
    }

    public LoginPage navigateToLoginPage(){
        openMyAccountMenu().loginLink().click();
        return new LoginPage();
    }

    public RegistrationPage openUserRegistrationPage(){
        openMyAccountMenu().registerLink().click();
        return new RegistrationPage();
    }

    private HomePage openMyAccountMenu(){
        getDriver().findElement(By.linkText("My account")).click();
        return this;
    }
    private WebElement loginLink(){
        return getDriver().findElement(By.linkText("Login"));
    }

    private WebElement registerLink(){
        return getDriver().findElement(By.linkText("Register"));
    }
}
