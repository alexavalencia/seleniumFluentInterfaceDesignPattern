package com.testpractices.tests;


import static com.testpractices.drivers.DriverManagers.getDriver;

import static com.testpractices.pages.HomePage.homePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EcommerceTest extends BaseTest {

    @BeforeClass
    public void setUpTest(){
        getDriver().get("https://ecommerce-playground.lambdatest.io/");
    }

    @Test
    public void testRegisterUser(){
        homePage().openUserRegistrationPage()
                .verifyPageHeader()
                .registerUser()
                .verifySuccessfulRegistration()
                .continueToMyAccount()
                .verifyPageHeader();
    }




}
