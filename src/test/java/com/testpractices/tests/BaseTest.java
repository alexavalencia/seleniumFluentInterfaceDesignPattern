package com.testpractices.tests;

import static com.testpractices.drivers.DriverManagers.createDriver;
import static com.testpractices.drivers.DriverManagers.quitDriver;
import com.testpractices.enums.Browser;
import lombok.Builder;
import org.testng.annotations.*;



public class BaseTest {

    @Parameters("browser")
    @BeforeClass
    public void setUp(final String browser){
       createDriver(Browser.valueOf(browser.toUpperCase()));

    }

    @AfterClass
    public void tearDown(){
        quitDriver();
    }
}
