package com.testpractices.pages;

import static com.testpractices.drivers.DriverManagers.getDriver;
import static com.testpractices.utilities.Helper.enterText;
import static org.testng.AssertJUnit.assertEquals;

import com.testpractices.model.RegisterUserData;
import com.testpractices.model.TestDataBuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RegistrationPage {
    private static final String PASSWORD="Password123#";
    private final RegisterUserData registerUserData;


    public RegistrationPage() {
        this.registerUserData = TestDataBuilder.getRegisterUserData();
    }

    public RegistrationSuccessPage registerUser(){
        enterText(firstNameField(),this.registerUserData.getFirstName());
        enterText(lastNameField(),this.registerUserData.getLastName());
        enterText(emailField(),this.registerUserData.getEmail());
        enterText(telephoneField(),this.registerUserData.getTelephone());
        enterText(passwordField(),PASSWORD);
        enterText(confirmPassword(),PASSWORD);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(agreePrivacyPolicyField()).click().perform();
        continueBtn().click();
        return new RegistrationSuccessPage();
    }
    public RegistrationPage verifyPageHeader () {
        assertEquals (getDriver ().findElement (By.tagName ("h1"))
                .getText (), "Register Account");
        return this;
    }

    private WebElement agreePrivacyPolicyField(){
        return registrationForm().findElement(By.id("input-agree"));
    }
    private WebElement confirmPassword(){
        return registrationForm().findElement(By.id("input-confirm"));
    }
    private WebElement continueBtn(){
        return registrationForm().findElement(By.cssSelector("input.btn-primary"));
    }
    private WebElement emailField(){
        return registrationForm().findElement(By.id("input-email"));
    }
    private WebElement firstNameField(){
        return registrationForm().findElement(By.id("input-firstname"));
    }
    private WebElement lastNameField(){
        return registrationForm().findElement(By.id("input-lastname"));
    }
    private WebElement passwordField(){
        return registrationForm().findElement(By.id("input-password"));
    }
    private WebElement telephoneField(){
        return registrationForm().findElement(By.id("input-telephone"));
    }
    private WebElement registrationForm(){
        return getDriver().findElement(By.id("content"));
    }
}
